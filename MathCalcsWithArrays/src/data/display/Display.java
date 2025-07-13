package data.display;

import data.initialize.Initialize;

import java.util.List;

import static types.WithRecursive.*;
import static types.WithStreamAPI.*;

public class Display extends Initialize {

    protected static void displayArray(int[] array){
        int i = 0;
        for (int number : array){
            if(i==0){
                System.out.print("Here is final(unmodifyable) array --> {"+number+",");
            }else if(i>0&&i<array.length-1){
                System.out.print(number+",");
            } else if (i==array.length-1) {
                System.out.println(number+"}");
            }
            i++;
        }
    }

    protected static void displayWithRecursiveWay(){
        System.out.println("Max number with recursive method is = "+getMaxFromArrayWithRecursive(0,numberArray));
        System.out.println("Min number with recursive method is = "+getMinFromArrayWithRecursive(0,numberArray));
        System.out.println("Average result with recursive method is = "+  avgCalc(totalCalcWithArrayNumbers(0,numberArray),numberArray.length));
    }

    protected static void displayWithStandardWay(){
        numberList = addListFromIntArray(numberArray);
        System.out.println("Min to max numbers with standard method --> "+minToMaxFromList(numberList));
        addListFromIntArray(numberArray);
        System.out.println("Max to min numbers with standard method --> "+maxToMinFromList(numberList));
        System.out.println("Min number using standard method is ="+getMinNumberFromArray(numberArray));
        System.out.println("Max number using standard method is ="+getMaxNumberFromArray(numberArray));
        System.out.println("Average with standard way = "+avgCalc(getTotalWithStandardWay(numberArray),numberArray.length));
    }

    protected static void displayWithCollectionsWay(){
        System.out.println("Min number using Collections method is = "+getMinFromArrayWithCollections(numberArray));
        System.out.println("Max number using Collections method is = "+getMaxFromArrayWithCollections(numberArray));
    }

    protected static void displayWithStreamAPIWay(){
        System.out.printf("Average with stream api way = %.2f",calcAverageFromNumberArray(numberArray));
    }

}
