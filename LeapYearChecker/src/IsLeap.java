import java.time.LocalDate;
import java.time.Month;

public class IsLeap {
    protected static void isLeapRange(int fromYear, int toYear){
        for (int currentYear=fromYear; currentYear < toYear; currentYear++) {
            if(LocalDate.of(currentYear, Month.of(1),1).isLeapYear()){
                System.out.println(currentYear+" is leap year.");
                LocalDate localeDateStart = LocalDate.of(currentYear,1,1);
                LocalDate localeDateEnd = LocalDate.of(currentYear,12,31);
                int count =1;
                for (LocalDate i = localeDateStart; i.isBefore(localeDateEnd); i = i.plusDays(1)) {
                    System.out.printf("[%2d/%2d/%2d] ",i.getDayOfMonth(),i.getMonthValue(),i.getYear());
                    if(count>=10){
                        if(Math.ceilMod(count,11) == 0){
                            System.out.println();
                        }
                    }
                    count++;
                }
            }else{
                System.out.print("\n"+currentYear+" is not leap year.");
            }
        }
    }
}
