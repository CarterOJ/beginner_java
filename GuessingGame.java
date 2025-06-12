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
                if (guess.trim().equalsIgnoreCase("q")) {
                    break;
                } else if (guess.trim().contains(" ")) {
                    System.out.println("Can only accept one argument at a time! Guess again: ");
                    guess = scanner.nextLine();
                } else if (!guess.trim().matches("\\d+")) {
                    System.out.println("Input must be an integer! Guess again: ");
                    guess = scanner.nextLine();
                } else {
                    int numGuess = Integer.parseInt(guess);
                    if (numGuess < 1 || numGuess > 100) {
                        System.out.println("The magic number is between 1 & 100! Guess again: ");
                        guess = scanner.nextLine();
                    } else if (magicNumber != numGuess) {
                        System.out.println("Not quite! Guess again: ");
                        guess = scanner.nextLine();
                    } else {
                        System.out.println("You got it! Let's play again.");
                        break;
                    }
                }
            }
            if (guess.trim().equalsIgnoreCase("q")) {
                System.out.println("Exiting guessing game");
                break;
            }
        }
        scanner.close();
    }
}