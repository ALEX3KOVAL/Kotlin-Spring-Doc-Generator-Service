package ru.alex3koval.docGenerator.storage.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import ru.alex3koval.eventingContract.vo.EventStatus
import java.time.LocalDateTime

data class TransactionalOutbox<ID : Any>(
    @Id
    val id: ID? = null,
    @Column("name")
    val name: String,
    @Column("topic")
    val topic: String,
    @Column("status")
    val status: EventStatus,
    @Column("json")
    val json: String,
    @Column("created_at")
    val createdAt: LocalDateTime,
    @Column("updated_at")
    val updatedAt: LocalDateTime
)
