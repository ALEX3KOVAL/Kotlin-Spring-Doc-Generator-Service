package ru.alex3koval.docGenerator.domain.contract

import ru.alex3koval.docGenerator.domain.vo.DocumentFormat
import java.io.Closeable
import java.io.InputStream

abstract class Document : Closeable {
    abstract val name: String
    abstract val stream: InputStream
    abstract val format: DocumentFormat
    abstract val size: ULong
    abstract val hash: String

    override fun close() = stream.close()
}
