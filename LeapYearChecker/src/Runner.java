import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Runner extends IsLeap{
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year :");
        String yearValue = scanner.nextLine();*/
        int fromYear, toYear;
        Pattern pattern = Pattern.compile("^[1-9][0-9]{1,8}$");
        do {
            System.out.print("\n----------------Program is Starting----------------");
            System.out.print("\nFrom year :");
            String fromIntString = new Scanner(System.in).nextLine();
            System.out.print("To year :");
            String toIntString = new Scanner(System.in).nextLine();
            if(pattern.matcher(fromIntString).matches()&&pattern.matcher(toIntString).matches()){
                fromYear = Integer.parseInt(fromIntString);
                toYear = Integer.parseInt(toIntString);
                if (toYear<=fromYear){
                    System.out.println("The variable from number is bigger than or equals to number...!");
                }else{
                        isLeapRange(fromYear,toYear);
                }
            }else {
                System.out.println("You entered an invalid number...!");
            }
        }while (true);
        }

    }
