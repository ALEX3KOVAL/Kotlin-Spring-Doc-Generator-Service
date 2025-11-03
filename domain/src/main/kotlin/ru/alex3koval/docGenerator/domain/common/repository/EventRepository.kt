package ru.alex3koval.docGenerator.domain.common.repository

import reactor.core.publisher.Mono
import ru.alex3koval.docGenerator.domain.common.repository.dto.EventRDTO
import ru.alex3koval.eventingContract.dto.CreateEventWDTO
import ru.alex3koval.eventingContract.dto.UpdateEventWDTO
import ru.alex3koval.eventingContract.vo.EventStatus

interface EventRepository<ID> {
    fun get(id: ID): Mono<EventRDTO>
    fun add(dto: CreateEventWDTO): Mono<ID>
    fun update(id: ID, dto: UpdateEventWDTO): Mono<ID>
    fun updateStatus(id: ID, newStatus: EventStatus): Mono<ID>
}
