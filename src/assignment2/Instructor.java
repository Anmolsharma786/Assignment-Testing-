/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author anmol
 */
public class Instructor {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String instructorSubject;
    private String postalCode;
    private LocalDate birthDay;
    private LocalDate hireDate;
    private int collegeID;
    /*
    constructor method
    */
    public Instructor(String instructorFirstName, String instructorLastName,int instructorCollegeID,String instructorAddress, String instructorCity,String instructorPostalCode, LocalDate instructorHireDate, LocalDate instructorBirthDay ){
        firstName = instructorFirstName;
        lastName = instructorLastName;
        address = instructorAddress;
        city = instructorCity;
        postalCode = instructorPostalCode;
        this.setBirthday(instructorBirthDay);
        this.setHireDate(instructorHireDate);
         collegeID = instructorCollegeID;       
    }
    String[] array = new String[5];
    int i=0;
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
     * @return the address
     */
    public String getAddress() {
        return address+", "+getCity()+", "+getPostalCode();
    }
    /**
     * @return the birthDay
     */
    public LocalDate getBirthDay() {
        return birthDay;
    }

    /**
      * @param birthDay the birthDay to set
     */
    public void setBirthday(LocalDate birthDay) {
    LocalDate now = LocalDate.now();
    Period diff = Period.between(birthDay, now);
    int age = diff.getYears();
        if(age>=100){
        
        throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old");
        
        }
        else{
            
        this.birthDay = birthDay;        
        
        }
    }

    /**
     * @return the hireDate
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * @param hireDate the hireDate to set
     */
    public void setHireDate(LocalDate hireDate) {
    LocalDate now = LocalDate.now();
    Period diff = Period.between(hireDate, now);
    int age = diff.getYears();
        if(age>79){
        throw new IllegalArgumentException("1910-08-22 as a hire date would mean Anita started working over 80 years ago");
        }
        else{   
        this.hireDate = hireDate;
        }
    }

    /**
     * @return the collegeID
     */
    public int getCollegeID() {
        return collegeID;
    }

    /**
     * @param collegeID the collegeID to set
     */
    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }
     /*
        this method is use to get the age in years
        */
    public int getAgeInYears(){
    LocalDate now = LocalDate.now();
    Period diff = Period.between(getBirthDay(), now);
    int age = diff.getYears();
    return age;
    }
     /*
        this method is use to get years at college 
        */        
    public int yearsAtCollege(){
    LocalDate now = LocalDate.now();
    Period diff = Period.between(hireDate, now);
    int collegeYears = diff.getYears();
    return collegeYears;
    }
     /*
        this method is use to change address
        */
    public void changeAddress(String newAddress,String newCity, String newPostalCode){
    city = newCity;
    address = newAddress;
    postalCode = newPostalCode;
    }
    
  ArrayList<String> courses = new ArrayList<String>();
     /*
        this method is use to add course to abblitites
        */
    public String addCourseToAbilities(String add)
    {
        if(courses.contains(add))
        {
            return "";
        }
        else
        {
            courses.add(add);
            return add;
        }
    }
    
           
     /*
        this method is use to get the instructor name 
        */
    public String toString(){
    String instructorName = getFirstName()+" "+getLastName();
    return instructorName;
    
    }
     /*
        this method is use to list the subjects which the teacher can teach.
        */
 public String listOfSubjectsCertifiedToTeach()
    {
       if(courses.isEmpty() == true)
       {
           return "not qualified to teach courses yet.";
       }
       else
       {
           return (""+courses);
       }
    }
     /*
        this method is use to add the teacher subjects to arraylist 
        */
    
       public boolean canTeach(String subject)
    {
        if(courses.contains(subject))
        {
            return true;
        }
        else
        {
            return false;
        }
    }



    
}
