package search;

import environment.Defines;

import java.util.List;

public class Searching extends Sorting {
    protected static void jumbSearch(List<Integer> kucuktenB, int searchedNumberValue){
        int searchedNumber = searchedNumberValue;
        int low = 0;
        int high = kucuktenB.size();
        int kok = (int)Math.sqrt(high);
        int size = kucuktenB.size();
        boolean wasFound = false;
        while (low<high){
            if(kucuktenB.get(low)==searchedNumber){
                System.out.println("The number " + searchedNumber + " was found using Jump Search.");
                break;
            }else{
                if(searchedNumber>kucuktenB.get(low)){
                    if(low+kok<size){
                        low = low + kok;
                    }
                }else if (searchedNumber<kucuktenB.get(low)){
                    for (int i = low-kok;i<low;i++){
                        if(kucuktenB.get(i)==searchedNumber){
                            System.out.println("The number " + searchedNumber + " was found using Jump Search.");
                            wasFound = true;
                            break;
                        }
                    }
                }
            }
            if(wasFound == true){
                break;
            }
        }
    }

    protected static void linearSearch(List<Integer> kucuktenB, int searchedNumberValue){
        int searchedNumber = searchedNumberValue;
        for (int i = 0; i < kucuktenB.size(); i++) {
            if(kucuktenB.get(i)==searchedNumber){
                System.out.println("The number " + searchedNumber + " was found using Linear Search.");
                break;
            }
        }
    }

    protected static void binarySearch(List<Integer> kucuktenB, int searchedNumberValue){
        List<Integer> list = kucuktenB;
        int searchedNumber = searchedNumberValue;
        int minIndex = 0;
        int maxIndex = list.size()-1;
        int medianIndex;
        boolean wasFound = false;
        do{
            medianIndex = (maxIndex+minIndex)/2;
            if(list.get(medianIndex)==searchedNumber){
                System.out.println("The number " + searchedNumber + " was found using Linear Search.");
                wasFound = true;
            }else{
                if(list.get(medianIndex)<searchedNumber){
                    //System.out.println(list.get(medianIndex)+" "+searchedNumber+" sayısından küçük.");
                    minIndex = medianIndex+1;
                }else if (list.get(medianIndex)>searchedNumber){
                    //System.out.println(list.get(medianIndex)+" "+searchedNumber+" sayısından büyük.");
                    maxIndex = medianIndex-1;
                }
            }
            if(wasFound == true){
                break;
            }
        }while (maxIndex>minIndex);
    }
}
