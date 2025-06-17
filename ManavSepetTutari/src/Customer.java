import java.util.*;

public class Customer {

    public static HashMap<String,Integer> sepetUrunListesi = new LinkedHashMap<>();
    public static List<Integer> urunAdetleri = new ArrayList<>();

    public static HashMap<String,Double> urunKayitListesi = new LinkedHashMap<>();
    public static HashMap<String,Double> urunSepetToplamlari = new LinkedHashMap<>();
    public static double toplam=0;
         /*
        ____Müşteri İşlemleri____
        1. Sepete ürün ekleme     tamam
        2. Sepetten ürün çıkarma  tamam
        3. Toplam Tutar hesaplama tamam
        4. Listeleme              tamam
         */

        public static void sepeteUrunEkle(HashMap<String,Double> urunKayitlari,String urunAdi, int urunAdedi) {
            int i = 1;
            Double birimFiyat = urunKayitlari.get(urunAdi);
            String key = urunAdi;
            if (sepetUrunListesi.containsKey(key)) {
                while (sepetUrunListesi.containsKey(key)) {
                    key = urunAdi + i;
                    i++;
                }
            }
            urunAdetleri.add(urunAdedi);
            sepetUrunListesi.put(key, urunAdedi);

            System.out.println(birimFiyat * urunAdedi + " TL sepet tutarı eklendi.");
            urunSepetToplamlari.put(key,birimFiyat * urunAdedi);
        }

        /*
            Sepetten ürün çıkarma
            scanner kontrol string(int de kabul eden)
            toplam tutar - sepet tutarı (for ( : ))
            sepetteki ürünler hashmapi .remove
        */


        public static double sepetToplami(){
            for (double urunSepetTutari : urunSepetToplamlari.values()){
                toplam = toplam + urunSepetTutari;
            }
            return toplam;
        }

        public static int urunAdediToplam(){
            int urunAdediToplami = 0;
            for (int urunAdedi : urunAdetleri) {
                urunAdediToplami += urunAdedi;
            }
            return urunAdediToplami;
        }

        public static void sepettenUrunCikar(HashMap<String,Double> urunKayitlari,String sepettenCikacakUrunAdi, int sepettenCikacakUrunSayisi){
            int guncelAdet;
            boolean sepetUrunSilStatus = false;

            for (String currentKey : sepetUrunListesi.keySet()){
                if(sepettenCikacakUrunAdi.equals(currentKey)){
                    for(String currentUnitProductName : urunKayitlari.keySet()){
                        if(currentKey.equals(currentUnitProductName)){
                            if(sepetUrunListesi.get(currentKey)==sepettenCikacakUrunSayisi){
                                sepetUrunSilStatus = true;
                            }else{
                                sepetUrunSilStatus = false;
                                guncelAdet = sepetUrunListesi.get(currentKey) - sepettenCikacakUrunSayisi;
                                sepetUrunListesi.replace(currentKey,guncelAdet);
                                urunSepetToplamlari.replace(currentKey,sepetUrunListesi.get(currentKey)*urunKayitlari.get(currentKey));
                            }
                        }else if(currentKey.startsWith(currentUnitProductName)){
                            if(sepetUrunListesi.get(currentKey)==sepettenCikacakUrunSayisi){
                                sepetUrunSilStatus = true;
                            }else{
                                sepetUrunSilStatus = false;
                                guncelAdet = sepetUrunListesi.get(currentKey) - sepettenCikacakUrunSayisi;
                                sepetUrunListesi.replace(currentKey,guncelAdet);
                                urunSepetToplamlari.replace(currentKey,sepetUrunListesi.get(currentKey)*urunKayitlari.get(currentUnitProductName));
                            }
                        }
                    }
                }
            }

            if(sepetUrunSilStatus){
                urunSepetToplamlari.remove(sepettenCikacakUrunAdi);
                sepetUrunListesi.remove(sepettenCikacakUrunAdi);
            }
        }

        public static void sepettekiUrunListesiniGetir(HashMap<String,Double> urunKayitlari){
            System.out.println("--------------Sepetteki ürünler--------------");
            for (String currentKey : sepetUrunListesi.keySet()){
                for(String currentUnitProductName : urunKayitlari.keySet()){
                    if(currentKey.equals(currentUnitProductName)){
                        urunSepetToplamlari.put(currentKey,sepetUrunListesi.get(currentKey)*urunKayitlari.get(currentUnitProductName));
                        System.out.println("{"+currentKey+","+sepetUrunListesi.get(currentKey)+" adet} Toplam = "+sepetUrunListesi.get(currentKey)*urunKayitlari.get(currentUnitProductName));
                    }else if(currentKey.startsWith(currentUnitProductName)){
                        urunSepetToplamlari.put(currentKey,sepetUrunListesi.get(currentKey)*urunKayitlari.get(currentUnitProductName));
                        System.out.println("{"+currentKey+","+sepetUrunListesi.get(currentKey)+" adet} Toplam = "+sepetUrunListesi.get(currentKey)*urunKayitlari.get(currentUnitProductName));
                    }
                }
            }
                    System.out.println("Sepet tutarı "+sepetToplami()+" TL' dir.");
            toplam = 0;
                    //System.out.println("Sepette "+urunAdediToplam()+" ürün bulunmaktadır.");
        }

}
