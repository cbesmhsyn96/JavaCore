package calcs;

import java.util.Scanner;
import java.util.regex.Pattern;

public interface MathCalcs {
    void run();
    Scanner scanner = new Scanner(System.in);
    Pattern pozIntPattern = Pattern.compile("\\d+");
}