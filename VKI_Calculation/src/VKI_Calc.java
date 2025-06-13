public class VKI_Calc {
    //BMI = Weight (kg) / (Height (m))²
    public double bmiCalc(int weight, double height){
        return weight/Math.pow(height,2);
    }

    public void scaleBMI(double bmi){
        if (bmi<18.5){
            System.out.println("Underweight");
        } else if (18.5<bmi&&bmi<24.9) {
            System.out.println("Normal weight");
        }else if (25<bmi&&bmi<29.9) {
            System.out.println("Overweight");
        }else if (30<bmi&&bmi<34.9) {
            System.out.println("Obese (Class 1)");
        }else if (35<bmi&&bmi<339.9) {
            System.out.println("Obese (Class 2)");
        }else if(bmi>=40){
            System.out.println("Morbidly Obese (Class 3)");
        }
    }
}
