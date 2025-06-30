package chinese;

import variables.PersonInfos;

public class ChineseZodiac extends PersonInfos {

    public ChineseZodiac(String fullName,int birthYear) {
        super(fullName,birthYear);
    }

    private static int chineseZodiacCalc(){
        return Math.floorMod(getBirthYear(),12);
    }
    public static String getChineseZodiac() {
        int zodiacValue = chineseZodiacCalc();
        return switch (zodiacValue) {
            case 0 -> "Monkey";
            case 1 -> "Rooster";
            case 2 -> "Dog";
            case 3 -> "Pig";
            case 4 -> "Rat";
            case 5 -> "Ox";
            case 6 -> "Tiger";
            case 7 -> "Rabbit";
            case 8 -> "Dragon";
            case 9 -> "Snake";
            case 10 -> "Horse";
            case 11 -> "Sheep";
            default -> "";
        };
    }
}