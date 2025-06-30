import chinese.ChineseZodiac;
import variables.PersonInfos;

import java.sql.SQLOutput;

import static chinese.ChineseZodiac.*;

public class Main {
    public static void main(String[] args) {
        ChineseZodiac chineseZodiac = new ChineseZodiac("Hüseyin Akcan",1996);
        getPersonInfos();
        System.out.println(getChineseZodiac());
        System.out.println(getBirthYear());
        }
}