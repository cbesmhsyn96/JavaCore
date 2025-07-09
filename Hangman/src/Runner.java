import javax.swing.text.Style;
import java.rmi.MarshalledObject;
import java.rmi.registry.LocateRegistry;
import java.util.*;
import java.util.regex.Pattern;

public class Runner {
    private static String str;
    private static HashSet<Integer> randIndexSetWillHaveHiddenText = new HashSet<>();
    private static Iterator<Integer> iterator;
    private static Random random = new Random();
    private static List<Integer> randomIndexList = new ArrayList<>();
    private static int count;
    private static String text;


    //Metin alma ve gizlenecek karakterlerin sayısını belirleme yardımcı metotlar
    public static int getCount() {
        return count;
    }
    public static void setCount(int count) {
        Runner.count = count;
    }
    public static String getStr() {
        return str;
    }
    public static void setStr(String str) {
        Runner.str = str;
    }


    //belirlenen metindeki karakterleri indisle gösterme
    public static void getStrWithIndexs(String getStr) {
        for (int i = 0; i < getStr.length(); i++) {
         System.out.print(getStr.charAt(i)+"{"+i+"}");
         if(i==getStr.length()-1){
             System.out.println();
         }
        }
    }
    //Console' dan metin alma
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
    //Metinde gizlenecek karakter sayısı parametre ile alınıp metindeki karakterlerin indislerin aralığında
    //olacak şekilde bu sayı kadar rastgele indis numarası randIndexSetWillHaveHiddenText setine atanıyor.
    private static void setRandomIndexToHidden(int count){
        randIndexSetWillHaveHiddenText.clear();
        setCount(0);
        if(count<=getStr().length()){
            setCount(count);
            int i = 0;
            while (randIndexSetWillHaveHiddenText.size()<getCount()){
                int randIndex = random.nextInt(0,getStr().length());
                if(!randIndexSetWillHaveHiddenText.contains(randIndex)){
                    if(getStr().charAt(randIndex)!=' '&&getStr().charAt(randIndex)!='\n'){
                        randIndexSetWillHaveHiddenText.add(randIndex);
                        i++;
                    }
                }
            }

        }
    }
    //randIndexSetWillHaveHiddenText setindeki değerler randomIndexList listesine alınıyor
    private static List<Integer> getRandomIndexList(){
        randomIndexList.clear();
        iterator = randIndexSetWillHaveHiddenText.iterator();
        while (iterator.hasNext()){
            randomIndexList.add(iterator.next());
        }
        return randomIndexList;
    }
    //setRandomIndexToHidden metoduyla belirlenen rastgele indislerdeki karakterler
    //_ ile değiştirilir. Burada değiştirilme en başta alınan metin üzerinde değil
    //text isminde static bir değişken üzerinde yapılıyor.
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


    //metindeki gizli karakterlerin metinde kaçıncı karakter olduğunun listelenmesi
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


    //adam asmaca oyunu ana metodu
    private static void switchLetterPointForGuess(){
        List<Integer> randPoints = getRandomIndexList();
        int loopCount = 0;
        int loopBound = 3;
        System.out.println(getHiddenWord());
        gizlikarakterleriListele();
        do {
            System.out.println("["+(loopBound-loopCount)+" yanlış tahmin hakkınız kaldı.]");
            System.out.print("Tahmin edeceğiniz karakterin sırasını giriniz :");
            String guessLetterPointAsString = new Scanner(System.in).nextLine();
            if(Pattern.compile("\\d+").matcher(guessLetterPointAsString).matches()){
                int guessLetterPoint = Integer.parseInt(guessLetterPointAsString);
                if(guessLetterPoint<=getStr().length()){
                    if(randPoints.contains(guessLetterPoint-1)){
                        System.out.print(guessLetterPoint+". karakter için tahmininiz :");
                        String guessedLetter = new Scanner(System.in).nextLine();
                        if(getStr().charAt(guessLetterPoint-1)==guessedLetter.charAt(0)){
                            System.out.println("Doğru tahmin ettiniz...");
                            //Doğru tahmin edilen karakterin bulunduğu index randIndexSetWillHaveHiddenText
                            //setinden siliniyor.
                            randIndexSetWillHaveHiddenText.remove(guessLetterPoint-1);
                            //Doğru tahminden sonra güncel metinde en az 1 tane _ varsa gizli metin ve
                            //kullanıcının tahmin edebileceği karakterlerin metindeki sıraları kullanıcıya listeleniyor.
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
                    if(loopCount==loopBound){
                        System.out.println("Yanlış girme haklarınız tükendi. Oyunu kaybettiniz...!");
                        break;
                    }
                }else{
                    System.out.println("Lütfen en fazla girdiğiniz metin uzunluğunun değerini giriniz...");
                }
            }
            //buradaki !getRandomIndexList().isEmpty() anlamı;
            //getRandomIndexList() metodu randIndexSetWillHaveHiddenText e
            //eklenen random indexleri listeye ekleyip oluşan listeyi döner.
            //bu yüzden randIndexSetWillHaveHiddenText te bir değişiklik yaptığımızda
            //getRandomIndexList() metodunda da aynı değişiklik olur.
            //Yani tahmin edilebilecek bir gizli karakter var olduğu sürece
            //bu bloktaki kodlar çalışmaya devam eder.
        }while (!getRandomIndexList().isEmpty());
    }


    public static void main(String[] args) {
        do {
            strGir();
            getStrWithIndexs(getStr());
            System.out.print("Kaç karakter gizlensin :");
            String countLetter = new Scanner(System.in).nextLine();
            setRandomIndexToHidden(Integer.parseInt(countLetter));
            switchLetterPointForGuess();
            randIndexSetWillHaveHiddenText.clear();
        }while (true);



    }
}