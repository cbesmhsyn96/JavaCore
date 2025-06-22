package validations;

import contants.InitialFinalValues;
import java.util.regex.Pattern;

public class Patterns extends InitialFinalValues {
    protected static Pattern patternInt =  Pattern.compile("\\d+");
    protected static Pattern patternNegativeInt = Pattern.compile("-\\d+");
    protected static Pattern patternDouble = Pattern.compile("-?\\d+\\.\\d+");
    protected static Pattern patternBinary  =  Pattern.compile("[01]+");
    protected static Pattern patternHexFormat =  Pattern.compile("[0-9a-fA-F]+");
    protected static Pattern patternPositiveIntAndDouble = Pattern.compile("^\\d+(\\.\\d+)?$");
}