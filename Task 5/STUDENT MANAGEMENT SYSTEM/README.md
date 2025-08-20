# Student Management System

A comprehensive Java-based console application for managing student records with persistent data storage. This system allows educational institutions to efficiently handle student information including names, roll numbers, and grades.

## 🎯 Features

- **Add Students**: Add new students with unique roll numbers
- **Remove Students**: Delete student records by roll number
- **Search Students**: Find students quickly using their roll number
- **Display All Students**: View complete list of all registered students
- **Edit Student Information**: Update student names and grades
- **Persistent Data Storage**: Automatically saves data to file and loads on startup
- **Input Validation**: Robust error handling for invalid inputs
- **User-Friendly Interface**: Clean console-based menu system

## 🛠️ Technology Stack

- **Language**: Java 21
- **Build Tool**: Maven
- **Data Storage**: Binary serialization (.dat files)
- **IDE Support**: IntelliJ IDEA compatible

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- **Java Development Kit (JDK) 21** or higher
- **Maven** (for building the project)
- **Git** (for cloning the repository)

## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd STUDENT-MANAGEMENT-SYSTEM
```

### 2. Build the Project
```bash
mvn clean compile
```

### 3. Run the Application
```bash
mvn exec:java -Dexec.mainClass="com.abhi.Main"
```

Alternatively, you can run the compiled JAR file:
```bash
java -cp target/classes com.abhi.Main
```

## 📖 Usage Guide

### Main Menu Options

1. **Add a new Student**
   - Enter student name
   - Enter unique roll number
   - Enter student grade
   - System validates input and checks for duplicate roll numbers

2. **Remove a Student**
   - Enter the roll number of the student to remove
   - System confirms removal or reports if student not found

3. **Search for a Student**
   - Enter roll number to search
   - Displays complete student information if found

4. **Display All Students**
   - Shows a formatted list of all registered students
   - Displays "No students in the system" if empty

5. **Edit a Student's Information**
   - Enter roll number of student to edit
   - Update name and/or grade
   - System validates changes

6. **Save and Exit**
   - Automatically saves all data to `students.dat`
   - Safely exits the application

### Data Storage

- Student data is automatically saved to `students.dat` file
- Data persists between application sessions
- File is created automatically on first run
- Corrupted files are handled gracefully

## 🏗️ Project Structure

```
STUDENT MANAGEMENT SYSTEM/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── abhi/
│                   └── Main.java          # Main application class
├── target/                               # Compiled classes
├── students.dat                          # Student data storage file
├── pom.xml                              # Maven configuration
└── README.md                            # This file
```

## 🔧 Key Classes

### Student Class
- Represents individual student records
- Implements `Serializable` for file storage
- Contains name, roll number, and grade
- Includes getter/setter methods and toString()

### StudentManagementSystem Class
- Core business logic for managing students
- Handles CRUD operations (Create, Read, Update, Delete)
- Manages file I/O operations
- Provides data validation

### Main Class
- Entry point of the application
- Handles user interface and menu system
- Implements input validation and error handling
- Manages application lifecycle

## 🛡️ Error Handling

The application includes comprehensive error handling for:

- **Invalid Input**: Non-numeric roll numbers, empty names/grades
- **Duplicate Roll Numbers**: Prevents adding students with existing roll numbers
- **File I/O Errors**: Graceful handling of file corruption or access issues
- **Input Mismatch**: Proper handling of scanner input errors

## 📝 Data Format

Student records are stored in the following format:
```
Student{name='John Doe', rollNumber=12345, grade='A'}
```

## 🔄 Data Persistence

- **Automatic Saving**: Data is saved when exiting the application
- **Automatic Loading**: Previous data is loaded when starting the application
- **File Format**: Binary serialization for efficient storage
- **Backup**: Consider backing up `students.dat` file regularly

## 🧪 Testing

To test the application:

1. Add several students with different information
2. Search for students using their roll numbers
3. Edit student information
4. Remove some students
5. Display all students to verify changes
6. Exit and restart to verify data persistence

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is part of the CODSOFT internship program. Please refer to the internship guidelines for usage and distribution terms.

## 👨‍💻 Author

**Abhi** - *Student Management System Developer*

## 🎓 Acknowledgments

- CODSOFT for providing the internship opportunity
- Java community for excellent documentation and resources
- Maven for the robust build system

---

**Note**: This is a console-based application designed for educational purposes. For production use in educational institutions, consider adding a graphical user interface and database integration.
