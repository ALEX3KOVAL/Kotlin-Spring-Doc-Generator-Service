package ru.alex3koval.docGenerator.domain.vo

@JvmInline
value class DocumentId(val value: ULong) {
    override fun toString(): String = "$value"
}
