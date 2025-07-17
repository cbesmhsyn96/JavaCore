import manager.StudentManagementSystem;
import student.Student;

public class Runner extends StudentManagementSystem {
    public static void main(String[] args) {
        /*
        Burada switch case veya if else mantığı uygulanabilirdi. Bu şekilde yeterli gördüm.
         */
        do {
            System.out.println("---------------------------------------studentInfoAdd() metodu çalışıyor");
            studentInfoAdd();
            System.out.println("---------------------------------------getStudentInfosById() metodu çalışıyor");
            getStudentInfosById();
            System.out.println("---------------------------------------updateStudentInfoById() metodu çalışıyor");
            updateStudentInfoById();
            listStudentInfos();
            System.out.println("---------------------------------------toString kullanımı");
            System.out.println(new Student().toString());
            System.out.println("---------------------------------------deleteStudent() metodu çalışıyor");
            deleteStudent();
        }while (true);
    }
}