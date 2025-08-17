## Grade Calculator (Java)

Simple console app to compute a student's total marks, average percentage, and grade based on inputs for multiple subjects.

### File
- `Task 2/GradeCalculator.java`

### Requirements
- Java JDK 8 or later

### How to Run
1. Open a terminal in the `Task 2` directory.
2. Compile:
```bash
javac GradeCalculator.java
```
3. Run:
```bash
java GradeCalculator
```

### Usage
- Enter the total number of subjects (positive integer).
- Enter marks for each subject between 0 and 100.
- If you enter an invalid mark, the program asks you to re-enter for that subject.
- The app prints total marks, average percentage, and the final grade.

### Grading Scale
- A+: 90–100
- A: 80–89.99
- B: 70–79.99
- C: 60–69.99
- D: 50–59.99
- F (Fail): below 50

### Example
```text
Student Grade Calculator
Enter the total number of subjects: 3
Enter marks obtained in subject 1 (out of 100): 95
Enter marks obtained in subject 2 (out of 100): 70
Enter marks obtained in subject 3 (out of 100): 85

 Results 
Total Marks Obtained: 250 out of 300
Average Percentage: 83.33%
Grade: A
```

### Notes
- Inputs are validated to be within 0–100.
- Average percentage is shown with two decimal places.

