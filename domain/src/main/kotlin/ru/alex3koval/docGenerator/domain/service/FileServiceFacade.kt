package ru.alex3koval.docGenerator.domain.service

import reactor.core.publisher.Mono
import ru.alex3koval.docGenerator.domain.service.dto.UploadFileRequestDTO

interface FileServiceFacade<T> {
    fun uploadFile(dto: UploadFileRequestDTO): Mono<T>
}
