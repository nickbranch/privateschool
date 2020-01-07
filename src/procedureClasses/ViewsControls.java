/*
This is the class responsible for every VIEW action that the application will need. It does not edit data. It only prints data
in some ordered format.
 */
package procedureClasses;

import classes.Assignment;
import classes.Course;
import classes.Student;
import classes.Trainer;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import static procedureClasses.DataGenerator.*;
import static procedureClasses.ViewsControls.formatters;

public class ViewsControls {

    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    static DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");

    public static void showAllCourses() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList = Populate.getGeneratedCourses();
        if (courseList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NOT COURSES REGISTERED |");
            System.out.println("|-----------------------------------|");
        } else {
            System.out.println("-----------------------------------Courses----------------------------------------------");
            System.out.println("|    Course Title    |" + "|    Stream   |" + "|    Type   |" + "|    Start Date   |" + "|    End Date   |");
            System.out.println("----------------------------------------------------------------------------------------");
            for (int i = 0; i < courseList.size(); i++) {
                System.out.println((i + 1) + "|   " + courseList.get(i).getTitle() + "         ||    " + courseList.get(i).getStream() + "    ||    "
                        + courseList.get(i).getType() + "   ||   " + courseList.get(i).getStart_date().format(formatters) + "   ||   "
                        + courseList.get(i).getEnd_date().format(formatters) + "   |   ");
            }
        }
    }

    public static void showAllAssignments() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList = Populate.getGeneratedCoursesAssignments();
        if (courseList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NOT COURSES REGISTERED |");
            System.out.println("|-----------------------------------|");
        } else {
            for (int i = 0; i < courseList.size(); i++) {
                System.out.println("-----------------------------------COURSE----------------------------------------------");
                System.out.println("|    Course Title    ||    Stream   ||    Type   ||    Start Date   ||      End Date   |");
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println((i + 1) + "|   " + courseList.get(i).getTitle() + "         ||    " + courseList.get(i).getStream() + "    ||    "
                        + courseList.get(i).getType() + "   ||   " + courseList.get(i).getStart_date().format(formatters) + "   ||   "
                        + courseList.get(i).getEnd_date().format(formatters) + "   |   ");
                System.out.println("---------------------------------------------------------------------ASSIGNMENTS------------------------------------------------------------------------");
                System.out.println("|         Title        ||                              Description                            ||    Submit Date & Time   ||  Oral Mark ||  Total Mark   |");
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                for (int j = 0; j < courseList.get(i).getAssignments().size(); j++) {
                    System.out.println((j + 1) + "|   " + courseList.get(i).getAssignments().get(j).getTitle() + " || " + courseList.get(i).getAssignments().get(j).getDescription()
                            + " || " + courseList.get(i).getAssignments().get(j).getSubDateTime().format(format) + "   ||   " + courseList.get(i).getAssignments().get(j).getOralMark()
                            + " || " + courseList.get(i).getAssignments().get(j).getTotalMark() + " |");
                }
                System.out.println("\n");
            }
        }
    }

    public static void showAllStudentsPerCourse() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList = Populate.getGeneratedCourses();
        if (courseList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NO  COURSES REGISTERED |");
            System.out.println("|-----------------------------------|");
        } else {
            for (int i = 0; i < courseList.size(); i++) {
                System.out.println("-----------------------------------COURSE----------------------------------------------");
                System.out.println("|    Course Title    ||    Stream   ||    Type   ||    Start Date   ||      End Date   |");
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println((i + 1) + "|   " + courseList.get(i).getTitle() + "         ||    " + courseList.get(i).getStream() + "    ||    "
                        + courseList.get(i).getType() + "   ||   " + courseList.get(i).getStart_date().format(formatters) + "   ||   "
                        + courseList.get(i).getEnd_date().format(formatters) + "   |   ");
                System.out.println("----------STUDENTS-----------");
                System.out.println("|   Name   ||   Last Name   |");
                System.out.println("-----------------------------");
                for (int j = 0; j < courseList.get(i).getStudents().size(); j++) {
                    System.out.println((j + 1) + "|   " + courseList.get(i).getStudents().get(j).getFirstName() + " || " + courseList.get(i).getStudents().get(j).getLastName() + " || ");
                }
                System.out.println("\n");
            }
        }
    }

    public static void showAllTrainersPerCourse() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList = Populate.getGeneratedCourses();
        if (courseList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NO  COURSES REGISTERED |");
            System.out.println("|-----------------------------------|");
        } else {
            for (int i = 0; i < courseList.size(); i++) {
                System.out.println("-----------------------------------COURSE----------------------------------------------");
                System.out.println("|    Course Title    ||    Stream   ||    Type   ||    Start Date   ||      End Date   |");
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println((i + 1) + "|   " + courseList.get(i).getTitle() + "         ||    " + courseList.get(i).getStream() + "    ||    "
                        + courseList.get(i).getType() + "   ||   " + courseList.get(i).getStart_date().format(formatters) + "   ||   "
                        + courseList.get(i).getEnd_date().format(formatters) + "   |   ");
                System.out.println("----------TRAINERS-----------");
                System.out.println("|   Name   ||   Last Name   |");
                System.out.println("-----------------------------");
                for (int j = 0; j < courseList.get(i).getTrainers().size(); j++) {
                    System.out.println((j + 1) + "|   " + courseList.get(i).getTrainers().get(j).getFirstName() + " || " + courseList.get(i).getTrainers().get(j).getLastName() + " || ");
                }
                System.out.println("\n");
            }
        }
    }

    public static void showAllTrainers() {
        ArrayList<Trainer> trainerList = new ArrayList<Trainer>();
        trainerList = Populate.getGeneratedTrainers();
        if (trainerList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NO TRAINERS REGISTERED |");
            System.out.println("|-----------------------------------|");
        } else {
            System.out.println("------------------   TRAINERS  --------------");
            System.out.println("|    Name    ||    Last Name   ||    Subject |");
            System.out.println("---------------------------------------------");
            for (int i = 0; i < trainerList.size(); i++) {
                System.out.println("|" + (i + 1) + "  | " + trainerList.get(i).getFirstName() + "   ||   " + trainerList.get(i).getLastName() + "   || "
                        + trainerList.get(i).getSubject() + " |");
            }
        }
    }

    public static void showAllStudents() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList = Populate.getGeneratedStudents();
        if (studentList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NO STUDENTS REGISTERED |");
            System.out.println("|-----------------------------------|");
        } else {
            System.out.println("--------------------------------STUDENTS-------------------------------");
            System.out.println("|    Name    ||    Last Name   ||    Date Of Birth ||   Tuition Fees  |");
            System.out.println("-----------------------------------------------------------------------");
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println("|" + (i + 1) + "  | " + studentList.get(i).getFirstName() + "   ||   " + studentList.get(i).getLastName() + "   ||            "
                        + studentList.get(i).getDateOfBirth().format(formatters) + "      ||      " + studentList.get(i).getTuitionFees() + "|");
            }
        }
    }

    public static void showStudentsOfMultipleCourses() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList = Populate.getGeneratedStudents();
        if (studentList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NO STUDENTS REGISTERED |");
            System.out.println("|-----------------------------------|");
        } else {
            System.out.println("------------------STUDENTS THAT ARE REGISTERED IN 2 OR MORE COURSES-------------------------");
            System.out.println("|    Name    ||    Last Name   ||    Date Of Birth ||   Tuition Fees  |  Number Of Courses |");
            System.out.println("--------------------------------------------------------------------------------------------");
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getCourses().size() >= 2) {
                    System.out.println("|" + (i + 1) + "  | " + studentList.get(i).getFirstName() + "   ||   " + studentList.get(i).getLastName() + "   ||      "
                            + studentList.get(i).getDateOfBirth().format(formatters) + "      ||        " + studentList.get(i).getTuitionFees() + "      |      "
                            + studentList.get(i).getCourses().size() + "      |");
                }
            }
        }
    }

    public static void showAllStudentsOfACourse(int selection) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList = Populate.getGeneratedCourses().get(selection).getStudents();
        if (studentList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NO STUDENTS REGISTERED |");
            System.out.println("|-----------------------------------|");
        } else {
            System.out.println("--------------------------------STUDENTS-------------------------------");
            System.out.println("|    Name    ||    Last Name   ||    Date Of Birth ||   Tuition Fees  |");
            System.out.println("-----------------------------------------------------------------------");
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println("|" + (i + 1) + "  | " + studentList.get(i).getFirstName() + "   ||   " + studentList.get(i).getLastName() + "   || "
                        + studentList.get(i).getDateOfBirth().format(formatters) + " || " + studentList.get(i).getTuitionFees() + "|");
            }
        }
    }

    public static void showAlltrainersOfACourse(int selection) {
        ArrayList<Trainer> trainerList = new ArrayList<Trainer>();
        trainerList = Populate.getGeneratedCourses().get(selection).getTrainers();
        if (trainerList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NO TRAINERS REGISTERED |");
            System.out.println("|-----------------------------------|");
        } else {
            System.out.println("------------------   TRAINERS  --------------");
            System.out.println("|    Name    ||    Last Name   ||    Subject |");
            System.out.println("---------------------------------------------");
            for (int i = 0; i < trainerList.size(); i++) {
                System.out.println("|" + (i + 1) + "  | " + trainerList.get(i).getFirstName() + "   ||   " + trainerList.get(i).getLastName() + "   || "
                        + trainerList.get(i).getSubject() + " |");
            }
        }
    }

    public static void showAllAssignmentsOfACourse(int selection) {
        ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
        assignmentList = Populate.getGeneratedCoursesAssignments().get(selection).getAssignments();
        if (assignmentList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NO STUDENTS REGISTERED |");
            System.out.println("|-----------------------------------|");
        } else {
            System.out.println("---------------------------------------------------------------------ASSIGNMENTS------------------------------------------------------------------------");
            System.out.println("|       Title      ||                                   Description                                    ||   Submit Date & Time  ||Oral Mark||Total Mark|");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < assignmentList.size(); i++) {
                System.out.println((i + 1) + "|   " + assignmentList.get(i).getTitle() + " || " + assignmentList.get(i).getDescription()
                        + " || " + assignmentList.get(i).getSubDateTime().format(format) + "   ||   " + assignmentList.get(i).getOralMark()
                        + " || " + assignmentList.get(i).getTotalMark() + " |");
            }
        }
    }

    public static void viewSelectedCourse(int selectedCourse) {
        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList = Populate.getGeneratedCourses();
        if (courseList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NO COURSES REGISTERED  |");
            System.out.println("|-----------------------------------|");
        } else {
            System.out.println("-----------------------------------COURSE----------------------------------------------");
            System.out.println("|    Course Title    |" + "|    Stream   |" + "|    Type   |" + "|    Start Date   |" + "|    End Date   |");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("|   " + courseList.get(selectedCourse).getTitle() + "         ||    " + courseList.get(selectedCourse).getStream() + "    ||    "
                    + courseList.get(selectedCourse).getType() + "   ||   " + courseList.get(selectedCourse).getStart_date().format(formatters) + "   ||   "
                    + courseList.get(selectedCourse).getEnd_date().format(formatters) + "   |   ");
        }
    }

    public static void viewSelectedStudent(int selectedStudent) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList = Populate.getGeneratedStudents();
        if (studentList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NO  STUDENTS REGISTERED|"); // just for security it will never be printed
            System.out.println("|-----------------------------------|");// reason is that we are passing parameter
        } else {
            System.out.println("--------------------------------STUDENT--------------------------------");
            System.out.println("|    Name    ||    Last Name   ||    Date Of Birth ||   Tuition Fees  |");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("|" + studentList.get(selectedStudent).getFirstName() + "   ||   " + studentList.get(selectedStudent).getLastName() + "   || "
                    + studentList.get(selectedStudent).getDateOfBirth().format(formatters) + " || " + studentList.get(selectedStudent).getTuitionFees() + "|");
        }
    }

    public static void currentFees(int selectedStudent) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList = Populate.getGeneratedStudents();
        System.out.println("CURRENT FEES ARE : " + studentList.get(selectedStudent).getTuitionFees());
    }

    public static void viewSelectedTrainer(int selectedTrainer) {
        ArrayList<Trainer> trainerList = new ArrayList<Trainer>();
        trainerList = Populate.getGeneratedTrainers();
        if (trainerList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  THERE ARE NO TRAINERS REGISTERED |");
            System.out.println("|-----------------------------------|");
        } else {
            System.out.println("--------------------------------TRAINERS-----------------------");
            System.out.println("|    Name    ||    Last Name   ||             Subject          |");
            System.out.println("---------------------------------------------------------------");
            System.out.println("|" + trainerList.get(selectedTrainer).getFirstName() + "   ||   " + trainerList.get(selectedTrainer).getLastName() + "   || "
                    + trainerList.get(selectedTrainer).getSubject() + "|");
        }
    }

    public static void showAllAssignmentsOfAStudent(int selectedStudent) {
        Student s = Populate.getGeneratedStudents().get(selectedStudent);
        ArrayList<Course> courseList = Populate.getGeneratedStudents().get(selectedStudent).getCourses();

        if (courseList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|  NO COURSES FOR THIS STUDENT YET  |");
            System.out.println("|-----------------------------------|");
        } else {
            System.out.println("--------------------------------STUDENTS------------------------------");
            System.out.println("|    Name    ||    Last Name   ||    Date Of Birth ||   Tuition Fees  |");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("|" + s.getFirstName() + "   ||   " + s.getLastName() + "   ||     "
                    + s.getDateOfBirth().format(formatters) + " ||      " + s.getTuitionFees() + "    |");

            for (int i = 0; i < courseList.size(); i++) {
                System.out.println("-----------------------------------COURSE----------------------------------------------");
                System.out.println("|    Course Title    ||    Stream   ||    Type   ||    Start Date   ||      End Date   |");
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println((i + 1) + "|   " + courseList.get(i).getTitle() + "         ||    " + courseList.get(i).getStream() + "    ||    "
                        + courseList.get(i).getType() + "   ||   " + courseList.get(i).getStart_date().format(formatters) + "   ||   "
                        + courseList.get(i).getEnd_date().format(formatters) + "   |   ");
                System.out.println("---------------------------------------------------------------------ASSIGNMENT-------------------------------------------------------------------------");
                System.out.println("|       Title      ||                                   Description                                    ||   Submit Date & Time  ||Oral Mark||Total Mark|");
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                for (int j = 0; j < courseList.get(i).getAssignments().size(); j++) {
                    System.out.println((j + 1) + "|   " + courseList.get(i).getAssignments().get(j).getTitle() + " || " + courseList.get(i).getAssignments().get(j).getDescription()
                            + " || " + courseList.get(i).getAssignments().get(j).getSubDateTime().format(format) + "   ||   " + courseList.get(i).getAssignments().get(j).getOralMark()
                            + " || " + courseList.get(i).getAssignments().get(j).getTotalMark() + " |");
                }
                System.out.println("\n");
            }

        }
    }

    public static void showAllAssignmentsPerStudent() {
        ArrayList<Student> studentList = Populate.getGeneratedStudents();
        if (studentList.isEmpty()) {
            System.out.println("|-----------------------------------|");
            System.out.println("|        NO STUDENTS AVAILABLE      |");
            System.out.println("|-----------------------------------|");
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println("--------------------------------STUDENT------------------------------");
                System.out.println("|    Name    ||    Last Name   ||    Date Of Birth ||   Tuition Fees  |");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("|" + studentList.get(i).getFirstName() + "   ||   " + studentList.get(i).getLastName() + "   ||     "
                        + studentList.get(i).getDateOfBirth().format(formatters) + " ||      " + studentList.get(i).getTuitionFees() + "    |");
                for (int j = 0; j < studentList.get(i).getCourses().size(); j++) {
                    System.out.println("-----------------------------------COURSE----------------------------------------------");
                    System.out.println("|    Course Title    ||    Stream   ||    Type   ||    Start Date   ||      End Date   |");
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println((i + 1) + "|   " + studentList.get(i).getCourses().get(j).getTitle() + "         ||    " + studentList.get(i).getCourses().get(j).getStream() + "    ||    "
                            + studentList.get(i).getCourses().get(j).getType() + "   ||   " + studentList.get(i).getCourses().get(j).getStart_date().format(formatters) + "   ||   "
                            + studentList.get(i).getCourses().get(j).getEnd_date().format(formatters) + "   |   ");
                    for (int k = 0; k < studentList.get(i).getCourses().get(j).getAssignments().size(); k++) {
                        System.out.println("---------------------------------------------------------------------ASSIGNMENTS------------------------------------------------------------------------");
                        System.out.println("|       Title      ||                                   Description                                    ||   Submit Date & Time  ||Oral Mark||Total Mark|");
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println((j + 1) + "|   " + studentList.get(i).getCourses().get(j).getAssignments().get(k).getTitle() + " || " + studentList.get(i).getCourses().get(j).getAssignments().get(k).getDescription()
                                + " || " + studentList.get(i).getCourses().get(j).getAssignments().get(k).getSubDateTime().format(format) + "   ||   " + studentList.get(i).getCourses().get(j).getAssignments().get(k).getOralMark()
                                + " || " + studentList.get(i).getCourses().get(j).getAssignments().get(k).getTotalMark() + " |");
                    }
                    System.out.println("\n");
                }

            }
        }
    }

    public static List<LocalDate> datesListOfCalendarWeek(LocalDate date) {
        LocalDate start = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        return IntStream.range(0, 7).mapToObj(start::plusDays).collect(toList());
    }

    public static void showMultipleAssignmentInOneWeek(String date) {
        ArrayList<Student> studentList = Populate.getGeneratedStudents();
        ArrayList<Student> tempStudentList = new ArrayList<Student>();
        List<LocalDate> week;
        if (Validator.dateValidator(date)) {
            LocalDate dateVar = LocalDate.parse(date, formatters);
            week = datesListOfCalendarWeek(dateVar);
            if (week.contains(dateVar)) {
                for (int i = 0; i < week.size() - 3; i++) {
                    int count = 0;
                    for (int j = 0; j < studentList.size(); j++) {
                        for (int k = 0; k < studentList.get(j).getCourses().size(); k++) {
                            for (int l = 0; l < studentList.get(j).getCourses().get(k).getAssignments().size(); l++) {
                                LocalDate toBeChecked = removeTimeFromDate(studentList.get(j).getCourses().get(k).getAssignments().get(l).getSubDateTime());
                                if (week.get(i).equals(toBeChecked)) {
                                    count++;
                                    if (count > 2) {
                                        tempStudentList.add(studentList.get(j));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("THESE STUDENTS HAVE TO DELIVER MULTIPLE ASSIGNMENTS IN THE WEEK FROM " + week.get(0).format(formatters)
                    + " TO " + week.get(week.size() - 3).format(formatters));
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < tempStudentList.size(); i++) {
                System.out.println(tempStudentList.get(i).getFirstName() + " " + tempStudentList.get(i).getLastName());
            }
            //System.out.println(datesListOfCalendarWeek(dateVar).toString());  test line to see if this is working
        } else {
            System.out.println("______________________________________________________________");
            System.out.println(Validator.WRONG_DATE_INPUT);
            System.out.println("--------------------------------------------------------------");
        }
    }
}
