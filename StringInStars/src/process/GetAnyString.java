package process;

import letters.InitializeLetterStrings;

public class GetAnyString extends InitializeLetterStrings {

    private static void initializeStarsWithString(String str){
        char[] chars = str.toCharArray();
        stars = initializeString();
        for (int index = 0; index < 5; index++) {
            for (char ch : chars){
                System.out.print(stars.get(ch)[index]);
            }
            System.out.println();
        }
    }
    protected static void getAnyStringFromUser(){
        System.out.print("Please enter a string in lowercase (Turkish characters are allowed) :");
        String input = scanner.nextLine();
        if(inputPattern.matcher(input).matches()){
            initializeStarsWithString(input);
        }
    }
}
