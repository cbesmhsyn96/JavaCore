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

    protected static void findDivisorsANumberWithRecursion(int number, int i, int obeb, List<Integer> divizorsNumberFirst){
        if(i==1){
            obeb = 1;
        }
        if(i<=number){
            if(Math.floorMod(number,i)==0){
                obeb = i;
                divizorsNumberFirst.add(obeb);
            }
            findDivisorsANumberWithRecursion(number,i+1,obeb,divizorsNumberFirst);
        }
    }

    protected static int sumDivisors(int i, List<Integer> divizors){
        if(i == 0){
            total = divizors.get(i);
        }
        if(i<divizors.size()){
            return  total = divizors.get(i) + sumDivisors(i+1,divizors);
        }
        return 0;
    }
}
