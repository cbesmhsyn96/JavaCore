import java.util.regex.Pattern;

public class ValidityCheck {
    //RunnerClass.java daki kodu sadeleştirmek için validasyon kodlarını
    //yani pattern tanımları ve pattern ile yapılan kontroller buraya alınabilir.

    protected static Pattern stringPattern = Pattern.compile("[a-zA-ZçÇğĞıİöÖşŞüÜ]+");
    protected static Pattern passwordPattern = Pattern.compile("^[a-zA-ZçÇğĞıİöÖşŞüÜ]+\\d*$");
    protected static Pattern intPattern = Pattern.compile("\\d+");


}
