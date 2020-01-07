/*
This is the class that is responsible for the population of the lists. It calls the random functions to create
objects but it also holds the arraylists that are used in the manual entry. It clears the lists if we change the mode.
 */
package procedureClasses;

import classes.Assignment;
import classes.Course;
import classes.Student;
import classes.Trainer;
import java.util.ArrayList;
import static procedureClasses.DataGenerator.assignStudentToCourse;

public class Populate {

    private static Student s;
    private static Trainer t;
    private static Assignment a;
    private static Course c;
    private static MenuOptions menu = new MenuOptions();
    private static ArrayList<Trainer> generatedTrainers = new ArrayList<Trainer>(); // First we need the trainers
    private static ArrayList<Course> generatedCourses = new ArrayList<Course>(); // Then we need courses with random number 
    private static ArrayList<Course> generatedCoursesAssignments = new ArrayList<Course>(); // will be used for assignment printing 
    private static ArrayList<Assignment> generatedAssignments = new ArrayList<Assignment>(); //of Trainers and assignments will not be used for now
    private static ArrayList<Student> generatedStudents = new ArrayList<Student>(); //Then we generate the students

    public static void populate() {
        int trainers;
        int courses;
        int assignments = 10;
        int students;
        int[] optionsSelect = {77};
        courses = menu.menuGeneratorInt(optionsSelect);
        optionsSelect[0] = 78;
        while (assignments > 5) {
            assignments = menu.menuGeneratorInt(optionsSelect);
            if (assignments > 5) {
                System.out.println("Too many. Generator works only with 5 assignments per course to secure logic in dates.");
                System.out.println("You can create assignments from the select course menu.");
            }
        }
        optionsSelect[0] = 79;
        trainers = menu.menuGeneratorInt(optionsSelect);
        optionsSelect[0] = 80;
        students = menu.menuGeneratorInt(optionsSelect);

        for (int i = 0; i < trainers; i++) {  // generate trainers
            t = new Trainer(DataGenerator.getRandomName(), DataGenerator.getRandomLastName());
            generatedTrainers.add(t);
        }
        for (int i = 0; i < courses; i++) { //Generate instances of courses
            c = new Course(DataGenerator.generateCourseTitle(), DataGenerator.generateStream(), DataGenerator.generateType(),
                    DataGenerator.generateDate()); //random course generation 
            Course ca = new Course(c.getTitle(), c.getStream(), c.getType(), c.getStart_date()); // new  for assignments printing
            DataGenerator.assignTrainerToCourse(c, generatedTrainers); //assign the generated trainers to courses
            for (int j = 0; j < assignments; j++) { // we will generate assignments for each course
                a = DataGenerator.generateAssignment(c, j); //random assignment generation
                Assignment aPlus = new Assignment(a.getTitle(), a.getDescription(), a.getSubDateTime(), a.getOralMark(), a.getTotalMark());
                c = DataGenerator.assignAssignmentToCourse(c, a); //add assignment to the course and return it  
                ca = DataGenerator.assignAssignmentToCourse(ca, aPlus); //exact copy of C
            }
            generatedCourses.add(c); // add course with trainers and assignments to the array
            generatedCoursesAssignments.add(ca);
        }

        for (int i = 0; i < students; i++) {   // student generation
            s = new Student(DataGenerator.getRandomName(), DataGenerator.getRandomLastName(),
                    DataGenerator.generateDateOfBirth());
            s = DataGenerator.randomStudentRegistration(generatedCourses, s);
            s.getRandomTuitionFees(); // calculate tuition fees at random depending on number of courses
            generatedStudents.add(s); // add student object to student arraylist
        }
        generatedCourses = assignStudentToCourse(generatedCourses, generatedStudents);

        for (int i = 0; i < generatedStudents.size(); i++) {
            generatedStudents.get(i).submitRandomAssignments();
        }
    }

    public static ArrayList<Trainer> getGeneratedTrainers() {
        return generatedTrainers;
    }

    public static void setGeneratedTrainers(ArrayList<Trainer> generatedTrainers) {
        Populate.generatedTrainers = generatedTrainers;
    }

    public static ArrayList<Course> getGeneratedCourses() {
        return generatedCourses;
    }

    public static void setGeneratedCourses(ArrayList<Course> generatedCourses) {
        Populate.generatedCourses = generatedCourses;
    }

    public static ArrayList<Student> getGeneratedStudents() {
        return generatedStudents;
    }

    public static void setGeneratedStudents(ArrayList<Student> generatedStudents) {
        Populate.generatedStudents = generatedStudents;
    }

    public static ArrayList<Course> getGeneratedCoursesAssignments() {
        return generatedCoursesAssignments;
    }

    public static void setGeneratedCoursesAssignments(ArrayList<Course> aGeneratedCoursesAssignments) {
        generatedCoursesAssignments = aGeneratedCoursesAssignments;
    }

    public static void clearAllLists() {
        generatedAssignments.clear();
        generatedCoursesAssignments.clear();
        generatedCourses.clear();
        generatedStudents.clear();
        generatedTrainers.clear();
    }
}
