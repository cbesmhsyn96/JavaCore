
import java.util.Scanner;
import java.util.regex.Pattern;

public class RunnerClass {
    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        VKI_Calc vkiCalc = new VKI_Calc();
        Scanner scanner = new Scanner(System.in);
        Pattern numberPattern = Pattern.compile("\\d+");
        Pattern doublePattern = Pattern.compile("\\d+\\.\\d+");
        System.out.print("Kilogram giriniz :");
        String intInput = scanner.nextLine();
        if (!numberPattern.matcher(intInput).matches()){
            System.out.println("Geçersiz kilogram girdiniz!");
            System.out.println("Program sonlanıyor...");
        }else{
            calculation.setWeight(Integer.parseInt(intInput));
            System.out.print("Boy giriniz :");
            String doubleInput = scanner.nextLine();
            if(!doublePattern.matcher(doubleInput).matches()){
                System.out.println("Geçersiz boy girdiniz!");
                System.out.println("Program sonlanıyor...");
            }else{
                calculation.setHeight(Double.parseDouble(doubleInput));
                vkiCalc.scaleBMI(vkiCalc.bmiCalc(calculation.getWeight(),calculation.getHeight()));
            }
        }
    }
}
