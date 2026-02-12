package org.backend.backend.catalog.category

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.UUID

@RestController
@RequestMapping(path = ["/api/categories"])
class CategoryController(
    private val categoryService: ICategoryService
) {

    @GetMapping
    fun getCategories(): ResponseEntity<List<CategoryResponse>> {
        return ResponseEntity.ok().body(categoryService.getAllCategory().toCategoryList())
    }

    @GetMapping(path = ["/{id}"])
    fun getCategory(@PathVariable("id") id: UUID): ResponseEntity<CategoryResponse> {
        return ResponseEntity.ok().body(categoryService.getCategoryById(id).toCategory())
    }

    @PostMapping
    fun create(@Valid @RequestBody request: CreateCategory): ResponseEntity<CategoryResponse> {
        val created = categoryService.createCategory(request).toCategory()
        val location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.id).toUri()
        return ResponseEntity.created(location).body(created)
    }

    @PutMapping(path = ["/{id}"])
    fun update(@PathVariable("id") id: UUID,@Valid @RequestBody request: UpdateCategory): ResponseEntity<Unit> {
        categoryService.updateCategoryById(id, request)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathVariable("id") id: UUID): ResponseEntity<Unit> {
        categoryService.deleteCategoryById(id)
        return ResponseEntity.noContent().build()
    }

}