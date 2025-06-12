package calculate;
public class Calculate {
    public int averageExams(int firstMidtermExamScore,int secondMidtermExamScore, int finalExamScore, int assignmentScore){
        return (int)Math.ceil((double) ((firstMidtermExamScore*30+secondMidtermExamScore*30+finalExamScore*40)/100+assignmentScore)/2);
    }
}
