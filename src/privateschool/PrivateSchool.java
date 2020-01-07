/*
 Individual Assignment
 Private School Structure implementation
 Student Name : Kladis Nikolaos
 */
package privateschool;

import procedureClasses.FlowControl;

public class PrivateSchool {

    public static void main(String[] args) {
        FlowControl.mainMenu();
    }
    /* ================================================== NOTE TO THE EVALUATOR========================================*/
    /*I have created more functions than the ones asked in the assignment just for educational and training purposes.
     If you want to go directly to the assignments menu options and save time from checking the whole program
     do the following options on menus after you select synthetic or manual entry.
    
     The application must ask from the command prompt to input data to all the entities and it 
     should give the option to add more than one entry at a time [10 marks].    
     Multiple Registration paths    Courses 1-1 Students 2-1 Trainers 3-1 
     You can create multiple assignments only when you register a new course 1-1-Follow procedure
     Extra functionality -> If you type stop at the end of each entity registration, the process will stop.
    
     If the user decides not to type any data, the program should use synthetic data [5 marks].
     Every time you run the program the data are randomly created with some business logic on dates.
     Extra functionality-> Program will ask you how many INSTANCES you want to create on EVERY synthetic data generation.
       
     1) A list of all the students [5 marks]                  SELECTION 2->2
     2) A list of all the trainers [5 marks]                  SELECTION 3->2
     3) A list of all the assignments [5 marks]               SELECTION 1->3
     4) A list of all the courses [5 marks]                   SELECTION 1->2
     5) All the students per course [10 marks]             (a)SELECTION 1->4(View All Courses with STUDENTS Listed) 
                                                           (b)SELECTION 1->6->SELECT COURSE FROM LIST->4  Shows all STUDENTS of a selected course
     6) All the trainers per course [10 marks]             (a)SELECTION 1->5(View All Courses with TRAINERS Listed) 
                                                           (b)SELECTION 1->6->SELECT COURSE FROM LIST->5  Shows all TRAINERS of a selected course
     7) All the assignments per course [10 marks]             SELECTION 1->6->SELECT COURSE FROM LIST->6
     8) All the assignments per student [10 marks]         (a)SELECTION 2->5->SELECT STUDENT FROM LIST->1
                                                           (b)SELECTION 1->3   A BIG LIST WITH ALL STUDENTS, THEIR COURSES AND THE GIVEN ASSIGNMENTS
     9) A list of students that belong to more than 
     one courses [10 marks]                                   SELECTION 1->4
     10) A list of students that have to deliver more
     than 2 assignmnets in a given week. [15 marks].          SELECTION 4
     */

}
