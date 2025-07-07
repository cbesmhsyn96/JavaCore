package fibonacci;

import commonmusts.Common;
import definitions.Defines;

import java.util.ArrayList;
import java.util.List;

import static definitions.Defines.*;

public class FibonacciListCreate extends Defines implements Common {
    protected static List<Long> initializeFibonacciNumbersWithRecursion(int i){
        if(i==0) {
            a = 0;b = 1;
            fibonacciList = new ArrayList<>();
            fibNumberForRecursive = a + b;
            fibonacciList.add(fibNumberForRecursive);
        }
        if(i<90){
            a = b;
            b = fibNumberForRecursive;
            fibNumberForRecursive = a+b;
            fibonacciList.add(fibNumberForRecursive);
            initializeFibonacciNumbersWithRecursion(i+1);
        }
        return fibonacciList;
    }

    protected static List<Long> initializeFibonacciNumbers(){
        for (int i = 0; i < 91; i++) {
            if(i==0){
                a = 0;b = 1;
                fibonacciList = new ArrayList<>();
                fibNumber = a+b;
                fibonacciList.add(fibNumber);

            }else{
                a = b;
                b = fibNumber;
                fibNumber = a+b;
                fibonacciList.add(fibNumber);
            }
        }
        return fibonacciList;
    }

    protected static void listFibonacciNumbers(List<Long> fibList){
        for (long finonacciNumber : fibList){
            System.out.println(finonacciNumber);
        }
    }

    private static boolean checkFibonacciNumber(List<Long> fibonacciList, long inputNumber){
        for (long finonacciNumber : fibonacciList){
            if(finonacciNumber==inputNumber){
                return true;
            }
            if(fibonacciList.get(fibonacciList.size()-1)!=finonacciNumber){
                return false;
            }
        }
        return false;
    }

    public static void getFibonacciNumbers(){
        System.out.println("Fibonacci numbers using the recursive method:");
        List<Long> ifnR = initializeFibonacciNumbersWithRecursion(0);
        listFibonacciNumbers(ifnR);
        System.out.println("Fibonacci numbers using the iterative method:");
        List<Long> ifN = initializeFibonacciNumbers();
        listFibonacciNumbers(ifN);
    }

    @Override
    public void execute() {
        List<Long> fibnumbers =  initializeFibonacciNumbers();
        a= 0; b = 1;
        System.out.print("Enter a number to check if it's a Fibonacci number: ");
        String inputValue = scanner.nextLine();
        if(intPattern.matcher(inputValue).matches()) {
            long inputNumber = Long.parseLong(inputValue);
            if (checkFibonacciNumber(fibnumbers, inputNumber)) {
                System.out.println(inputNumber + " is a Fibonacci number.");
            } else {
                System.out.println(inputNumber + " is not a Fibonacci number.");
            }
        }
    }

}
