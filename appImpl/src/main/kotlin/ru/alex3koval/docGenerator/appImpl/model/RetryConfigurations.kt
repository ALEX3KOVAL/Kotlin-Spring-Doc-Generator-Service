package ru.alex3koval.docGenerator.appImpl.model

data class RetryConfigurations(
    val configs: Map<String, Props>
) {
    data class Props(
        val maxAttempts: UShort,
        val minDelay: ULong,
        val jitter: Double
    )

    fun getConfig(name: String): Props? = configs[name]
}
