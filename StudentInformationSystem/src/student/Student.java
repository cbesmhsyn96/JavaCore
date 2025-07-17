package student;

import validation.PatternValidation;

import java.util.Map;
import java.util.regex.Pattern;

public class Student extends PatternValidation {
    private static String id;
    private static String fullName;
    private static String email;

    public static String getId() {
        return id;
    }

    public static void setId() {
        String id;
        do {
            System.out.print("Lütfen öğrenci idnizi girin :");
            id = scanner.nextLine();
            if(!idPattern.matcher(id).matches()){
                System.out.println("Lütfen 0 ile başlamayan ve en fazla 6 haneli, rakamlardan oluşan bir değer giriniz.");
            }
            if(studentNames.containsKey(id)){
                System.out.println(id+" idli kayıt var olduğundan başka bir id giriniz...");
            }
        }while (!idPattern.matcher(id).matches()||studentNames.containsKey(id));
        Student.id = id;
    }

    public static String getfullName() {
        return fullName;
    }

    public static void setfullName() {
        String fullName;
        do {
            System.out.print("Lütfen tam adınızı girin :");
            fullName = scanner.nextLine();
            if(!fullNamePattern.matcher(fullName).matches()){
                System.out.println("Lütfen harflerden oluşan, baş harfleri büyük en az 2 kelimeden oluşan bir değer giriniz...");
            }
            if(studentNames.containsValue(fullName)){
                System.out.println(fullName+ " tam adı var olduğundan başka bir tam ad giriniz...");
            }
        }while (!fullNamePattern.matcher(fullName).matches()||studentNames.containsValue(fullName));
        Student.fullName = fullName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail() {
        String email;
        do {
            System.out.print("Lütfen öğrenci emailinizi girin :");
            email = scanner.nextLine();
            if(!emailPattern.matcher(email).matches()){
                System.out.println("Lütfen geçerli bir mail giriniz...");
            }
            if(studentEmails.containsValue(email)){
                System.out.println(email+ " emaili var olduğundan başka bir email giriniz...");
            }
        }while (!emailPattern.matcher(email).matches()||studentEmails.containsValue(email));
        Student.email = email;
    }



    @Override
    public String toString() {
        //tüm idlerin bilgilerini listelerken kullanılacak
        return "idler = ".concat(studentNames.keySet().toString()).
                concat("\nEmailler = {"+studentEmails.values()+"}").
                concat("\nTam adlar = {"+studentNames.values()+"}");
    }



}
