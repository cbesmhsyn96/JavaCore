package process;

import display.TextDisplay;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GuessEngine extends TextDisplay {

    private static String getGuessPosition() {
        System.out.print("                                       Enter the index of the character you want to guess: ");
        guessLetterPointAsString = new Scanner(System.in).nextLine();
        return guessLetterPointAsString;
    }

    private static String guessALetter() {
        do {
            System.out.print("                                       Your guess for letter " + Integer.parseInt(guessLetterPointAsString) + ": ");
            guessedLetter = new Scanner(System.in).nextLine();
            if (!singleLetterPattern.matcher(guessedLetter).matches()) {
                System.out.println("                               <<<<<<<<<<<<<<Invalid input. Please enter a letter only...>>>>>>>>>>>>>>>>>>");
            }
        } while (!singleLetterPattern.matcher(guessedLetter).matches());
        return guessedLetter;
    }

    private static void letterGuessCoveredMethod() {
        if (positiveIntegerPattern.matcher(guessLetterPointAsString).matches()) {
            int guessLetterPoint = Integer.parseInt(guessLetterPointAsString);
            randPoints = getRandomIndexList();
            if (guessLetterPoint <= getStr().length()) {
                if (randPoints.contains(guessLetterPoint - 1)) {
                    guessALetter();
                    if (getStr().charAt(guessLetterPoint - 1) == guessedLetter.charAt(0) && guessedLetter.length() == 1) {
                        System.out.println("                            ======================================== SPOT OP! YOU GUESSED IT RIGHT ========================================");
                        // The index of the correctly guessed character is removed from randIndexSetWillHaveHiddenText.
                        randIndexSetWillHaveHiddenText.remove(guessLetterPoint - 1);
                        if (getRandomIndexList().isEmpty()) {
                            System.out.println("                        ************************************** Congratulations, you won the game! Correct text --> [" + getStr() + "] **************************************"
                            );
                        }
                    } else {
                        System.out.println("                        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Incorrect guess...!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        loopCount += 1;
                    }
                } else {
                    System.out.println("                                 <<<<<<<<<<<<<<<<<Invalid value. Please enter one of the listed index numbers...>>>>>>>>>>>>>>>>>");
                }
                if (loopCount == loopBound) {
                    System.out.println("\n\n\n\n\n\n\n\n              !!!!!!!!!!!!!!!!!!!!!!!!!!-----!!!!!!!!!!!!!!!!!!!!!!!!!!-----GAME OVER-----!!!!!!!!!!!!!!!!!!!!!!!!!!-----!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n\n\n\n\n");
                }
            } else {
                System.out.println("                                 <<<<<<<<<<<<<<Please enter a value within the length of the word you entered...>>>>>>>>>>>>>>>>>");
            }
        } else {
            System.out.println("                                   <<<<<<<<<<<<<<Only positive numbers are allowed. Please enter a number greater than 0...>>>>>>>>>>>>>>>>>>\n");
        }
    }

    protected static void switchLetterPointForGuess() {
        do {
            if (loopBound - loopCount > 0) {
                System.out.println("---------------------------------------------------------[" + (loopBound - loopCount) + " wrong guesses remaining.]-------------------------------------------------------------------");
                System.out.println("                                <*><> < * > <><*><> < * > <><*><> < * > <><*><> < * > <><*><> < * > <><*><> < * > <><*><> < * > <><*>");
                System.out.println("                                       Hidden word ==> " + getHiddenWord());
                gizlikarakterleriListele();
                if (!randIndexSetWillHaveHiddenText.isEmpty()) {
                    getGuessPosition();
                    letterGuessCoveredMethod();
                }
            }
            // Meaning of !getRandomIndexList().isEmpty():
            // getRandomIndexList() returns a list containing the indexes from randIndexSetWillHaveHiddenText.
            // So, when we change randIndexSetWillHaveHiddenText, getRandomIndexList() reflects those changes too.
            // In other words, this block continues to execute as long as there are characters left to guess.
        } while (!getRandomIndexList().isEmpty());
    }

}