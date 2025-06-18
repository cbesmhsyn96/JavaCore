import validations.PatternValidations;

import java.util.Scanner;
import java.util.regex.Pattern;

import static geometricshapes.Triangle.*;
import static geometricshapes.Triangle.right;

public class Main extends PatternValidations {
    public static void main(String[] args) {

        String selectionShape;
        Scanner scanner = new Scanner(System.in);
        boolean status;
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
                    System.out.print("İç açıların hepsi dik mi [evet/hayır]:");
                    String secimYesNo = scanner.nextLine();
                    if(yesNoPattern.matcher(secimYesNo).matches()){
                        if(secimYesNo.equals("Evet")){
                            /*
                            a b c d gir
                            eşitse kare
                            a ve b eşit ve d ve c eşit ise dikdörtgen(kombinasyonlar)
                             */
                        }else{
                            /*
                            a b c d gir
                            a ve b eşit ve d ve c eşit ise paralel kenar(kombinasyonlar)
                            değil ise yamuk
                             */
                        }
                    }else{
                        System.out.println("Hatalı giriş yaptınız...!");
                    }

            }
        }

    }
}
