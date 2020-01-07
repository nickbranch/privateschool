/*
This is just the datastorage for names and subjects. Menu options can be moved here too.
 */
package procedureClasses;

public class DataStorage {

    private static final String[] names = {"Orval", "Alice", "Cammie", "Halley", "Chester", "Estella", "Laurene", "Elna",
        "Nick", "John", "Angelita", "Bernadette", "Sherill", "George", "Leonia", "Natosha", "Agatha",
        "Cedric", "Joannie", "Elliot"};

    private static final String[] last_names = {"Fleming", "Smith", "Hodges", "Buck", "Boyd", "Figueroa", "Sampson", "Bartlett",
        "Watkins", "Zamora", "Brady", "Dunn", "Sanchez", "Moore", "Carter", "Johns", "Shaffer",
        "Peters", "Dyer", "Oconnell"};

    private static final String[] subjectsJava = {"Html and CSS introduction", "Java In-Depth",
        "Software Development and Program Design Course", "The Complete Java Developer Course",
        "Java Fundamentals: The Java Language", "Object-Oriented Programming in Java Specialization",
        "Java Programming: Solving Problems with Software", "Data Structures", "SQL for beginners", "Java Advanced"};
    
    private static final String[] subjectsCsharp = {"C# Basics", "C Sharp Training",
        "C# Intermediate: Classes, Interfaces and OOP", "Data Structures", "SQL for beginners", "Azure: Get Started",
        ".net Fundamentals", "Html and CSS introduction", "Frameworks", "Scripting"};

    public static String[] getNames() {
        return names;
    }

    public static String[] getLastNames() {
        return last_names;
    }

    public static String[] getSubjectsJava() {
        return subjectsJava;
    }

    public static String[] getSubjectsCsharp() {
        return subjectsCsharp;
    }
}
