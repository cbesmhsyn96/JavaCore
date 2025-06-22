import calculations.Arithmetic;

import java.security.KeyStore;
import java.util.*;

import static calculations.Arithmetic.*;

public class TryingClass extends Arithmetic{
    private static void getDivisors(int sayi,List<Integer> divisors){
        System.out.println(sayi+" sayısının bölenleri");
        int i = 0;
        for (int bolen : divisors){
            System.out.print(bolen+" ");
        }
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

    public static void main(String[] args) {
        List<Integer> divisorsNumber1 = new ArrayList<>();
        List<Integer> divisorsNumber2 = new ArrayList<>();
        List<Integer> commonDivisors = new ArrayList<>();

        calculateDivisors(20,divisorsNumber1);
        calculateDivisors(30,divisorsNumber2);

        getDivisors(20,divisorsNumber1);
        getDivisors(30,divisorsNumber2);

        findCommonDivisors(divisorsNumber1,divisorsNumber2, commonDivisors);

        System.out.println("\nOrtak bölenler = "+getCommonDivisors(commonDivisors));
        System.out.println("Ortak bölenlerin en küçüğü = "+findSmallestCommonDivisor(commonDivisors));
        System.out.println("Ortak bölenlerin en büyüğü = "+findGreatestCommonDivisor(commonDivisors));

    }
}