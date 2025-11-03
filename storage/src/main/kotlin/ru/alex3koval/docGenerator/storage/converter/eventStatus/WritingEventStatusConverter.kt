package ru.alex3koval.docGenerator.storage.converter.eventStatus

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter
import ru.alex3koval.eventingContract.vo.EventStatus

@WritingConverter
class WritingEventStatusConverter : Converter<EventStatus, UShort> {
    override fun convert(source: EventStatus): UShort? = source.value.toUShort()
}
