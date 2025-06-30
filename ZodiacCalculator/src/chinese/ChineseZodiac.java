package chinese;


public class ChineseZodiac{

    private static int birthYear;



    public static int getBirthYear() {
        return birthYear;
    }

    public static void setBirthYear(int birthYear) {
        ChineseZodiac.birthYear = birthYear;
    }

    public static String getChineseZodiac(int birthYear) {
        setBirthYear(birthYear);
        int subResult = getBirthYear();
        int zodiacValue = Math.floorMod(subResult, 12);
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