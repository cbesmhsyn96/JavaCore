import java.util.*;
import java.util.zip.ZipEntry;

public class TryingTwo {
    protected static HashMap<String,String> keyValueGuncelSehirler = new HashMap<>();
    protected static void setKeyValueGuncelSehirler(){
        List<String> turkceHarfIcerenSehirler = new ArrayList<>();
        turkceHarfIcerenSehirler.add("Adıyaman");
        turkceHarfIcerenSehirler.add("Afyonkarahisar");
        turkceHarfIcerenSehirler.add("Aydın");
        turkceHarfIcerenSehirler.add("Balıkesir");
        turkceHarfIcerenSehirler.add("Bilecik");
        turkceHarfIcerenSehirler.add("Çanakkale");
        turkceHarfIcerenSehirler.add("Çankırı");
        turkceHarfIcerenSehirler.add("Çorum");
        turkceHarfIcerenSehirler.add("Diyarbakır");
        turkceHarfIcerenSehirler.add("Elazığ");
        turkceHarfIcerenSehirler.add("Eskişehir");
        turkceHarfIcerenSehirler.add("Gümüşhane");
        turkceHarfIcerenSehirler.add("Hakkâri");
        turkceHarfIcerenSehirler.add("Iğdır");
        turkceHarfIcerenSehirler.add("Isparta");
        turkceHarfIcerenSehirler.add("İstanbul");
        turkceHarfIcerenSehirler.add("İzmir");
        turkceHarfIcerenSehirler.add("Kahramanmaraş");
        turkceHarfIcerenSehirler.add("Karabük");
        turkceHarfIcerenSehirler.add("Kırıkkale");
        turkceHarfIcerenSehirler.add("Kırklareli");
        turkceHarfIcerenSehirler.add("Kırşehir");
        turkceHarfIcerenSehirler.add("Kocaeli");
        turkceHarfIcerenSehirler.add("Kütahya");
        turkceHarfIcerenSehirler.add("Malatya");
        turkceHarfIcerenSehirler.add("Mardin");
        turkceHarfIcerenSehirler.add("Muğla");
        turkceHarfIcerenSehirler.add("Muş");
        turkceHarfIcerenSehirler.add("Nevşehir");
        turkceHarfIcerenSehirler.add("Niğde");
        turkceHarfIcerenSehirler.add("Sakarya");
        turkceHarfIcerenSehirler.add("Siirt");
        turkceHarfIcerenSehirler.add("Şanlıurfa");
        turkceHarfIcerenSehirler.add("Şırnak");
        turkceHarfIcerenSehirler.add("Tekirdağ");
        turkceHarfIcerenSehirler.add("Tunceli");
        turkceHarfIcerenSehirler.add("Uşak");
        turkceHarfIcerenSehirler.add("Düzce");
        turkceHarfIcerenSehirler.add("Bartın");
        turkceHarfIcerenSehirler.add("Bayburt");
        for (int i = 0; i < turkceHarfIcerenSehirler.size(); i++) {
            int index = 0;
            char[] letters;
            letters = turkceHarfIcerenSehirler.get(i).toCharArray();
            while (index<letters.length){
                if(letters[index] == 'ç' || letters[index] == 'Ç' ||
                        letters[index] == 'ğ' || letters[index] == 'Ğ' ||
                        letters[index] == 'ı' ||
                        letters[index] == 'i' || letters[index] == 'İ' ||
                        letters[index] == 'ö' || letters[index] == 'Ö' ||
                        letters[index] == 'ş' || letters[index] == 'Ş' ||
                        letters[index] == 'ü' || letters[index] == 'Ü' ||
                        letters[index] == 'â'){
                    if (letters[index] == 'ç' || letters[index] == 'Ç') {
                        letters[index] = 'c';
                    } else if (letters[index] == 'ğ' || letters[index] == 'Ğ') {
                        letters[index] = 'g';
                    } else if (letters[index] == 'ı') {
                        letters[index] = 'i';
                    } else if (letters[index] == 'İ') {
                        letters[index] = 'i';
                    } else if (letters[index] == 'ö' || letters[index] == 'Ö') {
                        letters[index] = 'o';
                    } else if (letters[index] == 'ş' || letters[index] == 'Ş') {
                        letters[index] = 's';
                    } else if (letters[index] == 'ü' || letters[index] == 'Ü') {
                        letters[index] = 'u';
                    } else if (letters[index] == 'â') {
                        letters[index] = 'a';
                    }
                }
                index++;
            }
            keyValueGuncelSehirler.put(turkceHarfIcerenSehirler.get(i),new String(letters).toLowerCase());
        }
    }
    public static void main(String[] args) {

        
    }
}
