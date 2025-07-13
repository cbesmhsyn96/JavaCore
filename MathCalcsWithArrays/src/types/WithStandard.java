package types;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

public class WithStandard extends WithRecursive {
    public static List<Integer> minToMaxFromList(List<Integer> numbers){
        while (!numbers.isEmpty()){
            minToMaxNumberList.add(Collections.min(numbers));
            numbers.remove(Collections.min(numbers));
        }
        return minToMaxNumberList;
    }

    public static List<Integer> maxToMinFromList(List<Integer> numbers){
        while (!numbers.isEmpty()){
            maxToMinNumberList.add(Collections.max(numbers));
            numbers.remove(Collections.max(numbers));
        }
        return maxToMinNumberList;
    }

   public static double avgCalc(int total, int count){
        return (double)total/count;
    }



   public static List<Integer> sortMinToMaxFromArray(List<Integer> numberList) {
        minToMaxNumberList.clear();
        int i;
        while (!numberList.isEmpty()) {
            i = 0;
            while (i < numberList.size()) {
                if (i == 0) {
                    min = numberList.get(i);
                } else {
                    if (numberList.get(i) < min) {
                        min = numberList.get(i);
                    }
                }
                if (i == numberList.size() - 1) {
                    System.out.println("min " + min);
                    minToMaxNumberList.add(min);
                    numberList.remove(Integer.valueOf(min));
                }
                i++;
            }
        }
        return minToMaxNumberList;
    }
   public static int getMinNumberFromArray(int[] numberArray){
        for (int i = 0; i < numberArray.length; i++) {
            if(i==0){
                min = numberArray[i];
            }else{
                if(numberArray[i]<min){
                    min = numberArray[i];
                }
            }
        }
        return min;
    }

   public static int getMaxNumberFromArray(int[] numberArray){
        for (int i = 0; i < numberArray.length; i++) {
            if(i==0){
                max = numberArray[i];
            }else{
                if(numberArray[i]>max){
                    max = numberArray[i];
                }
            }
        }
        return max;
    }

    public static int getTotalWithStandardWay(int[] numberArray){
        for (int i = 0; i < numberArray.length ; i++) {
            if(i==0){
                total = numberArray[i];
            }else{
                total = total+numberArray[i];
            }
        }
        return total;
    }
}
