/*
This is an advanced data generator for synthetic data. It creates objects randomly and do random operations on them.
 */
package procedureClasses;

import classes.Assignment;
import classes.Course;
import classes.Student;
import classes.Trainer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class DataGenerator {

    static DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static Random random = new Random();
    public static Assignment a;

    public static String getRandomName() {  //generates random name from an array
        String randomName = DataStorage.getNames()[random.nextInt(DataStorage.getNames().length)];
        return randomName;
    }

    public static String getRandomLastName() { //generates random last name from an array
        String randomLastName = DataStorage.getLastNames()[random.nextInt(DataStorage.getLastNames().length)];
        return randomLastName;
    }

    public static String getRandomCsharpSubject() {  //generates a random subject for a csharp trainer
        String randomCsharpSubject = DataStorage.getSubjectsCsharp()[random.nextInt(DataStorage.getSubjectsCsharp().length)];
        return randomCsharpSubject;
    }

    public static String getRandomJavaSubject() {  //generates a random subject for a java trainer
        String randomJavaSubject = DataStorage.getSubjectsJava()[random.nextInt(DataStorage.getSubjectsJava().length)];
        return randomJavaSubject;
    }

    public static double generateTuitionFees(Double maxTuitionFees) {  //generatesTuitionFees the max is defined by the number of courses
        double max = maxTuitionFees;
        double min = 0.00;
        double randomTuitionFee = min + Math.random() * (max - min);
        return randomTuitionFee;
    }

    public static String generateCourseTitle() {  // generates random name for the course
        String courseTitle = "CB" + (random.nextInt(20) + 1) + " #" + (random.nextInt(15) + 1);
        return courseTitle;
    }

    public static String generateStream() {  // random selection 50-50 for java or c#
        String stream[] = {"Java", "C#"};
        int randomSelection = random.nextInt() + 1;
        if (randomSelection % 2 == 0) {
            return stream[0];
        } else {
            return stream[1];
        }
    }

    public static String generateType() { //random selection 50-50 for full or part time
        String type[] = {"Full time", "Part time"};
        int randomSelection = random.nextInt() + 1;
        if (randomSelection % 2 == 0) {
            return type[0];
        } else {
            return type[1];
        }
    }

    public static Assignment generateAssignment(Course c, int count) { //gets the course and the number of assignments to generate
        a = new Assignment(generateAssignmentTitle(count), generateAssignmentDesc(c, count),
                generateAssignmentDateTime(c));
        return a; //calls the methods and then returns the new assignemnt that is generated
    }

    public static String generateAssignmentTitle(int count) {  // generates the assignment title
        String title = "ASSIGNMENT No" + (count + 1);
        return title;
    }

    public static String generateAssignmentDesc(Course c, int count) {  // generate the assignment description
        String desc = "Assignment description for the course " + c.getStream() + " "
                + c.getType() + " that started at " + c.getStart_date().format(formatters);
        return desc;
    }

    public static LocalDateTime generateAssignmentDateTime(Course c) { // generate assignent date time according to type
        int startMonth;
        int startDay;
        int startYear = c.getStart_date().getYear();
        switch (c.getAssignments().size()) {
            case 0:
                if (c.getType().equalsIgnoreCase("full time")) {
                    startDay = c.getStart_date().plusWeeks(2).getDayOfMonth();
                    startMonth = c.getStart_date().plusWeeks(2).getMonthValue();
                } else {
                    startDay = c.getStart_date().plusMonths(1).getDayOfMonth();
                    startMonth = c.getStart_date().plusMonths(1).getMonthValue();
                }
                break;
            case 1:
                if (c.getType().equalsIgnoreCase("full time")) {
                    startDay = c.getStart_date().plusWeeks(4).getDayOfMonth();
                    startMonth = c.getStart_date().plusWeeks(4).getMonthValue();
                } else {
                    startDay = c.getStart_date().plusMonths(2).getDayOfMonth();
                    startMonth = c.getStart_date().plusMonths(2).getMonthValue();
                }
                break;
            case 2:
                if (c.getType().equalsIgnoreCase("full time")) {
                    startDay = c.getStart_date().plusWeeks(6).getDayOfMonth();
                    startMonth = c.getStart_date().plusWeeks(6).getMonthValue();
                } else {
                    startDay = c.getStart_date().plusMonths(3).getDayOfMonth();
                    startMonth = c.getStart_date().plusMonths(3).getMonthValue();
                }
                break;
            case 3:
                if (c.getType().equalsIgnoreCase("full time")) {
                    startDay = c.getStart_date().plusWeeks(8).getDayOfMonth();
                    startMonth = c.getStart_date().plusWeeks(8).getMonthValue();
                } else {
                    startDay = c.getStart_date().plusMonths(4).getDayOfMonth();
                    startMonth = c.getStart_date().plusMonths(4).getMonthValue();
                }
                break;
            case 4:
                if (c.getType().equalsIgnoreCase("full time")) {
                    startDay = c.getStart_date().plusWeeks(10).getDayOfMonth();
                    startMonth = c.getStart_date().plusWeeks(10).getMonthValue();
                } else {
                    startDay = c.getStart_date().plusMonths(5).getDayOfMonth();
                    startMonth = c.getStart_date().plusMonths(5).getMonthValue();
                }
                break;
            default:
                throw new AssertionError();
        }
        int hours = 23;
        int minutes = 59;
        int seconds = 59;
        if (!isLeapYear(startYear) && (startDay == 29) && (startMonth == 2)) {
            startMonth = 3;
            startDay = 1;
        }
        LocalDateTime generatedLocalDateTime = LocalDateTime.of(startYear, startMonth, startDay, hours, minutes, seconds);
        return generatedLocalDateTime;
    }

    public static LocalDateTime addTimeToSubmittedDate(LocalDate date) { // gets a localdate and transforms it to localdatetime
        int subMonth = date.getMonthValue();
        int subYear = date.getYear();
        int subDay = date.getDayOfMonth();
        int hours = 23;
        int minutes = 59;
        int seconds = 59;
        LocalDateTime generatedLocalDateTime = LocalDateTime.of(subYear, subMonth, subDay, hours, minutes, seconds);
        return generatedLocalDateTime;
    }

    public static LocalDate removeTimeFromDate(LocalDateTime dateTime) { //remove time from localdate
        int subMonth = dateTime.getMonthValue();
        int subYear = dateTime.getYear();
        int subDay = dateTime.getDayOfMonth();
        LocalDate timeRemovedLocalDate = LocalDate.of(subYear, subMonth, subDay);
        return timeRemovedLocalDate;
    }

    public static LocalDate generateDate() {  // generates a random date for the course
        int randomMonth = random.nextInt(12) + 1;
        int randomYear = 2019 + random.nextInt(2);
        int randomDay = howManydays(randomMonth, randomYear);
        if (!isLeapYear(randomYear) && (randomDay == 29) && (randomMonth == 2)) {
            randomMonth = 3;
            randomDay = 1;
        }
        LocalDate generatedDate = LocalDate.of(randomYear, randomMonth, randomDay);
        return generatedDate;
    }

    public static LocalDate generateDateOfBirth() {  // generates a random date of birth from 1970-2000
        int randomMonth = random.nextInt(12) + 1;
        int randomYear = 1970 + random.nextInt(2000 - 1970) + 1;
        int randomDay = howManydays(randomMonth, randomYear);
        if (!isLeapYear(randomYear) && (randomDay == 29) && (randomMonth == 2)) {
            randomMonth = 3;
            randomDay = 1;
        }
        LocalDate dateOfBirth = LocalDate.of(randomYear, randomMonth, randomDay);
        return dateOfBirth;
    }

    public static boolean isLeapYear(int year) {  // checks if the year is leap
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    public static int howManydays(int month, int year) { //returns the days of a month
        int randomDay;
        switch (month) {
            case 1:
                randomDay = random.nextInt(31) + 1;
                return randomDay;
            case 2:
                if (isLeapYear(year)) {
                    randomDay = random.nextInt(29) + 1;
                } else {
                    randomDay = random.nextInt(28) + 1;
                }
                return randomDay;
            case 3:
                randomDay = random.nextInt(31) + 1;
                return randomDay;
            case 4:
                randomDay = random.nextInt(30) + 1;
                return randomDay;
            case 5:
                randomDay = random.nextInt(31) + 1;
                return randomDay;
            case 6:
                randomDay = random.nextInt(20) + 1;
                return randomDay;
            case 7:
                randomDay = random.nextInt(31) + 1;
                return randomDay;
            case 8:
                randomDay = random.nextInt(31) + 1;
                return randomDay;
            case 9:
                randomDay = random.nextInt(30) + 1;
                return randomDay;
            case 10:
                randomDay = random.nextInt(31) + 1;
                return randomDay;
            case 11:
                randomDay = random.nextInt(30) + 1;
                return randomDay;
            case 12:
                randomDay = random.nextInt(31) + 1;
                return randomDay;
            default:
                throw new AssertionError();
        }
    }

    public static Course assignTrainerToCourse(Course c, ArrayList<Trainer> generatedTrainers) { //assign a trainer to a course
        if (c.getStream().equals("C#")) { // if course is c#
            for (int j = 0; j < generatedTrainers.size(); j++) {
                for (int k = 0; k < DataStorage.getSubjectsCsharp().length; k++) {   //check if trainer is c sharp trainer
                    if (generatedTrainers.get(j).getSubject().equals(DataStorage.getSubjectsCsharp()[k])) {
                        c.getTrainers().add(generatedTrainers.get(j)); //add the csharp trainer
                    }
                }
            }
        } else { // else java course
            for (int j = 0; j < generatedTrainers.size(); j++) {
                for (int k = 0; k < DataStorage.getSubjectsJava().length; k++) {   //check if trainer is java 
                    if (generatedTrainers.get(j).getSubject().equals(DataStorage.getSubjectsJava()[k])) {
                        c.getTrainers().add(generatedTrainers.get(j)); //add the java trainer
                    }
                }
            }
        }
        return c;
    }

    public static Course assignAssignmentToCourse(Course c, Assignment a) { //gets a course and an assignment and relates them
        c.getAssignments().add(a);
        return c;
    }

    public static ArrayList<Course> assignStudentToCourse(ArrayList<Course> cList, ArrayList<Student> sList) {
        for (int i = 0; i < cList.size(); i++) {
            for (int j = 0; j < sList.size(); j++) {
                for (int k = 0; k < sList.get(j).getCourses().size(); k++) {
                    if (sList.get(j).getCourses().get(k).getTitle().toLowerCase().equals(cList.get(i).getTitle().toLowerCase())) {
                        cList.get(i).getStudents().add(sList.get(j)); //inform arraylist of courses with the assigned students on each course. 
                    }
                }
            }
        }
        return cList;
    }

    public static Student randomStudentRegistration(ArrayList<Course> cList, Student s) {
        int selectArandomCourse = random.nextInt(cList.size()); // random course selection
        int temp = selectArandomCourse;
        s.getCourses().add(cList.get(selectArandomCourse)); // we add 1 course
        if (cList.size() > 1) {  // if we have more than 1 course we can add second course randomly to a student
            int randomSelection = random.nextInt(200 + 1);
            if (randomSelection % 2 == 0  && randomSelection > 100) { // 1 out of 4 chances for a student to register in a second course
                //System.out.println("randomselection is " + randomSelection);  //testing purposes
                while (selectArandomCourse == temp) {  // we do this so we do not select randomly the same course
                    selectArandomCourse = random.nextInt(cList.size());
                }
                s.getCourses().add(cList.get(selectArandomCourse));
            }
        }
        return s;
    }
}
