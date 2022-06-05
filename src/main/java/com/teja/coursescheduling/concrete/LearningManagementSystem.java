package com.teja.coursescheduling.concrete;

import com.teja.coursescheduling.exception.CourseFullException;
import com.teja.coursescheduling.exception.InvalidInputException;
import com.teja.coursescheduling.model.Command;
import com.teja.coursescheduling.model.Course;
import com.teja.coursescheduling.service.CommandExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LearningManagementSystem {

    private final String organisationName;
    private final TreeMap<String , Course> courses;
    private final Map<String,Course> registrationIdCourseMap;

    public LearningManagementSystem(String name) {
        this.organisationName = name;
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    public void fulfillCommand(Command inputCommand) throws InvalidInputException {
        CommandExecutor commandExecutor = CommandExecutionFactory.getExecutor(inputCommand);
        try{
            commandExecutor.executeCommand(courses,registrationIdCourseMap, inputCommand);
        }catch(CourseFullException e ){
            System.out.println(e.getMessage());
        }
    }
}
