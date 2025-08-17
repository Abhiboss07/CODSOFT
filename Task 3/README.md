## ATM Banking System (Java)

A console-based ATM (Automated Teller Machine) simulation that allows users to perform basic banking operations like checking balance, depositing money, and withdrawing funds.

### Files
- `Task 3/Main.java` - Contains the main application with BankAccount and ATM classes

### Features
- **Check Balance**: View current account balance
- **Deposit**: Add money to the account (positive amounts only)
- **Withdraw**: Remove money from the account (if sufficient balance)
- **Input Validation**: Handles invalid inputs gracefully
- **User-Friendly Interface**: Clear menu-driven console interface

### Requirements
- Java JDK 8 or later

### How to Run
1. Open a terminal in the `Task 3` directory
2. Compile the program:
```bash
javac Main.java
```
3. Run the application:
```bash
java Main
```

### Usage
1. The program starts with an initial balance of $1000.00
2. Choose from the menu options (1-4):
   - **Option 1**: Check your current balance
   - **Option 2**: Deposit money (enter positive amount)
   - **Option 3**: Withdraw money (enter positive amount, must not exceed balance)
   - **Option 4**: Exit the ATM

### Example Session
```
--- ATM Menu ---
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 1

Your current balance is: $1000.00

--- ATM Menu ---
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 2
Enter amount to deposit: 500
Successfully deposited: $500.0

--- ATM Menu ---
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 1

Your current balance is: $1500.00

--- ATM Menu ---
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 3
Enter amount to withdraw: 200
Successfully withdrew: $200.0

--- ATM Menu ---
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 4
Thank you for using the ATM. Goodbye!
```

### Program Structure
- **BankAccount Class**: Manages account balance and core banking operations
- **ATM Class**: Handles user interface and menu navigation
- **Main Class**: Entry point that initializes the system

### Features Explained
- **Balance Validation**: Cannot withdraw more than available balance
- **Input Validation**: Only positive amounts accepted for deposits and withdrawals
- **Error Handling**: Graceful handling of invalid menu choices and non-numeric inputs
- **Precision**: Balance displayed with 2 decimal places for currency accuracy

### Notes
- The program runs in a loop until the user chooses to exit (option 4)
- Invalid inputs are handled with appropriate error messages
- The scanner is properly closed when exiting to prevent resource leaks
