package com.teja.coursescheduling.enums;

public enum CommandOperator {
    ADD_COURSE_OFFERING(5),
    CANCEL(1),
    REGISTER(2),
    ALLOT(1);

    CommandOperator(Integer numArgs){
        this.numberOfArguments = numArgs;
    }

    private final Integer numberOfArguments;

    public Integer getNumberOfArguments() {
        return numberOfArguments;
    }
}

