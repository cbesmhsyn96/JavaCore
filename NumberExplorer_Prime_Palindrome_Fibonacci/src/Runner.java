import commonmusts.Common;
import digitcount.DigitCount;
import fibonacci.FibonacciListCreate;
import palindrome.PalindromeExpressionCheck;
import prime.PrimeNumberLister;

import static fibonacci.FibonacciListCreate.getFibonacciNumbers;

public class Runner{
    public static void main(String[] args){
        Common digitCount = new DigitCount();
        Common primeNumberLister = new PrimeNumberLister();
        Common fibonacciNumberClass = new FibonacciListCreate();
        Common polindromChecker = new PalindromeExpressionCheck();
        /*digitCount.execute();
        primeNumberLister.execute();
        fibonacciNumberClass.execute();
        getFibonacciNumbers();
        polindromChecker.execute();*/
    }
}