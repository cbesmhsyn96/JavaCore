
import javax.swing.*;
import javax.xml.crypto.dom.DOMURIReference;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TryingClass extends Customer{
    private static double toplam = 0;
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


        HashMap<String,Integer> sepetUrunList = new HashMap<>();
        HashMap<String,Double> urunKayitListesi = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        urunKayitListesi.put("Elma",2.0);
        urunKayitListesi.put("Armut",3.0);
        sepetUrunList.put("Elma",3);
        sepetUrunList.put("Elma1",4);
        sepetUrunList.put("Armut",5);
        sepetUrunList.put("Armut1",6);
        sepetUrunList.put("Elma2",7);
        for (String currentKey : sepetUrunList.keySet()){
            for (String currentUnitProductName : urunKayitListesi.keySet()) {
                if(currentKey.equals(currentUnitProductName)){
                    System.out.println("["+currentKey+",("+urunKayitListesi.get(currentKey)+"*"+sepetUrunList.get(currentKey)+")] Toplam ="+urunKayitListesi.get(currentKey)*sepetUrunList.get(currentKey));
                    toplam = toplam + urunKayitListesi.get(currentKey)*sepetUrunList.get(currentKey);
                }else if(currentKey.startsWith(currentUnitProductName)){
                    System.out.println("["+currentKey+",("+urunKayitListesi.get(currentUnitProductName)+"*"+sepetUrunList.get(currentUnitProductName)+")] Toplam ="+urunKayitListesi.get(currentUnitProductName)*sepetUrunList.get(currentKey));
                    toplam = toplam + urunKayitListesi.get(currentUnitProductName)*sepetUrunList.get(currentKey);
                }
            }
        }
        System.out.println("Sepet tutarı = "+toplam);
        System.out.print("Sepetten çıkarmak istediğiniz ürün :");
        String urunAdi = scanner.nextLine();
        System.out.print("Sepetten çıkarmak istediğiniz ürün adedi :");
        String urunAdedi = scanner.nextLine();
        for (String currentKey : sepetUrunList.keySet()){
            if(urunAdi.equals(currentKey)) {
                if (sepetUrunList.get(currentKey) >= Integer.parseInt(urunAdedi)) {
                    sepetUrunList.replace(urunAdi, sepetUrunList.get(currentKey) - Integer.parseInt(urunAdedi));
                    for (String currentUnitProductName : urunKayitListesi.keySet()) {
                        if(currentKey.equals(currentUnitProductName)){
                            toplam = toplam - urunKayitListesi.get(currentKey)*Integer.parseInt(urunAdedi);
                        }else if(currentKey.startsWith(currentUnitProductName)){
                            toplam = toplam - urunKayitListesi.get(currentUnitProductName)*Integer.parseInt(urunAdedi);
                        }
                    }
                    break;
                } else {
                    System.out.println("Çıkarmak istediğiniz " + urunAdi + " ürünü adedi " + sepetUrunList.get(currentKey) + " adedinden fazla...!");
                    break;
                }
            }
        }


        for (String currentKey : sepetUrunList.keySet()){
            for (String currentUnitProductName : urunKayitListesi.keySet()) {
                if(currentKey.equals(currentUnitProductName)){
                    System.out.println("["+currentKey+",("+urunKayitListesi.get(currentKey)+"*"+sepetUrunList.get(currentKey)+")] Toplam ="+urunKayitListesi.get(currentKey)*sepetUrunList.get(currentKey));
                }else if(currentKey.startsWith(currentUnitProductName)){
                    System.out.println("["+currentKey+",("+urunKayitListesi.get(currentUnitProductName)+"*"+sepetUrunList.get(currentUnitProductName)+")] Toplam ="+urunKayitListesi.get(currentUnitProductName)*sepetUrunList.get(currentKey));
                }
            }
        }

        System.out.println("Güncel sepet tutarı = "+toplam);






















    }
}