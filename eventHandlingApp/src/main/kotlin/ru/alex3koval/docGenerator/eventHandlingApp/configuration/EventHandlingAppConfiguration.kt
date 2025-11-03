package ru.alex3koval.docGenerator.eventHandlingApp.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import ru.alex3koval.docGenerator.common.configuration.CommonModuleConfiguration
import ru.alex3koval.docGenerator.configuration.di.AppCommonConfiguration
import ru.alex3koval.docGenerator.eventHandlingApp.settings.ListenersRegistrationProps
import ru.alex3koval.kafkaEventer.EventerConfiguration
import ru.alex3koval.kafkaEventer.ListenersRegistrationConfig

@Configuration
@Import(
    AppCommonConfiguration::class,
    EventerConfiguration::class,
    EventListenerConfiguration::class,
    CommonModuleConfiguration::class
)
class EventHandlingAppConfiguration {
    @Bean
    fun listenersRegistrationProps(): ListenersRegistrationProps = ListenersRegistrationProps()

    @Bean
    fun listenersRegistrationConfig(
        listenersRegistrationProps: ListenersRegistrationProps
    ): ListenersRegistrationConfig = ListenersRegistrationConfig(listenersRegistrationProps.allProps)
}
