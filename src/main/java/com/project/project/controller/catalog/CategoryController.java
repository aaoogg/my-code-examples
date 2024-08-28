package com.project.project.controller.catalog;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.constants.MessageConstants;
import com.project.project.constants.ResourcePathAndActionsConstants;
import com.project.project.constants.StringConstants;
import com.project.project.dto.catalog.category.CategoryDTO;
import com.project.project.dto.catalog.category.UpdateCategoryDTO;
import com.project.project.model.catalog.Category;
import com.project.project.service.catalog.CategoryService;
import com.project.project.util.ResponseUtil;

@RestController
@RequestMapping(ResourcePathAndActionsConstants.CATEGORY)
@CrossOrigin(origins = ResourcePathAndActionsConstants.ORIGIN)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllCategories() {
	Map<String, Object> data = Map.of(StringConstants.CATEGORIES, categoryService.getAllCategories());
	return ResponseUtil.buildSuccessResponse(HttpStatus.OK, data);
    }

    @GetMapping(ResourcePathAndActionsConstants.GET_BY_ID)
    public ResponseEntity<Map<String, Object>> getCategoryById(@PathVariable Integer id) {
	Category category = categoryService.getCategoryById(id);
	Map<String, Object> data = Map.of(StringConstants.CATEGORY, category);
	return ResponseUtil.buildSuccessResponse(HttpStatus.OK, data);
    }

    @PostMapping(ResourcePathAndActionsConstants.CREATE)
    public ResponseEntity<Map<String, Object>> createCategory(@RequestBody CategoryDTO categoryDTO) {
	Map<String, Object> response = categoryService.createCategory(categoryDTO);
	return ResponseUtil.buildSuccessResponse(HttpStatus.CREATED, response);
    }

    @PutMapping(ResourcePathAndActionsConstants.UPDATE_ID)
    public ResponseEntity<Map<String, Object>> updateCategory(@PathVariable Integer id,
	    @RequestBody UpdateCategoryDTO updateCategoryDTO) {
	Map<String, Object> response = categoryService.updateCategory(id, updateCategoryDTO);
	return ResponseUtil.buildSuccessResponse(HttpStatus.OK, response);
    }

    @DeleteMapping(ResourcePathAndActionsConstants.DELETE_ID)
    public ResponseEntity<Map<String, Object>> deleteCategory(@PathVariable Integer id) {
	categoryService.deleteCategory(id);
	return ResponseUtil.buildSuccessResponse(HttpStatus.NO_CONTENT,
		Map.of(StringConstants.MESSAGE, MessageConstants.CATEGORY_DELETE_SUCCESS));
    }
}
