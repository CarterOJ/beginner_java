import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;

class Fizzbuzz {
    static String fizzbuzz(BigInteger n) {
        final BigInteger THREE = BigInteger.valueOf(3);
        final BigInteger FIVE = BigInteger.valueOf(5);
        ArrayList<String> lines = new ArrayList<>();
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0 ; i = i.add(BigInteger.ONE)) {
            if (i.mod(THREE).equals(BigInteger.ZERO) && i.mod(FIVE).equals(BigInteger.ZERO)) {
                lines.add("FizzBuzz");
            } else if (i.mod(THREE).equals(BigInteger.ZERO)) {
                lines.add("Fizz");
            } else if (i.mod(FIVE).equals(BigInteger.ZERO)) {
                lines.add("Buzz");
            } else {
                lines.add(i.toString());
            }
        }
        return String.join("\n", lines);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter the iteration amount to fizzbuzz. Type 'Q' to quit: ");
            String iters = scanner.nextLine();
            if (iters.trim().equalsIgnoreCase("q")) {
                System.out.println("Exiting fizzbuzz");
                break;
            } else if (iters.trim().contains(" ")) {
                System.out.println("Can only accept one argument!");
            } else if (!iters.trim().matches("\\d+")) {
                System.out.println("Input must be a positive integer!");
            } else {
                System.out.println(fizzbuzz(new BigInteger(iters.trim())));
            }
        }
        scanner.close();
    }
}