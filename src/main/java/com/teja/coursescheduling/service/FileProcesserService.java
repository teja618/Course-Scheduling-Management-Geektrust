package com.teja.coursescheduling.service;

import com.teja.coursescheduling.constants.Constants;
import com.teja.coursescheduling.exception.InvalidInputException;
import com.teja.coursescheduling.model.Command;

import java.io.*;

public class FileProcesserService {
    private final File file;
    private final BufferedReader reader;

    public FileProcesserService(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        reader = new BufferedReader(new FileReader(file));
    }

    public Command processLine() throws InvalidInputException, IOException {
        String inputString = reader.readLine();
        if(inputString == null){
            return null;
        }
        if(isEmpty(inputString)){
            processLine();
        }
        try{
            return CommandService.getInstance().getCommandFromString(inputString);
        }catch(InvalidInputException e){
            System.out.println(e.getMessage());
            return processLine();
        }
    }

    private boolean isEmpty(String line) {
        return line==null || line.length()==0 || line.trim().isEmpty() || line.trim().startsWith("#");
    }
}
