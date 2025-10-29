package ru.alex3koval.docGenerator.configuration.di

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import ru.alex3koval.docGenerator.appImpl.command.factory.CreateDocumentCommandFactory
import ru.alex3koval.docGenerator.appImpl.service.DocumentGeneratorImpl
import ru.alex3koval.docGenerator.appImpl.service.DocumentServiceImpl
import ru.alex3koval.docGenerator.appImpl.service.FileServiceFacadeImpl
import ru.alex3koval.docGenerator.domain.contract.DocumentGenerator
import ru.alex3koval.docGenerator.domain.repository.document.DocumentRepository
import ru.alex3koval.docGenerator.domain.service.DocumentService
import ru.alex3koval.docGenerator.domain.service.FileServiceFacade
import ru.alex3koval.docGenerator.storage.repository.impl.document.DocumentRepositoryImpl
import ru.alex3koval.docGenerator.storage.repository.orm.OrmDocumentRepository

@Configuration
class TypeDependentConfiguration(
    private val objectMapper: ObjectMapper
) {
    @Bean
    fun documentGenerator(): DocumentGenerator<ULong, *> = DocumentGeneratorImpl()

    @Bean
    fun documentRepository(
        ormDocumentRepository: OrmDocumentRepository<ULong, ULong>
    ): DocumentRepository<ULong, ULong> = DocumentRepositoryImpl(
        ormRepository = ormDocumentRepository
    )

    @Bean
    fun documentService(
        documentRepository: DocumentRepository<ULong, ULong>
    ): DocumentService<ULong, ULong> = DocumentServiceImpl(
        repository = documentRepository,
        objectMapper = objectMapper
    )

    @Bean
    fun createDocumentCommandFactory(
        documentService: DocumentService<ULong, ULong>,
        documentGenerator: DocumentGenerator<ULong, *>,
        fileServiceFacade: FileServiceFacade<ULong>
    ): CreateDocumentCommandFactory<ULong, ULong, *> = CreateDocumentCommandFactory(
        documentService = documentService,
        documentGenerator = documentGenerator,
        fileServiceFacade = fileServiceFacade
    )

    @Bean
    fun fileServiceFacade(
        @Qualifier("fileServiceFacadeWebClient") fileServiceFacadeWebClient: WebClient
    ): FileServiceFacade<ULong> = FileServiceFacadeImpl(
        fileServiceFacadeWebClient,
        ULong::class.java
    )
}
