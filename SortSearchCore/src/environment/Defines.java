package environment;

import java.util.ArrayList;
import java.util.List;

public class Defines {
    protected static List<Integer> ascendingList = new ArrayList<>();
    protected static List<Integer> descendingList = new ArrayList<>();
    protected static List<Integer> getNumbers(List<Integer>numbers){
        numbers.add(3);
        numbers.add(2);
        numbers.add(5);
        numbers.add(1);
        numbers.add(7);
        numbers.add(11);
        numbers.add(9);
        numbers.add(4);
        return numbers;
    }
}
