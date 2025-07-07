import javax.swing.text.Style;
import java.rmi.MarshalledObject;
import java.rmi.registry.LocateRegistry;
import java.util.*;
import java.util.regex.Pattern;

public class Runner {
    private static String str;
    private static HashSet<Integer> randIndexWillHaveHidden = new HashSet<>();
    private static Iterator<Integer> iterator;
    private static Random random = new Random();
    private static List<Integer> randomIndexList = new ArrayList<>();
    private static int count;
    private static String hiddenWord;
    private static String text;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Runner.count = count;
    }

    public static String getStr() {
        return str;
    }

    public static void getStrWithIndexs(String getStr) {
        for (int i = 0; i < getStr.length(); i++) {
         System.out.print(getStr.charAt(i)+"{"+i+"}");
         if(i==getStr.length()-1){
             System.out.println();
         }
        }
    }

    public static void setStr(String str) {
        Runner.str = str;
    }

    private static void strGir(){
        do{
            System.out.print("Metin giriniz  :");
            String name = new Scanner(System.in).nextLine();
            setStr(name);
            if(getStr().isEmpty()){
                System.out.println("Lütfen bir metin giriniz...!");
            }
        }while(getStr().isEmpty());
    }

    private static void setRandomIndexToHidden(int count){
        randIndexWillHaveHidden.clear();
        setCount(0);
        if(count<=getStr().length()){
            setCount(count);
            int i = 0;
            while (randIndexWillHaveHidden.size()<getCount()){
                int randIndex = random.nextInt(0,getStr().length());
                if(!randIndexWillHaveHidden.contains(randIndex)){
                    if(getStr().charAt(randIndex)!=' '&&getStr().charAt(randIndex)!='\n'){
                        randIndexWillHaveHidden.add(randIndex);
                        System.out.print(" _"+getStr().charAt(randIndex)+"_");
                        i++;
                    }
                }
            }
            System.out.println();
        }
    }

    private static List<Integer> getRandomIndexList(){
        randomIndexList.clear();
        iterator = randIndexWillHaveHidden.iterator();
        while (iterator.hasNext()){
            randomIndexList.add(iterator.next());
        }
        return randomIndexList;
    }

    private static String getHiddenWord(){
        text = "";
        List<Integer> randIndexs = getRandomIndexList();
        text = getStr();
        char[] chars = text.toCharArray();
        for (int i = 0; i < randIndexs.size(); i++) {
            chars[randIndexs.get(i)]='_';
        }
        return text = String.valueOf(chars);
    }


    private static void gizlikarakterleriListele(){
        System.out.println("Metnin tahmin edilebilecek karakter konumları :");
        List<Integer> randPoints = getRandomIndexList();
        Collections.sort(randPoints);
        for (int letterPoint : randPoints){
            if(randPoints.size()>1){
                if(randPoints.getFirst() == letterPoint){
                    System.out.print("<< "+(letterPoint+1)+". karakter");
                } else if (letterPoint != randPoints.getLast()) {
                    System.out.print(","+(letterPoint+1)+". karakter");
                }else{
                    System.out.println(","+(letterPoint+1)+". karakter >>");
                }
            }
            if(randPoints.size()==1){
                System.out.println("<<"+(letterPoint+1)+". karakter>>");
            }

        }
    }

    private static void switchLetterPointForGuess(){
        List<Integer> randPoints = getRandomIndexList();
        int loopCount = 0;
        do {
            if(loopCount>0){

            }
            System.out.print("Tahmin edeceğiniz karakterin sırasını giriniz :");
            String guessLetterPointAsString = new Scanner(System.in).nextLine();
            if(Pattern.compile("\\d+").matcher(guessLetterPointAsString).matches()){
                int guessLetterPoint = Integer.parseInt(guessLetterPointAsString);
                if(randPoints.contains(guessLetterPoint-1)){
                    System.out.print(guessLetterPoint+". karakter için tahmininiz :");
                    String guessedLetter = new Scanner(System.in).nextLine();
                    if(getStr().charAt(guessLetterPoint-1)==guessedLetter.charAt(0)){
                        System.out.println("Doğru tahmin ettiniz...");
                        randIndexWillHaveHidden.remove(guessLetterPoint-1);
                        if(text.contains("_")){
                            System.out.println(getHiddenWord());
                            gizlikarakterleriListele();
                        }
                        if(getRandomIndexList().isEmpty()){
                            System.out.println("--------------------------------------Doğru kelime --> ["+getStr()+"] Tebrikler...");
                        }

                    }else{
                        System.out.println("--------------------------------------Yanlış tahmin ettiniz...");
                        System.out.println(getHiddenWord());
                        gizlikarakterleriListele();
                        loopCount +=1;
                    }
                }else{
                    System.out.println("Hatalı değer girdiniz.Lütfen listelenen sıra numaralarından birini giriniz...");
                }
            }
        }while (!getRandomIndexList().isEmpty());


    }


    public static void main(String[] args) {
        do {
        strGir();
            getStrWithIndexs(getStr());
            System.out.print("Kaç karakter gizlensin :");
            String countLetter = new Scanner(System.in).nextLine();
            setRandomIndexToHidden(Integer.parseInt(countLetter));
            System.out.println(getHiddenWord());
            System.out.println(getRandomIndexList());
            gizlikarakterleriListele();
            switchLetterPointForGuess();
            randIndexWillHaveHidden.clear();
        }while (true);



    }
}