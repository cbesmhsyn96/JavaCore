import validations.PatternValidations;
import java.util.Scanner;
import static geometricshapes.Circle.allCoveredMethodCircle;
import static geometricshapes.Pentagon.*;
import static geometricshapes.Quadrilateral.allCoveredMethodQuadrilateral;
import static geometricshapes.Triangle.*;

public class Main extends PatternValidations {
    public static void main(String[] args) {
        /*
        Beşgen ve altıgen için hesaplama düzgün çokgen formatı üzerinden olacaktır.
        Elips büyük ve küçük eksenleri x ve y eksenine paralel olduğu varsayılarak hesaplanacaktır.
         */
        String selectionShape;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("""
        ----Alanı ve Çevresi Hesaplanacak Geometrik Şekiller----
        \t\t[Üçgen]  [Hesaplama için aktif]
        \t\t[Dörtgen][Hesaplama için aktif]
        \t\t[Daire]  [Hesaplama için aktif]
        \t\t[Beşgen] [Hesaplama için aktif]
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
                        allCoveredMethodQuadrilateral(false);
                        break;
                    case "Daire":
                        allCoveredMethodCircle(false);
                        break;
                    case "Beşgen":
                        allCoveredMethodRegularPentagon(false);
                        break;
                    case "Altıgen":
                        System.out.println("Altıgen alan ve çevre hesabı buraya.");
                        break;
                    case "Elips":
                        System.out.println("Altıgen alan ve çevre hesabı buraya.");
                        break;
                }
            }
        }while(true);
    }
}