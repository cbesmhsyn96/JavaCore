import org.w3c.dom.ls.LSException;

import java.util.*;

public class Main {
    private static Random random = new Random();
    private static List<Integer> numberList = new ArrayList<>();
    private static int min = 0;
    private static int max = 0;
    private static List<Integer> minToMaxNumberList = new ArrayList<>();
    private static List<Integer> maxToMinNumberList = new ArrayList<>();


    private static int[] createRandomArray(int randLength){
        randLength = random.nextInt(3,11);
        int [] numbers = new int[randLength];
        for (int i = 0; i < randLength; i++) {
            int randNumber = random.nextInt(5,10);
                numberList.add(numbers[i] = randNumber);
        }
        return numbers;
    }

    private static List<Integer> addListFromIntArray(int[] numbersArray){
        for (int number : numbersArray){
            numberList.add(number);
        }
        return numberList;
    }

    private static void displayArray(int[] array){
        int i = 0;
        for (int number : array){
            if(i==0){
                System.out.print("{"+number+",");
            }else if(i>0&&i<array.length-1){
                System.out.print(number+",");
            } else if (i==array.length-1) {
                System.out.println(number+"}");
            }
            i++;
        }
    }

    private static int getMinFromArrayWithCollections(int[] numberArray){
        numberList.clear();
        for(int number : numberArray){
            numberList.add(number);
        }
        return Collections.min(numberList);
    }

    private static int getMaxFromArrayWithCollections(int[] numberArray){
        numberList.clear();
        for(int number : numberArray){
            numberList.add(number);
        }
        return Collections.max(numberList);
    }

    private static int getMaxFromArrayWithRecursive(int i, int[] numberArray){
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

    private static int getMinFromArrayWithRecursive(int i, int[] numberArray){
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

    private static int getMinNumberFromArray(int[] numberArray){
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



    private static int getMaxNumberFromArray(int[] numberArray){
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

    private static List<Integer> minToMaxFromList(List<Integer> numbers){
        while (!numbers.isEmpty()){
            minToMaxNumberList.add(Collections.min(numbers));
            numbers.remove(Collections.min(numbers));
        }
        return minToMaxNumberList;
    }

    private static List<Integer> maxToMinFromList(List<Integer> numbers){
        while (!numbers.isEmpty()){
            maxToMinNumberList.add(Collections.max(numbers));
            numbers.remove(Collections.max(numbers));
        }
        return maxToMinNumberList;
    }





    public static void main(String[] args) {

        /*
        array ortalama hesaplayan metot(önce listeleyecek, bir listeleme metodu,
        standart rekürsif ve collections kullanarak)
        Array' de elemanları sıralama(standard yolla rekürsif ile)
         */

        int [] currentArray = createRandomArray(5);
        displayArray(currentArray);
        System.out.println("Max number with recursive method is = "+getMaxFromArrayWithRecursive(0,currentArray));
        System.out.println("Min number with recursive method is = "+getMinFromArrayWithRecursive(0,currentArray));
        System.out.println("Min number using Collections method is = "+getMinFromArrayWithCollections(currentArray));
        System.out.println("Max number using Collections method is = "+getMaxFromArrayWithCollections(currentArray));
        System.out.println("Min number using standard method is ="+getMinNumberFromArray(currentArray));
        System.out.println("Max number using standard method is ="+getMaxNumberFromArray(currentArray));

        System.out.println(minToMaxFromList(numberList));
        addListFromIntArray(currentArray);
        System.out.println(maxToMinFromList(numberList));

        int [] nArray = new int[5];
        nArray[0]=4;
        nArray[1]=2;
        nArray[2]=1;
        nArray[3]=5;
        nArray[4]=3;
        List<Integer> integerList = new ArrayList<>();
        for (int sayi : nArray){
            integerList.add(sayi);
        }

    }
}