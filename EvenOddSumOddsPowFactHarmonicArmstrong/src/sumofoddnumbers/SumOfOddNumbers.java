package sumofoddnumbers;

import calcs.MathCalcs;

import java.lang.foreign.PaddingLayout;
import java.util.ArrayList;
import java.util.List;

public class SumOfOddNumbers implements MathCalcs {
    private static int i = 0;
    private static int total = 0;
    private static List<Integer> oddNumbers = new ArrayList<>();
    private static List<Integer> oddNumbers(int sayi){
        while (i<sayi){
            if(Math.floorMod(i,2)==1){
                oddNumbers.add(i);
            }
            i++;
        }
        return oddNumbers;
    }

    private static int sumOddNumbers(List<Integer> oddNumbers){
        for (int currentNumber : oddNumbers){
            total = total + currentNumber;
        }
        return total;
    }

    @Override
    public void run() {
        System.out.print("Kaça kadar tek sayılar listelensin :");
        String secimIntValue = scanner.nextLine();
        if(pozIntPattern.matcher(secimIntValue).matches()){
            int secimInt = Integer.parseInt(secimIntValue);
            oddNumbers(secimInt);
            for (int oddNumber : oddNumbers){
                if(oddNumber == oddNumbers.get(0)){
                    System.out.print("{{{ "+oddNumber+" ");
                }else{
                    if(oddNumber != oddNumbers.get(oddNumbers.size()-1)){
                        System.out.print(oddNumber+" ");
                    }else{
                        System.out.println(oddNumber+" }}}");
                    }
                }
            }
            System.out.println("Total = "+sumOddNumbers(oddNumbers(secimInt)));
        }

    }

}
