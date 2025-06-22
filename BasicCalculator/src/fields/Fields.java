package fields;

import validations.Patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fields extends Patterns {
    protected static double number1;
    protected static double number2;
    protected static int sayi1;
    protected static int sayi2;
    protected static int sayi;
    protected static List<Integer> divisorsNumber1 = new ArrayList<>();
    protected static List<Integer> divisorsNumber2 = new ArrayList<>();
    protected static List<Integer> commonDivisors = new ArrayList<>();
    protected static Scanner scanner = new Scanner(System.in);
    protected static boolean continueStatus;
    protected static String selectionContinue;
}
