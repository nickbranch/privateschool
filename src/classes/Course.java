/*

 */
package classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Course {

    private String title;
    private String stream; //java or c#
    private String type; // part time or full time
    private LocalDate start_date;
    private LocalDate end_date;
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
    private ArrayList<Trainer> trainers = new ArrayList<Trainer>();
    private Course c;

    public Course(String title, String stream, String type, LocalDate start_date) { //random course constructor
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        setEnd_date();
    }

    public Course() {

    }

    public Course(Course c) {
        this.c = c;
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(ArrayList<Trainer> trainers) {
        this.trainers = trainers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date() {
        if (this.type.equalsIgnoreCase("full time")) {
            this.end_date = (this.start_date.plusMonths(3));  //sets end date to start date plus 3|6 months depening on type
        } else {
            this.end_date = (this.start_date.plusMonths(6));
        }
    }

    public void setEnd_date(LocalDate date) {
        this.end_date = date;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

}
