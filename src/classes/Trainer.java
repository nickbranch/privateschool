/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.Random;
import procedureClasses.DataStorage;

public class Trainer {

    private static Random random = new Random();

    private String firstName;
    private String lastName;
    private String subject;
    private ArrayList<Course> courses = new ArrayList<Course>();

    public String getFirstName() {
        return firstName;
    }

    public Trainer(String firstName, String lastName) { //random trainer constructor
        this.firstName = firstName;
        this.lastName = lastName;
        int randomSelection = random.nextInt(); // decision if trainers subject is c# or java
        if (randomSelection % 2 == 0) {
                this.subject = DataStorage.getSubjectsCsharp()[random.nextInt(DataStorage.getSubjectsCsharp().length)];
        } else { //get subject depending on random decision from array on DataStorage
                this.subject = DataStorage.getSubjectsJava()[random.nextInt(DataStorage.getSubjectsJava().length)];
        }
    }
    public Trainer(){
        
    };

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
