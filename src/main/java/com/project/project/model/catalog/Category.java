package com.project.project.model.catalog;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.project.model.image.Image;
import com.project.project.model.schedule.ScheduleWeekday;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalog_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @ManyToMany
    @JoinTable(name = "link_category_weekday", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "weekday_id"))
    private Set<ScheduleWeekday> weekdays = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "link_category_flavor", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "flavor_id"))
    private Set<Flavor> flavors = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "link_category_size", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "size_id"))
    private Set<Size> sizes = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "link_category_item", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> items = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "link_category_option", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "option_id"))
    private Set<Option> options = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "link_category_image", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "image_id"))
    @JsonManagedReference
    private Set<Image> images = new HashSet<>();

    // Constructors, getters, and setters

    public Category() {
	super();
    }

    public Category(Integer id, String name, String description, Boolean isActive, ZonedDateTime createdAt,
	    ZonedDateTime updatedAt, Set<ScheduleWeekday> weekdays, Set<Flavor> flavors, Set<Size> sizes,
	    Set<Item> items, Set<Option> options, Set<Image> images) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.isActive = isActive;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.weekdays = weekdays;
	this.flavors = flavors;
	this.sizes = sizes;
	this.items = items;
	this.options = options;
	this.images = images;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Boolean getIsActive() {
	return isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public ZonedDateTime getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
	this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
	return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
	this.updatedAt = updatedAt;
    }

    public Set<ScheduleWeekday> getWeekdays() {
	return weekdays;
    }

    public void setWeekdays(Set<ScheduleWeekday> weekdays) {
	this.weekdays = weekdays;
    }

    public Set<Flavor> getFlavors() {
	return flavors;
    }

    public void setFlavors(Set<Flavor> flavors) {
	this.flavors = flavors;
    }

    public Set<Size> getSizes() {
	return sizes;
    }

    public void setSizes(Set<Size> sizes) {
	this.sizes = sizes;
    }

    public Set<Item> getItems() {
	return items;
    }

    public void setItems(Set<Item> items) {
	this.items = items;
    }

    public Set<Option> getOptions() {
	return options;
    }

    public void setOptions(Set<Option> options) {
	this.options = options;
    }

    public Set<Image> getImages() {
	return images;
    }

    public void setImages(Set<Image> images) {
	this.images = images;
    }
}
