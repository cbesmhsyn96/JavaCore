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
                System.out.println("Lütfen 0 ile başlamayan ve 5-11 haneli, rakamlardan oluşan bir değer giriniz."); 
            }
        }while (!idPattern.matcher(id).matches());
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
        }while (!fullNamePattern.matcher(fullName).matches());
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
        }while (!emailPattern.matcher(email).matches());
        Student.email = email;
    }

    protected static void studentInfoAdd(){
        int count =0;
        int boundCount;
        String studentCount;
        do {
            do {
                System.out.print("Bilgileri girilecek öğrenci sayısı :");
                studentCount = scanner.nextLine();
                if(!intPattern.matcher(studentCount).matches()){
                    System.out.println("Lüften 0 ile başlamayan ve en az 1 rakamdan oluşan bir sayı girin...");
                }
            }while (!intPattern.matcher(studentCount).matches());
            boundCount = Integer.parseInt(studentCount);
            do {
                setId();
                setfullName();
                setEmail();
                if(studentNames.containsKey(getId())&&studentEmails.containsKey(getId())){
                    System.out.println(getId()+" idli öğrenci bilgisi daha önce girildi...");
                }
            }while (studentNames.containsKey(getId())&&studentEmails.containsKey(getId()));
            studentNames.put(getId(),getfullName());
            studentEmails.put(getId(),getEmail());
            count++;
        }while (count< boundCount);

    }

    protected static void getStudentInfosById(){
        String idVal;
        if(studentNames.size()!=0){
            System.out.println("Bilgileri listelenebilecek öğrenci idleri");
            for (String key : studentNames.keySet()){
                System.out.println(key);
            }
            System.out.print("Lütfen bilgileri listelenecek öğrencinin idsini girin :");
            idVal = scanner.nextLine();
            if(studentNames.containsKey(idVal)){
                System.out.println(idVal + " idli öğrencinin bilgileri");
                System.out.println("id = "+Integer.parseInt(idVal));
                System.out.println("Tam ad = "+studentNames.get(idVal));
                System.out.println("Email = "+studentEmails.get(idVal));
            }
        }else{
            System.out.println("Öğrenci bilgi listesi boş. Lüften öğrenci bilgisi ekleyin.");
        }
    }

    protected static void updateStudentInfosById(){
        String idVal;
        if(studentNames.size()!=0){
            System.out.println("Bilgileri güncellenebilecek öğrenci idleri");
            for (String key : studentNames.keySet()){
                System.out.println(key);
            }
            System.out.print("Lütfen bilgileri güncellenecek öğrencinin idsini girin :");
            idVal = scanner.nextLine();
            if(studentNames.containsKey(idVal)){
                System.out.println(idVal + " idli öğrencinin bilgileri");
                System.out.println("id = "+Integer.parseInt(idVal));
                System.out.println("Tam ad = "+studentNames.get(idVal));
                System.out.println("Email = "+studentEmails.get(idVal));
                /*
                Burada switch case ile alınan değere göre Tam ad veya email değiştirilir.
                id değiştirilmemeli
                 */
            }
        }else{
            System.out.println("Öğrenci bilgi listesi boş. Lüften öğrenci bilgisi ekleyin.");
        }
    }

    /*
        Student sınıfı,
        öğrenci bilgilerini tutar ve bu bilgilere erişim ve güncelleme imkanı sağlar.

        toString metodu,(ayrı metot olarak yazacağım tüm idlerin bilgilerini listelerken kullanılacak.)
        öğrenci bilgilerini yazdırmak için kullanılır.
     */

    @Override
    public String toString() {
        return "";
    }
}
