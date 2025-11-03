package ru.alex3koval.docGenerator.domain.contract

import ru.alex3koval.docGenerator.domain.vo.DocumentFormat
import java.io.Closeable
import java.io.InputStream

abstract class DocumentContent : Closeable {
    abstract val stream: InputStream
    abstract val format: DocumentFormat

    override fun close() = stream.close()
}
