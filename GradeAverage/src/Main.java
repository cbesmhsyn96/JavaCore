import calculate.Calculate;
import notes.MathNotes;
import notes.PhisicsNotes;
import student.Student;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int classMembersCount;
        int avgNoteMath;
        int avgNotePhisics;
        int secim;
        String yeniIslem;
        Student student;
        MathNotes mathNotes;
        PhisicsNotes phisicsNotes;
        HashSet<String> fullNames = new HashSet();
        Calculate calculate = new Calculate();
        Map<String,Integer> mathNoteAvgHashMap = new HashMap<>();
        Map<String,Integer> phisicsNoteAvgHashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Number of students whose grades will be entered :");
            classMembersCount = scanner.nextInt();
            for (int i = 0; i < classMembersCount; i++) {
                student = new Student();
                mathNotes = new MathNotes();
                phisicsNotes = new PhisicsNotes();
                student.setStudentID();
                System.out.print("""
                -----------------MENU------------------
                1-) Enter Mathematics grades
                2-) Enter Physics grades
                3-) Enter both Mathematics and Physics grades
                Enter a number (1, 2, or 3):""");
                secim = scanner.nextInt();
                System.out.println("The student with ID " + student.getStudentID());
                fullNames.add(student.getStudentID());
                switch (secim) {
                    case 1:
                        mathNotes.inputMathNotes();
                        System.out.println("Mathematics grades have been entered for the student with ID " + student.getStudentID());
                        avgNoteMath = calculate.averageExams(mathNotes.getFirstMidtermExamScore(), mathNotes.getSecondMidtermExamScore(), mathNotes.getFinalExamScore(), mathNotes.getAssignmentScore());
                        mathNoteAvgHashMap.put(student.getStudentID(), avgNoteMath); continue;
                    case 2:
                        phisicsNotes.inputPhisicsNotes();
                        System.out.println("Physics grades have been entered for the student with ID " + student.getStudentID());
                        avgNotePhisics = calculate.averageExams(phisicsNotes.getFirstMidtermExamScore(), phisicsNotes.getSecondMidtermExamScore(), phisicsNotes.getFinalExamScore(), phisicsNotes.getAssignmentScore());
                        phisicsNoteAvgHashMap.put(student.getStudentID(), avgNotePhisics); continue;
                    case 3:
                        mathNotes.inputMathNotes();
                        System.out.println("Mathematics grades have been entered for the student with ID " + student.getStudentID());
                        phisicsNotes.inputPhisicsNotes();
                        System.out.println("Physics grades have been entered for the student with ID " + student.getStudentID());
                        avgNoteMath = calculate.averageExams(mathNotes.getFirstMidtermExamScore(), mathNotes.getSecondMidtermExamScore(), mathNotes.getFinalExamScore(), mathNotes.getAssignmentScore());
                        mathNoteAvgHashMap.put(student.getStudentID(), avgNoteMath);
                        avgNotePhisics = calculate.averageExams(phisicsNotes.getFirstMidtermExamScore(), phisicsNotes.getSecondMidtermExamScore(), phisicsNotes.getFinalExamScore(), phisicsNotes.getAssignmentScore());
                        phisicsNoteAvgHashMap.put(student.getStudentID(), avgNotePhisics); continue;
                    default:
                        System.out.println("Invalid selection...");
                        break;
                }
            }
            System.out.print("Start a new grade entry process? [yes/no] :");
            yeniIslem = scanner.next();
            if (yeniIslem.equals("no") | !yeniIslem.equals("yes")) {
                if (yeniIslem.equals("no")) {
                    System.out.println("Process is being terminated...");
                } else if (!yeniIslem.equals("yes")) {
                    System.out.println("Invalid input.");
                    System.out.println("Process is being terminated...");
                }
                break;
            }
        } while (true);
        System.out.println("------------------------Mathematics Grades--------------------------");
        for (String key : mathNoteAvgHashMap.keySet()) {
            if (mathNoteAvgHashMap.get(key) >= 50) {
                System.out.println("The student with ID " + key + " has a Mathematics average = " + mathNoteAvgHashMap.get(key) + " [Passed]");
            } else {
                System.out.println("The student with ID " + key + " has a Mathematics average = " + mathNoteAvgHashMap.get(key) + " [Failed]");
            }
        }
        System.out.println("--------------------------Physics Grades---------------------------");
        for (String key : phisicsNoteAvgHashMap.keySet()) {
            if (phisicsNoteAvgHashMap.get(key) >= 50) {
                System.out.println("The student with ID " + key + " has a Physics average = " + phisicsNoteAvgHashMap.get(key) + " [Passed]");
            } else {
                System.out.println("The student with ID " + key + " has a Physics average = " + phisicsNoteAvgHashMap.get(key) + " [Failed]");
            }
        }
    }
}
