package types;

public class WithRecursive extends WithCollections {
    public static int getMaxFromArrayWithRecursive(int i, int[] numberArray){
        if(i==0){
            max = numberArray[i];
        }
        if(i<numberArray.length){
            if(numberArray[i]>max){
                max = numberArray[i];
            }
            return max = getMaxFromArrayWithRecursive(i+1,numberArray);
        }
        return max;
    }

    public static int getMinFromArrayWithRecursive(int i, int[] numberArray){
        if(i==0){
            min = numberArray[i];
        }
        if(i<numberArray.length){
            if(numberArray[i]<min){
                min = numberArray[i];
            }
            return min = getMinFromArrayWithRecursive(i+1,numberArray);
        }
        return min;
    }

    public static int totalCalcWithArrayNumbers(int i, int[] numberArray){
        if(i<numberArray.length){
            return total + numberArray[i] + totalCalcWithArrayNumbers(i+1, numberArray);
        }
        return total;
    }


}
