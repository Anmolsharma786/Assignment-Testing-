/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author anmol
 */
public class CourseWithLab extends Course{
    private String prerequisite,courseCode,courseName, room,labRoom;
    private DayOfWeek classDay,labDay;
    private LocalTime classStartTime,labStartTime;
    private int numberOfStudents;
    private  Instructor labGuy;
    private final Instructor ellaV;
    private final Instructor alec;

    /*
    constructor method
    */
    public CourseWithLab(Instructor frank, String courseCode1, String courseName1, String room1, DayOfWeek classDay1, LocalTime classStartTime1, int numberOfStudents1,Instructor labGuy1, String labRoom1, DayOfWeek labDay1, LocalTime labStartTime1) {
        super(frank, courseCode1, courseName1, room1, classDay1, classStartTime1, numberOfStudents1);
        super.setCourseCode(courseCode1);
        this.ellaV = frank;
        this.alec = frank;
        this.labGuy = labGuy1;
         labRoom=labRoom1;
        labDay=labDay1;
        this.setLabStartTime(labStartTime1);       
    }
    
    /*
    constructor method
    */
    public CourseWithLab(Instructor frank, String courseCode1, String courseName1, String room1, DayOfWeek classDay1, LocalTime classStartTime1, int numberOfStudents1,String prerequisite1,Instructor labGuy1, String labRoom1, DayOfWeek labDay1, LocalTime labStartTime1) {
        super(frank, courseCode1, courseName1, room1, classDay1, classStartTime1, numberOfStudents1);
        super.setCourseCode(courseCode1);
        this.ellaV = frank;
        this.alec = frank;
        this.labGuy = labGuy1;
         labRoom=labRoom1;
        labDay=labDay1;
        this.setLabStartTime(labStartTime1);
        this.setPrerequisite(prerequisite1);
    }
        
    /*
        this method is use to get the instructor.
        */
    @Override
    public Instructor getInstructor() {
        return ellaV; //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
        this method is use to the lab teach
        */
   public Instructor getLabTech(){
     return labGuy;
   }
   
    public void setLabTech(Instructor labInstructor){
        if(labInstructor.canTeach(this.courseCode+"-LAB")){
            this.labGuy = labInstructor;
        }
        else{
        throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
    }
   
    /*
        this method is use to the class and the time.
        */
   
   public String getLabClassAndTime(){
    return "room: "+ this.getLabRoom()+", "+this.getLabDay()+" starting at "+this.getLabStartTime();
   }
   
    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(String courseCode1) {
        this.courseCode = courseCode1;
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
     * @return the labRoom
     */
    public String getLabRoom() {
        return labRoom;
    }

    /**
     * @param labRoom the labRoom to set
     */
    public void setLabRoom(String labRoom) {
        this.labRoom = labRoom;
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
     * @return the labDay
     */
    public DayOfWeek getLabDay() {
        return labDay;
    }

    /**
     * @param labDay the labDay to set
     */
    public void setLabDay(DayOfWeek labDay) {
        this.labDay = labDay;
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
    public void setClassStartTime(LocalTime classStartTime) {
        this.classStartTime = classStartTime;
    }

    /**
     * @return the labStartTime
     */
    public LocalTime getLabStartTime() {
        return labStartTime;
    }

    /**
     * @param labStartTime the labStartTime to set
     */
    public void setLabStartTime(LocalTime labStartTime1) throws IllegalArgumentException {
         LocalTime abc = LocalTime.of(8,0);
        LocalTime dfg = LocalTime.of(18,0);
       
        if(labStartTime1.isAfter(abc)&&labStartTime1.isBefore(dfg)){
            this.labStartTime = labStartTime1;        } 
        else {
        throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
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
        this method is use to course code and name
        */
    public String toString(){
    return this.getCourseCode()+"-"+this.getCourseName()+" with lab";
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
