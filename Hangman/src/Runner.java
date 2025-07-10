import process.GuessEngine;
import java.util.*;
import java.util.regex.Pattern;

public class Runner extends GuessEngine {

    public static void main(String[] args) {
        String countLetter;
        String continueStatus = "";
        do {
            do {
                do {
                    strGir();
                    System.out.print("                                       How many characters should be hidden: ");
                    countLetter = new Scanner(System.in).nextLine();
                    if(!positiveIntegerPattern.matcher(countLetter).matches()){
                        System.out.println("              !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Invalid input format. Please enter a positive integer...!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                } while (!positiveIntegerPattern.matcher(countLetter).matches());
                if(Integer.parseInt(countLetter)>getStr().length()){
                    System.out.println("                     !!!!!!!!!!!!!!>>>>>>>>>>>>>>The number you entered cannot be greater than the length of the text.<<<<<<<<<<<<<<!!!!!!!!!!!!!!");
                }
            }while (Integer.parseInt(countLetter)>getStr().length());
            setRandomIndexToHidden(Integer.parseInt(countLetter));
            switchLetterPointForGuess();
            randIndexSetWillHaveHiddenText.clear();
            do {
                System.out.print("                                       Do you want to start a new game? [yes|no] :");
                continueStatus= new Scanner(System.in).nextLine();
                if(yesNoPattern.matcher(continueStatus).matches()){
                    if(continueStatus.equals("no")){
                        System.out.println("                                       Ending the game...");
                        System.out.println("\n\n\n\n\n\n\n\n                                              >>>>>>>>>>>>>>>>>>>>>>>>HOPE TO SEE YOU AGAIN SOON!<<<<<<<<<<<<<<<<<<<<<<<<\n\n\n\n\n");
                    } else if(continueStatus.equals("yes")){
                        System.out.println("                                       >>>>>>>>>>>>>>>>>>>>>>>>>>>A new game is starting...");
                    }
                }else{
                    System.out.println("              !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Invalid input format. Please enter only 'yes' or 'no'.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            }while (!continueStatus.equals("no")&&!continueStatus.equals("yes"));
        } while (continueStatus.equals("yes"));

    }
}
