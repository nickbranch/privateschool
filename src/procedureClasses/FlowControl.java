/*
This is the class responsible for the flow control of the program. It has multiple menus and launches methods.
There is also some business logic implemented in some switch options.
 */
package procedureClasses;

import static procedureClasses.CRUDcontrol.*;
import static procedureClasses.ViewsControls.*;

public class FlowControl {

    private static MenuOptions menu = new MenuOptions();
    private static int selectedCourse;
    private static int selectedTrainer;
    private static int selectedStudent;

    /* this is the main menu that lets the user decide to use manual data entry or synthetic data entry*/
    public static void mainMenu() {
        int choice;
        int[] optionsSelect = {0, 1, 2}; //main menu item selection
        choice = menu.menuGenerator(optionsSelect);
        switch (choice) {
            case 1:
                Populate.clearAllLists();
                dataMenu();
                break;
            case 2:
                Populate.clearAllLists();
                Populate.populate();
                dataMenu();
                break;
            case 3:
                break;
            default:
                throw new AssertionError();
        }
    }

    /*This is the actual menu*/
    public static void dataMenu() {
        int choice;
        String userInput;
        int[] optionsSelect = {3, 4, 5, 6, 7, 2}; //main menu item selection
        int[] weekFromDate = {0};
        choice = menu.menuGenerator(optionsSelect);
        switch (choice) {
            case 1:
                coursesMenu();
                break;
            case 2:
                studentsMenu();
                break;
            case 3:
                trainersMenu();
                break;
            case 4://multiple assignments in one week function
                weekFromDate[0] = 76;
                userInput = menu.menuGeneratorCrudString(weekFromDate);
                showMultipleAssignmentInOneWeek(userInput);
                dataMenu();
                break;
            case 5:
                mainMenu();
                break;
            case 6:
                break;
            default:
                throw new AssertionError();
        }
    }

    /*This is the Courses Action Menu*/
    public static void coursesMenu() {
        int choice;
        int[] optionsSelect = {8, 9, 10, 73, 74, 11, 7, 2}; //courses menu item selection
        choice = menu.menuGenerator(optionsSelect);
        switch (choice) {
            case 1: //register a course
                registerCourse();
                coursesMenu();
                break;
            case 2: //show all courses
                showAllCourses();
                coursesMenu();
                break;
            case 3:// show assignments of all courses
                showAllAssignments();
                coursesMenu();
                break;
            case 4:
                showAllStudentsPerCourse();
                coursesMenu();
                break;
            case 5:
                showAllTrainersPerCourse();
                coursesMenu();
                break;
            case 6://select a course
                if (Populate.getGeneratedCourses().isEmpty()) {
                    showAllCourses();
                    coursesMenu();
                } else {
                    showAllCourses();
                    selectedCourse = menu.selectCourse(Populate.getGeneratedCourses());
                    selectCourse();
                }
                break;
            case 7:
                dataMenu();
                break;
            case 8:
                break;
            default:
                throw new AssertionError();
        }
    }

    // This is the selected Course menu Actions
    public static void selectCourse() {
        int choice;
        int[] optionsSelect = {18, 19, 20, 21, 22, 23, 24, 7, 2}; //courses menu item selection
        viewSelectedCourse(selectedCourse);
        choice = menu.menuGenerator(optionsSelect);
        switch (choice) {
            case 1:  //register a trainer to this course
                showAllTrainers();
                selectedTrainer = menu.selectTrainer(Populate.getGeneratedTrainers());
                registerATrainerToACourse(selectedTrainer, selectedCourse);
                selectCourse();
                break;
            case 2:  // register a student to this course
                ViewsControls.showAllStudents();
                selectedStudent = menu.selectStudent(Populate.getGeneratedStudents());
                registerAStudentToACourse(selectedStudent, selectedCourse);
                selectCourse();
                break;
            case 3:  // Create an assignment for this course
                createAssignment(selectedCourse, Populate.getGeneratedCourses().get(selectedCourse));  //course parameter for populate lists manipulation
                selectCourse();
                break;
            case 4: // Show all students of this course
                showAllStudentsOfACourse(selectedCourse);
                selectCourse();
                break;
            case 5:  // Show all trainers of this course
                showAlltrainersOfACourse(selectedCourse);
                selectCourse();
                break;
            case 6: // Show all assignments of this course
                showAllAssignmentsOfACourse(selectedCourse);
                selectCourse();
                break;
            case 7:
                editCourse();
                break;
            case 8:
                coursesMenu();
                break;
            case 9:
                break;
            default:
                throw new AssertionError();
        }
    }

    // This is the selected Course edit menu Actions
    public static void editCourse() {
        int choice;
        int[] optionsSelect = {25, 26, 27, 28, 29, 7, 2}; //selected course menu item selection - new array creation for new menu
        int[] editAttributeMenuItem = {0};
        viewSelectedCourse(selectedCourse);
        String userInput;
        choice = menu.menuGenerator(optionsSelect);
        switch (choice) {
            case 1: // edit Course title
                editAttributeMenuItem[0] = 44;
                userInput = menu.menuGeneratorCrudString(editAttributeMenuItem);
                editCourseTitle(selectedCourse, userInput);
                editCourse();
                break;
            case 2: // edit Course Stream
                editAttributeMenuItem[0] = 45;
                userInput = menu.menuGeneratorCrudString(editAttributeMenuItem);
                editCourseStream(selectedCourse, userInput);
                editCourse();
                break;
            case 3: // edit Course type
                editAttributeMenuItem[0] = 46;
                userInput = menu.menuGeneratorCrudString(editAttributeMenuItem);
                editCourseType(selectedCourse, userInput);
                editCourse();
                break;
            case 4: // edit Course start date
                editAttributeMenuItem[0] = 47;
                userInput = menu.menuGeneratorCrudString(editAttributeMenuItem);
                editCourseStartDate(selectedCourse, userInput);
                editCourse();
                break;
            case 5:  // edit course end Date
                editAttributeMenuItem[0] = 48;
                userInput = menu.menuGeneratorCrudString(editAttributeMenuItem);
                editCourseEndDate(selectedCourse, userInput);
                editCourse();
                break;
            case 6:
                selectCourse();
                break;
            case 7:
                break;
            default:
                throw new AssertionError();
        }
    }

    /*This is the Students Action menu*/
    public static void studentsMenu() {
        int choice;
        int[] optionsSelect = {12, 13, 75, 14, 15, 7, 2}; //student menu item selection
        choice = menu.menuGenerator(optionsSelect);
        switch (choice) {
            case 1: // Create a student
                createStudent();
                studentsMenu();
                break;
            case 2: // show all students
                showAllStudents();
                studentsMenu();
                break;
            case 3: //Show all assignments per student
                showAllAssignmentsPerStudent();
                studentsMenu();
                break;
            case 4: //Show students of multiple courses
                showStudentsOfMultipleCourses();
                studentsMenu();
                break;
            case 5: // select a student
                if (Populate.getGeneratedStudents().isEmpty()) {
                    showAllStudents();
                    studentsMenu();
                } else {
                    showAllStudents();
                    selectedStudent = menu.selectStudent(Populate.getGeneratedStudents());
                    selectedStudent();
                }
                break;
            case 6:
                dataMenu();
                break;
            case 7:
                break;
            default:
                throw new AssertionError();
        }
    }

    /*This is the selected student Action menu*/
    public static void selectedStudent() {
        int choice;
        viewSelectedStudent(selectedStudent);
        int[] optionsSelect = {30, 31, 32, 33, 34, 35, 7, 2}; //selected student menu item selection
        int[] editAttributeMenuItem = {0};
        String userInput;
        choice = menu.menuGenerator(optionsSelect);
        switch (choice) {
            case 1: // show all assignments
                showAllAssignmentsOfAStudent(selectedStudent);
                selectedStudent();
                break;
            case 2:  // edit first name
                editAttributeMenuItem[0] = 57;
                userInput = menu.menuGeneratorNameSurname(editAttributeMenuItem);
                editStudentName(selectedStudent, userInput);
                selectedStudent();
                break;
            case 3:  // edit last name
                editAttributeMenuItem[0] = 58;
                userInput = menu.menuGeneratorNameSurname(editAttributeMenuItem);
                editStudentLastName(selectedStudent, userInput);
                selectedStudent();
                break;
            case 4:  // edit date of birth
                editAttributeMenuItem[0] = 59;
                userInput = menu.menuGeneratorCrudString(editAttributeMenuItem);
                editDOB(selectedStudent, userInput);
                selectedStudent();
                break;
            case 5:  // edit tuition fees
                editTuitionFees();
                break;
            case 6:  // add courses (increase fees) ready from course
                showAllCourses();
                selectedCourse = menu.selectCourse(Populate.getGeneratedCourses());
                registerAStudentToACourse(selectedStudent, selectedCourse);
                selectedStudent();
                break;
            case 7:
                studentsMenu();
                break;
            case 8:
                break;
            default:
                throw new AssertionError();
        }
    }

    /* edit tuition fees menu options*/
    public static void editTuitionFees() {
        int choice;
        double ammount;
        int[] optionsSelect = {36, 37, 38, 7, 2}; //edit tuition fees menu item
        int[] editAttributeMenuItem = {0};
        currentFees(selectedStudent);
        choice = menu.menuGenerator(optionsSelect);
        switch (choice) {
            case 1:  // payment was made
                editAttributeMenuItem[0] = 63;
                ammount = menu.menuGeneratorDouble(editAttributeMenuItem);
                payment(selectedStudent, ammount);
                editTuitionFees();
                break;
            case 2:  // complete payments
                completePayments(selectedStudent);
                editTuitionFees();
                break;
            case 3: // calculate installments
                editAttributeMenuItem[0] = 64;
                choice = menu.menuGeneratorInt(editAttributeMenuItem);
                calculateInstallments(selectedStudent, choice);
                editTuitionFees();
                break;
            case 4:
                selectedStudent();
                break;
            case 5:
                break;
            default:
                throw new AssertionError();
        }
    }

    /*This is the Trainers Action menu*/
    public static void trainersMenu() {
        int choice;
        int[] optionsSelect = {65, 16, 17, 7, 2}; //trainers menu item selection
        choice = menu.menuGenerator(optionsSelect);
        switch (choice) {
            case 1:
                registerATrainer();
                trainersMenu();
                break;
            case 2:  //show all trainers
                showAllTrainers();
                trainersMenu();
                break;
            case 3://select a trainer list trainers
                if (Populate.getGeneratedTrainers().isEmpty()) {
                    showAllTrainers();
                    trainersMenu();
                } else {
                    showAllTrainers();
                    selectedTrainer = menu.selectTrainer(Populate.getGeneratedTrainers());
                    selectedTrainer();
                }
                break;
            case 4:
                dataMenu();
                break;
            case 5:
                break;
            default:
                throw new AssertionError();
        }
    }

    /*This is the selected Trainers Action menu*/
    public static void selectedTrainer() {
        int choice;
        int[] editAttributeMenuItem = {0};
        String userInput;
        viewSelectedTrainer(selectedTrainer);
        int[] optionsSelect = {39, 40, 41, 42, 7, 2}; //selected trainer menu item selection
        choice = menu.menuGenerator(optionsSelect);
        switch (choice) {
            case 1:  // edit trainers name
                editAttributeMenuItem[0] = 67;
                userInput = menu.menuGeneratorNameSurname(editAttributeMenuItem);
                editTrainersName(selectedTrainer, userInput);
                selectedTrainer();
                break;
            case 2: // edit trainers last name
                editAttributeMenuItem[0] = 68;
                userInput = menu.menuGeneratorNameSurname(editAttributeMenuItem);
                editTrainersLastName(selectedTrainer, userInput);
                selectedTrainer();
                break;
            case 3:  // edit subject
                editAttributeMenuItem[0] = 69;
                userInput = menu.menuGeneratorCrudString(editAttributeMenuItem);
                editTrainersSubject(selectedTrainer, userInput);
                selectedTrainer();
                break;
            case 4:  // register a course to this trainer
                showAllCourses();
                choice = menu.selectCourse(Populate.getGeneratedCourses());
                registerATrainerToACourse(selectedTrainer, choice);
                selectedTrainer();
                break;
            case 5:
                trainersMenu();
                break;
            case 6:
                break;
            default:
                throw new AssertionError();
        }
    }
}
