package com.project.project.dto.catalog.category;

import java.util.Optional;

public record UpdateCategoryDTO(Optional<String> name, Optional<String> description, Optional<Boolean> isActive,
	Optional<String> image) {
}