package ru.alex3koval.docGenerator.storage.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import ru.alex3koval.docGenerator.domain.vo.DocumentFormat
import java.time.LocalDateTime

@Table(name = "document")
class Document<T : Any, R>(
    @Id
    val id: T? = null,
    @Column("model")
    val jsonModel: String,
    @Column("format")
    val format: DocumentFormat,
    @Column("file_id")
    val fileId: R,
    @Column("created_at")
    val createdAt: LocalDateTime,
    @Column("updated_at")
    val updatedAt: LocalDateTime
)
