import validations.PatternValidations;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import static geometricshapes.Quadrilateral.*;
import static geometricshapes.Triangle.*;

public class Main extends PatternValidations {
    public static void main(String[] args) {

        String selectionShape;
        Scanner scanner = new Scanner(System.in);
        boolean status;
        double sinValue = 0;
        double height;
        int trapezoidBase1;
        int trapezoidBase2;
        System.out.print("""
        ----Alanı ve Çevresi Hesaplanacak Geometrik Şekiller----
        \t[Üçgen]
        \t[Dörtgen]
        \t[Daire]
        \t[Beşgen]
        \t[Altıgen]
        \t[Elips]
        Hesaplanacak şekil :""");
        selectionShape=scanner.nextLine();
        if(shapesPattern.matcher(selectionShape).matches()){
            switch (selectionShape){
                case "Üçgen":
                    allCoveredMothod_triangle(false);
                break;
                case "Dörtgen":
                    System.out.print("İç açıların hepsi dik mi [Evet/Hayır]:");
                    String secimYesNo = scanner.nextLine();
                    if(yesNoPattern.matcher(secimYesNo).matches()){
                        if(secimYesNo.equals("Evet")){
                            System.out.print("İlk kenarı girin :");
                            String a = scanner.nextLine();
                            System.out.print("İkinci kenarı girin :");
                            String b = scanner.nextLine();
                            System.out.print("Ücüncü kenarı girin :");
                            String c = scanner.nextLine();
                            System.out.print("Dördüncü kenarı girin :");
                            String d = scanner.nextLine();
                            if(intPattern.matcher(a).matches()&&
                               intPattern.matcher(b).matches()&&
                               intPattern.matcher(c).matches()&&
                               intPattern.matcher(d).matches()){
                                int aInt = Integer.parseInt(a);
                                int bInt = Integer.parseInt(b);
                                int cInt = Integer.parseInt(c);
                                int dInt = Integer.parseInt(d);
                                if(aInt>0&&bInt>0&&cInt>0&&dInt>0){
                                    int[] sides = {aInt, bInt, cInt, dInt};
                                    Arrays.sort(sides);
                                    boolean isQuadrilateral = (sides[0] == sides[1]) && (sides[2] == sides[3]);
                                    if((aInt == bInt) && (aInt == cInt) && (aInt == dInt)){
                                        System.out.println("Kare için hesaplama başlatılıyor...");
                                        square(aInt);
                                    }else if(isQuadrilateral){
                                        System.out.println("Dikdörtgen için hesaplama başlatılıyor...");
                                        rectangle(sides[0],sides[2]);
                                    }
                                }else{
                                    System.out.println("Negatif değerler girdiniz...!");
                                }
                            }
                        }else{
                            /*
                            a b c d gir
                            a ve b eşit ve d ve c eşit ise paralel kenar(kombinasyonlar)
                            değil ise yamuk
                             */
                            System.out.print("İlk kenarı girin :");
                            String a = scanner.nextLine();
                            System.out.print("İkinci kenarı girin :");
                            String b = scanner.nextLine();
                            System.out.print("Ücüncü kenarı girin :");
                            String c = scanner.nextLine();
                            System.out.print("Dördüncü kenarı girin :");
                            String d = scanner.nextLine();
                            if(intPattern.matcher(a).matches()&&
                               intPattern.matcher(b).matches()&&
                               intPattern.matcher(c).matches()&&
                               intPattern.matcher(d).matches()){
                                int aInt = Integer.parseInt(a);
                                int bInt = Integer.parseInt(b);
                                int cInt = Integer.parseInt(c);
                                int dInt = Integer.parseInt(d);
                                if(aInt>0&&bInt>0&&cInt>0&&dInt>0){
                                    int[] sides = {aInt, bInt, cInt, dInt};
                                    Arrays.sort(sides);
                                    boolean isParallelogram = (sides[0] == sides[1]) && (sides[2] == sides[3]);
                                    boolean isTrabezoid = (sides[0] == sides[1] && sides[0] != sides[2] && sides[0] != sides[3])||
                                            (sides[1] == sides[2] && sides[1] != sides[0] && sides[1] != sides[3])||
                                            (sides[2] == sides[3] && sides[2] != sides[0] && sides[2] != sides[1])||
                                            (sides[3] == sides[0] && sides[3] != sides[1] && sides[3] != sides[2]);

                                    if(isParallelogram){
                                        System.out.println("Paralelkenar için hesaplama başlatılıyor...");
                                        parallelogram(sides);
                                    }else if(isTrabezoid){
                                        System.out.println("Yamuk için hesaplama başlatılıyor...");
                                        if(sides[0] == sides[1]){
                                            trapezoidBase1 = sides[0];
                                            trapezoidBase2 = sides[1];
                                        } else if (sides[1] == sides[2]) {
                                            trapezoidBase1 = sides[1];
                                            trapezoidBase2 = sides[2];
                                        } else if (sides[2] == sides[3]) {
                                            trapezoidBase1 = sides[2];
                                            trapezoidBase2 = sides[3];
                                        } else if (sides[3] == sides[0]) {
                                            trapezoidBase1 = sides[3];
                                            trapezoidBase2 = sides[0];
                                        }

                                    }
                                }else{
                                    System.out.println("Negatif değerler girdiniz...!");
                                }
                            }
                        }
                    }else{
                        System.out.println("Hatalı giriş yaptınız...!");
                    }
                    System.out.print("Dörtgen hesaplmasına devam edilsin mi[Evet/Hayır] :");
                    String textYesNo = scanner.nextLine();
                    if(yesNoPattern.matcher(textYesNo).matches()){
                        if(textYesNo.equals("Evet")){
                            status = true;
                        }else{
                            System.out.println("\n\n-------------------------------------------------------");
                            System.out.println("Dörtgen için alan ve çevre hesaplaması sonlandırılıyor...");
                            System.out.println("-------------------------------------------------------");
                            status = false;
                        }
                    }
                break;

            }
        }

    }
}
