import chinese.ChineseZodiac;
import standard.StandardZodiac;
import variables.Defines;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

import static chinese.ChineseZodiac.*;
import static standard.StandardZodiac.getZodiac;

public class Runner extends Defines {
    public static void main(String[] args) {
        StandardZodiac standardZodiac;

        for (int i = 0; i < 20; i++) {
            randYear = new Random().nextInt(1900,LocalDate.now().getYear()+1);
            randMonth = new Random().nextInt(1,13);
            randDayOfMonth = new Random().nextInt(1,29);
            System.out.println("------------------------------------");
            System.out.println("Month = "+randMonth);
            System.out.println("DayOfMonth = "+randDayOfMonth);
            System.out.println("Standard Zodiac = "+getZodiac(randYear,randMonth,randDayOfMonth));
            if(i==19){
                System.out.println("------------------------------------");
            }
        }
        System.out.println("=========================================================================");
        for (int i = 0; i < 2; i++) {
            randYear = new Random().nextInt(1900,LocalDate.now().getYear()+1);
            System.out.println("------------------------------------");
            System.out.println("Year = "+randYear);
            System.out.println("Chinese zodiac = "+getChineseZodiac(randYear));
            if(i==1){
                System.out.println("------------------------------------");
            }
        }


    }
}