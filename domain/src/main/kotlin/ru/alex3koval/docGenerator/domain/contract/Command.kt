package ru.alex3koval.docGenerator.domain.contract

import reactor.core.publisher.Mono

interface Command<R> {
    fun execute(): Mono<R>
}
