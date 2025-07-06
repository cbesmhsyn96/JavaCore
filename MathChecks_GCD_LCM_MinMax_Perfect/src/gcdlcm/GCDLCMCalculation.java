package gcdlcm;

import helper.CommonMethods;

import java.util.*;

public class GCDLCMCalculation extends CommonMethods {

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

    public static int getLCMValueWithLongWay(int a,int b){
        return Collections.min(commonMultiplesFromIntegerList(calcMultiplesFromInteger(a,multiplesListByCountFirst),calcMultiplesFromInteger(b,multiplesListByCountSecond)));
    }

    public static int getLCMValue(int a, int b){
        return a*b/getGCDValue(a,b);
    }

    public static int getGCDValue(int a, int b){
        findDivisorsANumberWithRecursion(a,1,0,divizorsNumberFirst);
        findDivisorsANumberWithRecursion(b,1,0,divizorsNumberSecond);
        commonDivisorsFromInteger(divizorsNumberFirst,divizorsNumberSecond);
        return Collections.max(commonDivisors);
    }


    public static void getGCMAndLCM(int a, int b){
        System.out.println("---------------------------------------");
        System.out.println("GCD of "+a+" and "+b+ " = "+getGCDValue(a,b));
        System.out.println("LCM of "+a+" and "+b+ " = "+getLCMValue(a,b));
        System.out.println("LCM with long way of "+a+" and "+b+" = "+getLCMValueWithLongWay(a,b));
    }

}
