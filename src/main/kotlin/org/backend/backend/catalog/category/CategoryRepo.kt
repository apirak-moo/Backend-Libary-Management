package org.backend.backend.catalog.category

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CategoryRepo : JpaRepository<Category, UUID> {

}