package calculations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static calculations.Arithmetic.mod;

public class NumberTheoryAndAdvancedMath {
    private static int sayi;
    private static int sayi2;
    private static List<Integer> divisorsNumber1 = new ArrayList<>();
    private static List<Integer> divisorsNumber2 = new ArrayList<>();
    private static List<Integer> commonDivisors = new ArrayList<>();

    public static List<Integer> getDivisorsNumber1() {
        return divisorsNumber1;
    }

    public static void setDivisorsNumber1(List<Integer> divisorsNumber1) {
        NumberTheoryAndAdvancedMath.divisorsNumber1 = divisorsNumber1;
    }

    public static List<Integer> getDivisorsNumber2() {
        return divisorsNumber2;
    }

    public static void setDivisorsNumber2(List<Integer> divisorsNumber2) {
        NumberTheoryAndAdvancedMath.divisorsNumber2 = divisorsNumber2;
    }

    public static List<Integer> getCommonDivisors() {
        return commonDivisors;
    }

    public static void setCommonDivisors(List<Integer> commonDivisors) {
        NumberTheoryAndAdvancedMath.commonDivisors = commonDivisors;
    }

    public static int getSayi2() {
        return sayi2;
    }

    public static void setSayi2(int sayi2) {
        NumberTheoryAndAdvancedMath.sayi2 = sayi2;
    }

    private static int getSayi1() {
        return sayi;
    }

    private static void setSayi1(int sayi) {
        NumberTheoryAndAdvancedMath.sayi = sayi;
    }

    private static int factorialCalc(int sayi){
        int product = 1;
        setSayi1(sayi);
        for (int i = 1; i <= getSayi1(); i++) {
            product = product * i;
        }
        return product;
    }

    private static void primeNumberCheck(int maxNumberAddOne){
        int a;
        int sayi;
        for (sayi = 2; sayi < maxNumberAddOne; sayi++) {
            a = 0;
            if (sayi==2){
                System.out.println(sayi+ " asal sayıdır.");
            }else{
                for (int i=2;i<=sayi;i++){
                    if(Arithmetic.mod(sayi,i)!=0){
                        a++;
                    }
                    if(a==(sayi-2)){
                        System.out.println(sayi+" asal sayıdır.");
                        break;
                    }
                }
                if(a!=(sayi-2)){
                    System.out.println(sayi+" asal sayı değildir.");
                }
            }
        }
    }

    private static void checkIfEven(int sayi) {
        if (mod(sayi, 2) == 0) {
            System.out.println("Sayı çift");
        } else {
            System.out.println("Sayı tek");
        }
    }

    private static void getDivisors(int sayi, List<Integer> divisors){
        System.out.println(sayi+" sayısının bölenleri");
        int i = 0;
        for (int bolen : divisors){
            System.out.print(bolen+" ");
        }
        System.out.println();
    }

    private static void calculateDivisors(int sayi,List<Integer> divisors){
        System.out.println(sayi+" sayısının tam bolenleri hesaplanıyor...");
        for(int i = 2; i < sayi; i++){
            if(mod(sayi,i) == 0){
                divisors.add(i);
            }
        }
    }

    private static void findCommonDivisors(List<Integer> divisors1, List<Integer> divisors2, List<Integer> commonDivisors){
        for (int simdikiBolenSayi1 : divisors1){
            for (int simdikiBolenSayi2 : divisors2){
                if(simdikiBolenSayi1 == simdikiBolenSayi2){
                    commonDivisors.add(simdikiBolenSayi1);
                }
            }
        }
    }

    private static int findGreatestCommonDivisor(List<Integer> commonDivisors){
        int temp = 0;
        for(int sayi : commonDivisors){
            if(sayi == commonDivisors.get(0)){
                temp = sayi;
            }else{
                if(sayi>temp){
                    temp = 0;
                    temp = sayi;
                }
            }
        }
        return temp;
    }

    private static int findSmallestCommonDivisor(List<Integer> commonDivisors){
        int temp = 0;
        for(int sayi : commonDivisors){
            if(sayi == commonDivisors.get(0)){
                temp = sayi;
            }else{
                if(sayi<temp){
                    temp = sayi;
                }
            }
        }
        return temp;
    }

    private static List<Integer> getCommonDivisors(List<Integer> commonDivisors){
        return commonDivisors;
    }

    private static double averageCalc(List<Integer> numbers){
        int total = 0;
        for (int currentNumber : numbers){
            total = total + currentNumber;
        }
        return (double)total/numbers.size();
    }

    private static String findMinMax(List<Integer> numbers){
        return "Min is "+findSmallestCommonDivisor(numbers)+", Max is "+findGreatestCommonDivisor(numbers);
    }

    public static void numberTheoryAndAdvancedMathCalcs(){

        System.out.print("Sayi girin :");
        String sayi1 = new Scanner(System.in).nextLine();
        System.out.print("Sayi girin :");
        String sayi2 = new Scanner(System.in).nextLine();

        if(Pattern.compile("\\d+").matcher(sayi1).matches()&&
           Pattern.compile("\\d+").matcher(sayi2).matches()){
            int sayi1Int = Integer.parseInt(sayi1);
            int sayi2Int = Integer.parseInt(sayi2);
            setSayi1(sayi1Int);
            setSayi2(sayi2Int);
            setDivisorsNumber1(divisorsNumber1);
            setDivisorsNumber2(divisorsNumber2);

            calculateDivisors(getSayi1(),getDivisorsNumber1());
            calculateDivisors(getSayi2(),getDivisorsNumber2());
            getDivisors(getSayi1(),getDivisorsNumber1());
            getDivisors(getSayi2(),getDivisorsNumber2());
            setCommonDivisors(commonDivisors);
            findCommonDivisors(getDivisorsNumber1(),getDivisorsNumber2(), getCommonDivisors());

            System.out.println("\nOrtak bölenler = "+getCommonDivisors(getCommonDivisors()));
            System.out.println("Ortak bölenlerin en küçüğü(LCM) = "+findSmallestCommonDivisor(getCommonDivisors()));
            System.out.println("Ortak bölenlerin en büyüğü(GCD) = "+findGreatestCommonDivisor(getCommonDivisors()));
        }


    }

}