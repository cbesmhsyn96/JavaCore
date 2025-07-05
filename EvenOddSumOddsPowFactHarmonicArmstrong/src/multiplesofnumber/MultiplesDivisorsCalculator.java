package multiplesofnumber;

import calcs.MathCalcs;

import java.util.ArrayList;
import java.util.List;

public class MultiplesDivisorsCalculator implements MathCalcs {
    private static void commonDivisors(int sayi, int i,int b, List<Integer> sayilar){
        if(sayi>i){
            if(Math.floorMod(sayi,i)==0 && Math.floorMod(i,b)==0){
                sayilar.add(i);
            }
            commonDivisors(sayi,i+1,b,sayilar);
        }
    }
    @Override
    public void run() {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Ortak bölenleri listeleme işlemi başlıyor...");
        System.out.print("Kaça kadar hesaplansın :");
        String intBoundValue = scanner.nextLine();
        System.out.print("Kaçın katı olan ortak bölenler listelensin :");
        String intSecondNumberValue = scanner.nextLine();
        if(pozIntPattern.matcher(intBoundValue).matches()&&pozIntPattern.matcher(intSecondNumberValue).matches()){
            int intBound = Integer.parseInt(intBoundValue);
            int intSecondNumber = Integer.parseInt(intSecondNumberValue);
            commonDivisors(intBound,1,intSecondNumber,numbers);
            System.out.println(intBound+" sayısına kadar "+intSecondNumber+" sayısının katı olan bölenleri");
            for (int number : numbers){
                System.out.println(number);
            }
            numbers.clear();
        }
    }
}
