/*
This class implements methods of different validators that are needed throughout the application.
 */
package procedureClasses;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validator {

    public static final String INCORRECT_INPUT = "PLEASE GIVE A NUMBER.";
    public static final String CHOICE_OUT_OF_LIMITS = "PLEASE GIVE A NUMBER BETWEEN THE GIVEN LIMITS (NO NEGATIVES).";
    public static final String NO_NEGATIVES = "PLEASE DO NOT ENTER NEGATIVE NUMBERS";
    public static final String ONLY_LETTERS = "THIS IS NOT A VALID INPUT ONLY LETTERS ARE ACCEPTED";
    public static final String WRONG_DATE_INPUT = "ERROR. PLEASE ENTER A VALID DATE ON THIS FORMAT -> 30/01/2019.";
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    public static boolean passValidation(String userInput, int lengthOfMenu) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println(INCORRECT_INPUT);
            return false;
        }
        int choice = Integer.parseInt(userInput);
        if (limitCheck(lengthOfMenu, choice)) {
            return true;
        } else {
            System.out.println(CHOICE_OUT_OF_LIMITS);
            return false;
        }
    }

    public static boolean passValidationMark(String userInput, int markLimit) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println(INCORRECT_INPUT);
            return false;
        }
        int choice = Integer.parseInt(userInput);
        if (limitCheck100(markLimit, choice)) {
            return true;
        } else {
            System.out.println(CHOICE_OUT_OF_LIMITS);
            return false;
        }
    }

    public static boolean limitCheck100(int limit, int choice) {
        return !(choice < 0 || choice > limit);
    }

    public static boolean limitCheck(int limit, int choice) {
        return !(choice <= 0 || choice > limit);
    }

    public static boolean isItAnInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println(INCORRECT_INPUT);
            return false;
        }
        int choice = Integer.parseInt(userInput);
        if (choice < 0) {
            System.out.println(NO_NEGATIVES);
            return false;
        }
        return choice >= 0;
    }

    public static boolean isItADouble(String userInput) {
        try {
            Double.parseDouble(userInput);
        } catch (NumberFormatException e) {
            System.out.println(INCORRECT_INPUT);
            return false;
        }
        double choice = Double.parseDouble(userInput);
        return choice >= 0;
    }

    public static boolean nameLastNameValidator(String userInput) {
        boolean check = true;
        if (!userInput.matches("[a-zA-Z_]+")) {
            System.out.println(ONLY_LETTERS);
            check = false;
        }
        return check;
    }

    public static boolean streamValidation(String userInput) {
        return userInput.equalsIgnoreCase("c#") || userInput.equalsIgnoreCase("java");
    }

    public static boolean typeValidation(String userInput) {
        return userInput.equalsIgnoreCase("full") || userInput.equalsIgnoreCase("part");
    }

    public static boolean yesNoValidation(String userInput) {
        return userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no");
    }

    public static boolean dateValidator(String dateStr) {
        try {
            LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public static boolean logicalDateOfBirth(String dob) {
        LocalDate check = LocalDate.parse(dob, formatter);
        LocalDate now = LocalDate.now();
        int years = 0;
        if ((check != null) && (now != null)) {
            years = Period.between(check, now).getYears();
            System.out.println("Student is " + years + " old.");
        }
        if (years >= 18) {
            return true;
        }
        System.out.println("Student must be over 18 years old.");
        return false;
    }

    public static boolean logicCalculator(String userInput, LocalDate startDate) {
        int compare;
        try {
            compare = LocalDate.parse(userInput, formatter).compareTo(startDate);
        } catch (DateTimeParseException e) {
            return false;
        }
        if (compare < 0) {  // can be done in 1 line but the logic is clear in this way
            return false;
        }
        return true;
    }

    public static boolean logicCalculator(int selectedCourse, String userInput) {
        int compare;
        try {
            compare = LocalDate.parse(userInput, formatter).compareTo(Populate.getGeneratedCourses().get(selectedCourse).getEnd_date());
        } catch (DateTimeParseException e) {
            return false;
        }
        if (compare > 0) {
            return false;
        }
        return true;
    }

    public static boolean logicCalculatorForSetEndDate(int selectedCourse, String userInput) {
        int compare;
        try {
            compare = LocalDate.parse(userInput, formatter).compareTo(Populate.getGeneratedCourses().get(selectedCourse).getEnd_date());
        } catch (DateTimeParseException e) {
            return false;
        }
        if (compare < 0) {
            return false;
        }
        return true;
    }

    public static boolean logicCalculator(String userInput, LocalDate startDate, LocalDate endDate) {
        int compare;
        int compare2;
        try {
            compare = LocalDate.parse(userInput, formatter).compareTo(startDate);
        } catch (DateTimeParseException e) {
            return false;
        }

        try {
            compare2 = LocalDate.parse(userInput, formatter).compareTo(endDate);
        } catch (DateTimeParseException e) {
            return false;
        }
        if (compare < 0 || compare2 > 0) {
            return false;
        }
        return true;
    }

    public static boolean stringMenuValidation(String userInput, int lengthOfMenu) {
        int choice = Integer.parseInt(userInput);
        if (limitCheck(lengthOfMenu, choice)) {
            return true;
        } else {
            System.out.println(CHOICE_OUT_OF_LIMITS);
            return false;
        }
    }

}
