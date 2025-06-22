package calculations;

import static calculations.Arithmetic.mod;

public class NumberTheoryAndAdvancedMath {
    /*en küçük ortak kat (LCM)
    Sayıların ortalaması, maksimumu, minimumu*/
    private static int sayi;

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



}