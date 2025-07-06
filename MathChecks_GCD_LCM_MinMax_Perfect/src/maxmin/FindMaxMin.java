package maxmin;

import java.util.Collections;
import java.util.List;

public class FindMaxMin {
    private static int findMaxNumberFromListWithLongWay(List<Integer>numbers){
        int max = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if(i==0){
                max = numbers.get(i);
            }else{
                if(numbers.get(i)>max){
                    max = numbers.get(i);
                }
            }
        }
        return max;
    }

    private static int findMinNumberFromListWithLongWay(List<Integer>numbers){
        int min = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if(i==0){
                min = numbers.get(i);
            }else{
                if(numbers.get(i)<min){
                    min = numbers.get(i);
                }
            }
        }
        return min;
    }

    private static int findMaxNumberFromList(List<Integer>numbers){
        return Collections.max(numbers);
    }

    private static int findMinNumberFromList(List<Integer>numbers){
        return Collections.min(numbers);
    }


    public static void findMinAndMaxNumberFromList(List<Integer>numbers){
        System.out.println("---------------------------------------");
        System.out.println("Max number with long way = "+findMaxNumberFromListWithLongWay(numbers));
        System.out.println("Max number with short way = "+findMaxNumberFromList(numbers));
        System.out.println("Min number with long way = "+findMinNumberFromListWithLongWay(numbers));
        System.out.println("Min number with short way = "+findMinNumberFromList(numbers));
    }

}