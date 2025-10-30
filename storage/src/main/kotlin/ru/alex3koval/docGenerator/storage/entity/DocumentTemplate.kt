package ru.alex3koval.docGenerator.storage.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import ru.alex3koval.docGenerator.domain.vo.DocumentFormat
import java.time.LocalDateTime

@Table(name = "document_template")
data class DocumentTemplate<ID : Any, FILE_ID>(
    @Id
    val id: ID? = null,
    @Column("model")
    val jsonModel: String,
    @Column("format")
    val format: DocumentFormat,
    @Column("file_id")
    val fileId: FILE_ID,
    @Column("clazz")
    val clazz: String,
    @Column("created_at")
    val createdAt: LocalDateTime,
    @Column("updated_at")
    val updatedAt: LocalDateTime
)
