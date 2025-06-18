import java.util.Random;
import java.util.Scanner;

class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int magicNumber = rand.nextInt(1, 101);
            System.out.print("I am thinking of a number 1-100. Take a guess or type 'Q' to quit: ");
            String guess = scanner.nextLine();
            while (true) {
                String trimmed = guess.trim();
                if (trimmed.equalsIgnoreCase("q")) {
                    System.out.println("Exiting guessing game");
                    scanner.close();
                    return;
                } else if (trimmed.contains(" ")) {
                    System.out.print("Can only accept one argument at a time! Guess again: ");
                    guess = scanner.nextLine();
                } else if (!trimmed.matches("\\d+")) {
                    System.out.print("Input must be an integer! Guess again: ");
                    guess = scanner.nextLine();
                } else {
                    int numGuess = Integer.parseInt(guess);
                    if (numGuess < 1 || numGuess > 100) {
                        System.out.print("The magic number is between 1 & 100! Guess again: ");
                        guess = scanner.nextLine();
                    } else if (magicNumber != numGuess) {
                        System.out.print("Not quite! Guess again: ");
                        guess = scanner.nextLine();
                    } else {
                        System.out.print("You got it! Let's play again.");
                        break;
                    }
                }
            }
        }
    }
}