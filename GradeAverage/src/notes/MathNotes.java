package notes;

import student.Student;

import java.util.Scanner;

public class MathNotes extends Student {
    private int firstMidtermExamScore;
    private int secondMidtermExamScore;
    private int finalExamScore;
    private int assignmentScore;

    public int getFirstMidtermExamScore() {
        return firstMidtermExamScore;
    }

    public void setFirstMidtermExamScore(int firstMidtermExamScore) {
        this.firstMidtermExamScore = firstMidtermExamScore;
    }

    public int getSecondMidtermExamScore() {
        return secondMidtermExamScore;
    }

    public void setSecondMidtermExamScore(int secondMidtermExamScore) {
        this.secondMidtermExamScore = secondMidtermExamScore;
    }

    public int getFinalExamScore() {
        return finalExamScore;
    }

    public void setFinalExamScore(int finalExamScore) {
        this.finalExamScore = finalExamScore;
    }

    public int getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(int assignmentScore) {
        this.assignmentScore = assignmentScore;
    }

    public void inputMathNotes(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mathematics 1st midterm score: ");
        int firstMidtermExamScore = scanner.nextInt();
        setFirstMidtermExamScore(firstMidtermExamScore);
        System.out.print("Mathematics 2nd midterm score: ");
        int secondMidtermExamScore = scanner.nextInt();
        setSecondMidtermExamScore(secondMidtermExamScore);
        System.out.print("Mathematics final exam score: ");
        int finalExamScore = scanner.nextInt();
        setFinalExamScore(finalExamScore);
        System.out.print("Mathematics assignment score: ");
        int assignmentScore = scanner.nextInt();
        setAssignmentScore(assignmentScore);
    }
}
