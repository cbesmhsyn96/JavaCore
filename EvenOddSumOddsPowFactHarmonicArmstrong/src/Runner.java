import armstrongnumber.ArmstrongNumberCheck;
import evennumberfinder.EvenNumberFinder;
import factorialcalc.FactorialCalc;
import harmonicseries.HarmonicSeries;
import multiplesofnumber.MultiplesDivisorsCalculator;
import org.w3c.dom.ls.LSOutput;
import powercalculator.PowerCalculator;
import sumofoddnumbers.SumOfOddNumbers;

import java.util.ArrayList;
import java.util.List;

public class Runner {


    public static void main(String[] args) {
        EvenNumberFinder evenNumberFinder = new EvenNumberFinder();
        //evenNumberFinder.run();
        FactorialCalc factorialCalc = new FactorialCalc();
        //recursive
        //factorialCalc.run();
        SumOfOddNumbers sumOfOddNumbers = new SumOfOddNumbers();
        //sumOfOddNumbers.run();
        PowerCalculator powerCalculator = new PowerCalculator();
        //powerCalculator.run();
        HarmonicSeries harmonicSeries = new HarmonicSeries();
        //harmonicSeries.run();
        ArmstrongNumberCheck armstrongNumberCheck = new ArmstrongNumberCheck();
        //armstrongNumberCheck.run();
        MultiplesDivisorsCalculator multiplesDivisorsCalculator = new MultiplesDivisorsCalculator();
        multiplesDivisorsCalculator.run();

    }
}