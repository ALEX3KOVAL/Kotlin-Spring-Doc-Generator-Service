package ru.alex3koval.docGenerator.domain.common.vo

enum class Topic(val value: String) {
    DOCUMENT_GENERATION("documentGeneration"),
    DOCUMENT_GENERATION_DLT("documentGeneration.DLT");

    companion object {
        operator fun invoke(value: String): Result<Topic> = runCatching {
            entries
                .firstOrNull { topic -> topic.value == value }
                ?: throw RuntimeException("Значение топика не найдено: $value")
        }
    }
}
