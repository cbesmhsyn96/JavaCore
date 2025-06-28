package passenger;

import validation.PatternValidate;

public class PassengerInfos extends PatternValidate {
    private static String fullName;
    private static double tripDistance;//mesafe pozitif
    private static int age;//pozitif
    private static int tripType;// yolculuk tipi 1 2
    //"Hatalı Veri Girdiniz !" uyarısı

    public static String getFullName() {
        return fullName;
    }

    public static void setFullName(String fullName) {
        PassengerInfos.fullName = fullName;
    }

    public static double getTripDistance() {
        return tripDistance;
    }

    public static void setTripDistance(double tripDistance) {
        PassengerInfos.tripDistance = tripDistance;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        PassengerInfos.age = age;
    }

    public static int getTripType() {
        return tripType;
    }

    public static void setTripType(int tripType) {
        PassengerInfos.tripType = tripType;
    }

    protected static void getPassengerInfo(){
        System.out.print("Full name [text]:");
        String fullNameValue = scanner.nextLine();
        System.out.print("Trip distance [number]:");
        String tripDistanceValue = scanner.nextLine();
        System.out.print("Age  [number]:");
        String ageValue = scanner.nextLine();
        System.out.print("Trip type  [1/2]:");
        String tripTypeValue = scanner.nextLine();
        /*String tripDistanceValue = "12";
        String fullNameValue = "Hüseyin";
        String ageValue = "23";
        String tripTypeValue = "2";*/
        if(patternDoubleAndIntNumber.matcher(tripDistanceValue).matches()&&
           patternFullName.matcher(fullNameValue).matches()&&
           patternDoubleAndIntNumber.matcher(ageValue).matches()&&
           patternTripType.matcher(tripTypeValue).matches()){
            setAge(Integer.parseInt(ageValue));
            setFullName(fullNameValue);
            setTripDistance(Double.parseDouble(tripDistanceValue));
            setTripType(Integer.parseInt(tripTypeValue));
        }else{
            System.out.println("Geçersiz değer girişi.");
        }
    }

}