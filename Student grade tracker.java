import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        String input;
        double grade;

        System.out.println("Student Grade Tracker");

        // Input grades
        while (true) {
            System.out.print("Enter a grade (or type 'done' to finish): ");
            input = scanner.next();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                grade = Double.parseDouble(input);
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade.");
            }
        }

        // Calculate average grade
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }

        double average = (grades.size() > 0) ? sum / grades.size() : 0;

        // Determine letter grade
        char letterGrade;

        if (average >= 90) {
            letterGrade = 'A';
        } else if (average >= 80) {
            letterGrade = 'B';
        } else if (average >= 70) {
            letterGrade = 'C';
        } else if (average >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }

        // Display results
        System.out.println("Average Grade: " + average);
        System.out.println("Letter Grade: " + letterGrade);

        // Optionally, calculate and display GPA
        double gpa = convertToGPA(letterGrade);
        System.out.println("GPA: " + gpa);

        // Close the scanner
        scanner.close();
    }

    // Method to convert letter grade to GPA
    public static double convertToGPA(char letterGrade) {
        switch (letterGrade) {
            case 'A':
                return 4.0;
            case 'B':
                return 3.0;
            case 'C':
                return 2.0;
            case 'D':
                return 1.0;
            case 'F':
                return 0.0;
            default:
                return 0.0;
        }
    }
}
