package org.backend.backend.catalog.category

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateCategory(
    @Size(max = 50, message = "Thai name must not exceed 50 characters")
    val nameTh: String?,
    @NotBlank(message = "English name is required")
    @Size(min = 2, max = 50, message = "English name must be between 2 and 50 characters")
    val nameEn: String,
    @Size(max = 1000, message = "Thai description must not exceed 1000 characters")
    val descriptionTh: String?,
    @Size(max = 1000, message = "English description must not exceed 1000 characters")
    val descriptionEn: String?,
    @NotNull(message = "Status is required")
    val status: Boolean
)
