import taxi.TurkishTaxi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RunnerClass {
    public static void main(String[] args) {
        TurkishTaxi turkishTaxi;
        System.out.println("Toplam = "+new TurkishTaxi().calcTotallyCost(1));
        }
}