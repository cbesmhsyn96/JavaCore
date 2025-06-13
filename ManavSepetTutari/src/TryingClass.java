
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TryingClass extends Customer{
    public static void main(String[] args) {
        //Kod parçalarını test etmek için
        Customer customer;
        boolean alisveriseDevamStatus;
        HashMap<String,Double> urunler = new HashMap<>();
        Pattern intPattern = Pattern.compile("\\d+");
        Pattern stringPattern = Pattern.compile("[a-zA-ZçÇğĞıİöÖşŞüÜ]+");
        urunler.put("Elma",1.0);
        urunler.put("Armut",1.0);
        Scanner scanner = new Scanner(System.in);
        do{
            alisveriseDevamStatus = false;
            System.out.println("--------Sepete ürün ekleme başlıyor--------");
            System.out.print("Sepete eklenecek ürün adı :");
            String urunAdi = scanner.nextLine();
            System.out.print("Sepete eklenecek ürünün adedi :");
            String urunAdedi = scanner.nextLine();
            if(stringPattern.matcher(urunAdi).matches()&&intPattern.matcher(urunAdedi).matches()){
                sepeteUrunEkle(urunler,urunAdi,Integer.parseInt(urunAdedi));
                System.out.print("Sepete yeni bir ürün eklemek ister misiniz [evet[e] / hayır[h]] :");
                String secim = scanner.nextLine();
                if(stringPattern.matcher(secim).matches()){
                    if(secim.equals("e")||secim.equals("h")){
                        if(secim.equals("e")){
                            alisveriseDevamStatus = true;
                        }else{
                            alisveriseDevamStatus = false;
                        }
                    }else{
                        System.out.println("Hatalı değer girdiniz. Sepetten çıkılıyor...");
                        alisveriseDevamStatus = false;
                    }
                }else{
                    System.out.println("Geçersiz değer girdiniz. Sepetten çıkılıyor...");
                    alisveriseDevamStatus = false;
                }
            }else{
                System.out.println("Geçersiz değer girdiniz. Ürün bilgilerini tekrar girin...");
                alisveriseDevamStatus = true;
            }
            if (alisveriseDevamStatus == false){
                System.out.println("Toplam tutar hesaplanıyor...");
                break;
            }
        }while(alisveriseDevamStatus == true);
        System.out.println("Toplam = "+toplam);
    }
}