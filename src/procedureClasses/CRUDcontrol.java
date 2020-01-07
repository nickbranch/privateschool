/*
This is the class responsible for the creation, update or future deletion of data. Only for manual creation
 */
package procedureClasses;

import classes.Assignment;
import classes.Course;
import classes.Student;
import classes.Trainer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static procedureClasses.ViewsControls.showAllCourses;

public class CRUDcontrol {

    private static Student s;
    private static Course c;
    private static Assignment a;
    private static Trainer t;
    private static MenuOptions menuCrud = new MenuOptions();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private static NumberFormat formatDouble = new DecimalFormat("#0.00");

    public static void registerCourse() {
        boolean correctUserInput = false;
        int choice;
        int count = 0;
        int[] optionsSelect = {43};
        choice = menuCrud.menuGeneratorInt(optionsSelect); //number of courses
        while (count != choice) {
            count++;
            String userInput;
            c = new Course();
            Course ca;
            optionsSelect[0] = 44;
            c.setTitle(menuCrud.menuGeneratorCrudString(optionsSelect));//title
            /*--------------------------------*/
            optionsSelect[0] = 45; //stream
            while (!correctUserInput) {
                userInput = menuCrud.menuGeneratorCrudString(optionsSelect);
                if (Validator.streamValidation(userInput)) {
                    if (userInput.equalsIgnoreCase("java")) {
                        c.setStream("Java");
                    } else {
                        c.setStream("C#");
                    }
                    correctUserInput = true;
                } else {
                    System.out.println("Wrong input. Please enter 'java' or 'c#.'");
                }
            }
            /*--------------------------------*/
            correctUserInput = false;
            /*--------------------------------*/
            optionsSelect[0] = 46;//type
            while (!correctUserInput) {
                userInput = menuCrud.menuGeneratorCrudString(optionsSelect);
                if (Validator.typeValidation(userInput)) {
                    correctUserInput = true;
                    if (userInput.equalsIgnoreCase("full")) {
                        c.setType("Full Time");
                    } else {
                        c.setType("Part Time");
                    }
                } else {
                    System.out.println("Wrong input. Please enter 'part' or 'full.'");
                }
            }
            /*--------------------------------*/
            correctUserInput = false;
            /*--------------------------------*/
            optionsSelect[0] = 47;// start date course
            while (!correctUserInput) {
                userInput = menuCrud.menuGeneratorCrudString(optionsSelect);
                if (Validator.dateValidator(userInput)) {
                    correctUserInput = true;
                    c.setStart_date(LocalDate.parse(userInput, formatter));
                } else {
                    System.out.println(Validator.WRONG_DATE_INPUT);
                }
            }
            /*--------------------------------*/
            correctUserInput = false;
            /*--------------------------------*/
            optionsSelect[0] = 48;// end date course
            while (!correctUserInput) {
                userInput = menuCrud.menuGeneratorCrudString(optionsSelect);
                if (Validator.dateValidator(userInput)) {
                    if (Validator.logicCalculator(userInput, c.getStart_date())) {  //date logic here cannot be outside logic limits
                        correctUserInput = true;
                        c.setEnd_date(LocalDate.parse(userInput, formatter));
                    } else {
                        System.out.println("END DATE CANNOT BE BEFORE START DATE");
                    }
                } else {
                    System.out.println(Validator.WRONG_DATE_INPUT);
                }
            }
            /*--------------------------------*/
            correctUserInput = false;
            ca = new Course(c.getTitle(), c.getStream(), c.getType(), c.getStart_date()); // new object for assignments printing

            int choiceForAssignment;
            int countAssignment = 0;
            optionsSelect[0] = 49;
            choiceForAssignment = menuCrud.menuGeneratorInt(optionsSelect); //number of assignments
            while ((countAssignment != choiceForAssignment)) {
                countAssignment++;
                a = assignmentCreation(c); //create assignment
                Assignment aPlus = new Assignment(a.getTitle(), a.getDescription(), a.getSubDateTime(), a.getOralMark(), a.getTotalMark()); // duplicate assignment for printing
                ca.getAssignments().add(aPlus);
                c.getAssignments().add(a); //add them to the course arraylists
                correctUserInput = false;
                if (choiceForAssignment > 1 && countAssignment != choiceForAssignment) {
                    optionsSelect[0] = 53;// Stop assignment registration menu item
                    String userInputAssignment = menuCrud.menuGeneratorCrudString(optionsSelect);
                    if (userInputAssignment.equalsIgnoreCase("stop")) {
                        break;
                    }
                }
            }
            Populate.getGeneratedCoursesAssignments().add(ca);  // for printing different course/assignment table 2nd object
            Populate.getGeneratedCourses().add(c);

            if (choice > 1 && count != choice) {
                optionsSelect[0] = 54;// Stop course
                userInput = menuCrud.menuGeneratorCrudString(optionsSelect);
                if (userInput.equalsIgnoreCase("stop")) {
                    break;
                }
            }
        }
    }

    public static void registerATrainerToACourse(int trainer, int course) {
        if (Populate.getGeneratedCourses().get(course).getTrainers().contains(Populate.getGeneratedTrainers().get(trainer))) {
            System.out.println("THIS TRAINER IS ALREADY REGISTERED TO THIS COURSE");
        } else {
            Populate.getGeneratedTrainers().get(trainer).getCourses().add(Populate.getGeneratedCourses().get(course));// inform both arrayLists in case we need them for future use
            Populate.getGeneratedCourses().get(course).getTrainers().add(Populate.getGeneratedTrainers().get(trainer));
            System.out.println("TRAINER HAS BEEN REGISTERED TO THIS COURSE");
        }
    }

    public static void registerAStudentToACourse(int student, int course) {
        if (Populate.getGeneratedCourses().get(course).getStudents().contains(Populate.getGeneratedStudents().get(student))) {
            System.out.println("THIS STUDENT IS ALREADY REGISTERED TO THIS COURSE");
        } else {
            Populate.getGeneratedCourses().get(course).getStudents().add(Populate.getGeneratedStudents().get(student));
            Populate.getGeneratedStudents().get(student).getCourses().add(Populate.getGeneratedCourses().get(course));  // inform both arrayLists in case we need them for future use
            System.out.println("STUDENT HAS BEEN REGISTERED TO THIS COURSE.");
            Populate.getGeneratedStudents().get(student).increaseFees();  //increase fees by 2500
        }
    }

    private static Assignment assignmentCreation(Course c) {  //create a single assignment
        String userInputAssignment;
        boolean correctUserInput;
        int[] optionsSelect = {0};
        a = new Assignment();
        optionsSelect[0] = 50;
        a.setTitle(menuCrud.menuGeneratorCrudString(optionsSelect));//title
        optionsSelect[0] = 51;
        a.setDescription(menuCrud.menuGeneratorCrudString(optionsSelect));//description
        correctUserInput = false;
        optionsSelect[0] = 52;// submit date limit
        while (!correctUserInput) {
            userInputAssignment = menuCrud.menuGeneratorCrudString(optionsSelect);
            if (Validator.dateValidator(userInputAssignment)) {
                if (Validator.logicCalculator(userInputAssignment, c.getStart_date(), c.getEnd_date())) {  //logic calculate for the date userinput and we compare to courses dates
                    correctUserInput = true;
                    a.setSubDateTime(DataGenerator.addTimeToSubmittedDate(LocalDate.parse(userInputAssignment, formatter)));
                } else {
                    System.out.println("ERROR. ASSIGNMENT SUBMIT DATE SHOULD BE BETWEEN THE CORRECT LIMITS("
                            + c.getStart_date().format(formatter) + " - to - " + c.getEnd_date().format(formatter) + ").");
                }
            } else {
                System.out.println("______________________________________________________________");
                System.out.println(Validator.WRONG_DATE_INPUT);
                System.out.println("---------------------------------------------------------------");
            }
        }
        correctUserInput = false;

        optionsSelect[0] = 55;// oral mark
        while (!correctUserInput) {
            String userInput = menuCrud.menuGeneratorCrudString(optionsSelect);
            if (Validator.passValidationMark(userInput, 100)) {
                int oralMark = Integer.parseInt(userInput);
                a.setOralMark(oralMark);
                a.setTotalMark(100 - oralMark);
                correctUserInput = true;
            }
        }
        return a;
    }

    public static void createAssignment(int selection, Course c) {
        a = assignmentCreation(c); // create assignment
        Assignment temp = new Assignment(a.getTitle(), a.getDescription(), a.getSubDateTime(), a.getOralMark(), a.getTotalMark()); // exact copy
        Populate.getGeneratedCourses().get(selection).getAssignments().add(a);
        Populate.getGeneratedCoursesAssignments().get(selection).getAssignments().add(temp); //inform both arraylists printing and assignment to students for marks
    }

    public static void editCourseTitle(int selectedCourse, String userInput) {
        Populate.getGeneratedCourses().get(selectedCourse).setTitle(userInput);
        Populate.getGeneratedCoursesAssignments().get(selectedCourse).setTitle(userInput);
        System.out.println("_________________________");
        System.out.println("COURSE TITLE HAS CHANGED");
        System.out.println("-------------------------");
    }

    public static void editCourseStream(int selectedCourse, String userInput) {
        if (Validator.streamValidation(userInput)) {
            if (userInput.equalsIgnoreCase("java")) {
                userInput = "Java";
            } else {
                userInput = "C#";
            }
            Populate.getGeneratedCourses().get(selectedCourse).setStream(userInput);
            Populate.getGeneratedCoursesAssignments().get(selectedCourse).setStream(userInput);
            System.out.println("________________________");
            System.out.println("COURSE STREAM HAS CHANGED.");
            System.out.println("------------------------");
        } else {
            System.out.println("________________________");
            System.out.println(" JAVA OR C# INPUT ONLY  ");
            System.out.println("------------------------");
        }
    }

    public static void editCourseType(int selectedCourse, String userInput) {
        if (Validator.typeValidation(userInput)) {
            if (userInput.equalsIgnoreCase("part")) {
                userInput = "Part Time";
            } else {
                userInput = "Full Time";
            }
            Populate.getGeneratedCourses().get(selectedCourse).setType(userInput);
            Populate.getGeneratedCoursesAssignments().get(selectedCourse).setType(userInput);
            System.out.println("________________________");
            System.out.println("COURSE TYPE HAS CHANGED.");
            System.out.println("------------------------");
        } else {
            System.out.println("________________________");
            System.out.println("  'FULL' OR 'PART' ONLY ");
            System.out.println("------------------------");
        }
    }

    public static void editCourseStartDate(int selectedCourse, String userInput) {
        if (Validator.dateValidator(userInput)) {
            if (Validator.logicCalculator(selectedCourse, userInput)) {
                Populate.getGeneratedCourses().get(selectedCourse).setStart_date(LocalDate.parse(userInput, formatter));
                Populate.getGeneratedCoursesAssignments().get(selectedCourse).setStart_date(LocalDate.parse(userInput, formatter));
            } else {
                System.out.println("________________________________________________");
                System.out.println("ERROR. START DATE CANNOT BE AFTER THE END DATE");
                System.out.println("-------------------------------------------------");
            }
        } else {
            System.out.println("______________________________________________________________");
            System.out.println(Validator.WRONG_DATE_INPUT);
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static void editCourseEndDate(int selectedCourse, String userInput) {
        if (Validator.dateValidator(userInput)) {
            if (Validator.logicCalculatorForSetEndDate(selectedCourse, userInput)) {
                Populate.getGeneratedCourses().get(selectedCourse).setEnd_date(LocalDate.parse(userInput, formatter));
                Populate.getGeneratedCoursesAssignments().get(selectedCourse).setEnd_date(LocalDate.parse(userInput, formatter));
            } else {
                System.out.println("________________________________________________");
                System.out.println("ERROR. END DATE CANNOT BE BEFORE THE START DATE");
                System.out.println("-------------------------------------------------");
            }
        } else {
            System.out.println("______________________________________________________________");
            System.out.println(Validator.WRONG_DATE_INPUT);
            System.out.println("--------------------------------------------------------------");
        }
    }

    //******************************************COURSE ACTIONS END*****************************************************************//
    public static void createStudent() {
        boolean correctUserInput = false;
        int choice;
        int count = 0;
        int[] optionsSelect = {56};

        choice = menuCrud.menuGeneratorInt(optionsSelect); //number of students
        while (count != choice) {
            correctUserInput = false;
            count++;
            String userInput;
            boolean yearTrigger = false;
            s = new Student();
            optionsSelect[0] = 57;
            s.setFirstName(menuCrud.menuGeneratorNameSurname(optionsSelect)); //first name
            optionsSelect[0] = 58;
            s.setLastName(menuCrud.menuGeneratorNameSurname(optionsSelect)); //last name
            optionsSelect[0] = 59;
            while (!correctUserInput) {
                userInput = menuCrud.menuGeneratorCrudString(optionsSelect); // date of birth
                if (Validator.dateValidator(userInput)) {
                    correctUserInput = true;
                    if (Validator.logicalDateOfBirth(userInput)) {
                        s.setDateOfBirth(LocalDate.parse(userInput, formatter));
                    } else {
                        System.out.println("We cannot accept this registration for now.");
                        yearTrigger = true;
                    }
                } else {
                    System.out.println(Validator.WRONG_DATE_INPUT);
                }
            }
            if (!yearTrigger) {  // no registration takes place if student is under 18 years old
                /*-------------------COURSE TO STUDENT REGISTRATION-------------*/
                int choiceForCourses = Integer.MAX_VALUE;
                int coursesAvailable = Populate.getGeneratedCourses().size(); // just for better visibility
                int countCourse = 0;
                optionsSelect[0] = 60;
                int courseNumber;
                if (Populate.getGeneratedCourses().isEmpty()) {
                    System.out.println("THERE ARE NO COURSES AVAILABLE BUT THE STUDENT'S DATA WILL BE SAVED IN THE SYSTEM");
                }

                while ((choiceForCourses > coursesAvailable) && (coursesAvailable > 0)) {
                    choiceForCourses = menuCrud.menuGeneratorInt(optionsSelect); //number of courses
                    if (coursesAvailable < choiceForCourses) {
                        System.out.println("THERE ARE " + coursesAvailable + " COURSES AVAILABLE.");
                    }
                }
                while ((countCourse != choiceForCourses) && (!Populate.getGeneratedCourses().isEmpty()) && (choiceForCourses <= coursesAvailable)) {
                    showAllCourses();
                    optionsSelect[0] = 61;
                    courseNumber = menuCrud.menuGeneratorInt(optionsSelect) - 1;

                    if (Populate.getGeneratedCourses().get(courseNumber).getStudents().contains(s)) {
                        System.out.println("THIS STUDENT IS ALREADY REGISTERED TO THIS COURSE");
                    } else {
                        s.getCourses().add(Populate.getGeneratedCourses().get(courseNumber));
                        Populate.getGeneratedCourses().get(courseNumber).getStudents().add(s);
                        Populate.getGeneratedCoursesAssignments().get(courseNumber).getStudents().add(s);
                        System.out.println("STUDENT HAS BEEN REGISTERED TO THIS COURSE.");
                        s.increaseFees();
                        System.out.println("FEES ARE INCREASED BY 2500."); //we are assuming that each course costs 2500
                        countCourse++; // since student is added we increase count for how many courses this student will attend
                    }
                }
                Populate.getGeneratedStudents().add(s);
            }
            if (choice > 1 && count != choice) {
                optionsSelect[0] = 62;// Stop student registration
                userInput = menuCrud.menuGeneratorCrudString(optionsSelect);
                if (userInput.equalsIgnoreCase("stop")) {
                    break;
                }
            }
        }
    }

    public static void editStudentName(int selectedStudent, String userInput) {
        Populate.getGeneratedStudents().get(selectedStudent).setFirstName(userInput);
        System.out.println("_______________________________");
        System.out.println("STUDENT'S FIRST NAME HAS CHANGED");
        System.out.println("-------------------------------");
    }

    public static void editStudentLastName(int selectedStudent, String userInput) {
        Populate.getGeneratedStudents().get(selectedStudent).setLastName(userInput);
        System.out.println("_______________________________");
        System.out.println("STUDENT'S LAST NAME HAS CHANGED");
        System.out.println("-------------------------------");
    }

    public static void editDOB(int selectedStudent, String userInput) {
        if (Validator.dateValidator(userInput)) {
            if (Validator.logicalDateOfBirth(userInput)) {
                Populate.getGeneratedStudents().get(selectedStudent).setDateOfBirth(LocalDate.parse(userInput, formatter));
                System.out.println("_________________________________");
                System.out.println("STUDENT DATE OF BIRTH HAS CHANGED");
                System.out.println("---------------------------------");
            } else {
                System.out.println("__________________________________________________________________________");
                System.out.println("Please enter a valid input. Student should not be less than 18 years old.");
                System.out.println("---------------------------------------------------------------------------");
            }
        } else {
            System.out.println("______________________________________________________________");
            System.out.println(Validator.WRONG_DATE_INPUT);
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static void payment(int selectedStudent, Double userInput) {
        double remainingFees = Populate.getGeneratedStudents().get(selectedStudent).getTuitionFees();
        if (userInput > remainingFees) {
            System.out.println("__________________________________________________________");
            System.out.println("REMAINING FEES ARE LESS THAN THE AMMOUNT YOU TRY TO DEDUCT");
            System.out.println("-----------------------------------------------------------");
        } else {
            Populate.getGeneratedStudents().get(selectedStudent).decreaseFees(userInput);
            System.out.println("________________________________________________________");
            System.out.println("PAYMENT WAS COMPLETED -> REMAINING FEES ARE NOW " + Populate.getGeneratedStudents().get(selectedStudent).getTuitionFees());
            System.out.println("--------------------------------------------------------");
        }
    }

    public static void completePayments(int selectedStudent) {
        double remainingFees = Populate.getGeneratedStudents().get(selectedStudent).getTuitionFees();
        System.out.println("Remaining fees are " + remainingFees + ".");
        Populate.getGeneratedStudents().get(selectedStudent).setTuitionFees(0);
        System.out.println("________________________________________________________");
        System.out.println("PAYMENT WAS COMPLETED -> REMAINING FEES ARE NOW " + Populate.getGeneratedStudents().get(selectedStudent).getTuitionFees());
        System.out.println("--------------------------------------------------------");
    }

    public static void calculateInstallments(int selectedStudent, int installments) {
        if (installments > 1) {
            double remainingFees = Populate.getGeneratedStudents().get(selectedStudent).getTuitionFees();
            System.out.println("Remaining fees are " + remainingFees + ".");
            double ammountPerInstallment = remainingFees / installments;
            System.out.println("The Arrangement will be as follows");
            System.out.println("__________________________________");
            System.out.println("|                                 |");
            System.out.println("|                                 |");
            System.out.println("|    " + installments + "  X " + formatDouble.format(ammountPerInstallment) + "                 |");
            System.out.println("|       Monthly Installments      |");
            System.out.println("|                                 |");
            System.out.println("__________________________________");
        } else {
            System.out.println("__________________________________________________________");
            System.out.println("ERROR. PLEASE INPUT 2 OR MORE MONTHLY INSTALLMENTS");
            System.out.println("-----------------------------------------------------------");
        }
    }
    //******************************************STUDENT ACTIONS END*****************************************************************//

    public static void registerATrainer() {
        int choice;
        int count = 0;
        int[] optionsSelect = {66};

        choice = menuCrud.menuGeneratorInt(optionsSelect); //number of trainers
        while (count != choice) {
            count++;
            String userInput;
            t = new Trainer();
            optionsSelect[0] = 67;
            t.setFirstName(menuCrud.menuGeneratorNameSurname(optionsSelect)); //first name
            optionsSelect[0] = 68;
            t.setLastName(menuCrud.menuGeneratorNameSurname(optionsSelect)); //last name
            optionsSelect[0] = 69;
            t.setSubject(menuCrud.menuGeneratorCrudString(optionsSelect)); // subject
            /*-------------------COURSE TO TRAINER REGISTRATION-------------*/
            int choiceForCourses = Integer.MAX_VALUE;
            int coursesAvailable = Populate.getGeneratedCourses().size(); // just for better visibility
            int countCourse = 0;
            optionsSelect[0] = 70;
            int courseNumber;
            if (Populate.getGeneratedCourses().isEmpty()) {
                System.out.println("THERE ARE NO COURSES AVAILABLE BUT THE TRAINER'S DATA WILL BE SAVED IN THE SYSTEM");
            }
            while ((choiceForCourses > coursesAvailable) && (coursesAvailable > 0)) {
                choiceForCourses = menuCrud.menuGeneratorInt(optionsSelect); //number of courses
                if (coursesAvailable < choiceForCourses) {
                    System.out.println("THERE ARE " + coursesAvailable + " COURSES AVAILABLE.");
                }
            }
//while there are courses && they are enough for the choice && loop count for how many courses this trainer will teach is not passed 
            while ((countCourse != choiceForCourses) && (!Populate.getGeneratedCourses().isEmpty()) && (choiceForCourses <= coursesAvailable)) {
                showAllCourses();
                optionsSelect[0] = 71; // COURSE NUMBER
                courseNumber = menuCrud.menuGeneratorInt(optionsSelect) - 1;

                if (Populate.getGeneratedCourses().get(courseNumber).getTrainers().contains(t)) {
                    System.out.println("THIS TRAINER IS ALREADY REGISTERED TO THIS COURSE");
                } else {
                    t.getCourses().add(Populate.getGeneratedCourses().get(courseNumber));
                    Populate.getGeneratedCourses().get(courseNumber).getTrainers().add(t);
                    Populate.getGeneratedCoursesAssignments().get(courseNumber).getTrainers().add(t); //second array for assignment printing
                    System.out.println("TRAINER HAS BEEN REGISTERED TO THIS COURSE.");
                    countCourse++; // since trainer is added we increase count for how many courses this trainer will teach here
                }

            }
            Populate.getGeneratedTrainers().add(t);
            if (choice > 1 && count != choice) {
                optionsSelect[0] = 72;// Stop trainer registration
                userInput = menuCrud.menuGeneratorCrudString(optionsSelect);
                if (userInput.equalsIgnoreCase("stop")) {
                    break;
                }
            }
        }
    }

    public static void editTrainersName(int selectedTrainer, String userInput) {
        Populate.getGeneratedTrainers().get(selectedTrainer).setFirstName(userInput);
        System.out.println("________________________________");
        System.out.println("TRAINER'S FIRST NAME HAS CHANGED");
        System.out.println("--------------------------------");
    }

    public static void editTrainersLastName(int selectedTrainer, String userInput) {
        Populate.getGeneratedTrainers().get(selectedTrainer).setLastName(userInput);
        System.out.println("_______________________________");
        System.out.println("TRAINER'S LAST NAME HAS CHANGED");
        System.out.println("-------------------------------");
    }

    public static void editTrainersSubject(int selectedTrainer, String userInput) {
        Populate.getGeneratedTrainers().get(selectedTrainer).setSubject(userInput);
        System.out.println("_______________________________");
        System.out.println("TRAINER'S SUBJECT HAS CHANGED");
        System.out.println("-------------------------------");
    }
}
