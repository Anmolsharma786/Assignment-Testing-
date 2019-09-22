/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author anmol
 */
public class Course {
    private String prerequisite,courseCode,courseName,room;
    private DayOfWeek classDay;
    private LocalTime classStartTime;
    private int numberOfStudents;
    private final Instructor frank;
    private final Instructor labGuy;
    private int classSize;
    private int numberOfStudents1;
  
    
    /*
    constructor method
    */
    public Course(Instructor frank, String courseCode1, String courseName1, String room1, DayOfWeek classDay1, LocalTime classStartTime1, int numberOfStudents1) {
        this.frank = frank;
        this.setCourseCode(courseCode1);
        this.setClassDay(classDay1);
        this.setRoom(room1);
        this.setCourseName(courseName1);
        this.setClassStartTime(classStartTime1);
        this.setNumberOfStudents(numberOfStudents1);
        this.labGuy = frank;
    }
    
    /*
    constructor method
    */
    public Course(Instructor frank, String courseCode1, String courseName1, String room1, DayOfWeek classDay1, LocalTime classStartTime1, int numberOfStudents1,String prerequisite1) {
        this.frank = frank;
        this.setCourseCode(courseCode1);
        this.setClassDay(classDay1);
        this.setRoom(room1);
        this.setCourseName(courseName1);
        this.setClassStartTime(classStartTime1);
        this.setNumberOfStudents(numberOfStudents1);
        this.setPrerequisite(prerequisite1);
        this.labGuy = frank;
    }
     /*
        this method is use to set the class size
        */
    public String setClassSize(int ClassSize){
    String abc = "";
    if(ClassSize==40){
    this.classSize = ClassSize;

    }
    else if(ClassSize>=40){
    this.classSize  = 40;
    abc = "Max class size = 40, it has been set to 40";
    }
    return abc;
    }
     /*
        this method is use to get the class size
        */
    public int getClassSize(){
    return classSize=40;
    }
   


    
    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }
//  ArrayList<String> courses = new ArrayList<String>();
    
//    public String addCourseToAbilities(String add)
//    {
//        if(courses.contains(add))
//        {
//            return "";
//        }
//        else
//        {
//            courses.add(add);
//            return add;
//        }
//    }     frank.courses.contains(courseCode1)||labGuy.courses.contains(courseCode1+"-LAB")
    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(String courseCode1){
       
        if(frank.courses.contains(courseCode1)){
            this.courseCode = courseCode1; 
            
        }
        
        else{
                throw new IllegalArgumentException("Professor "+this.getInstructor()+" is not qualified to teach "+courseCode1);
            }
        }
        
    

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * @return the classDay
     */
    public DayOfWeek getClassDay() {
        return classDay;
    }

    /**
     * @param classDay the classDay to set
     */
    public void setClassDay(DayOfWeek classDay) {
        this.classDay = classDay;
    }

    /**
     * @return the classStartTime
     */
    public LocalTime getClassStartTime() {
        return classStartTime;
    }

    /**
     * @param classStartTime the classStartTime to set
     */
    public void setClassStartTime(LocalTime classStartTime)throws IllegalArgumentException {
        LocalTime abc = LocalTime.of(8,0);
        LocalTime dfg = LocalTime.of(18,0);
       
        if(classStartTime.isAfter(abc)&&classStartTime.isBefore(dfg)){
            
        this.classStartTime = classStartTime;    
        } 
        else {
        throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        }
        
    }

    /**
     * @return the numberOfStudents
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * @param numberOfStudents the numberOfStudents to set
     */
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
     /*
        this method is use to get the course code and name
        */
    public String toString(){
   String abc = this.getCourseCode()+"-"+this.getCourseName();
    return abc;
    }
     /*
        this method is use to get the course day and time
        */
    public String getCourseDayAndTime(){
    String abc = this.getClassDay()+"'s, starting at "+this.getClassStartTime();
    return abc;
    }
     /*
        this method is use to get the instructor
        */
    public Instructor getInstructor(){
    return frank;
    }

   
    ArrayList<Student> classSize1 = new ArrayList<Student>();
    int i=0;
     /*
        this method is use to add student to course
        */
    public String addStudent(Student st1)
    {
        
        String added = "";
   
       if(st1.isSuspend()==false){
       
        if(i<this.getNumberOfStudents()){
            classSize1.add(st1);
            added = classSize1.get(i).toString();
            i++;
        }

        else{
        added = "Student was not added because the course is full";
        }
       }
       else if(st1.isSuspend()==true){
       added = "The Student is not in good standing and cannot join the course.";
       }
       
       
              
        return added;
    }
     /*
        this method is use to show the class list
        */
    public String showClassList(){ 
    String abc = "";    
    for(int i=0;i<classSize1.size();i++){
    abc =  classSize1.get(i).toString();
    }
    return abc;
    }
     /*
        this method is use to check whether the class is mature or not.
        */
  public  boolean matureClass() {
      boolean mature;
      int age = 0;
      for(int i=0;i<classSize1.size();i++){
      age += (classSize1.get(i).getAge());
      }
      age = age/classSize1.size();
      if(age>25){
      mature = true;
      }
      else{
      mature = false;
      }
      return mature;
    }

    /**
     * @return the prerequisite
     */
    public String getPrerequisite() {
        return prerequisite;
    }

    /**
     * @param prerequisite the prerequisite to set
     */
    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
       
    }
}