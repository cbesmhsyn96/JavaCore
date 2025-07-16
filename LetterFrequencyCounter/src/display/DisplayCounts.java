package display;

import lettercounts.LetterCounter;

import java.util.Map;

public class DisplayCounts extends LetterCounter {
    protected static void displayLetterCounts(Map<Character,Integer> letterCountMap){
        int indis = 0;
        for (Map.Entry ch : letterCountMap.entrySet()){
            if(indis == 0){
                System.out.print("{'"+ch.getKey()+"' karakteri "+ch.getValue()+" tane, ");
            }
            if(indis!=0 && indis < letterCountMap.keySet().size()-1){
                System.out.print("'"+ch.getKey()+"' karakteri "+ch.getValue()+" tane, ");
            }
            if(indis == letterCountMap.keySet().size()-1){
                System.out.print("'"+ch.getKey()+"' karakteri "+ch.getValue()+" tane}");
            }
            indis++;
        }
    }
}
