package helper;

import variables.Defines;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CommonMethods extends Defines {
    protected static List<Integer> calcDivisorsFromInteger(int number, List<Integer> divsList){
        for (int i = 1; i < number; i++) {
            if(Math.floorMod(number,i)==0){
                divsList.add(i);
            }
        }
        return divsList;
    }
}
