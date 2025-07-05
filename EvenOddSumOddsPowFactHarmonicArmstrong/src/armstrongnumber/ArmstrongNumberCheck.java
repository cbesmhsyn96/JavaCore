package armstrongnumber;

import calcs.MathCalcs;

public class ArmstrongNumberCheck implements MathCalcs {
    private static int toplam = 0;
    private static int armstrongCheck(String sayi, int i){
        if(i<sayi.length()){
            int a = Integer.parseInt(String.valueOf(sayi.charAt(i)));
            return toplam = (int) Math.pow(a,sayi.length())+armstrongCheck(sayi,i+1);
        }
        return 0;
    }

    @Override
    public void run() {
        System.out.print("Armstrong kontrolü yapılacak sayı :");
        String intValue = scanner.nextLine();
        if(pozIntPattern.matcher(intValue).matches()){
            int number = Integer.parseInt(intValue);
            System.out.println("Armstrong hesaplama sonucu = "+armstrongCheck(String.valueOf(number),0));
            System.out.println((number==armstrongCheck(String.valueOf(number),0)) ?
                    number + " armstrong bir sayıdır." :
                    number+" armstrong bir sayı değildir.");
        }
    }
}
