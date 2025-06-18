package geometricshapes;

import validations.PatternValidations;

import java.util.Scanner;

import static trigonometry.TrigHelper.sin;
import static validations.PatternValidations.intPattern;

public class Quadrilateral {
    private static PatternValidations patternValidations;
    private static Scanner scanner = new Scanner(System.in);
    public static void square(int a){
        int area = a*a;
        int perimeter = a*4;
        System.out.println("Alan = "+area);
        System.out.println("Çevre = "+perimeter);
    }

    public static void rectangle(int a,int b){
        int area = a*b;
        int perimeter = (a+b)*2;
        System.out.println("Alan = "+area);
        System.out.println("Çevre = "+perimeter);
    }

    public static void parallelogramArea(double base,double height){
        double area = base*height;
        System.out.println("Alan = "+Math.round(area));
    }

    public static void parallelogramPerimeter(int a,int b){
        int perimeter = (a+b)*2;
        System.out.println("Çevre = "+perimeter);
    }

//    public static void trapezoidArea(int trapezoidBase1,int trapezoidBase2, int height){
//        double area = base*height;
//        System.out.println("Alan = "+Math.round(area));
//    }

    public static void trapezoidPerimeter(int a,int b){
        int perimeter = (a+b)*2;
        System.out.println("Çevre = "+perimeter);
    }



    public static void parallelogram(int[] sides){
        double sinValue = 0;
        System.out.print("Paralelkenarın tabanı :");
        String base = scanner.nextLine();
        if(intPattern.matcher(base).matches()){
            int i = 0;
            boolean isContain = false;
            while (i<sides.length){
                if(sides[i]==Integer.parseInt(base)){
                    isContain = true;
                    break;
                }
                i++;
            }
            if(isContain==false){
                System.out.println("Paralelkenara ait bir kenar uzunluğu girmediniz...!");
            }
            System.out.print("Paralelkenarın tabanı ile yan kenarı arasındaki açı :");
            String angle = scanner.nextLine();
            if(intPattern.matcher(angle).matches()){
                sinValue = sin(Double.parseDouble(angle));
            }
            double height = Double.parseDouble(String.valueOf(sides[2]))*sinValue;
            parallelogramPerimeter(sides[0],sides[2]);
            parallelogramArea(Double.parseDouble(base),height);
        }else{
            System.out.println("Geçersiz değer girdiniz...!");
        }
    }




}