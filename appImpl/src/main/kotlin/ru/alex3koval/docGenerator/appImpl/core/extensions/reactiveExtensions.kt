package ru.alex3koval.docGenerator.appImpl.core.extensions

import org.springframework.core.io.buffer.DataBuffer
import org.springframework.core.io.buffer.DataBufferUtils
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream

internal fun WebClient.RequestHeadersSpec<*>.buildByteArrayInputStream(): Mono<InputStream> {
    val byteArrayOutputStream = ByteArrayOutputStream()

    return exchangeToFlux { response ->
        if (response.statusCode().is2xxSuccessful) {
            return@exchangeToFlux response.bodyToFlux(DataBuffer::class.java)
        }

        return@exchangeToFlux response
            .createError<DataBuffer>()
            .flux()
    }
        .`as` { bufferFlux -> DataBufferUtils.write(bufferFlux, byteArrayOutputStream) }
        .then(Mono.just(byteArrayOutputStream))
        .map { outputStream -> ByteArrayInputStream(outputStream.toByteArray()) }
}
