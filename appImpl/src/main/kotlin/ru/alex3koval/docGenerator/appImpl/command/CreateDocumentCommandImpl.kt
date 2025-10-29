package ru.alex3koval.docGenerator.appImpl.command

import reactor.core.publisher.Mono
import ru.alex3koval.docGenerator.domain.command.CreateDocumentCommand
import ru.alex3koval.docGenerator.domain.contract.BaseGeneratedDocDTO
import ru.alex3koval.docGenerator.domain.contract.DocumentGenerator
import ru.alex3koval.docGenerator.domain.service.DocumentService
import ru.alex3koval.docGenerator.domain.service.FileServiceFacade
import ru.alex3koval.docGenerator.domain.service.dto.UploadFileRequestDTO

class CreateDocumentCommandImpl<DOC_ID, FILE_ID, DTO : BaseGeneratedDocDTO<FILE_ID>>(
    private val domainDto: DTO,
    private val documentService: DocumentService<DOC_ID, FILE_ID>,
    private val documentGenerator: DocumentGenerator<FILE_ID, DTO>,
    private val fileServiceFacade: FileServiceFacade<FILE_ID>
) : CreateDocumentCommand<DOC_ID> {
    override fun execute(): Mono<DOC_ID> {
        return documentGenerator
            .generate(data = domainDto)
            .flatMap { document ->
                fileServiceFacade.uploadFile(
                    UploadFileRequestDTO(
                        filename = document.name,
                        hash = document.hash,
                        size = document.size,
                        format = document.format,
                        stream = document.stream
                    )
                )
            }
            .flatMap { fileId ->
                documentService.createDocument(
                    fileId = fileId,
                    domainDto = domainDto,
                )
            }
    }
}
