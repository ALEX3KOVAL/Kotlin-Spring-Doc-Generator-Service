package ru.alex3koval.docGenerator.domain.vo

enum class DocumentFormat(val value: String) {
    DOCX("docx"),
    PDF("pdf");

    companion object {
        operator fun invoke(format: String): Result<DocumentFormat> = runCatching {
            entries
                .firstOrNull { it.value.equals(format, ignoreCase = true) }
                ?: throw RuntimeException("Неизвестный формат: $format")
        }
    }
}
