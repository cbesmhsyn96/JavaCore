package data.initialize;

import vars.Definitions;

import java.util.List;

public class Initialize extends Definitions {
    protected static int[] createRandomArray(int randLength){
        int [] numbers = new int[randLength];
        for (int i = 0; i < randLength; i++) {
            int randNumber = random.nextInt(5,10);
            numberList.add(numbers[i] = randNumber);
        }
        return numbers;
    }

    protected static List<Integer> addListFromIntArray(int[] numbersArray){
        for (int number : numbersArray){
            numberList.add(number);
        }
        return numberList;
    }
}
