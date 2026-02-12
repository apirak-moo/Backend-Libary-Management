package org.backend.backend.catalog.category

import org.backend.backend.exception.ResourceNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class CategoryService(
    private val categoryRepo: CategoryRepo
) : ICategoryService {

    @Transactional(readOnly = true)
    override fun getAllCategory(): List<Category> {
        return categoryRepo.findAll()
    }

    @Transactional(readOnly = true)
    override fun getCategoryById(id: UUID): Category {
        return categoryRepo.findById(id).orElseThrow {
            ResourceNotFoundException("category not found")
        }
    }

    @Transactional
    override fun createCategory(request: CreateCategory): Category {
        val category = Category(
            nameTh = request.nameTh,
            nameEn = request.nameEn,
            descriptionTh = request.descriptionTh,
            descriptionEn = request.descriptionEn,
            status = false
        )
        return categoryRepo.save(category)
    }

    @Transactional
    override fun updateCategoryById(id: UUID, request: UpdateCategory) {
        val category = getCategoryById(id)
        category.nameTh = request.nameTh
        category.nameEn = request.nameEn
        category.descriptionTh = request.descriptionTh
        category.descriptionEn = request.descriptionEn
        category.status = request.status
        categoryRepo.save(category)
    }

    @Transactional
    override fun deleteCategoryById(id: UUID) {
        return categoryRepo.deleteById(id)
    }

}