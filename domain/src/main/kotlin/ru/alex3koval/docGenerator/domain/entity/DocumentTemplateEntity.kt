package ru.alex3koval.docGenerator.domain.entity

import ru.alex3koval.docGenerator.domain.contract.BaseGeneratedDocDTO
import ru.alex3koval.docGenerator.domain.vo.DocumentFormat

class DocumentTemplateEntity<ID, FILE_ID> internal constructor(
    val id: ID,
    val clazz: String,
    val fileId: FILE_ID,
    val domainDto: BaseGeneratedDocDTO,
    val format: DocumentFormat
)
