package ru.alex3koval.docGenerator.appImpl.service.factory

import ru.alex3koval.docGenerator.appImpl.model.RetryConfigurations
import ru.alex3koval.docGenerator.appImpl.service.RetryService

class RetryServiceFactory(
    private val retryConfigs: RetryConfigurations
) {
    fun create(retryName: String): RetryService = RetryService(
        configProps = retryConfigs.getConfig(name = retryName)!!
    )
}
