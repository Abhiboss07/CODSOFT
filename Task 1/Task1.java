import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        
        System.out.println("=== NUMBER GUESSING GAME ===");
        System.out.println("I'm thinking of a number between " + min + " and " + max);
        System.out.println("You have " + maxAttempts + " attempts to guess it!");
        System.out.println();

        int secretNumber = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        boolean gameWon = false;

        while (attempts < maxAttempts && !gameWon) {
            attempts++;
            System.out.print("Attempt " + attempts + "/" + maxAttempts + " - Enter your guess: ");
    
            int guess;
            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                attempts--; 
                continue;
            }
            
            if (guess < min || guess > max) {
                System.out.println("Please enter a number between " + min + " and " + max + "!");
                attempts--; 
                continue;
            }
            
            if (guess == secretNumber) {
                System.out.println("🎉 CONGRATULATIONS! You guessed it in " + attempts + " attempts!");
                gameWon = true;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Too high! Try a lower number.");
            }
            
            if (!gameWon && attempts < maxAttempts) {
                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }
            System.out.println();
        }
        
        if (!gameWon) {
            System.out.println("😔 Game Over! The number was: " + secretNumber);
        }
        
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
