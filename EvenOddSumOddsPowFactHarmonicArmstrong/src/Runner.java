import evennumberfinder.EvenNumberFinder;
import factorialcalc.FactorialCalc;
import sumofoddnumbers.SumOfOddNumbers;

public class Runner {
    public static void main(String[] args) {
        EvenNumberFinder evenNumberFinder = new EvenNumberFinder();
        //evenNumberFinder.run();
        FactorialCalc factorialCalc = new FactorialCalc();
        //recursive
        factorialCalc.run();

        SumOfOddNumbers sumOfOddNumbers = new SumOfOddNumbers();
        //sumOfOddNumbers.run();
    }
}