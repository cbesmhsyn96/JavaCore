import student.Student;

public class Main extends Student {
    public static void main(String[] args) {
        /*
        Student sınıfı,
        öğrenci bilgilerini tutar ve bu bilgilere erişim ve güncelleme imkanı sağlar.

        toString metodu,
        öğrenci bilgilerini yazdırmak için kullanılır.

        StudentManagementSystem Sınıfı:
        Öğrenci yönetimi için temel işlevleri içerir: ekleme, listeleme, güncelleme ve silme.addStudent,
        listStudents, updateStudent, ve deleteStudent metodları, öğrenci yönetimi işlemlerini gerçekleştirir.

        main metodu, kullanıcıdan girdi alarak bu işlemleri gerçekleştirir ve sonsuz bir döngü içinde kullanıcıyı yönlendirir.
         */

        studentInfoAdd();
        getStudentInfosById();
    }
}