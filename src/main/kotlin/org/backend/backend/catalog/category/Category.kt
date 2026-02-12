package org.backend.backend.catalog.category

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.backend.backend.base.DateTimeEntity
import java.util.UUID

@Entity
@Table(name = "categories", schema = "catalog")
class Category (
    @Column(name = "name_th", length = 50, nullable = true)
    var nameTh: String?,
    @Column(name = "name_en", length = 50, nullable = false)
    var nameEn: String,
    @Column(name = "description_th", columnDefinition = "TEXT", nullable = true)
    var descriptionTh: String?,
    @Column(name = "description_en", columnDefinition = "TEXT", nullable = true)
    var descriptionEn: String?,
    @Column(name = "status", nullable = false)
    var status: Boolean,
) : DateTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    val id: UUID? = null
}