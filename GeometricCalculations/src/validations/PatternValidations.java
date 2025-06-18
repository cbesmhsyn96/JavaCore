package validations;

import trigonometry.ConstantsForTrig;

import java.util.regex.Pattern;

public class PatternValidations extends ConstantsForTrig {
    protected static Pattern shapesPattern = Pattern.compile("Üçgen|Dörtgen|Daire|Beşgen|Altıgen|Elips");
    public static Pattern intPattern = Pattern.compile("-?\\d+");
    public static Pattern yesNoPattern = Pattern.compile("Evet|Hayır");
}
