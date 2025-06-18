import validations.PatternValidations;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

import static geometricshapes.Quadrilateral.*;
import static geometricshapes.Triangle.*;
import static trigonometry.TrigHelper.sin;

public class Main extends PatternValidations {
    public static void main(String[] args) {

        String selectionShape;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("""
        ----Alanı ve Çevresi Hesaplanacak Geometrik Şekiller----
        \t[Üçgen]  [Hesaplama için aktif]
        \t[Dörtgen][Hesaplama için aktif]
        \t[Daire]  [--------------------]
        \t[Beşgen] [--------------------]
        \t[Altıgen][--------------------]
        \t[Elips]  [--------------------]
        Hesaplanacak şekil :""");
            selectionShape=scanner.nextLine();
            if(shapesPattern.matcher(selectionShape).matches()){
                switch (selectionShape){
                    case "Üçgen":
                        allCoveredMothod_Triangle(false);
                        break;
                    case "Dörtgen":
                        allCoveredMethod_Quadrilateral(false);
                        break;

                }
            }
        }while(true);


    }
}
