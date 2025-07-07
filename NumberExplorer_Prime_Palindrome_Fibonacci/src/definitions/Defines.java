package definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Defines {
    protected static int countDigits = 0;
    protected static final Scanner scanner = new Scanner(System.in);
    protected static final Pattern intPattern = Pattern.compile("\\d+");
    protected static final Pattern strPattern = Pattern.compile("^[A-Za-z0-9 ]+$");
    protected static List<Integer> primeNumbers = new ArrayList<>();
    protected static long fibNumberForRecursive = 0;
    protected static long fibNumber = 0;
    protected static List<Long> fibonacciList = new ArrayList<>();
    protected static long a;
    protected static long b;
    protected static char[] charsStr;
    protected static String reverseStr;
    protected static List<Character> charsStrReverse;
}