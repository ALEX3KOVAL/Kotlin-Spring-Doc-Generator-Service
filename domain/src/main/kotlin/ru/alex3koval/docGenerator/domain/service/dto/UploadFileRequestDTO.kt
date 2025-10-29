package ru.alex3koval.docGenerator.domain.service.dto

import ru.alex3koval.docGenerator.domain.vo.DocumentFormat
import java.io.InputStream

data class UploadFileRequestDTO(
    val filename: String,
    val hash: String,
    val size: ULong,
    val format: DocumentFormat,
    val stream: InputStream
)
