import java.util.Scanner;

class PalindromeChecker {
    static boolean checkPalindrome(String pal) {
        if (pal.length() <= 1) {
            return true;
        } else if (pal.charAt(0) == pal.charAt(pal.length() - 1)) {
            return checkPalindrome(pal.substring(1, pal.length() - 1));
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter any string to check if it's a palindrome. Type 'Q' to exit: ");
            String palindrome = scanner.nextLine();
            if (palindrome.trim().equalsIgnoreCase("q")) {
                System.out.println("Exiting palindrome checker");
                break;
            }
            System.out.println(checkPalindrome(palindrome));
        }
        scanner.close();
    }
}
