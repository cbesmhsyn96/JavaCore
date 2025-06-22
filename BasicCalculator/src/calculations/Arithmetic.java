package calculations;

import java.security.PublicKey;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Arithmetic {
    private static double number1;
    private static double number2;

    private static double getNumber1() {
        return number1;
    }

    private static void setNumber1(double number1) {
        Arithmetic.number1 = number1;
    }

    private static double getNumber2() {
        return number2;
    }

    private static void setNumber2(double number2) {
        Arithmetic.number2 = number2;
    }

    private static double add(double number1, double number2) {
        setNumber1(number1);
        setNumber2(number2);
        return getNumber1() + getNumber2();
    }

    private static double subtract(double number1, double number2) {
        setNumber1(number1);
        setNumber2(number2);
        return getNumber1() - getNumber2();
    }

    private static double multiply(double number1, double number2) {
        setNumber1(number1);
        setNumber2(number2);
        return getNumber1() * getNumber2();
    }

    private static double divide(double number1, double number2) {
        setNumber1(number1);
        setNumber2(number2);
        return getNumber1() / getNumber2();
    }

    private static int mod(int a, int b) {
        int c = a/b;
        int modValue = a - b * c;
        return modValue;
    }

    private static int abs(int a){
        return Math.abs(a);
    }

    public static void arithmeticCalcs(){
        System.out.println("Aritmetik Hesaplamalar");
        System.out.print("İlk sayıyı gir :");
        String sayi1 = new Scanner(System.in).nextLine();
        System.out.print("İlk sayıyı gir :");
        String sayi2 = new Scanner(System.in).nextLine();
        System.out.print("Mutlak değeri alınacak sayıyı gir(negatif) :");
        String sayi3 = new Scanner(System.in).nextLine();
        if(Pattern.compile("\\d+").matcher(sayi1).matches()&&
                Pattern.compile("\\d+").matcher(sayi2).matches()&&
                Pattern.compile("-\\d+").matcher(sayi3).matches()){
            int sayi1Int = Integer.parseInt(sayi1);
            int sayi2Int = Integer.parseInt(sayi2);
            int sayi3Int = Integer.parseInt(sayi3);
            System.out.printf("%10s %10s %10s %10s %10s %15s%n","Toplam","Fark","Çarpım","Bölüm","Mod","Mutlak Değer");
            System.out.printf("%10.2f %10.2f %10.2f %10.2f %9d %10d%n",
                    add(sayi1Int,sayi2Int),
                    subtract(sayi1Int,sayi2Int),
                    multiply(sayi1Int,sayi2Int),
                    divide(sayi1Int,sayi2Int),
                    mod(sayi1Int,sayi2Int),
                    abs(sayi3Int));
        }
    }
}
