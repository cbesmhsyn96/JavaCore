package manager;

import student.Student;

import java.util.Map;

public class StudentManagementSystem extends Student {
    protected static void studentInfoAdd(){
        int count =0;
        int boundCount;
        boolean status = false;
        String studentCount="";
        do {
            do {
                if(count == 0){
                    System.out.print("Bilgileri girilecek öğrenci sayısı :");
                    studentCount = scanner.nextLine();
                }
                if(!intPattern.matcher(studentCount).matches()){
                    System.out.println("Lüften 0 ile başlamayan ve en az 1 rakamdan oluşan bir sayı girin...");
                }else{
                    status = true;
                    break;
                }
            }while (!intPattern.matcher(studentCount).matches()&& !status);
            boundCount = Integer.parseInt(studentCount);
            do {
                System.out.println((count+1)+". öğrencinin bilgileri");
                setId();
                setfullName();
                setEmail();
                if(studentNames.containsKey(getId())||studentEmails.containsKey(getId())){
                    System.out.println(getId()+" idli öğrenci bilgisi daha önce girildi...");
                }
            }while (studentNames.containsKey(getId())||studentEmails.containsKey(getId()));
            studentNames.put(getId(),getfullName());
            studentEmails.put(getId(),getEmail());
            count++;
        }while (count!=boundCount);

    }

    protected static void getStudentInfosById(){
        String idVal;
        if(studentNames.size()!=0){
            System.out.println("Bilgileri listelenebilecek öğrenci idleri");
            for (String key : studentNames.keySet()){
                System.out.println(key);
            }
            do {
                System.out.print("Lütfen bilgileri listelenecek öğrencinin idsini girin :");
                idVal = scanner.nextLine();
                if(studentNames.containsKey(idVal)){
                    System.out.println(idVal + " idli öğrencinin bilgileri");
                    System.out.println("id = "+Integer.parseInt(idVal));
                    System.out.println("Tam ad = "+studentNames.get(idVal));
                    System.out.println("Email = "+studentEmails.get(idVal));
                }else{
                    System.out.println("Lütfen listelenen idlerden birini yazınız...");
                }
            }while (!studentNames.containsKey(idVal));
        }else{
            System.out.println("Öğrenci bilgi listesi boş. Lüften öğrenci bilgisi ekleyin.");
        }
    }

    protected static void updateStudentInfoById(){
        String idVal;
        String updatedField;
        if(!studentEmails.isEmpty()){
            System.out.print("Bilgileri güncellenecek öğrencinin idsi :");
            idVal = scanner.nextLine();
            if(studentEmails.keySet().contains(idVal)){
                System.out.println(idVal+" idli öğrencinin güncellenebilecek bilgileri");

                System.out.println("Email = "+studentEmails.get(idVal));
                System.out.println("Tam ad = "+studentNames.get(idVal));
                //toString kullanılabilir
                do {
                    System.out.print("Güncellenecek alan [Email|Tam ad]:");
                    updatedField = scanner.nextLine();
                    if(!updateValuePattern.matcher(updatedField).matches()){
                        System.out.println("Lütfen geçerli bir alan adı giriniz [Email|Tam ad]...");
                    }
                }while (!updateValuePattern.matcher(updatedField).matches());

                switch (updatedField){
                    case "Email": updateEmail(idVal); break;
                    case "Tam ad": updateFullName(idVal); break;
                }

            }

        }
    }
    protected static void listStudentInfos(){
        System.out.println("Öğrencilerin Bilgileri");
        for (Map.Entry entry : studentNames.entrySet()){
            System.out.println("------------------------------------");
            System.out.println("id = "+entry.getKey());
            System.out.println("Tam ad = "+entry.getValue());
            System.out.println("Email = "+studentEmails.get(entry.getKey().toString()));
            System.out.println("------------------------------------");
        }
    }
    private static void updateFullName(String idVal){
        String newFullNameVal;
        do {
            System.out.print(idVal+" idli öğrencinin güncel tam adını giriniz :");
            newFullNameVal = scanner.nextLine();
            if (!fullNamePattern.matcher(newFullNameVal).matches()) {
                System.out.println("Lütfen harflerden oluşan, baş harfleri büyük en az 2 kelimeden oluşan bir değer giriniz...");
            }
            if(studentNames.get(idVal).equals(newFullNameVal)){
                System.out.println("Güncel tam ad var olan tam ad ile aynı olamaz...");
            }
        }while (!fullNamePattern.matcher(newFullNameVal).matches()&&studentNames.get(idVal).equals(newFullNameVal));
        studentNames.replace(idVal,newFullNameVal);
        System.out.println(idVal+" idli öğrencinin tam adı "+newFullNameVal+" ile güncellendi.");
    }

    private static void updateEmail(String idVal){
        String newEmailVal;
        do {
            System.out.print(idVal+" idli öğrencinin güncel emailini giriniz");
            newEmailVal = scanner.nextLine();
            if (!emailPattern.matcher(newEmailVal).matches()) {
                System.out.println("Lütfen harflerden oluşan, baş harfleri büyük en az 2 kelimeden oluşan bir değer giriniz...");
            }
            if(studentEmails.get(idVal).equals(newEmailVal)){
                System.out.println("Güncel tam ad var olan tam ad ile aynı olamaz...");
            }
        }while (!emailPattern.matcher(newEmailVal).matches()&&studentEmails.get(idVal).equals(newEmailVal));
        studentEmails.replace(idVal,newEmailVal);
        System.out.println(idVal+" idli öğrencinin emaili "+newEmailVal+" ile güncellendi.");
    }

    protected static void deleteStudent(){
        String  idVal;
        System.out.println("-- Silinme İşleminden Önce --");
        listStudentInfos();
        do {
            System.out.print("Bilgilerini silmek isteğiniz öğrencinin idsini giriniz :");
            idVal = scanner.nextLine();
            if(!studentNames.containsKey(idVal)){
                System.out.println("Lütfen listede olan bir id yi giriniz...");
            }
        }while (!studentNames.containsKey(idVal));
        System.out.println(idVal+" idli öğrencinin bilgileri siliniyor...");
        studentNames.remove(idVal);
        studentEmails.remove(idVal);
        System.out.println("-- Silinme İşleminden Sonra --");
        listStudentInfos();
    }
}
