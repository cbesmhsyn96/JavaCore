import java.util.*;

public class Customer {

    static Scanner scanner = new Scanner(System.in);
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
            toplam = 0;
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
        }

        public static void musteriSepeteUrunEkleme(boolean sepeteEklemeyeDevamStatusStarting, HashMap<String,Double> urunKayitlari){
            boolean alisveriseDevamStatus = sepeteEklemeyeDevamStatusStarting;
            do{
                System.out.println("--------Sepete ürün ekleme başlıyor--------");
                if(!urunKayitlari.isEmpty()){
                    Admin.urunKayitlariListele(urunKayitlari);
                    if(!Customer.sepetUrunListesi.isEmpty()){
                        Customer.sepettekiUrunListesiniGetir(urunKayitlari);
                    }
                    System.out.print("Sepete eklenecek ürün adı :");
                    String urunAdi = scanner.nextLine();
                    System.out.print("Sepete eklenecek ürünün adedi :");
                    String urunAdedi = scanner.nextLine();
                    if(ValidityCheck.stringPattern.matcher(urunAdi).matches()&& ValidityCheck.intPattern.matcher(urunAdedi).matches()){
                        if (urunKayitlari.containsKey(urunAdi)){
                            Customer.sepeteUrunEkle(urunKayitlari,urunAdi, Integer.parseInt(urunAdedi));
                            System.out.print("Ürün eklemeye devam edilsin mi[evet[e]/hayır[h]] :");
                            String eklemeyeDevamDurumu = scanner.nextLine();
                            if (ValidityCheck.stringPattern.matcher(eklemeyeDevamDurumu).matches()){
                                if (eklemeyeDevamDurumu.equals("e")||eklemeyeDevamDurumu.equals("h")){
                                    if(eklemeyeDevamDurumu.equals("e")){
                                        alisveriseDevamStatus=true;
                                    }else{
                                        System.out.println("Ürün ekleme sonlandırılıyor...");
                                        alisveriseDevamStatus = false;
                                    }
                                }
                            }else{
                                System.out.println("Geçersiz giriş yaptınız...!");
                                alisveriseDevamStatus = false;

                            }
                        }
                        //alisveriseDevamStatus = false;
                        else {
                            System.out.println("Sepete eklemek istediğiniz ürün stokta yok...!");
                            System.out.print("Ürün eklemeye devam edilsin mi[evet[e]/hayır[h]] :");
                            String eklemeyeDevamDurumu = scanner.nextLine();
                            if (ValidityCheck.stringPattern.matcher(eklemeyeDevamDurumu).matches()){
                                if (eklemeyeDevamDurumu.equals("e")||eklemeyeDevamDurumu.equals("h")){
                                    if(eklemeyeDevamDurumu.equals("e")){
                                        alisveriseDevamStatus=true;
                                    }else{
                                        System.out.println("Ürün ekleme sonlandırılıyor...");
                                        alisveriseDevamStatus = false;
                                    }
                                }
                            }else{
                                System.out.println("Geçersiz giriş yaptınız...!");
                                break;
                            }
                        }
                    }else{
                        System.out.println("Geçersiz değer girdiniz. Ürün bilgilerini tekrar girin...");
                        alisveriseDevamStatus = true;
                    }
                }else{
                    System.out.println("Sepete eklenecek ürün bulunmamaktadır...");
                    alisveriseDevamStatus = false;
                }
            }while(alisveriseDevamStatus==true);
        }

        public static void musteriSepettenUrunCikarma(boolean sepettenCikarmayaDevamStatusStarting, HashMap<String,Double> urunKayitlari){
            boolean sepettenCikarDevamStatus = sepettenCikarmayaDevamStatusStarting;
            do{
                Customer.sepettekiUrunListesiniGetir(urunKayitlari);
                if(!urunKayitlari.isEmpty()){
                    System.out.print("Sepetten çıkarılacak ürün adı :");
                    String cikarilacakUrunAdi = scanner.nextLine();
                    System.out.print("Sepetten çıkarılacak ürünün adedi :");
                    String cikarilacakUrunAdedi = scanner.nextLine();
                    boolean cikarilacakUrunAdiStr = ValidityCheck.passwordPattern.matcher(cikarilacakUrunAdi).matches();
                    boolean cikarilacakUrunAdediInt = ValidityCheck.intPattern.matcher(cikarilacakUrunAdedi).matches();
                    if(cikarilacakUrunAdiStr && cikarilacakUrunAdediInt){
                        if(Customer.sepetUrunListesi.containsKey(cikarilacakUrunAdi)){
                            if(Customer.sepetUrunListesi.get(cikarilacakUrunAdi)>=Integer.parseInt(cikarilacakUrunAdedi) ){
                                Customer.sepettenUrunCikar(urunKayitlari,cikarilacakUrunAdi,Integer.parseInt(cikarilacakUrunAdedi));
                                System.out.print("Sepetten ürün çıkarmaya devam edilsin mi [evet[e]/hayır[h]]  :");
                                String cikarmayaDevam = scanner.nextLine();
                                if(ValidityCheck.stringPattern.matcher(cikarmayaDevam).matches()){
                                    if (cikarmayaDevam.equals("e")||cikarmayaDevam.equals("h")){
                                        if(cikarmayaDevam.equals("e")){
                                            sepettenCikarDevamStatus = true;
                                        }else{
                                            System.out.println("Ürün çıkarma sonlandırılıyor...");
                                            sepettenCikarDevamStatus = false;
                                        }
                                    }
                                }else{
                                    System.out.println("Hatalı giriş yaptınız...!");
                                    sepettenCikarDevamStatus = false;
                                }

                            }else{
                                System.out.println("Sepetteki "+cikarilacakUrunAdi+" ürün adedinden fazla bir değer girdiniz...!");
                                sepettenCikarDevamStatus = true;
                            }
                        }
                        else{
                            System.out.println(cikarilacakUrunAdi+" adlı ürün sepette yok...");
                            sepettenCikarDevamStatus = true;
                        }
                    }else{
                        System.out.println("Geçersiz değer girdiniz. Ürün bilgilerini tekrar girin...");
                        sepettenCikarDevamStatus = true;
                    }
                }else{
                    System.out.println("Kayıtlı ürün bulunmamaktadır...");
                    sepettenCikarDevamStatus = false;
                }
            }while(sepettenCikarDevamStatus == true);
        }

        public static void musteriSepettekileriListeleme(HashMap<String,Double> urunKayitlari){
            if(!Customer.sepetUrunListesi.isEmpty()){
                Customer.sepettekiUrunListesiniGetir(urunKayitlari);
            }else {
                System.out.println("Sepette ürün yok.");
            }
        }

        public static void musteriSepetTutariHesaplama(){
            double toplamTutar = Customer.sepetToplami();
            if(toplamTutar != 0.0){
                System.out.println("Toplam sepet tutarı = "+toplamTutar);
            }else{
                System.out.println("Sepet boş. Lüften sepete ürün ekleyin...!");
            }
        }


        public static void musteriCoveredMethod_allMusteriMethods(boolean musteriIslemeDevamStatusStarting, HashMap<String,Double> urunKayitlari){
            boolean musteriIslemeDevamStatus = musteriIslemeDevamStatusStarting;
            do {
                System.out.println("-------------Müşteri işlemleri-------------");
                System.out.print("""
                                [ 1 ] Sepete ürün ekleme
                                [ 2 ] Sepetten ürün çıkarma
                                [ 3 ] Sepetteki ürünleri listele
                                [ 4 ] Sepet tutarı hesaplama
                                Seçiniz[1,2,3,4] :""");
                String musteriSecim = scanner.nextLine();
                if(ValidityCheck.intPattern.matcher(musteriSecim).matches()){
                    int musteriScm = Integer.parseInt(musteriSecim);
                    if(musteriScm==1||musteriScm==2||musteriScm==3||musteriScm==4){
                        switch (musteriScm){
                            case 1:
                                Customer.musteriSepeteUrunEkleme(false,urunKayitlari);
                                break;
                            case 2:
                                Customer.musteriSepettenUrunCikarma(false,urunKayitlari);
                                break;
                            case 3:
                                Customer.musteriSepettekileriListeleme(urunKayitlari);
                                break;
                            case 4:
                                Customer.musteriSepetTutariHesaplama();
                        }
                        System.out.print("Başka bir işlem yapmak ister misiniz[evet/hayır] :");
                        String devam = scanner.nextLine();
                        if(ValidityCheck.stringPattern.matcher(devam).matches()){
                            if(devam.equals("evet")||devam.equals("hayır")){
                                if (devam.equals("evet")){
                                    musteriIslemeDevamStatus = true;
                                } else{
                                    musteriIslemeDevamStatus = false;
                                    System.out.println("Çıkış yapılıyor...");
                                }
                            }else{
                                musteriIslemeDevamStatus = true;
                                System.out.println("Hatalı seçim yaptınız ...");
                            }
                        }
                    }
                }
            }while(musteriIslemeDevamStatus == true);
        }
}
