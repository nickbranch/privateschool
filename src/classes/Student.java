/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import procedureClasses.DataGenerator;

public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private double tuitionFees;
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
    Random random = new Random();

    public Student(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Student() {

    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getTuitionFees() {
        return this.tuitionFees;
    }

    public double getRandomTuitionFees() {
        return randomTuitionFees();
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public void increaseFees() {
        this.tuitionFees += 2500;
    }

    public void decreaseFees(double userInput) {
        this.tuitionFees -= userInput;
    }

    private double randomTuitionFees() {
        this.tuitionFees = this.getCourses().size() * 2500.00;
        return DataGenerator.generateTuitionFees(this.tuitionFees);
    }

    public void submitRandomAssignments() {
        for (int i = 0; i < getCourses().size(); i++) {
            LocalDateTime currentTime = LocalDateTime.now(); // overloaded method to get current time
            for (int j = 0; j < getCourses().get(i).getAssignments().size(); j++) {
                int maxOral = 40;
                int minOral = 1;
                int maxTotal = 100;
                int minTotal = 40;
                getCourses().get(i).getAssignments().get(j).setOralMark(random.nextInt((maxOral - minOral) + 1) + minOral);
                LocalDateTime assignmentSubDateTime = getCourses().get(i).getAssignments().get(j).getSubDateTime();
                int compare = assignmentSubDateTime.compareTo(currentTime);
                if (compare < 0) {
                    getCourses().get(i).getAssignments().get(j).setTotalMark(random.nextInt((maxTotal - minTotal) + 1) + minTotal);
                } else if (compare > 0) {
                    getCourses().get(i).getAssignments().get(j).setTotalMark(0);
                }
            }
        }
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }
}
