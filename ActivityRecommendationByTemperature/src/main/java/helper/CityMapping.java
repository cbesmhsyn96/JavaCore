package helper;

import defines.Defines;

public class CityMapping extends Defines {
    protected static void setKeyValueGuncelSehirler() {
        tumSehirler.add("Adana");
        tumSehirler.add("Adıyaman");
        tumSehirler.add("Afyonkarahisar");
        tumSehirler.add("Ağrı");
        tumSehirler.add("Aksaray");
        tumSehirler.add("Amasya");
        tumSehirler.add("Ankara");
        tumSehirler.add("Antalya");
        tumSehirler.add("Ardahan");
        tumSehirler.add("Artvin");
        tumSehirler.add("Aydın");
        tumSehirler.add("Balıkesir");
        tumSehirler.add("Bartın");
        tumSehirler.add("Batman");
        tumSehirler.add("Bayburt");
        tumSehirler.add("Bilecik");
        tumSehirler.add("Bingöl");
        tumSehirler.add("Bitlis");
        tumSehirler.add("Bolu");
        tumSehirler.add("Burdur");
        tumSehirler.add("Bursa");
        tumSehirler.add("Çanakkale");
        tumSehirler.add("Çankırı");
        tumSehirler.add("Çorum");
        tumSehirler.add("Denizli");
        tumSehirler.add("Diyarbakır");
        tumSehirler.add("Düzce");
        tumSehirler.add("Edirne");
        tumSehirler.add("Elazığ");
        tumSehirler.add("Erzincan");
        tumSehirler.add("Erzurum");
        tumSehirler.add("Eskişehir");
        tumSehirler.add("Gaziantep");
        tumSehirler.add("Giresun");
        tumSehirler.add("Gümüşhane");
        tumSehirler.add("Hakkâri");
        tumSehirler.add("Hatay");
        tumSehirler.add("Iğdır");
        tumSehirler.add("Isparta");
        tumSehirler.add("İstanbul");
        tumSehirler.add("İzmir");
        tumSehirler.add("Kahramanmaraş");
        tumSehirler.add("Karabük");
        tumSehirler.add("Karaman");
        tumSehirler.add("Kars");
        tumSehirler.add("Kastamonu");
        tumSehirler.add("Kayseri");
        tumSehirler.add("Kilis");
        tumSehirler.add("Kırıkkale");
        tumSehirler.add("Kırklareli");
        tumSehirler.add("Kırşehir");
        tumSehirler.add("Kocaeli");
        tumSehirler.add("Konya");
        tumSehirler.add("Kütahya");
        tumSehirler.add("Malatya");
        tumSehirler.add("Manisa");
        tumSehirler.add("Mardin");
        tumSehirler.add("Mersin");
        tumSehirler.add("Muğla");
        tumSehirler.add("Muş");
        tumSehirler.add("Nevşehir");
        tumSehirler.add("Niğde");
        tumSehirler.add("Ordu");
        tumSehirler.add("Osmaniye");
        tumSehirler.add("Rize");
        tumSehirler.add("Sakarya");
        tumSehirler.add("Samsun");
        tumSehirler.add("Siirt");
        tumSehirler.add("Sinop");
        tumSehirler.add("Sivas");
        tumSehirler.add("Şanlıurfa");
        tumSehirler.add("Şırnak");
        tumSehirler.add("Tekirdağ");
        tumSehirler.add("Tokat");
        tumSehirler.add("Trabzon");
        tumSehirler.add("Tunceli");
        tumSehirler.add("Uşak");
        tumSehirler.add("Van");
        tumSehirler.add("Yalova");
        tumSehirler.add("Yozgat");
        tumSehirler.add("Zonguldak");
        for (int i = 0; i < tumSehirler.size(); i++) {
            int index = 0;
            char[] letters;
            letters = tumSehirler.get(i).toCharArray();
            while (index < letters.length) {
                if (letters[index] == 'ç' || letters[index] == 'Ç' ||
                        letters[index] == 'ğ' || letters[index] == 'Ğ' ||
                        letters[index] == 'ı' ||
                        letters[index] == 'i' || letters[index] == 'İ' ||
                        letters[index] == 'ö' || letters[index] == 'Ö' ||
                        letters[index] == 'ş' || letters[index] == 'Ş' ||
                        letters[index] == 'ü' || letters[index] == 'Ü' ||
                        letters[index] == 'â') {
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
            keyValueGuncelSehirler.put(tumSehirler.get(i), new String(letters).toLowerCase());
        }
    }
}
