package task1;
import java.util.Random;
import java.util.Scanner;

public class task1_numbergaming {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randomGenerator = new Random();

        int rangeMin = 1;
        int rangeMax = 100;
        int maxAttempts = 10;
        int totalRounds = 0;
        int totalGuesses = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            totalRounds++;
            int secretNumber = randomGenerator.nextInt(rangeMax - rangeMin + 1) + rangeMin;
            int attempts = 0;
            boolean maxAttemptsReached = false;

            System.out.println("\nRound " + totalRounds + ": I have picked a number between " + rangeMin + " and " + rangeMax + ". Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = input.nextInt();
                attempts++;
                totalGuesses++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {
                maxAttemptsReached = true;
            }

            if (maxAttemptsReached) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + secretNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = input.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }

        } while (true);

        int averageGuessesPerRound = (int) totalGuesses / totalRounds;
        System.out.println("\nGame over. You played " + totalRounds + " rounds. Your average score (guesses per round) is: " + averageGuessesPerRound);
        input.close();
    }
}