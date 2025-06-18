package geometricshapes;

import validations.PatternValidations;

import java.util.Arrays;
import java.util.Scanner;

import static trigonometry.TrigHelper.sin;
import static validations.PatternValidations.intPattern;
import static validations.PatternValidations.yesNoPattern;


public class Quadrilateral {

    private static PatternValidations patternValidations;
    private static Scanner scanner = new Scanner(System.in);
    private static double sinValue = 0;
    private static double height = 0;
    private static int trapezoidBase1 = 0;
    private static int trapezoidBase2 = 0;
    private static int lateralSide1 = 0;
    private static int lateralSide2 = 0;

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

    public static void trapezoidArea(int trapezoidBase1,int trapezoidBase2, double height){
        double area = ((trapezoidBase1+trapezoidBase2)*height)/2;
        System.out.println("Alan = "+Math.round(area));
    }

    public static void trapezoidPerimeter(int trapezoidBase1,int lateralSide1,int lateralSide2){
        int perimeter = 2*trapezoidBase1 + (lateralSide1+lateralSide2);
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


    public static void trapezoid(int[] sides){
        System.out.println("[Yamuk alanı için girdiğiniz eşit değerler paralel kabul edilecektir.]");
        System.out.println("Yamuk için hesaplama başlatılıyor...");
        System.out.print("Yamuğun tabanı ile yan kenarı arasındaki açı :");
        String angle = scanner.nextLine();
        if(intPattern.matcher(angle).matches()){
            int angleValue = Integer.parseInt(angle);
            if(angleValue>0){
                if(sides[0] == sides[1]){
                    trapezoidBase1 = sides[0];
                    trapezoidBase2 = sides[1];
                    height = sin(angleValue)*Math.max(sides[3], sides[2]);
                    lateralSide1 = sides[3];
                    lateralSide2 = sides[2];
                } else if (sides[1] == sides[2]) {
                    trapezoidBase1 = sides[1];
                    trapezoidBase2 = sides[2];
                    height = sin(angleValue)*Math.max(sides[3], sides[0]);
                    lateralSide1 = sides[3];
                    lateralSide2 = sides[0];
                } else if (sides[2] == sides[3]) {
                    trapezoidBase1 = sides[2];
                    trapezoidBase2 = sides[3];
                    height = sin(angleValue)*Math.max(sides[1], sides[0]);
                    lateralSide1 = sides[1];
                    lateralSide2 = sides[0];
                } else if (sides[3] == sides[0]) {
                    trapezoidBase1 = sides[3];
                    trapezoidBase2 = sides[0];
                    height = sin(angleValue)*Math.max(sides[1], sides[2]);
                    lateralSide1 = sides[1];
                    lateralSide2 = sides[2];
                }
                trapezoidArea(trapezoidBase1,trapezoidBase2,height);
                trapezoidPerimeter(trapezoidBase1,lateralSide1,lateralSide2);
            }else{
                System.out.println("Açı negatif değer olamaz...!");
            }
        }else{
            System.out.println("Hatalı giriş yaptınız...!");
        }
    }

    public static void allCoveredMethod_Quadrilateral(boolean startingValue){
        boolean status = startingValue;
        do{
            System.out.print("İç açıların hepsi dik mi [Evet/Hayır]:");
            String secimYesNo = scanner.nextLine();
            if(yesNoPattern.matcher(secimYesNo).matches()){
                if(secimYesNo.equals("Evet")){
                    System.out.print("İlk kenarı girin :");
                    String a = scanner.nextLine();
                    System.out.print("İkinci kenarı girin :");
                    String b = scanner.nextLine();
                    System.out.print("Ücüncü kenarı girin :");
                    String c = scanner.nextLine();
                    System.out.print("Dördüncü kenarı girin :");
                    String d = scanner.nextLine();
                    if(intPattern.matcher(a).matches()&&
                            intPattern.matcher(b).matches()&&
                            intPattern.matcher(c).matches()&&
                            intPattern.matcher(d).matches()){
                        int aInt = Integer.parseInt(a);
                        int bInt = Integer.parseInt(b);
                        int cInt = Integer.parseInt(c);
                        int dInt = Integer.parseInt(d);
                        if(aInt>0&&bInt>0&&cInt>0&&dInt>0){
                            int[] sides = {aInt, bInt, cInt, dInt};
                            Arrays.sort(sides);
                            boolean isQuadrilateral = (sides[0] == sides[1]) && (sides[2] == sides[3]);
                            if((aInt == bInt) && (aInt == cInt) && (aInt == dInt)){
                                System.out.println("Kare için hesaplama başlatılıyor...");
                                square(aInt);
                            }else if(isQuadrilateral){
                                System.out.println("Dikdörtgen için hesaplama başlatılıyor...");
                                rectangle(sides[0],sides[2]);
                            }
                        }else{
                            System.out.println("Negatif değerler girdiniz...!");
                        }
                    }
                }else{
                            /*
                            a b c d gir
                            a ve b eşit ve d ve c eşit ise paralel kenar(kombinasyonlar)
                            değil ise yamuk
                             */
                    System.out.print("İlk kenarı girin :");
                    String a = scanner.nextLine();
                    System.out.print("İkinci kenarı girin :");
                    String b = scanner.nextLine();
                    System.out.print("Ücüncü kenarı girin :");
                    String c = scanner.nextLine();
                    System.out.print("Dördüncü kenarı girin :");
                    String d = scanner.nextLine();
                    if(intPattern.matcher(a).matches()&&
                            intPattern.matcher(b).matches()&&
                            intPattern.matcher(c).matches()&&
                            intPattern.matcher(d).matches()){
                        int aInt = Integer.parseInt(a);
                        int bInt = Integer.parseInt(b);
                        int cInt = Integer.parseInt(c);
                        int dInt = Integer.parseInt(d);
                        if(aInt>0&&bInt>0&&cInt>0&&dInt>0){
                            int[] sides = {aInt, bInt, cInt, dInt};
                            Arrays.sort(sides);
                            boolean isParallelogram = (sides[0] == sides[1]) && (sides[2] == sides[3]);
                            boolean isTrabezoid = (sides[0] == sides[1] && sides[0] != sides[2] && sides[0] != sides[3])||
                                    (sides[1] == sides[2] && sides[1] != sides[0] && sides[1] != sides[3])||
                                    (sides[2] == sides[3] && sides[2] != sides[0] && sides[2] != sides[1])||
                                    (sides[3] == sides[0] && sides[3] != sides[1] && sides[3] != sides[2]);

                            if(isParallelogram){
                                System.out.println("Paralelkenar için hesaplama başlatılıyor...");
                                parallelogram(sides);
                            }else if(isTrabezoid){
                                trapezoid(sides);
                            }
                        }else{
                            System.out.println("Negatif değerler girdiniz...!");
                        }
                    }
                }
            }else{
                System.out.println("Hatalı giriş yaptınız...!");
            }
            System.out.print("Dörtgen hesaplmasına devam edilsin mi[Evet/Hayır] :");
            String textYesNo = scanner.nextLine();
            if(yesNoPattern.matcher(textYesNo).matches()){
                if(textYesNo.equals("Evet")){
                    status = true;
                }else{
                    System.out.println("\n\n-------------------------------------------------------");
                    System.out.println("Dörtgen için alan ve çevre hesaplaması sonlandırılıyor...");
                    System.out.println("-------------------------------------------------------\n\n");
                    status = false;
                }
            }else{
                status = true;
            }
        }while(status == true);
    }



}