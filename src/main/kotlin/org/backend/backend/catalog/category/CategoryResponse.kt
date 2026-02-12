package org.backend.backend.catalog.category

import java.time.Instant
import java.util.UUID

data class CategoryResponse(
    val id: UUID?,
    val nameTh: String?,
    val nameEn: String,
    val descriptionTh: String?,
    val descriptionEn: String?,
    val status: Boolean,
    val createdAt: Instant,
    val updatedAt: Instant,
)
