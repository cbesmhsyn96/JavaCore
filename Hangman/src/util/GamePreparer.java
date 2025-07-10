package util;

import input.InputManager;

import java.util.List;

public class GamePreparer extends InputManager {
    //Metinde gizlenecek karakter sayısı parametre ile alınıp metindeki karakterlerin indislerin aralığında
    //olacak şekilde bu sayı kadar rastgele indis numarası randIndexSetWillHaveHiddenText setine atanıyor.
    protected static void setRandomIndexToHidden(int count){
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
    protected static List<Integer> getRandomIndexList(){
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
    protected static String getHiddenWord(){
        text = "";
        List<Integer> randIndexs = getRandomIndexList();
        text = getStr();
        char[] chars = text.toCharArray();
        for (int i = 0; i < randIndexs.size(); i++) {
            chars[randIndexs.get(i)]='_';
        }
        return text = String.valueOf(chars);
    }
}
