package factorialcalc;

import calcs.MathCalcs;

import java.util.concurrent.atomic.DoubleAccumulator;

public class FactorialCalc implements MathCalcs {

    private static int fact = 1;
    private static int i = 1;
    private static int standartFact(int sayi){
        while (i<=sayi){
            fact = fact * i;
            i++;
        }
        return fact;
    }

    private static int recusiveFact(int sayi){
        if(1<=sayi){
                return fact = sayi * recusiveFact(sayi-1);
        }
        return fact;
    }

    @Override
    public void run() {
        System.out.print("Faktoriyeli alınacak sayı :");
        String intValue = scanner.nextLine();
        if(pozIntPattern.matcher(intValue).matches()){
            int number = Integer.parseInt(intValue);
            System.out.println(number+"! (standart metot ile)= "+ standartFact(number));
            fact = 1;
            System.out.println(number+"! (özyineli metot ile)= "+ recusiveFact(number));
        }
    }
}