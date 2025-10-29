package ru.alex3koval.docGenerator.appImpl.command.factory

import ru.alex3koval.docGenerator.appImpl.command.CreateDocumentCommandImpl
import ru.alex3koval.docGenerator.domain.command.CreateDocumentCommand
import ru.alex3koval.docGenerator.domain.command.factory.CommandFactory
import ru.alex3koval.docGenerator.domain.contract.BaseGeneratedDocDTO
import ru.alex3koval.docGenerator.domain.contract.DocumentGenerator
import ru.alex3koval.docGenerator.domain.service.DocumentService
import ru.alex3koval.docGenerator.domain.service.FileServiceFacade

class CreateDocumentCommandFactory<T, R, DTO : BaseGeneratedDocDTO<R>>(
    private val documentService: DocumentService<T, R>,
    private val documentGenerator: DocumentGenerator<R, DTO>,
    private val fileServiceFacade: FileServiceFacade<R>
) : CommandFactory<CreateDocumentCommand<T>, CreateDocumentCommand.DTO<R, DTO>> {
    override fun create(dto: CreateDocumentCommand.DTO<R, DTO>): CreateDocumentCommand<T> = CreateDocumentCommandImpl(
        domainDto = dto.domainDto,
        documentService = documentService,
        documentGenerator = documentGenerator,
        fileServiceFacade = fileServiceFacade
    )
}
