package ru.alex3koval.docGenerator.domain.contract

import org.apache.poi.xwpf.usermodel.XWPFParagraph

interface DocxListGenerator<T> {
    fun item(render: DocxListGenerator<T>.(T, XWPFParagraph, String) -> Unit)
    fun paragraph(builder: XWPFParagraph.() -> Unit): XWPFParagraph

    fun render()
}
