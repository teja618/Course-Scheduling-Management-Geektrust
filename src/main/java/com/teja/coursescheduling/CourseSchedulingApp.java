package com.teja.coursescheduling;

import com.teja.coursescheduling.exception.InvalidInputException;
import com.teja.coursescheduling.model.Command;
import com.teja.coursescheduling.concrete.LearningManagementSystem;
import com.teja.coursescheduling.service.FileProcesserService;

import java.io.FileNotFoundException;
import java.io.IOException;


public class CourseSchedulingApp {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new FileNotFoundException("Input file is not supplied");
            } else {
                LearningManagementSystem lms = new LearningManagementSystem("Intuit");
                FileProcesserService fileProcesserService = new FileProcesserService(args[0]);
                try {
                    try {
                        Command command = fileProcesserService.processLine();
                        while (command != null) {
                            lms.fulfillCommand(command);
                            command = fileProcesserService.processLine();
                        }
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
