package gcdlcm;

import com.sun.security.auth.LdapPrincipal;
import variables.Defines;

import javax.print.DocFlavor;
import javax.xml.stream.events.EntityReference;
import java.io.LineNumberInputStream;
import java.util.*;

public class GCDLCMCalculation extends Defines {
    private static List<Integer> calcDivisorsFromInteger(int number, List<Integer> divsList){
        for (int i = 1; i < number; i++) {
            if(Math.floorMod(number,i)==0){
                divsList.add(i);
            }
        }
        return divsList;
    }

    private static Set<Integer> commonDivisorsFromInteger(List<Integer> divsNum1, List<Integer> divsNum2){
        for (int i = 0; i < divsNum1.size(); i++) {
            for (int j = 0; j < divsNum2.size(); j++) {
                if (Objects.equals(divsNum1.get(i), divsNum2.get(j))) {
                    commonDivisors.add(divsNum1.get(i));
                }
            }
        }
        return commonDivisors;
    }

    private static List<Integer> calcMultiplesFromInteger(int number, List<Integer> multsList){
        for (int i = 1; i < number; i++) {
            multsList.add(number*i);
        }
        return multsList;
    }

    private static Set<Integer> commonMultiplesFromIntegerList(List<Integer> multsList1, List<Integer> multsList2){
        for (int i = 0; i < multsList1.size(); i++) {
            for (int j = 0; j < multsList2.size(); j++) {
                if (Objects.equals(multsList1.get(i), multsList2.get(j))) {
                    commonMultiples.add(multsList1.get(i));
                }
            }
        }
        return commonMultiples;
    }

    public static int getLVMValueWithLongWay(int a,int b){
        return Collections.min(commonMultiplesFromIntegerList(calcMultiplesFromInteger(a,multiplesListByCountFirst),calcMultiplesFromInteger(b,multiplesListByCountSecond)));
    }

    public static int getLCMValue(int a, int b){
        return a*b/getGCDValue(a,b);
    }

    public static int getGCDValue(int a, int b){
        calcDivisorsFromInteger(a,divizorsNumberFirst);
        calcDivisorsFromInteger(b,divizorsNumberSecond);
        commonDivisorsFromInteger(divizorsNumberFirst,divizorsNumberSecond);
        return Collections.max(commonDivisors);
    }


    public static void getGCMAndLCM(int a, int b){
        System.out.println("GCD of "+a+" and "+b+ " = "+getGCDValue(a,b));
        System.out.println("LCM of "+a+" and "+b+ " = "+getLCMValue(a,b));
        System.out.println("LCM with long way of "+a+" and "+b+" = "+getLVMValueWithLongWay(a,b));
    }

}
