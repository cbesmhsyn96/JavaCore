package variables;

public class PersonInfos {
    private static String fullName;
    private static int birthYear;
    private static int birthMonth;
    private static int birthDayOfMonth;

    public PersonInfos(String fullName, int birthYear, int birthMonth, int birthDayOfMonth) {
        setFullName(fullName);
        setBirthYear(birthYear);
        setBirthMonth(birthMonth);
        setBirthDayOfMonth(birthDayOfMonth);
    }

    public PersonInfos(String fullName, int birthYear) {
        setFullName(fullName);
        setBirthYear(birthYear);
    }

    public static String getFullName() {
        return fullName;
    }

    public static int getBirthMonth() {
        return birthMonth;
    }

    public static void setBirthMonth(int birthMonth) {
        PersonInfos.birthMonth = birthMonth;
    }

    public static int getBirthDayOfMonth() {
        return birthDayOfMonth;
    }

    public static void setBirthDayOfMonth(int birthDayOfMonth) {
        PersonInfos.birthDayOfMonth = birthDayOfMonth;
    }

    public static void setFullName(String fullName) {
        PersonInfos.fullName = fullName;
    }

    public static int getBirthYear() {
        return birthYear;
    }

    public static void setBirthYear(int birthYear) {
        PersonInfos.birthYear = birthYear;
    }

    public static void getPersonInfos(){
        System.out.println("Hello "+getFullName()+", your birth year "+getBirthYear());
        System.out.print("Your zodiac :");
    }
}
