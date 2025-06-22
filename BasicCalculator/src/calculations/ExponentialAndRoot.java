package calculations;

import fields.Fields;

import java.util.Scanner;

public class ExponentialAndRoot extends Fields {

    public static double getSayi1() {
        return sayi1;
    }

    public static void setSayi1(int sayi1) {
        ExponentialAndRoot.sayi1 = sayi1;
    }

    public static double getSayi2() {
        return sayi2;
    }

    public static void setSayi2(int sayi2) {
        ExponentialAndRoot.sayi2 = sayi2;
    }

    private static double power(int sayi1, int sayi2){
        setSayi1(sayi1);
        setSayi2(sayi2);
        return Math.pow(getSayi1(),getSayi2());
    }

    private static double sqrt(int sayi1){
        setSayi2(sayi1);
        return Math.sqrt(sayi1);
    }

    private static double nThRoot(int sayi1,int n){
        setSayi1(sayi1);
        setSayi2(n);
        return (Math.pow(getSayi1(),1.0/getSayi2()));
    }

    private static double exp(int sayi1){
        setSayi1(sayi1);
        return Math.exp(getSayi1());
    }

    private static double log(int sayi1){
        setSayi1(sayi1);
        return Math.log(getSayi1());
    }

    private static double log10(int sayi1){
        setSayi1(sayi1);
        return Math.log10(getSayi1());
    }

    public static void exponentialAndRootCalcs(){
        System.out.println("Üst ve Kök Hesaplamaları");
        System.out.print("İlk sayıyı gir :");
        String sayi1Str = new Scanner(System.in).nextLine();
        System.out.print("İkinci sayıyı gir :");
        String sayi2Str = new Scanner(System.in).nextLine();
        if(patternInt.matcher(sayi1Str).matches()&&
                patternInt.matcher(sayi2Str).matches()){
            int sayi1Int = Integer.parseInt(sayi1Str);
            int sayi2Int = Integer.parseInt(sayi2Str);
            System.out.printf("%15s %15s %15s %15s %9s %17s%n","ÜsAl","KökAl","N.DerecedenKök","Exponansiyel","Log","Log10");
            System.out.printf("%15.2f %15.2f %10.2f %15.2f %15.2f %15.2f%n",
                    power(sayi1Int,sayi2Int),
                    sqrt(sayi1Int),
                    nThRoot(sayi1Int,sayi2Int),
                    exp(sayi1Int),
                    log(sayi1Int),
                    log10(sayi1Int));
        }
    }

}