/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author anmol
 */
public class Student {
    private String prerequisite,firstName, lastName,address,city,postalCode;
    private String courseCode;
    private int studentID,yearEnrolled;
    private LocalDate admissionDate;
    private LocalDate birthDay;
    private int courseMarks;
    private boolean suspend;
    
    /*
    constructor method
    */
    public Student(String studentFirstName, String studentLastName, String studentAddress, String studentCity, String studentPostalCode, String studentCousrCode,int studentID,   LocalDate studentAdmissionDate,LocalDate studentBirthDay){
    firstName = studentFirstName;
    lastName=  studentLastName;    
    address =  studentAddress; 
    city  =  studentCity; 
    postalCode=  studentPostalCode;
    courseCode =  studentCousrCode; 
    this.setStudentID(studentID);
    admissionDate = studentAdmissionDate;
    this.setBirthday(studentBirthDay);
    }

  
    
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address+" "+city+" "+postalCode;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
    public void setCourseCode(Course courseCode) {
        this.courseCode = courseCode.toString();
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID1) {
        this.studentID = studentID1;
    }

    /**
     * @return the admissionDate
     */
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    /**
     * @param admissionDate the admissionDate to set
     */
    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * @return the birthDay
     */
    public LocalDate getBirthday() {
        return birthDay;      
        
    }

    /**
     * @param birthDay the birthDay to set
     */
    public void setBirthday(LocalDate birthDay) throws IllegalArgumentException {
        LocalDate now = LocalDate.now();
        Period diff = Period.between(birthDay, now);
        int age = diff.getYears();
        if(age>=100){
        throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
        }
        else{
        this.birthDay = birthDay;
        }
        
   /*
        this method is use to change address.
        */
    }
    public void changeAddress(String newAddress, String newCity, String newPostalCode){
    address=newAddress;
    city=newCity;
    postalCode=newPostalCode;
    }
       /*
        this method is use to check the standing of the student
        */
    public boolean inGoodStanding(){
        if(isSuspend() == true){
        return false;
        }
        else{
        return true;
        }
    }
    /*
        this method is use to check the standing of the student
        */
    public boolean suspendStudent(){
        setSuspend(true);
    return isSuspend();
    
    }
    /*
        this method is use to check the standing of the student
        */
    public boolean reinstateStudent(){
        setSuspend(false);
    return isSuspend();
    }
    /*
        this method is use to check the age
        */ 
    public int getAge(){
    LocalDate now = LocalDate.now();
    Period diff = Period.between(getBirthday(), now);
    int age = diff.getYears();
    return age;
    }

    /**
     * @return the yearEnrolled
     */
    public int getYearEnrolled() {
        return yearEnrolled;
    }

    /**
     * @param yearEnrolled the yearEnrolled to set
     */
    public void setYearEnrolled(int yearEnrolled) {
        this.yearEnrolled = yearEnrolled;
    }
    /*
        this method is use to add the completed course
        */
    public void addCompletedCourse(Course courseCode, int courseMarksObtained)throws IllegalArgumentException{
    this.setCourseCode(courseCode);
        if(courseMarksObtained>0&&courseMarksObtained<100){
            this.setCourseMarks(courseMarksObtained);
        }
        else{
            throw new IllegalArgumentException("grade must be 0-100 inclusive");
        }   
    }
     /*
        this method is use to get the completed course
        */
    public String getCompletedCourses(){
    return "["+this.getCourseCode()+" grade="+this.getCourseMarks()+"]";
    }
     /*
        this method is use to get the student number
        */
    public int getStudentNumber(){
    return this.getStudentID();
    }
     /*
        this method is use to has the completed course
        */
    public boolean hasCompleted(String courseCode){
    boolean object = true;
    if( this.getCourseMarks()<=50){
    object = false;
    }
    else{
    object = true;
    }
    return object;
    }

    /**
     * @return the courseMarks
     */
    public int getCourseMarks() {
        return courseMarks;
    }

    /**
     * @param courseMarks the courseMarks to set
     */
    public void setCourseMarks(int courseMarks) {
        this.courseMarks = courseMarks;
    }
    public String toString(){
    return getFirstName()+ " " + getLastName()+", student number: "+getStudentID();
    }

    /**
     * @return the suspend
     */
    public boolean isSuspend() {
        return suspend;
    }

    /**
     * @param suspend the suspend to set
     */
    public void setSuspend(boolean suspend) {
        this.suspend = suspend;
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
