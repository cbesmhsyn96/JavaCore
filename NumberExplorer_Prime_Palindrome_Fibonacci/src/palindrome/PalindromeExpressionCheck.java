package palindrome;

import commonmusts.Common;
import definitions.Defines;

import java.util.ArrayList;
import java.util.List;

public class PalindromeExpressionCheck extends Defines implements Common {

    private static boolean isPalindromeRecursive(int i, String str) {
        if (str.length() == 1) {
            return true;
        }
        if (i < str.length() / 2) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
            return isPalindromeRecursive(i + 1, str);
        }
        return true;
    }

    private static boolean isPalindromeIterative(String str) {
        charsStr = str.toCharArray();
        reverseStr = "";
        charsStrReverse = new ArrayList<>();
        for (int j = charsStr.length - 1; j >= 0; j--) {
            charsStrReverse.add(charsStr[j]);
        }
        for (int index = 0; index < charsStrReverse.size(); index++) {
            reverseStr += charsStrReverse.get(index);
        }
        return reverseStr.equals(str);
    }

    private static void checkPalindromeBothWays(String str) {
        System.out.println("Using recursion:");
        if (isPalindromeRecursive(0, str)) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }
        System.out.println("Without using recursion:");
        if (isPalindromeIterative(str)) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }
    }

    @Override
    public void execute() {
        System.out.print("Enter the text or number to check for palindrome: ");
        String expression = scanner.nextLine();
        if (strPattern.matcher(expression).matches()) {
            checkPalindromeBothWays(expression);
        } else {
            System.out.println("Invalid input pattern.");
        }
    }
}
