package var;

import java.util.*;
import java.util.regex.Pattern;

public class Defines extends PatternDefines{
    protected static String str;
    protected static HashSet<Integer> randIndexSetWillHaveHiddenText = new HashSet<>();
    protected static Iterator<Integer> iterator;
    protected static Random random = new Random();
    protected static List<Integer> randomIndexList = new ArrayList<>();
    protected static int count;
    protected static String text;
    protected static String guessLetterPointAsString;
    protected static  List<Integer> randPoints;
    protected static int loopCount = 0;
    protected final static int loopBound = 3;
    protected static String guessedLetter;
}
