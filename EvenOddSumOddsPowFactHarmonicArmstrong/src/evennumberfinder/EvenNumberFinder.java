package evennumberfinder;

import calcs.MathCalcs;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.List;

public class EvenNumberFinder implements MathCalcs {
    @Override
    public void run() {
        int supBound,i=0;
        List<Integer> evenNumbers = new ArrayList<>();
        System.out.print("Kaça kadarki çift sayılar listelensin :");
        String secSupBound = scanner.nextLine();
        if(pozIntPattern.matcher(secSupBound).matches()){
            supBound = Integer.parseInt(secSupBound);
            while (i<supBound){
                if(Math.floorMod(i,2)==0){
                    evenNumbers.add(i);
                }
                i++;
            }
        }
        System.out.println("--- Çift Sayılar ---");
        for(int currentEven: evenNumbers){
            if(currentEven == evenNumbers.get(0)){
                System.out.print("{{{ ");
            } else if (currentEven != evenNumbers.get(evenNumbers.size()-1)) {
                    System.out.print(currentEven+" ");
            }else if(currentEven == evenNumbers.get(evenNumbers.size()-1)){
                System.out.print("}}}");
            }
        }
    }
}
