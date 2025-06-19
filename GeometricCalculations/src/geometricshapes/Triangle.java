package geometricshapes;

import validations.PatternValidations;

import java.util.Scanner;

public class Triangle extends PatternValidations{

    private static Scanner scanner = new Scanner(System.in);

    public static void equiLateral(int a){
        double area = (Math.sqrt(3)*Math.pow(a,2))/4;
        int perimeter = 3*a;
        System.out.println("Alan = "+area);
        System.out.println("Çevre = "+perimeter);
    }

    public static void notEquiLateral(int a,int b, int c){
        int perimeter = a+b+c;
        double s = (double)perimeter/2;
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        System.out.println("Alan = "+area);
        System.out.println("Çevre = "+perimeter);
    }

    public static void right(int a,int b){
        double perimeter = (double)(a+b) + Math.sqrt(a*a+b*b);
        double area = (double)(a*b)/2;
        System.out.println("Alan = "+area);
        System.out.println("Çevre = "+perimeter);
    }

    public static void allCoveredMothodTriangle(boolean startingValue){
        boolean status = startingValue;
        do{
            System.out.print("İlk kenarı girin :");
            String a = scanner.nextLine();
            System.out.print("İkinci kenarı girin :");
            String b = scanner.nextLine();
            System.out.print("Ücüncü kenarı girin :");
            String c = scanner.nextLine();
            if(intPattern.matcher(a).matches()&&
                    intPattern.matcher(b).matches()&&
                    intPattern.matcher(c).matches()){
                int aInt = Integer.parseInt(a);
                int bInt = Integer.parseInt(b);
                int cInt = Integer.parseInt(c);
                int a2 = (int) Math.pow(aInt,2);
                int b2 = (int) Math.pow(bInt,2);
                int c2 = (int) Math.pow(cInt,2);
                if(aInt > 0 && bInt > 0 && cInt > 0){
                    if(aInt == bInt && aInt == cInt){
                        System.out.println("Eşkenar üçgen için hesaplama başlatılıyor...");
                        equiLateral(aInt);
                    } else if ((aInt + bInt > cInt) && (aInt + cInt > bInt) && (bInt + cInt > aInt)) {
                        if (a2==(b2+c2) || (b2==(c2+a2)) || (c2==(a2+b2))) {
                            System.out.println("Dik üçgen için hesaplama başlatılıyor...");
                            if(a2==(b2+c2)){right(bInt,cInt);}
                            if(b2==(c2+a2)){right(cInt,aInt);}
                            if(c2==(a2+b2)){right(aInt,bInt);}
                        }else{
                            System.out.println("Eşkenar olmayan üçgen için hesaplama başlatılıyor...");
                            notEquiLateral(aInt,bInt,cInt);
                        }
                    }else{
                        System.out.println("Üçgen şartını sağlamayan değerler girdiniz...!");
                    }
                }else{
                    System.out.println("Negatif değerler girdiniz...!");
                }
            }else{
                System.out.println("Sayı girmediniz...!");
            }
            System.out.print("Üçgen hesaplamasına devam edilsin mi[Evet/Hayır] :");
            String textYesNo = scanner.nextLine();
            if(yesNoPattern.matcher(textYesNo).matches()){
                if(textYesNo.equals("Evet")){
                    status = true;
                }else{
                    System.out.println("\n\n-------------------------------------------------------");
                    System.out.println("Üçgen için alan ve çevre hesaplaması sonlandırılıyor...");
                    System.out.println("-------------------------------------------------------\n\n");
                    status = false;
                }
            }
        }while (status==true);
    }

}