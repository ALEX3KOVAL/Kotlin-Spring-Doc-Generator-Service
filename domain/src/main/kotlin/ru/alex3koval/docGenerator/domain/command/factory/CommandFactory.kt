package ru.alex3koval.docGenerator.domain.command.factory

import ru.alex3koval.docGenerator.domain.contract.Command

interface CommandFactory<COMMAND : Command<*>, COMMAND_DTO> {
    fun create(dto: COMMAND_DTO): COMMAND
}