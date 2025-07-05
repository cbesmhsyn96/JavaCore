package harmonicseries;

import calcs.MathCalcs;

public class HarmonicSeries implements MathCalcs {
    private double harmonicSeriesCalc(int number){
        if(number == 1){
            return 1;
        }
        if(number>0){
            return Math.pow(number,-1)+harmonicSeriesCalc(number-1);
        }
        return 5;
    }

    @Override
    public void run() {
        System.out.print("Harmonik serisi hesaplanacak sayı :");
        String intValue = scanner.nextLine();
        if(pozIntPattern.matcher(intValue).matches()){
            int number = Integer.parseInt(intValue);
            System.out.printf("%5.2f",harmonicSeriesCalc(number));
        }
    }
}
