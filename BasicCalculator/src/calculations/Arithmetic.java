package calculations;

public class Arithmetic {
    private static double number1;
    private static double number2;

    public static double getNumber1() {
        return number1;
    }

    public static void setNumber1(double number1) {
        Arithmetic.number1 = number1;
    }

    public static double getNumber2() {
        return number2;
    }

    public static void setNumber2(double number2) {
        Arithmetic.number2 = number2;
    }

    public static double add(double number1, double number2){
        return number1+number2;
    }
    public static double subtract(double number1, double number2){
        return number1-number2;
    }
    public static double multiply(double number1, double number2){
        return number1*number2;
    }
    public static double divide(double number1, double number2){
        return number1/number2;
    }
}
