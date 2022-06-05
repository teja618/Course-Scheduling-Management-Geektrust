package com.teja.coursescheduling.model;

import com.teja.coursescheduling.enums.CommandOperator;

import java.util.List;

public class Command {
    private final CommandOperator inputCommand;
    private final List<String> commandParams;

    public Command(CommandOperator inputCommand, List<String> commandParams){
        this.inputCommand = inputCommand;
        this.commandParams = commandParams;
    }

    public CommandOperator getInputCommand() {
        return inputCommand;
    }

    public List<String> getCommandParams() {
        return commandParams;
    }

}
