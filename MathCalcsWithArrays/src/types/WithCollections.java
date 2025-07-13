package types;

import data.display.Display;
import data.initialize.Initialize;
import vars.Definitions;

import java.util.Collections;

public class WithCollections extends Display {
    public static int getMinFromArrayWithCollections(int[] numberArray){
        numberList.clear();
        for(int number : numberArray){
            numberList.add(number);
        }
        return Collections.min(numberList);
    }

    public static int getMaxFromArrayWithCollections(int[] numberArray){
        numberList.clear();
        for(int number : numberArray){
            numberList.add(number);
        }
        return Collections.max(numberList);
    }
}
