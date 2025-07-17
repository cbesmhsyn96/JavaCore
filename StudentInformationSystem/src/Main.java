import student.Student;

public class Main extends Student {
    public static void main(String[] args) {
        /*

        StudentManagementSystem Sınıfı:
        Öğrenci yönetimi için temel işlevleri içerir: ekleme, listeleme, güncelleme ve silme.addStudent,
        listStudents, updateStudent, ve deleteStudent metodları, öğrenci yönetimi işlemlerini gerçekleştirir.

        main metodu, kullanıcıdan girdi alarak bu işlemleri gerçekleştirir ve sonsuz bir döngü içinde kullanıcıyı yönlendirir.
         */
        System.out.println("---------------------------------------studentInfoAdd() metodu çalışıyor");
        studentInfoAdd();
        System.out.println("---------------------------------------getStudentInfosById() metodu çalışıyor");
        getStudentInfosById();
        System.out.println("---------------------------------------updateStudentInfoById() metodu çalışıyor");
        updateStudentInfoById();
        listStudentInfos();
        System.out.println("---------------------------------------toString kullanımı");
        System.out.println(new Student().toString());

    }
}