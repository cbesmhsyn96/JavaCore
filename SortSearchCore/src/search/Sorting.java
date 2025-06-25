package search;

import environment.Defines;

import java.util.ArrayList;
import java.util.List;

public class Sorting extends Defines {
    protected static List<Integer> selectionSortFromMinToMax(List<Integer> getIntegerList, List<Integer>ascendingList){
        int min = 0;
        int size = getIntegerList.size();
        do{
            for (int i = 0;i<size; i++){
                if (i==0) {
                    min = getIntegerList.get(i);
                }else{
                    if (i < getIntegerList.size()) {
                        if(getIntegerList.get(i)<min){
                            min = getIntegerList.get(i);
                        }
                    }
                }
            }
            ascendingList.add(min);
            getIntegerList.remove(Integer.valueOf(min));
        }while (!getIntegerList.isEmpty());
        return ascendingList;
    }

    protected static List<Integer> selectionSortFromMaxToMin(List<Integer> getIntegerList, List<Integer>descendingList){
        int max = 0;
        int size = getIntegerList.size();
        do{
            for (int i = 0;i<size; i++){
                if (i==0) {
                    max = getIntegerList.get(i);
                }else{
                    if (i < getIntegerList.size()) {
                        if(getIntegerList.get(i)>max){
                            max = getIntegerList.get(i);
                        }
                    }
                }
            }
            descendingList.add(max);
            getIntegerList.remove(Integer.valueOf(max));
        }while (!getIntegerList.isEmpty());
        return descendingList;
    }
}