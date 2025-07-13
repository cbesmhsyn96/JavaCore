package types;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.OptionalDouble;

public class WithStreamAPI extends WithStandard{
    public static double calcAverageFromNumberArray(int[] numberArray){
        OptionalDouble average = Arrays.stream(numberArray).asDoubleStream().average();
        if(average.isPresent()){
            return average.getAsDouble();
        }else{
            return 0.0;
        }
    }

}
