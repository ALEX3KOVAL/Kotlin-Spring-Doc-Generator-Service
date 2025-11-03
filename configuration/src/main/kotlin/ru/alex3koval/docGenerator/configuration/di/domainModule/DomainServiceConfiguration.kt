package ru.alex3koval.docGenerator.configuration.di.domainModule

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import ru.alex3koval.docGenerator.appImpl.service.FileConverterImpl
import ru.alex3koval.docGenerator.appImpl.service.UnoconvFacadeImpl
import ru.alex3koval.docGenerator.appImpl.service.factory.DocxGeneratorFactory
import ru.alex3koval.docGenerator.appImpl.service.generator.DocumentGeneratorImpl
import ru.alex3koval.docGenerator.appImpl.service.generator.FileGeneratorImpl
import ru.alex3koval.docGenerator.domain.service.FileConverter
import ru.alex3koval.docGenerator.domain.service.FileGenerator
import ru.alex3koval.docGenerator.domain.service.UnoconvFacade
import ru.alex3koval.docGenerator.domain.service.generator.DocumentGenerator

@Configuration
class DomainServiceConfiguration() {
    @Bean
    fun fileConverter(unoconvFacade: UnoconvFacade): FileConverter = FileConverterImpl(
        unoconvFacade = unoconvFacade
    )

    @Bean
    fun unoconvFacade(
        @Qualifier("unoconvWebClient") unoconvWebClient: WebClient
    ): UnoconvFacade = UnoconvFacadeImpl(
        webClient = unoconvWebClient
    )

    @Bean
    fun docxGeneratorFactory(): DocxGeneratorFactory = DocxGeneratorFactory()

    @Bean
    fun fileGenerator(
        docxGeneratorFactory: DocxGeneratorFactory,
        fileConverter: FileConverter
    ): FileGenerator = FileGeneratorImpl(
        docxGeneratorFactory = docxGeneratorFactory,
        fileConverter = fileConverter
    )

    @Bean
    fun documentGenerator(
        fileGenerator: FileGenerator
    ): DocumentGenerator = DocumentGeneratorImpl(
        fileGenerator = fileGenerator
    )
}
