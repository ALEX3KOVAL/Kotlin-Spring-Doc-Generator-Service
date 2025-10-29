package ru.alex3koval.docGenerator.server.api

import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ru.alex3koval.docGenerator.appImpl.command.factory.CreateDocumentCommandFactory
import ru.alex3koval.docGenerator.domain.command.CreateDocumentCommand
import ru.alex3koval.docGenerator.server.api.dto.request.CreateDocumentRequest

@RestController
@RequestMapping("document")
class DocumentController(
    private val createDocumentCommandFactory: CreateDocumentCommandFactory<*, *, *>
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun add(
        @Validated @RequestBody body: CreateDocumentRequest
    ): Int = createDocumentCommandFactory
        .create(
            dto = CreateDocumentCommand.DTO(

            )
        )
        .execute()
        .getOrThrow()
}