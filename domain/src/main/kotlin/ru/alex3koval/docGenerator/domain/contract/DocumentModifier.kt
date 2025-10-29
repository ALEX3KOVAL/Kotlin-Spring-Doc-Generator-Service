package ru.alex3koval.docGenerator.domain.contract

interface DocumentModifier<R, T : BaseGeneratedDocDTO<R>> {
    fun modify(dto: T, generator: DocxGenerator<R, T>)
}
