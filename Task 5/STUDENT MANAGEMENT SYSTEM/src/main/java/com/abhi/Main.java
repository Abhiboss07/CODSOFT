package  com.abhi;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private long rollNumber;
    private String grade;

    public Student(String name, long rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public long getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                '}';
    }
}

class StudentManagementSystem {
    private List<Student> students;
    private static final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
        loadStudentsFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(long rollNumber) {
        Student studentToRemove = searchStudent(rollNumber);
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    public Student searchStudent(long rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void editStudent(long rollNumber, String newName, String newGrade) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            student.setName(newName);
            student.setGrade(newGrade);
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            System.out.println("\n--- All Students ---");
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println("--------------------\n");
        }
    }

    public void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("All student data has been saved.");
        } catch (IOException e) {
            System.err.println("Error saving students to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadStudentsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No existing data file found. Starting with an empty system.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Student data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading students from file: " + e.getMessage());
            students = new ArrayList<>();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add a new Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Search for a Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit a Student's Information");
            System.out.println("6. Save and Exit");
            System.out.print("Please enter your choice (1-6): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();

                        long rollNumber = -1L;
                        while (true) {
                            try {
                                System.out.print("Enter roll number: ");
                                rollNumber = scanner.nextLong();
                                scanner.nextLine();
                                if (sms.searchStudent(rollNumber) != null) {
                                    System.out.println("Error: A student with this roll number already exists. Please enter a unique roll number.");
                                } else {
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a number for the roll number.");
                                scanner.nextLine();
                            }
                        }

                        System.out.print("Enter student grade: ");
                        String grade = scanner.nextLine();

                        if (name.trim().isEmpty() || grade.trim().isEmpty()) {
                            System.out.println("Error: Name and grade cannot be empty.");
                        } else {
                            sms.addStudent(new Student(name, rollNumber, grade));
                        }
                        break;

                    case 2:
                        System.out.print("Enter the roll number of the student to remove: ");
                        try {
                            long rollToRemove = scanner.nextLong();
                            scanner.nextLine();
                            sms.removeStudent(rollToRemove);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.nextLine();
                        }
                        break;

                    case 3:
                        System.out.print("Enter the roll number of the student to search for: ");
                        try {
                            long rollToSearch = scanner.nextLong();
                            scanner.nextLine();
                            Student foundStudent = sms.searchStudent(rollToSearch);
                            if (foundStudent != null) {
                                System.out.println("Student Found: " + foundStudent);
                            } else {
                                System.out.println("Student not found.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.nextLine();
                        }
                        break;

                    case 4:
                        sms.displayAllStudents();
                        break;

                    case 5:
                        System.out.print("Enter the roll number of the student to edit: ");
                        try {
                            long rollToEdit = scanner.nextLong();
                            scanner.nextLine();

                            if (sms.searchStudent(rollToEdit) == null) {
                                System.out.println("Student with this roll number does not exist.");
                                break;
                            }

                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter new grade: ");
                            String newGrade = scanner.nextLine();

                            if (newName.trim().isEmpty() || newGrade.trim().isEmpty()) {
                                System.out.println("Error: Name and grade cannot be empty.");
                            } else {
                                sms.editStudent(rollToEdit, newName, newGrade);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number for the roll number.");
                            scanner.nextLine();
                        }
                        break;

                    case 6:
                        sms.saveStudentsToFile();
                        System.out.println("Exiting application. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number for your choice.");
                scanner.nextLine();
            }
        }
    }
}
