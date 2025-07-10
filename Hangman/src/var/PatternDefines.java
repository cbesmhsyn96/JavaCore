package var;

import java.util.regex.Pattern;

public class PatternDefines {
    protected static Pattern yesNoPattern = Pattern.compile("^(?:yes|no)$");
    protected static Pattern positiveIntegerPattern = Pattern.compile("^[1-9][0-9]*$");
    protected static Pattern  alphabeticInputPattern= Pattern.compile("^[A-Za-zÇİÖŞÜçğıöşü]+[A-Za-zÇĞİÖŞÜçğıöşü ]+$");
    protected static Pattern singleLetterPattern = Pattern.compile("^[A-Za-zÇİÖŞÜçğıöşü]$");
}
