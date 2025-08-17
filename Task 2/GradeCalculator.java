import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator");

        // 1. Input: Get the number of subjects.
        System.out.print("Enter the total number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Initialize totalMarks to 0. This variable will store the sum of all marks.
        int totalMarks = 0;

        // 2. Input & Calculation: Get marks for each subject and calculate the total.
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();

            // Input validation: Ensure marks are between 0 and 100.
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                i--; // Decrement i to re-enter marks for the same subject.
                continue;
            }
            // Add the marks for the current subject to the totalMarks.
            totalMarks += marks;
        }

        // 3. Calculate Average Percentage.
        // We cast totalMarks to a double to ensure the division results in a decimal value.
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // 4. Grade Calculation.
        // Determine the grade based on the average percentage.
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        // 5. Display Results.
        System.out.println("\n Results ");
        System.out.println("Total Marks Obtained: " + totalMarks + " out of " + (numberOfSubjects * 100));
        // Use printf for formatted output to show two decimal places for the percentage.
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        // Close the scanner to prevent resource leaks.
        scanner.close();
    }
}
