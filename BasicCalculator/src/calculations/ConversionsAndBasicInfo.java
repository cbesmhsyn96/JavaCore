package calculations;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ConversionsAndBasicInfo {
    /*
    System.out.println(toBinaryString(10)); // Çıktı: 1010
    System.out.println(toHexString(255)); // Çıktı: ff
    System.out.println(toOctalString(64)); // Çıktı: 100
    System.out.println(parseIntBinaryToDec("1010")); // Çıktı: 10
    System.out.println(parseIntHexToDec("ff")); // Çıktı: 255
    System.out.println(parseIntOctalToDec("100")); // Çıktı: 64
    System.out.println(getSignumNumber(-123.45)); // Çıktı: -1.0
    System.out.println(getSignumNumber(0));       // Çıktı: 0.0
    System.out.println(getSignumNumber(42));      // Çıktı: 1.0
     */
    private static double floor(double sayi) {
        return Math.floor(sayi);
    }

    private static long round(double sayi) {
        return Math.round(sayi);
    }

    private static double ceil(double sayi) {
        return Math.ceil(sayi);
    }

    private static String toBinaryString(int sayi) {
        return Integer.toBinaryString(sayi);
    }

    private static String toHexString(int sayi) {
        return Integer.toHexString(sayi);
    }

    private static String toOctalString(int sayi) {
        return Integer.toOctalString(sayi);
    }

    private static int parseIntBinaryToDec(String sayiTxt) {
        return Integer.parseInt(sayiTxt, 2);
    }

    private static long parseLongHexToDec(String sayiTxt) {
        return Long.parseLong(sayiTxt, 16);
    }

    private static int parseIntOctalToDec(String sayiTxt) {
        return Integer.parseInt(sayiTxt, 8);
    }

    private static double getSignumNumber(double sayi) {
        return Math.signum(sayi);
    }

    public static void conversionsAndBasicInfoCalcs() {
        System.out.println("Dönüşümler ve bilgi alma");
        System.out.print("İlk sayıyı gir(int) :");
        String sayi1 = new Scanner(System.in).nextLine();
        System.out.print("İkinci sayıyı gir(double) :");
        String sayi2 = new Scanner(System.in).nextLine();
        System.out.print("Üçüncü sayıyı gir(String binary sayı şeklinde) :");
        String sayi3 = new Scanner(System.in).nextLine();
        System.out.print("Dördüncü sayıyı gir(String hexadecimal sayı şeklinde) :");
        String sayi4 = new Scanner(System.in).nextLine();
        if(Pattern.compile("\\d+").matcher(sayi1).matches()&&
           Pattern.compile("-?\\d+\\.\\d+").matcher(sayi2).matches()&&
           Pattern.compile("[01]+").matcher(sayi3).matches()&&
           Pattern.compile("[0-9a-fA-F]+").matcher(sayi4).matches()){
            /*System.out.println("floor("+sayi2+") = " + floor(Double.parseDouble(sayi2)));
            System.out.println("round("+sayi2+") = " + round(Double.parseDouble(sayi2)));
            System.out.println("ceil("+sayi2+") = " + ceil(Double.parseDouble(sayi2)));
            System.out.println("toBinaryString(\""+sayi1+"\") = " + toBinaryString(Integer.parseInt(sayi1)));
            System.out.println("toHexString("+255+") = " + toHexString(255));
            System.out.println("toOctalString("+64+") = " + toOctalString(64));
            System.out.println("parseIntBinaryToDec(\""+sayi3+"\") = " + parseIntBinaryToDec(sayi3));
            System.out.println("parseIntHexToDec(\""+sayi4+"\") = " + parseIntHexToDec(sayi4));
            System.out.println("parseIntOctalToDec(\""+sayi3+"\") = " + parseIntOctalToDec(sayi3));
            System.out.println("getSignumNumber(\""+sayi2+"\") = " + getSignumNumber(Double.parseDouble(sayi2)));*/
        System.out.printf("%15s %15s %10s %15s %15s %15s %15s %15s %15s %15s%n",
                "floor", "round", "ceil", "toBinaryString", "toHexString",
                "toOctalString", "parseIntBinaryToDec", "parseIntHexToDec",
                "parseIntOctalToDec", "getSignumNumber");
        System.out.printf("%15.2f %15d %10.2f %9s %16s %15s %15d %21d %15d %15.2f%n",
                floor(Double.parseDouble(sayi2)), round(Double.parseDouble(sayi2)),
                ceil(Double.parseDouble(sayi2)), toBinaryString(Integer.parseInt(sayi1)),
                toHexString(255), toOctalString(64), parseIntBinaryToDec(sayi3),
                parseLongHexToDec(sayi4), parseIntOctalToDec(sayi3), getSignumNumber(Double.parseDouble(sayi2)));
        }
    }
}