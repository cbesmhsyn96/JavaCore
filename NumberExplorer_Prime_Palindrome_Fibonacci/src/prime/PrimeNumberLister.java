package prime;

import commonmusts.Common;
import definitions.Defines;

public class PrimeNumberLister extends Defines implements Common{
    private static boolean isPrimeNumber(int number){
        for (int i = 2; i< number; i++){
            if(Math.floorMod(number,i)==0){
                return false;
            }else{
                if(i == number-1){
                    if(Math.floorMod(number,i)!=0){
                        return true;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isPrimeNumberWithRecursion(int i, int number){
        if(i<number){
            if(Math.floorMod(number,i)==0){
                return false;
            }else {
                if(i==number-1){
                    if(Math.floorMod(number,i)!=0){
                        return true;
                    }
                }else{
                    return isPrimeNumberWithRecursion(i+1,number);
                }
            }
        }
        return false;
    }

    private static void listPrimeNumbersUpTo(int upperBound){
        for (int i = 2; i < upperBound; i++) {
            if(isPrimeNumber(i)){
                System.out.println(i + " is prime");
            }
        }
    }

    private static void listPrimeNumbersUpToWithRecursion(int upperBound){
        for (int i = 2; i < upperBound; i++) {
            if(i==2){
                System.out.println(i + " is prime");
            }
            if(isPrimeNumberWithRecursion(2,i)){
                System.out.println(i + " is prime");
            }
        }
    }
    @Override
    public void execute() {
        System.out.print("Enter the upper limit to list prime numbers :");
        String upperBoundValue = scanner.nextLine();
        if(intPattern.matcher(upperBoundValue).matches()){
            int upperBound = Integer.parseInt(upperBoundValue);
            System.out.println("Without recursion");
            listPrimeNumbersUpTo(upperBound);
            System.out.println("With recursion");
            listPrimeNumbersUpToWithRecursion(upperBound);
        }
    }
}
