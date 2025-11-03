package ru.alex3koval.docGenerator.domain.vo

enum class DocumentStatus(val value: UShort) {
    IN_PROCESS(0U),
    COMPLETED(1U),
    ARCHIVE(2U);

    companion object {
        operator fun invoke(value: String): Result<DocumentStatus> = runCatching {
            val preprocessed: UShort = value.toUShort()

            entries
                .firstOrNull { entry -> entry.value == preprocessed }
                ?: throw RuntimeException("Не найдено значение статуса: $preprocessed")
        }

        operator fun invoke(value: UShort): Result<DocumentStatus> = runCatching {
            entries
                .firstOrNull { entry -> entry.value == value }
                ?: throw RuntimeException("Не найдено значение статуса: $value")
        }
    }
}
