package perfectnumber;

import helper.CommonMethods;

import java.util.regex.Pattern;


public class PerfectNumberCheck extends CommonMethods {
    private static String isPerfectNumber(int number){
        divizorsNumberFirst.clear();
        int sum = calcDivisorsFromInteger(number,divizorsNumberFirst).stream().mapToInt(Integer::intValue).sum();
        if(number==sum){
            return "Perfect Number";
        }else{
            return "Not Perfect Number";
        }
    }


    public static void getPerfectNumberStatus(){
        System.out.print("Please input a number :");
        String inputValue = scanner.nextLine();

        if(Pattern.compile("\\d+").matcher(inputValue).matches()){
            int inputNumber = Integer.parseInt(inputValue);
            System.out.println(inputNumber+ " Is "+ isPerfectNumber(inputNumber));
            divizorsNumberFirst.clear();
        }
    }
}