
import javax.swing.*;
import javax.xml.crypto.dom.DOMURIReference;
import java.security.KeyStore;
import java.util.*;
import java.util.regex.Pattern;

public class TryingClass extends Customer{
    private static double toplam = 0;
    private static HashMap<String,Integer> sepetUrunList = new LinkedHashMap<>();
    public static void main(String[] args) {

        /*sepettenCikarDevamStatus = false;
        do{
            System.out.println("--------Sepetten ürün çıkarma başlıyor--------");
            if(!Customer.sepetUrunListesi.isEmpty()){
                Customer.sepettekiUrunListesiniGetir(urunKayitlari);
                System.out.print("Sepetten çıkarılacak ürün adı :");
                String urunAdi = scanner.nextLine();
                System.out.print("Sepete çıkarılacak ürün adedi :");
                String urunAdedi = scanner.nextLine();
                if(passwordPattern.matcher(urunAdi).matches()&&intPattern.matcher(urunAdedi).matches()){
                    if (Customer.sepetUrunListesi.containsKey(urunAdi)){
                        Customer.sepettenUrunCikar(urunKayitlari,urunAdi, Integer.parseInt(urunAdedi));
                        System.out.print("Ürün çıkarmaya devam edilsin mi[evet[e]/hayır[h]] :");
                        String cikarmayaDevamDurumu = scanner.nextLine();
                        if (stringPattern.matcher(cikarmayaDevamDurumu).matches()){
                            if (cikarmayaDevamDurumu.equals("e")||cikarmayaDevamDurumu.equals("h")){
                                if(cikarmayaDevamDurumu.equals("e")){
                                    sepettenCikarDevamStatus=true;
                                }else{
                                    System.out.println("Sepetten ürün çıkarma sonlandırılıyor...");
                                    sepettenCikarDevamStatus = false;
                                }
                            }
                        }else{
                            System.out.println("Geçersiz giriş yaptınız...!");
                            sepettenCikarDevamStatus = false;

                        }
                    }
                    //alisveriseDevamStatus = false;
                    else {
                        System.out.println("Sepetten çıkarmak istediğiniz ürün sepette yok...!");
                        System.out.print("Sepetten ürün çıkarmaya devam edilsin mi[evet[e]/hayır[h]] :");
                        String cikarmayaDevamDurumu = scanner.nextLine();
                        if (stringPattern.matcher(cikarmayaDevamDurumu).matches()){
                            if (cikarmayaDevamDurumu.equals("e")||cikarmayaDevamDurumu.equals("h")){
                                if(cikarmayaDevamDurumu.equals("e")){
                                    sepettenCikarDevamStatus=true;
                                }else{
                                    System.out.println("Ürün ekleme sonlandırılıyor...");
                                    sepettenCikarDevamStatus = false;
                                }
                            }
                        }else{
                            System.out.println("Geçersiz giriş yaptınız...!");
                            break;
                        }
                    }
                }else{
                    System.out.println("Geçersiz değer girdiniz. Ürün bilgilerini tekrar girin...");
                    sepettenCikarDevamStatus = true;
                }
            }else{
                System.out.println("Sepette ürün bulunmamaktadır...");
                sepettenCikarDevamStatus = false;
            }
        }while(sepettenCikarDevamStatus==true);
        break;*/


        HashMap<String,Double> urunKayitListesi = new LinkedHashMap<>();
        List<Double> toplamFiyatListesi = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        urunKayitListesi.put("Elma",2.0);
        urunKayitListesi.put("Armut",3.0);
        sepetUrunList.put("Elma",3);
        sepetUrunList.put("Elma1",4);
        sepetUrunList.put("Armut",5);
        sepetUrunList.put("Armut1",6);
        sepetUrunList.put("Elma2",7);
        System.out.println("================================================");
        for (String currentUnitProductName : urunKayitListesi.keySet()){
            System.out.println("{"+currentUnitProductName+","+urunKayitListesi.get(currentUnitProductName)+"TL} && {startsWith("+currentUnitProductName+"),"+urunKayitListesi.get(currentUnitProductName)+"TL}");
        }
        System.out.println("------------------------------------------------");
        System.out.println("Sepet ilk durum");
        for (String currentKey : sepetUrunList.keySet()){
            for(String currentUnitProductName : urunKayitListesi.keySet()){
                if(currentKey.equals(currentUnitProductName)){
                    System.out.println("{"+currentKey+","+sepetUrunList.get(currentKey)+" adet} Toplam = "+sepetUrunList.get(currentKey)*urunKayitListesi.get(currentUnitProductName));
                }else if(currentKey.startsWith(currentUnitProductName)){
                    System.out.println("{"+currentKey+","+sepetUrunList.get(currentKey)+" adet} Toplam = "+sepetUrunList.get(currentKey)*urunKayitListesi.get(currentUnitProductName));
                }

            }

        }
        System.out.println("================================================");
        System.out.print("Çıkarılacak ürün adı :");
        String cikarilacakUrunAdi = scanner.nextLine();
        System.out.print("Çıkarılacak ürün sayısı :");
        String cikarilacakUrunAdedi = scanner.nextLine();
        System.out.println("------------------------------------------------");
        for (String currentKey : sepetUrunList.keySet()) {
            if(cikarilacakUrunAdi.equals(currentKey)){
                int guncelAdet = sepetUrunList.get(currentKey) - Integer.parseInt(cikarilacakUrunAdedi);
                sepetUrunList.replace(currentKey,guncelAdet);
            }
        }
        System.out.println("Güncel durum");
        for (String currentKey : sepetUrunList.keySet()){
            for(String currentUnitProductName : urunKayitListesi.keySet()){
                if(currentKey.equals(currentUnitProductName)){
                    System.out.println("{"+currentKey+","+sepetUrunList.get(currentKey)+" adet} Toplam = "+sepetUrunList.get(currentKey)*urunKayitListesi.get(currentUnitProductName));
                }else if(currentKey.startsWith(currentUnitProductName)){
                    System.out.println("{"+currentKey+","+sepetUrunList.get(currentKey)+" adet} Toplam = "+sepetUrunList.get(currentKey)*urunKayitListesi.get(currentUnitProductName));
                }
            }
        }

        System.out.println("================================================");
        System.out.print("Çıkarılacak ürün adı :");
        String cikarilacakUrunAdi2 = scanner.nextLine();
        System.out.print("Çıkarılacak ürün sayısı :");
        String cikarilacakUrunAdedi2 = scanner.nextLine();
        System.out.println("------------------------------------------------");
        for (String currentKey : sepetUrunList.keySet()) {
            if(cikarilacakUrunAdi2.equals(currentKey)){
                int guncelAdet = sepetUrunList.get(currentKey) - Integer.parseInt(cikarilacakUrunAdedi2);
                sepetUrunList.replace(currentKey,guncelAdet);
            }
        }
        System.out.println("Güncel durum");
        for (String currentKey : sepetUrunList.keySet()){
            for(String currentUnitProductName : urunKayitListesi.keySet()){
                if(currentKey.equals(currentUnitProductName)){
                    System.out.println("{"+currentKey+","+sepetUrunList.get(currentKey)+" adet} Toplam = "+sepetUrunList.get(currentKey)*urunKayitListesi.get(currentUnitProductName));
                }else if(currentKey.startsWith(currentUnitProductName)){
                    System.out.println("{"+currentKey+","+sepetUrunList.get(currentKey)+" adet} Toplam = "+sepetUrunList.get(currentKey)*urunKayitListesi.get(currentUnitProductName));
                }
            }
        }












    }
}