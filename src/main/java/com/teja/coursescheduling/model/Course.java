package com.teja.coursescheduling.model;

import java.util.*;

public class Course implements Comparable<Course>{
    private final String courseID;
    private final String courseName;
    private final String instructor;
    private final Date date;
    private final int minCapacity;
    private final int maxCapacity;
    private boolean isAllotted;
    private boolean isCancelled;

    private final Map<String , Employee> registeredEmployees;


    public Course(String courseID, String courseName, String instructor, Date date, int minCapacity, int maxCapacity, boolean isAllotted, boolean isCancelled) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructor = instructor;
        this.date = date;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.isAllotted = isAllotted;
        this.isCancelled = isCancelled;
        registeredEmployees = new TreeMap<>();
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public Date getDate() {
        return date;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean isAllotted() {
        return isAllotted;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setAllotted(boolean allotted) {
        isAllotted = allotted;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public Map<String, Employee> getRegisteredEmployees() {
        return registeredEmployees;
    }

    public String addEmployee(Employee e){
        String registrationID = "REG-COURSE-"+e.getName()+"-"+this.courseName;
        this.registeredEmployees.put(registrationID , e);
        return registrationID;
    }

    @Override
    public int compareTo(Course o) {
        return this.courseName.compareTo(o.courseName);
    }
}
