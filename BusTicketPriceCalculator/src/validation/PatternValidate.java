package validation;

import discount.TicketDiscountCalculator;

import java.util.regex.Pattern;

public class PatternValidate extends TicketDiscountCalculator {
    protected static Pattern patternFullName = Pattern.compile("^[A-ZŞÜÖİÇ][a-zşüöğıç]+(\\s[A-ZŞÜÖİÇ][a-zşüöğıç]+)?");
    protected static Pattern patternTripType = Pattern.compile("^[12]$");
    protected static Pattern patternDoubleAndIntNumber = Pattern.compile("\\d+(\\.\\d+)?");
}