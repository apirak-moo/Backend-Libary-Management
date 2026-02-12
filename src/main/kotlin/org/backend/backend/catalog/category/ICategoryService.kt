package org.backend.backend.catalog.category

import java.util.UUID

interface ICategoryService {
    fun getAllCategory(): List<Category>
    fun getCategoryById(id: UUID): Category
    fun createCategory(request: CreateCategory): Category
    fun updateCategoryById(id: UUID, request: UpdateCategory)
    fun deleteCategoryById(id: UUID)
}