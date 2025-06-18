import validations.PatternValidations;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

import static geometricshapes.Circle.allCoveredMethod_Circle;
import static geometricshapes.Quadrilateral.*;
import static geometricshapes.Quadrilateral.allCoveredMethod_Quadrilateral;
import static geometricshapes.Triangle.*;
import static trigonometry.TrigHelper.sin;

public class Main extends PatternValidations {
    public static void main(String[] args) {

        String selectionShape;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("""
        ----Alanı ve Çevresi Hesaplanacak Geometrik Şekiller----
        \t\t[Üçgen]  [Hesaplama için aktif]
        \t\t[Dörtgen][Hesaplama için aktif]
        \t\t[Daire]  [Hesaplama için aktif]
        \t\t[Beşgen] [--------------------]
        \t\t[Altıgen][--------------------]
        \t\t[Elips]  [--------------------]
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
                    case "Daire":
                        allCoveredMethod_Circle(false);
                        break;

                }
            }
        }while(true);


    }
}
