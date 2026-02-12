package org.backend.backend.catalog.category

fun Category.toCategory(): CategoryResponse {
    return CategoryResponse(
        this.id,
        this.nameTh,
        this.nameEn,
        this.descriptionTh,
        this.descriptionEn,
        this.status
    )
}

fun List<Category>.toCategoryList(): List<CategoryResponse> {
    return this.map { category -> category.toCategory() }
}