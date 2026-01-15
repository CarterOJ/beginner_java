import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.regex.*;

public class Calculator {
    static double binaryOperation(double opOne, double opTwo, String operator) {
        switch (operator) {
            case "+": return opOne + opTwo;
            case "-": return opOne - opTwo;
            case "*": return opOne * opTwo;
            case "/": return opOne / opTwo;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        System.out.println("To use the calculator, please adhere to the following format: [int] '+'||'-'||'*'||'/' [int].");
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.######");
        Pattern tokenPattern = Pattern.compile("(?:^|(?<=[+\\-*/]))-?(?:\\w+(?:\\.\\w+)?|\\.\\w+)|[+\\-*/]");
        while (true) {
            System.out.println("Enter an expression or type 'Q' to quit: ");
            String userIn = scanner.nextLine();
            if (userIn.trim().equalsIgnoreCase("q")) {
                System.out.println("Exiting calculator");
                scanner.close();
                break;
            }
            List<String> tokens = new ArrayList<>();
            Matcher matcher = tokenPattern.matcher(userIn.replaceAll("\\s+", ""));
            while (matcher.find()) {
                tokens.add(matcher.group());
            }
            if (tokens.size() != 3) {
                System.out.println("There must be exactly three arguments!");
            } else if (!tokens.get(0).matches("-?\\d+")) {
                System.out.printf("%s is not an integer!%n", tokens.get(0));
            } else if (!tokens.get(2).matches("-?\\d+")) {
                System.out.printf("%s is not an integer!%n", tokens.get(2));
            } else if (!tokens.get(1).matches("[+\\-*/]")) {
                System.out.printf("%s is not a valid operator!%n", tokens.get(1));
            } else if (Integer.parseInt(tokens.get(2)) == 0 && tokens.get(1).equals("/")) {
                System.out.println("Undefined");
            } else {
                double result = binaryOperation(Double.parseDouble(tokens.get(0)), Double.parseDouble(tokens.get(2)), tokens.get(1));
                System.out.printf("Result: %s%n", df.format(result));
            }
        }
    }
}