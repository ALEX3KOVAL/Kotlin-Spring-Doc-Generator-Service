package ru.alex3koval.docGenerator.domain.command

import ru.alex3koval.docGenerator.domain.contract.BaseGeneratedDocDTO
import ru.alex3koval.docGenerator.domain.contract.Command

interface CreateDocumentCommand<T> : Command<T> {
    data class DTO<R, DTO : BaseGeneratedDocDTO<R>>(
        val domainDto: DTO
    )
}
