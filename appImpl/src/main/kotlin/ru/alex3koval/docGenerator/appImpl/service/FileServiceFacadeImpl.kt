package ru.alex3koval.docGenerator.appImpl.service

import org.springframework.core.io.buffer.DataBufferUtils
import org.springframework.core.io.buffer.DefaultDataBufferFactory
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import ru.alex3koval.docGenerator.domain.service.FileServiceFacade
import ru.alex3koval.docGenerator.domain.service.dto.UploadFileRequestDTO

class FileServiceFacadeImpl<T : Any>(
    private val webClient: WebClient,
    private val fileIdClazz: Class<T>
) : FileServiceFacade<T> {
    override fun uploadFile(dto: UploadFileRequestDTO): Mono<T> = webClient
        .post()
        .uri { uriBuilder ->
            uriBuilder
                .path("file")
                .build()
        }
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .header("X-Filename", dto.filename)
        .body(
            BodyInserters.fromDataBuffers(
                DataBufferUtils
                    .readInputStream(
                        { dto.stream },
                        DefaultDataBufferFactory(),
                        65536
                    )
                    .subscribeOn(Schedulers.boundedElastic())
            )
        )
        .retrieve()
        .bodyToMono(fileIdClazz)
        .doFinally { dto.stream.close() }
        .subscribeOn(Schedulers.boundedElastic())
}
