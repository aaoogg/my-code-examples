package com.project.project.service.catalog;

import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.project.constants.MessageConstants;
import com.project.project.constants.StringConstants;
import com.project.project.dto.catalog.category.CategoryDTO;
import com.project.project.dto.catalog.category.UpdateCategoryDTO;
import com.project.project.exception.IllegalArgumentExceptionCustom;
import com.project.project.exception.NotFoundException;
import com.project.project.model.catalog.Category;
import com.project.project.model.image.Image;
import com.project.project.repository.catalog.CategoryRepository;
import com.project.project.repository.image.ImageRepository;
import com.project.project.service.image.ImageService;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ImageService imageService;
    private final ImageRepository imageRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ImageService imageService,
	    ImageRepository imageRepository) {
	this.categoryRepository = categoryRepository;
	this.imageService = imageService;
	this.imageRepository = imageRepository;
    }

    @Transactional
    public List<Category> getAllCategories() {
	return categoryRepository.findAll();
    }

    @Transactional
    public Category getCategoryById(Integer id) {
	return categoryRepository.findById(id)
		.orElseThrow(() -> new NotFoundException(MessageConstants.CATEGORY_NOT_FOUND_BY_ID + id));
    }

    @Transactional
    public Map<String, Object> createCategory(CategoryDTO categoryDTO) {
	Category category = new Category();
	category.setName(categoryDTO.name());
	category.setDescription(categoryDTO.description());
	category.setIsActive(categoryDTO.isActive());

	if (categoryDTO.image() != null && !categoryDTO.image().trim().isEmpty()) {
	    Set<Image> images = new HashSet<>();
	    String imageBase64 = categoryDTO.image();
	    try {
		Image image = imageService.saveImage(imageBase64);
		images.add(image);
		category.setImages(images);
		categoryRepository.save(category);
	    } catch (IllegalArgumentExceptionCustom e) {
		System.err.println(MessageConstants.BASE64_DECODE_FAILED + e.getMessage());
	    }
	}
	categoryRepository.save(category);
	Map<String, Object> response = new HashMap<>();
	Map<String, Object> categoryData = new HashMap<>();
	categoryData.put(StringConstants.ID, category.getId());
	categoryData.put(StringConstants.NAME, category.getName());
	categoryData.put(StringConstants.DESCRIPTION, category.getDescription());
	categoryData.put(StringConstants.IS_ACTIVE, category.getIsActive());

	if (categoryDTO.image() != null) {
	    List<Map<String, Object>> imageList = category.getImages().stream().map(image -> {
		Map<String, Object> imageData = new HashMap<>();
		imageData.put(StringConstants.ID, image.getId());
		imageData.put(StringConstants.IMAGE, Base64.getEncoder().encodeToString(image.getImage()));
		return imageData;
	    }).collect(Collectors.toList());
	    categoryData.put(StringConstants.IMAGES, imageList);
	}
	response.put(StringConstants.CATEGORY, categoryData);

	return response;
    }

    @Transactional
    public Map<String, Object> updateCategory(Integer id, UpdateCategoryDTO updateCategoryDTO) {
	Category category = categoryRepository.findById(id)
		.orElseThrow(() -> new NotFoundException(MessageConstants.CATEGORY_NOT_FOUND_BY_ID + id));

	updateCategoryDTO.name().ifPresent(category::setName);
	updateCategoryDTO.description().ifPresent(category::setDescription);
	updateCategoryDTO.isActive().ifPresent(category::setIsActive);

	updateCategoryDTO.image().ifPresent(imageBase64 -> {
	    Set<Image> images = category.getImages();

	    if (images != null && !images.isEmpty()) {
		Image existingImage = images.iterator().next();
		try {
		    byte[] imageBytes = Base64.getDecoder().decode(imageBase64);
		    existingImage.setImage(imageBytes);
		    imageRepository.save(existingImage);
		} catch (IllegalArgumentExceptionCustom e) {
		    throw new IllegalArgumentException(MessageConstants.DECODE_IMAGE_FAILED + e.getMessage());
		}
	    } else {
		try {
		    Image newImage = imageService.saveImage(imageBase64);
		    category.setImages(Set.of(newImage));
		} catch (IllegalArgumentExceptionCustom e) {
		    System.err.println(MessageConstants.BASE64_DECODE_FAILED + e.getMessage());
		}
	    }
	});

	categoryRepository.save(category);
	Map<String, Object> response = new HashMap<>();
	Map<String, Object> categoryData = new HashMap<>();
	categoryData.put(StringConstants.ID, category.getId());
	categoryData.put(StringConstants.NAME, category.getName());
	categoryData.put(StringConstants.DESCRIPTION, category.getDescription());
	categoryData.put(StringConstants.IS_ACTIVE, category.getIsActive());

	if (updateCategoryDTO.image() != null) {
	    List<Map<String, Object>> imageList = category.getImages().stream().map(image -> {
		Map<String, Object> imageData = new HashMap<>();
		imageData.put(StringConstants.ID, image.getId());
		imageData.put(StringConstants.IMAGE, Base64.getEncoder().encodeToString(image.getImage()));
		return imageData;
	    }).collect(Collectors.toList());
	    categoryData.put(StringConstants.IMAGES, imageList);
	}
	response.put(StringConstants.CATEGORY, categoryData);

	return response;
    }

    @Transactional
    public void deleteCategory(Integer id) {
	if (categoryRepository.existsById(id)) {
	    categoryRepository.deleteById(id);
	} else {
	    throw new NotFoundException(MessageConstants.CATEGORY_NOT_FOUND_BY_ID + id);
	}
    }
}
