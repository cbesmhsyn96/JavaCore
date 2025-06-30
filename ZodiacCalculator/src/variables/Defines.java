package variables;

import java.time.LocalDate;

import static chinese.ChineseZodiac.*;

public class Defines{
    private static String fullName;
    private static int birthYear;
    private static int birthMonth;
    private static int birthDayOfMonth;
    protected static LocalDate localDate;
    protected static int randYear;
    protected static int randMonth;
    protected static int randDayOfMonth;

    public static void getPersonInfos(){
        System.out.println("");
        System.out.print("Your zodiac :");
    }
}
