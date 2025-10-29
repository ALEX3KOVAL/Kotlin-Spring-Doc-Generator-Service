package ru.alex3koval.docGenerator.domain.contract

import ru.alex3koval.docGenerator.domain.vo.DocumentFormat

abstract class BaseGeneratedDocDTO<T> {
    abstract val templateId: T
    abstract val format: DocumentFormat
}
