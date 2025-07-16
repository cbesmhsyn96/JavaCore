package lettercounts;

import vars.Defines;

import java.util.Map;
import java.util.regex.Pattern;

public class LetterCounter extends Defines {

    protected static Map<Character,Integer> letterCounter(){
        do {
            System.out.print("Dizge gir : ");
            str = scanner.nextLine();
            if(!Pattern.compile("^[A-Za-zışğüçöİŞÇÖÜ]+$").matcher(str).matches()){
                System.out.println("Lütfen boşluk ve işaretsiz bir dizge giriniz...");
            }
        }while (!Pattern.compile("^[A-Za-zışğüçöİŞÇÖÜ]+$").matcher(str).matches());
        int count;
        int j;
        for (int i = 0; i < str.length(); i++) {
            if(i==0){
                count = 1;
                chrs.put(str.charAt(i),count);
            }else {
                if(!chrs.keySet().contains(str.charAt(i))){
                    count = 1;
                    chrs.put(str.charAt(i),count);
                }else{
                    count = 0;
                    j = 0;
                    while (j<=i){
                        if(str.charAt(j)==str.charAt(i)){
                            count++;
                        }
                        j++;
                    }
                    chrs.replace(str.charAt(i),count);
                }
            }
        }
        return chrs;
    }


}
