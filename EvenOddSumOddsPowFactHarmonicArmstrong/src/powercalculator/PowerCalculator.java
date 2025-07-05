package powercalculator;

import calcs.MathCalcs;

public class PowerCalculator implements MathCalcs {
    private static int powCalc(int a, int b,int i){
        if(i<=b){
            return a*powCalc(a,b,i+1);
        }
        return 1;
    }

    @Override
    public void run() {
        //Sadece positif sayılar girilebiliyor. Ama pattern pozitif ve negatif kabul eden
        //pattern ile güncellenirse negatif te kabul eder.
        System.out.println("Üs Alma işlemi başlıyor...");
        System.out.print("Taban sayı :");
        String intBaseValue = scanner.nextLine();
        System.out.print("Üs sayı :");
        String intPowerValue = scanner.nextLine();
        if(pozIntPattern.matcher(intBaseValue).matches()&&pozIntPattern.matcher(intPowerValue).matches()){
            int intBase = Integer.parseInt(intBaseValue);
            int intPower = Integer.parseInt(intPowerValue);
            System.out.println("pow("+intBase+","+intPower+") = "+powCalc(intBase,intPower,1));
        }
    }

}
