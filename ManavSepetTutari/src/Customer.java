import java.util.*;

public class Customer {
    public static List<Double> urunToplamlari = new ArrayList<>();
    public static HashMap<String,Integer> sepetUrunListesi = new HashMap<>();
    public static List<Integer> urunAdetleri = new ArrayList<>();
         /*
        ____Müşteri İşlemleri____
        1. Sepete ürün ekleme     tamam
        2. Sepetten ürün çıkarma   ---
        3. Toplam Tutar hesaplama tamam
        4. Listeleme              tamam
        Listelemede ürün sayısındaki bozukluk giderildi.
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
            urunToplamlari.add(birimFiyat * urunAdedi);
        }

        /*
            Sepetten ürün çıkarma
            scanner kontrol string(int de kabul eden)
            toplam tutar - sepet tutarı (for ( : ))
            sepetteki ürünler hashmapi .remove
        */


        public static double sepetToplami(){
            double sepetToplami = 0.0;
            for (double toplam : urunToplamlari) {
                sepetToplami += toplam;
            }
            return sepetToplami;
        }

        public static int urunAdediToplam(){
            int urunAdediToplami = 0;
            for (int urunAdedi : urunAdetleri) {
                urunAdediToplami += urunAdedi;
            }
            return urunAdediToplami;
        }

        public static void sepettekiUrunListesiniGetir(HashMap<String,Double> urunKayitlari){
                System.out.println("--------------Sepetteki ürünler--------------");
                double guncelValue;
                String guncelK = "";
                for(Map.Entry sepettekiUrun : sepetUrunListesi.entrySet()){
                        List<String> keyList = urunKayitlari.keySet().stream().toList();
                        for (String currentKey : keyList){
                            if (sepettekiUrun.getKey().toString().contains(currentKey)&&sepettekiUrun.getKey().toString().length()>currentKey.length()){
                                guncelK = currentKey;
                                System.out.println("<Ürün adı --> "+sepettekiUrun.getKey()+"> <Ürün adedi = "+sepettekiUrun.getValue()+"> "+"<Ürün birim fiyatı = "+urunKayitlari.get(guncelK)+"TL>");
                                break;
                            }
                        }
                        if(urunKayitlari.get(sepettekiUrun.getKey())!=null){
                            System.out.println("<Ürün adı --> "+sepettekiUrun.getKey()+"> <Ürün adedi = "+sepettekiUrun.getValue()+"> "+"<Ürün birim fiyatı = "+urunKayitlari.get(sepettekiUrun.getKey())+"TL>");
                        }
                }


                    System.out.println("Sepet tutarı "+sepetToplami()+" TL' dir.");
                    System.out.println("Sepette "+urunAdediToplam()+" ürün bulunmaktadır.");



        }

}
