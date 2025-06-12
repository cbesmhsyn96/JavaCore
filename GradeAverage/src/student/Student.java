package student;

import java.util.Scanner;

public class Student {
    private String name;
    private String lastName;
    private int classLevel;

    public String getStudentID(){
        return this.name+""+this.lastName+""+this.classLevel;
    }

    public void setStudentID(){
        String name;
        String lastName;
        int classLevel;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Student first name: ");
        name = scanner.next();
        this.name = name;
        System.out.print("Student last name: ");
        lastName = scanner.next();
        this.lastName = lastName;
        System.out.print("Student class level: ");
        classLevel = scanner.nextInt();
        this.classLevel = classLevel;
    }
}
