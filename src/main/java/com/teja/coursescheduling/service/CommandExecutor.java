package com.teja.coursescheduling.service;

import com.teja.coursescheduling.exception.CourseFullException;
import com.teja.coursescheduling.exception.InvalidInputException;
import com.teja.coursescheduling.model.Command;
import com.teja.coursescheduling.model.Course;

import java.util.Map;
import java.util.TreeMap;

public interface CommandExecutor {
    void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException, CourseFullException;
}
