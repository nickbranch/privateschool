/*
This is the menu options class. It includes menu options arraylist with different menu generator implementations.
It builds menus, calls validators and returns values to the flow control.
 */
package procedureClasses;

import classes.Course;
import classes.Student;
import classes.Trainer;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuOptions {

    private ArrayList<String> menuOptionsHolder = new ArrayList<>();

    public MenuOptions() {
        menuOptionsHolder.add("Manual Data Entry"); //0
        menuOptionsHolder.add("Use synthetic data"); //1
        menuOptionsHolder.add("Exit"); //2

        menuOptionsHolder.add("Courses"); //3
        menuOptionsHolder.add("Students"); //4
        menuOptionsHolder.add("Trainers"); //5
        menuOptionsHolder.add("Multiple Assignments Checker"); //6

        menuOptionsHolder.add("Back"); //7

        menuOptionsHolder.add("Register A Course"); //8 add assignments at the same time
        menuOptionsHolder.add("Show All Courses"); //9
        menuOptionsHolder.add("Show All Assignments / Course"); //10
        menuOptionsHolder.add("Select A Course"); //11  //show list of courses numbered first

        menuOptionsHolder.add("Register A Student"); //12 // add courses at the same time
        menuOptionsHolder.add("Show All Students"); //13
        menuOptionsHolder.add("Show Students Of Multiple Courses"); //14
        menuOptionsHolder.add("Select A Student"); //15 show list of all students first

        menuOptionsHolder.add("Show All Trainers"); //16
        menuOptionsHolder.add("Select A Trainer"); //17 //show list of all trainers first

        menuOptionsHolder.add("Register A Trainer to This Course"); //18 //show list of all trainers first
        menuOptionsHolder.add("Register A Student to This Course"); //19 //show list of all students first
        menuOptionsHolder.add("Create an Assignment to this Course"); //20 //show list of all assignments first
        menuOptionsHolder.add("Show All Students Of This Course"); //21 
        menuOptionsHolder.add("Show All Trainers Of this Course"); //22 
        menuOptionsHolder.add("Show All Assignments Of This Course"); //23 
        menuOptionsHolder.add("Edit Course"); //24        

        menuOptionsHolder.add("Edit Course Title"); //25        
        menuOptionsHolder.add("Edit Stream"); //26        
        menuOptionsHolder.add("Edit Type"); //27        
        menuOptionsHolder.add("Edit Start Date"); //28        
        menuOptionsHolder.add("Edit End Date"); //29

        menuOptionsHolder.add("Show All Assignments"); //30        
        menuOptionsHolder.add("Edit First Name"); //31        
        menuOptionsHolder.add("Edit Last Name"); //32        
        menuOptionsHolder.add("Edit Date Of Birth"); //33        
        menuOptionsHolder.add("Edit Tuition Fees"); //34        
        menuOptionsHolder.add("Add Courses"); //35 // increase fees

        menuOptionsHolder.add("Payment was made"); //36
        menuOptionsHolder.add("Completion Of Payment"); //37
        menuOptionsHolder.add("Calculate Installments"); //38

        menuOptionsHolder.add("Edit Trainer Name"); //39
        menuOptionsHolder.add("Edit Trainer Last Name"); //40
        menuOptionsHolder.add("Edit Subject"); //41
        menuOptionsHolder.add("Register A Course To this Trainer"); //42  // show list of courses

        menuOptionsHolder.add("How many courses will you add? (type a number): "); // 43
        menuOptionsHolder.add("Give a title for the course: "); //44
        menuOptionsHolder.add("Course Stream (Type c# or java): "); //45
        menuOptionsHolder.add("Part time or full time (type part or full)"); //46
        menuOptionsHolder.add("Please enter the date the course will start (e.g 30/12/2019): "); //47
        menuOptionsHolder.add("Please enter the date the course will end (e.g 30/12/2019): "); //48
        menuOptionsHolder.add("How many Assignments will this course have? "); //49
        menuOptionsHolder.add("Please enter title for assignment: "); //50
        menuOptionsHolder.add("Please enter description for assignment: "); //51
        menuOptionsHolder.add("Please enter the date that this assignment needs to be submitted (e.g 30/12/2019): ");  //52
        menuOptionsHolder.add("Type STOP if you want to stop entering assignments or anything else to continue: ");  //53
        menuOptionsHolder.add("Type STOP if you want to stop entering courses or anything else to continue: ");  //54
        menuOptionsHolder.add("Please enter a number that represents the maximum of the oral mark (MAX 100): ");  //55

        menuOptionsHolder.add("How many students will you add? (type a number): "); // 56
        menuOptionsHolder.add("Give student's First Name: "); //57
        menuOptionsHolder.add("Give students's Last Name:  "); //58
        menuOptionsHolder.add("Give student's Date of birth in the following form (e.g 30/12/2019) \n Have in mind that we accept students that are 18 years old or more: "); //59
        menuOptionsHolder.add("How many Courses will this student attend: "); //60
        menuOptionsHolder.add("Please give a course number: "); //61
        menuOptionsHolder.add("Type STOP if you want to stop entering STUDENTS or anything else to continue: ");  //62

        menuOptionsHolder.add("How much: ");  //63
        menuOptionsHolder.add("How many monthly installements you want to calculate: ");  //64
        menuOptionsHolder.add("Register a trainer ");  //65

        menuOptionsHolder.add("How many trainers will you add? (type a number): "); // 66
        menuOptionsHolder.add("Give trainer's First Name: "); //67
        menuOptionsHolder.add("Give trainer's Last Name:  "); //68
        menuOptionsHolder.add("Describe trainer's subject: "); //69
        menuOptionsHolder.add("How many Courses will this trainer teach: "); //70
        menuOptionsHolder.add("Please give a course number: "); //71
        menuOptionsHolder.add("Type STOP if you want to stop entering TRAINERS or anything else to continue: ");  //72

        menuOptionsHolder.add("Show All Students / Course"); //73
        menuOptionsHolder.add("Show All Trainers / Course"); //74
        menuOptionsHolder.add("Show All Assignments / Student"); //75

        menuOptionsHolder.add("Please enter a date in the following form (e.g 30/12/2019):"); //76

        menuOptionsHolder.add("Give number of courses to generate: "); //77
        menuOptionsHolder.add("Give number of assignments to generate per course (MAX 5): "); //78
        menuOptionsHolder.add("Give number of trainers to generate: "); //79
        menuOptionsHolder.add("Give number of students to generate: "); //80
    }

    public int menuGenerator(int[] optionList) {  // generates the menu and returns choice so switch can happen
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        boolean correctUserInput = false;

        while (!correctUserInput || choice <= 0 || choice > optionList.length) {
            printMenu(optionList); //print menu
            String userInput = scanner.nextLine();
            if (Validator.passValidation(userInput, optionList.length)) { // validates user input to be integer and limit of the choice
                correctUserInput = true;
                choice = Integer.parseInt(userInput);
            }
        }
        return choice;
    }

    public int selectCourse(ArrayList<Course> courseList) {
        System.out.println("Give a course number (1 - " + courseList.size() + "): ");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        boolean correctUserInput = false;

        while (!correctUserInput || choice < 0) {
            String userInput = scanner.nextLine();
            if (Validator.passValidation(userInput, courseList.size())) { // validates user input to be integer and limit of the choice
                correctUserInput = true;
                choice = Integer.parseInt(userInput) - 1;  //-1 because we need to get the array index
            } else {
                ViewsControls.showAllCourses();
                System.out.println("PLEASE MAKE A SELECTION WITHIN THE GIVEN LIMITS OF 1 to " + courseList.size());
                System.out.println("Give a course number (1 - " + courseList.size() + "): ");
            }
        }
        return choice;
    }

    public int selectTrainer(ArrayList<Trainer> trainerList) {
        System.out.println("Give a trainer number (1 - " + trainerList.size() + "): ");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        boolean correctUserInput = false;

        while (!correctUserInput || choice < 0) {
            String userInput = scanner.nextLine();
            if (Validator.passValidation(userInput, trainerList.size())) { // validates user input to be integer and limit of the choice
                correctUserInput = true;
                choice = Integer.parseInt(userInput) - 1;//-1 because we need to get the array index
            } else {
                ViewsControls.showAllTrainers();
                System.out.println("PLEASE MAKE A SELECTION WITHIN THE GIVEN LIMITS OF 1 to " + trainerList.size());
                System.out.println("Give a trainer number (1 - " + trainerList.size() + "): ");
            }
        }
        return choice;
    }

    public int selectStudent(ArrayList<Student> studentList) {
        System.out.println("Give a student number (1 - " + studentList.size() + "): ");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        boolean correctUserInput = false;

        while (!correctUserInput || choice < 0) {
            String userInput = scanner.nextLine();
            if (Validator.passValidation(userInput, studentList.size())) { // validates user input to be integer and limit of the choice
                correctUserInput = true;
                choice = Integer.parseInt(userInput) - 1;//-1 because we need to get the array index
            } else {
                ViewsControls.showAllStudents();
                System.out.println("PLEASE MAKE A SELECTION WITHIN THE GIVEN LIMITS OF 1 to " + studentList.size());
                System.out.println("Give a student number (1 - " + studentList.size() + "): ");
            }
        }
        return choice;
    }

    public String menuGeneratorCrudString(int[] optionList) {  // generates the menu and returns value after
        Scanner scanner = new Scanner(System.in);      // any validation takes place
        int[] optionsSelect = optionList; // menu item selection
        printMenuOption(optionsSelect); //print menu
        String userInput = scanner.nextLine();
        return userInput;
    }

    public String menuGeneratorNameSurname(int[] optionList) {  // generates the menu and returns value after
        boolean correctUserInput = false;
        String userInput = "";
        while (!correctUserInput) {
            Scanner scanner = new Scanner(System.in);
            int[] optionsSelect = optionList; // menu item selection
            printMenuOption(optionsSelect); //print menu        
            userInput = scanner.nextLine();
            if (Validator.nameLastNameValidator(userInput)) {
                correctUserInput = true;
            }
        }
        return userInput;
    }

    public int menuGeneratorInt(int[] optionList) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean correctUserInput = false;
        while (!correctUserInput) {
            int[] optionsSelect = optionList; // menu item selection
            printMenuOption(optionsSelect); //print menu
            String userInput = scanner.nextLine();
            if (Validator.isItAnInteger(userInput)) {
                correctUserInput = true;
                choice = Integer.parseInt(userInput);
            }
        }
        return choice;
    }

    public double menuGeneratorDouble(int[] optionList) {
        Scanner scanner = new Scanner(System.in);
        double choice = 0;
        boolean correctUserInput = false;
        while (!correctUserInput) {
            int[] optionsSelect = optionList; // menu item selection
            printMenuOption(optionsSelect); //print menu
            String userInput = scanner.nextLine();
            if (Validator.isItADouble(userInput)) {
                correctUserInput = true;
                choice = Double.parseDouble(userInput);
            }
        }
        return choice;
    }

    public void printMenu(int[] optionList) {
        System.out.println("*************************************************************************************");
        for (int i = 0; i < optionList.length; i++) {
            System.out.println((i + 1) + ")" + menuOptionsHolder.get(optionList[i]));
        }
        System.out.println("*************************************************************************************");
        if (optionList.length > 1) {
            System.out.println("Type a number 1-" + optionList.length + ": ");
        } else {
            System.out.println("Type number 1 to continue: ");
        }
    }

    public void printMenuOption(int[] optionList) {
        for (int i = 0; i < optionList.length; i++) {
            System.out.println(menuOptionsHolder.get(optionList[i]));
        }
    }
}
