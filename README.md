# Number Guessing Game

A simple and fun number guessing game built in Java where players try to guess a randomly generated number within a limited number of attempts.

## 🎮 Game Features

- **Simple and intuitive** - Easy to understand and play
- **5 attempts maximum** - Challenge yourself to guess within 5 tries
- **Range: 1-100** - Numbers are generated between 1 and 100
- **Smart feedback** - Get hints whether your guess is too high or too low
- **Input validation** - Handles invalid inputs gracefully
- **Attempt tracking** - See your current attempt and remaining tries

## 🚀 How to Play

1. **Start the game** - Run the Java program
2. **Read the instructions** - The game will tell you the rules
3. **Make your guess** - Enter a number between 1 and 100
4. **Get feedback** - The game will tell you if your guess is too high or too low
5. **Keep guessing** - You have 5 attempts to find the correct number
6. **Win or lose** - Either guess correctly or run out of attempts

## 📋 Requirements

- Java Development Kit (JDK) 8 or higher
- Any Java IDE or command line

## 🔧 How to Run

### Method 1: Using Command Line

1. **Compile the program:**
   ```bash
   javac Task1.java
   ```

2. **Run the program:**
   ```bash
   java Task1
   ```

### Method 2: Using an IDE

1. Open your Java IDE (Eclipse, IntelliJ IDEA, NetBeans, etc.)
2. Create a new Java project
3. Add the `Task1.java` file to your project
4. Run the program

## 🎯 Game Rules

- The computer generates a random number between 1 and 100
- You have exactly **5 attempts** to guess the correct number
- After each guess, you'll get feedback:
  - "Too low! Try a higher number." - if your guess is below the target
  - "Too high! Try a lower number." - if your guess is above the target
  - "🎉 CONGRATULATIONS!" - if you guess correctly
- Invalid inputs (non-numbers or out-of-range numbers) don't count as attempts
- The game ends when you either guess correctly or use all 5 attempts

## 💡 Tips for Playing

- **Use the feedback wisely** - If you guess 50 and it's too high, try a lower number
- **Think strategically** - Use binary search approach for better chances
- **Don't waste attempts** - Make sure your guesses are within the valid range (1-100)

## 🏆 Example Game Session

```
=== NUMBER GUESSING GAME ===
I'm thinking of a number between 1 and 100
You have 5 attempts to guess it!

Attempt 1/5 - Enter your guess: 50
Too high! Try a lower number.
Attempts remaining: 4

Attempt 2/5 - Enter your guess: 25
Too low! Try a higher number.
Attempts remaining: 3

Attempt 3/5 - Enter your guess: 37
🎉 CONGRATULATIONS! You guessed it in 3 attempts!

Thanks for playing!
```

## 📁 Project Structure

```
Number Guessing Game/
├── Task1.java          # Main game source code
├── Task1.class         # Compiled Java bytecode
└── README.md           # This documentation file
```

## 🛠️ Technical Details

- **Language:** Java
- **Input:** Console-based user input
- **Random Generation:** Uses Java's Random class
- **Error Handling:** Input validation for non-numeric and out-of-range values
- **User Interface:** Simple console interface with clear prompts and feedback

## 🤝 Contributing

Feel free to improve this game by:
- Adding more features (multiple rounds, scoring system)
- Improving the user interface
- Adding sound effects or graphics
- Creating different difficulty levels

## 📝 License

This project is open source and available under the MIT License.

---

**Enjoy playing the Number Guessing Game! 🎲** 