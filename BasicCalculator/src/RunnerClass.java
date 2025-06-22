import fields.Fields;

import static calculations.Arithmetic.*;
import static calculations.ConversionsAndBasicInfo.conversionsAndBasicInfoCalcs;
import static calculations.ExponentialAndRoot.*;
import static calculations.NumberTheoryAndAdvancedMath.*;
import static calculations.Trigonometric.*;

/*
protected ile
Sabitler
   |
Patternler extend Sabitler
   |
Fieldlar extend Patternler
   |
Sınıflar extend Fieldlar
 */
public class RunnerClass extends Fields {
    public static void main(String[] args) {
        do {
            continueStatus = false;
            System.out.print("""
            { 1 } Aritmetik Hesaplamalar
            { 2 } Üs ve Kök Hesaplamaları
            { 3 } Trigonometrik Hesaplamalar
            { 4 } Dönüştürmeler ve Temel Bilgilerle İlgili Hesaplamalar
            { 5 } Sayı Teorisi ve İleri Matematik Hesaplamaları
            Seçiniz :""");
            String selection = scanner.nextLine();
            if(patternInt.matcher(selection).matches()){
                int selectionInt = Integer.parseInt(selection);
                if(selectionInt == 1){
                    arithmeticCalcs();
                } else if (selectionInt == 2) {
                    exponentialAndRootCalcs();
                } else if (selectionInt == 3) {
                    trigonometricCalcs();
                } else if (selectionInt == 4) {
                    conversionsAndBasicInfoCalcs();
                } else if (selectionInt == 5) {
                    numberTheoryAndAdvancedMathCalcs();
                } else {
                    System.out.println("Geçerli değer girmediniz...!");
                }
            }
            System.out.print("Temel hesap makinesi devam durumu [evet|hayır] :");
            selectionContinue = scanner.nextLine();
            if(selectionContinue.equals("evet")||selectionContinue.equals("hayır")){
                if(selectionContinue.equals("evet")){
                    continueStatus = true;
                }else{
                    continueStatus = false;
                }
            }
        }while (continueStatus);
    }
}