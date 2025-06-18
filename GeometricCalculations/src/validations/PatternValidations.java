package validations;

import java.util.regex.Pattern;

public class PatternValidations {
    protected static Pattern shapesPattern = Pattern.compile("Üçgen|Dörtgen|Daire|Beşgen|Altıgen|Elips");
    protected static Pattern intPattern = Pattern.compile("-?\\d+");
    protected static Pattern yesNoPattern = Pattern.compile("Evet|Hayır");
}
