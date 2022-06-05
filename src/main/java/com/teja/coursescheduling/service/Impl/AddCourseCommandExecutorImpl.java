package com.teja.coursescheduling.service.Impl;

import com.teja.coursescheduling.exception.InvalidInputException;
import com.teja.coursescheduling.model.Command;
import com.teja.coursescheduling.model.Course;
import com.teja.coursescheduling.service.CommandExecutor;

import java.text.SimpleDateFormat;
import java.util.*;

public class AddCourseCommandExecutorImpl implements CommandExecutor {

    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException {
        List<String> params = command.getCommandParams();
        Course course = constructCourseObject(params);
        offerCourse(courses , course);
    }

    private Course constructCourseObject(List<String> params) throws InvalidInputException {
        Course course = null;
        try{
            String courseName = params.get(0);
            String courseInstructor = params.get(1);
            SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
            Date d = inputFormat.parse(params.get(2));
            int minCount = Integer.parseInt(params.get(3));
            int maxCount = Integer.parseInt(params.get(4));
            course = new Course("OFFERING-"+courseName+"-"+courseInstructor,courseName , courseInstructor , d ,minCount , maxCount , false, false);
        }catch (Exception e){
            throw new InvalidInputException("INPUT_ERROR");
        }
        return course;
    }

    private void offerCourse(TreeMap<String, Course> courses, Course course){
        courses.put(course.getCourseID(),course);
        System.out.println(course.getCourseID());
    }

}
