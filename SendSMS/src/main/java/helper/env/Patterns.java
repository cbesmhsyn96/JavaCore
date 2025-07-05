package helper.env;
import java.util.regex.*;

public class Patterns{
    protected static Pattern patternName = Pattern.compile("^[A-ZİŞÇÜÖ][a-zışçöüğ]+\\s([A-ZİŞÇÜÖ][a-zışçöüğ]+)*$");
    protected static Pattern patternMessage = Pattern.compile("^[\\w\\W]+$");
}
