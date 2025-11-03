package ru.alex3koval.docGenerator.domain.contract

import ru.alex3koval.docGenerator.domain.service.generator.DocxGenerator

interface DocumentModifier<DTO : BaseGeneratedDocDTO> {
    fun modify(dto: DTO, generator: DocxGenerator)
}
