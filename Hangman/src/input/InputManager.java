package input;

import var.Defines;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputManager extends Defines {
    // Helper methods to get input and set the number of characters to be hidden
    protected static int getCount() {
        return count;
    }
    protected static void setCount(int count) {
        Defines.count = count;
    }
    protected static String getStr() {
        return str;
    }
    protected static void setStr(String str) {
        Defines.str = str;
    }

    // Get input from console
    protected static void strGir(){
        System.out.println("                                                 >>>>>>>>>>>>>>>>>>>>>>>>WELCOME TO HANGMAN GAME<<<<<<<<<<<<<<<<<<<<<<<<                ");
        do {
            System.out.print("                                       Enter a word or sentence: ");
            String name = new Scanner(System.in).nextLine();
            if(alphabeticInputPattern.matcher(name).matches()){
                setStr(name);
            }else{
                System.out.println("");
                setStr("");
            }
            if(getStr().isEmpty()){
                System.out.println("                 !!!!!!!!!!!!!!!!Please enter a text that begins with a letter and may include letters and spaces only.!!!!!!!!!!!!!!!!");
            }
        } while(getStr().isEmpty());
    }
}