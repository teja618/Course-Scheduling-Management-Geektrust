package com.example.geektrust.enums;

import com.teja.coursescheduling.enums.CommandOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;

public class CommandOperatorTest {

    Integer registerValue;
    Integer courseOfferingValue;

    @BeforeEach
    public void setup(){
        registerValue = 2;
        courseOfferingValue = 5;
    }
    @Test
    public void testGetNumberOfArguments() {
        assertEquals(Optional.of(CommandOperator.REGISTER.getNumberOfArguments()).get(),registerValue);
        assertEquals(Optional.of(CommandOperator.ADD_COURSE_OFFERING.getNumberOfArguments()).get(),courseOfferingValue);
    }
}
