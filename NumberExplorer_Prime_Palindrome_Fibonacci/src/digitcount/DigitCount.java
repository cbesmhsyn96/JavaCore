package digitcount;

import commonmusts.Common;
import definitions.Defines;

public class DigitCount extends Defines implements Common {
    private static int getDigitCountWithRecursion(int i, String stringValue){
        if(i==0){
            countDigits = 1;
        }
        if(i<stringValue.length()){
            return countDigits+getDigitCountWithRecursion(i+1,stringValue);
        }
        return 0;
    }

    private static int getDigitCount(String stringValue){
        return stringValue.length();
    }

    @Override
    public void execute() {
        System.out.print("Please enter a number :");
        String inputInt = scanner.nextLine();
        if(intPattern.matcher(inputInt).matches()){
            System.out.println("Number contains " + getDigitCountWithRecursion(0, inputInt) + " digits (calculated with recursion).");
            System.out.println("Number contains " + getDigitCount(inputInt) + " digits (calculated without recursion).");

        }else{
            System.out.println("The value you entered does not match the required pattern.");
        }
    }
}
