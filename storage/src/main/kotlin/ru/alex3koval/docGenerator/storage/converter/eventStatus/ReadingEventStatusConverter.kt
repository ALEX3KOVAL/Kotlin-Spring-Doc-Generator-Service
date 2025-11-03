package ru.alex3koval.docGenerator.storage.converter.eventStatus

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import ru.alex3koval.eventingContract.vo.EventStatus
import kotlin.jvm.optionals.getOrNull

@ReadingConverter
class ReadingEventStatusConverter : Converter<UShort, EventStatus> {
    override fun convert(source: UShort): EventStatus? = EventStatus
        .of(source.toShort())
        .getOrNull()
}
