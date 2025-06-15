import java.util.*;
import java.util.regex.Pattern;


public class RunnerClass extends Admin{
    public static void main(String[] args) {
        HashMap<String,Double> urunKayitlari = new LinkedHashMap<>();
        ProductEntry productEntry = new ProductEntry();
        Admin admin = new Admin();
        Customer customer;
        boolean adminDevamStatus;
        boolean urunEkleDevamStatus;
        boolean urunKayitSilDevamStatus;
        boolean urunKayitGuncelleDevamStatus;
        boolean alisveriseDevamStatus;
        boolean sepettenCikarDevamStatus;
        boolean musteriIslemeDevamStatus;

        Scanner scanner = new Scanner(System.in);
        Pattern intPattern = Pattern.compile("\\d+");
        Pattern stringPattern = Pattern.compile("[a-zA-ZçÇğĞıİöÖşŞüÜ]+");
        Pattern passwordPattern = Pattern.compile("[a-zA-ZçÇğĞıİöÖşŞüÜ\\d]+");


        int continuee;
        do {
            continuee = 0;
            System.out.println("-------------Ana Panel-------------");
            System.out.print("""
            [ 1 ] Admin
            [ 2 ] Müşteri
            Kullanıcı türü seçiniz[1 veya 2] :""");
            String secim = scanner.nextLine();
            if (!intPattern.matcher(secim).matches()){
                System.out.println("Sayı girmediniz.");
            }else{
                if (Integer.valueOf(secim)!=1&&Integer.valueOf(secim)!=2){
                    System.out.println("Geçerli giriş yapmadınız");
                } else if (Integer.valueOf(secim)==1||Integer.valueOf(secim)==2) {
                    System.out.println("Panele yönlendiriliyorsunuz...\n\n\n\n\n\n");
                    continuee = 1;
                    switch (Integer.valueOf(secim)){
                        case 1:
                            System.out.println("-------------Admin Login Paneli-------------");
                            System.out.print("Username :");
                            String username = scanner.nextLine();
                            System.out.print("Password :");
                            String password = scanner.nextLine();
                            if (passwordPattern.matcher(username).matches()&&passwordPattern.matcher(password).matches()){
                                boolean deger = admin.login(username.toString(),password.toString());
                                if (deger){
                                    System.out.println("Login başarılı.");
                                    do {
                                        adminDevamStatus=false;
                                        System.out.println("--------Admin Menü--------");
                                        System.out.print("""
                                        [ 1 ] Ürün ekleme
                                        [ 2 ] Ürün güncelleme
                                        [ 3 ] Ürün silme
                                        [ 4 ] Ürün listeleme
                                        Seçiniz[1,2,3,4] :""");
                                        String adminSecim = scanner.nextLine();
                                        if (intPattern.matcher(adminSecim).matches()){
                                            if (Integer.valueOf(adminSecim)==1||
                                                    Integer.valueOf(adminSecim)==2||
                                                    Integer.valueOf(adminSecim)==3||
                                                    Integer.valueOf(adminSecim)==4){
                                                switch (Integer.valueOf(adminSecim)){
                                                    case  1:
                                                        urunEkleDevamStatus = false;
                                                        System.out.println("--------------Ürün Ekleme Başlatılıyor--------------");
                                                        do{
                                                            System.out.print("Ürün adı [harflerden oluşan bir değer girin]:");
                                                            String urunAdi = scanner.nextLine();
                                                            System.out.print("Ürün fiyatı [sayi girin]:");
                                                            String urunFiyati = scanner.nextLine();
                                                            if (stringPattern.matcher(urunAdi).matches()&&intPattern.matcher(urunFiyati).matches()){
                                                                urunKaydiEkle(urunAdi, Double.valueOf(urunFiyati),urunKayitlari);
                                                                System.out.println(urunAdi+" ürünü eklendi.");
                                                                System.out.print("Ürün eklemeye devam edilsin mi [evet için e/hayır için h] :");
                                                                String urunEkleDevamSt = scanner.nextLine();
                                                                if (stringPattern.matcher(urunEkleDevamSt).matches()){
                                                                    if (urunEkleDevamSt.equals("e")||urunEkleDevamSt.equals("h")){
                                                                        if (urunEkleDevamSt.equals("e")){
                                                                            System.out.println("----Sonraki ürünü ekleyin-----");
                                                                            urunEkleDevamStatus = true;
                                                                        }else{
                                                                            System.out.println("----Ürün ekleme tamamlandı-----");
                                                                            urunEkleDevamStatus = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }while (urunEkleDevamStatus==true);
                                                        break;
                                                    case 2:
                                                        urunKayitGuncelleDevamStatus = false;
                                                        do{
                                                            if(!urunKayitlari.isEmpty()){
                                                                System.out.println("--------------Ürün Güncelleme Başlatılıyor--------------");
                                                                System.out.print("Güncellenecek kaydın ürün adı [harflerden oluşan bir değer girin]:");
                                                                String urunAdi = scanner.nextLine();
                                                                System.out.print("Güncellenecek kaydın yeni fiyatı [sayı girin]:");
                                                                String urunYeniFiyat = scanner.nextLine();
                                                                if (stringPattern.matcher(urunAdi).matches()&&intPattern.matcher(urunYeniFiyat).matches()){
                                                                    urunKaydiGuncelle(urunKayitlari,urunAdi, Double.parseDouble(urunYeniFiyat));
                                                                    System.out.print("Ürün güncellemeye devam edilsin mi [evet için e/hayır için h] :");
                                                                    String urunGuncelleDevamSt = scanner.nextLine();
                                                                    if (stringPattern.matcher(urunGuncelleDevamSt).matches()){
                                                                        if (urunGuncelleDevamSt.equals("e")||urunGuncelleDevamSt.equals("h")){
                                                                            if (urunGuncelleDevamSt.equals("e")){
                                                                                System.out.println("----Sonraki ürünü güncelleyin-----");
                                                                                urunKayitGuncelleDevamStatus = true;
                                                                            }else{
                                                                                System.out.println("----Ürün güncelleme tamamlandı-----");
                                                                                urunKayitGuncelleDevamStatus = false;
                                                                            }
                                                                        }
                                                                    }
                                                                }else{
                                                                    if(!stringPattern.matcher(urunAdi).matches()){
                                                                        System.out.println("Geçersiz ürün adı girdiniz...!");
                                                                    }
                                                                    if(!intPattern.matcher(urunYeniFiyat).matches()){
                                                                        System.out.println("Geçersiz ürün fiyatı girdiniz...!");
                                                                    }
                                                                    urunKayitGuncelleDevamStatus=false;
                                                                }
                                                            }
                                                            else{
                                                                System.out.println("Kayıtlı ürün olmadığı için güncelleme işlemi yapılamaz...!");
                                                            }
                                                        }while (urunKayitGuncelleDevamStatus==true);
                                                        break;
                                                    case 3:
                                                        urunKayitSilDevamStatus = false;
                                                        do{
                                                            if(!urunKayitlari.isEmpty()){
                                                                System.out.println("--------------Ürün Silme Başlatılıyor--------------");
                                                                System.out.print("Silinecek ürün kaydında ürün adı [harflerden oluşan bir değer girin]:");
                                                                String urunAdi = scanner.nextLine();
                                                                if (stringPattern.matcher(urunAdi).matches()){
                                                                    urunKaydiSil(urunKayitlari,urunAdi);
                                                                    System.out.print("Ürün silmeye devam edilsin mi [evet için e/hayır için h] :");
                                                                    String urunSilDevamSt = scanner.nextLine();
                                                                    if (stringPattern.matcher(urunSilDevamSt).matches()){
                                                                        if (urunSilDevamSt.equals("e")||urunSilDevamSt.equals("h")){
                                                                            if (urunSilDevamSt.equals("e")){
                                                                                System.out.println("----Sonraki ürünü silin-----");
                                                                                urunKayitSilDevamStatus = true;
                                                                            }else{
                                                                                System.out.println("----Ürün silme tamamlandı-----");
                                                                                urunKayitSilDevamStatus = false;
                                                                            }
                                                                        }
                                                                    }
                                                                }else{
                                                                    System.out.println("Geçersiz ürün adı girdiniz...!");
                                                                    urunKayitSilDevamStatus = true;
                                                                }
                                                            }else{
                                                                System.out.println("Kayıtlı ürün olmadığı için silme işlemi yapılamaz...!");
                                                                urunKayitSilDevamStatus = true;
                                                            }
                                                        }while (urunKayitSilDevamStatus==true);
                                                        break;
                                                    case 4:
                                                        urunKayitlariListele(urunKayitlari);break;
                                                }
                                                System.out.print("Başka bir işlem yapmak ister misiniz[evet/hayır] :");
                                                String devam = scanner.nextLine();
                                                if(stringPattern.matcher(devam).matches()){
                                                    if(devam.equals("evet")||devam.equals("hayır")){
                                                        if (devam.equals("evet")){
                                                            adminDevamStatus = true;
                                                        } else{
                                                            adminDevamStatus = false;
                                                            System.out.println("Çıkış yapılıyor...");
                                                        }
                                                    }else{
                                                        adminDevamStatus = true;
                                                        System.out.println("Hatalı seçim yaptınız ...");
                                                    }
                                                }
                                            }
                                        }
                                    }while(adminDevamStatus==true);
                                }else{
                                    System.out.println("Geçersiz login.");
                                   //continuee = 1;
                                }
                            }else{
                                System.out.println("Geçersiz login.");
                               //continuee = 1;
                            }break;

                        case 2:
                            do {
                                musteriIslemeDevamStatus = false;
                                System.out.println("-------------Müşteri işlemleri-------------");
                                System.out.print("""
                                [ 1 ] Sepete ürün ekleme
                                [ 2 ] Sepetten ürün çıkarma
                                [ 3 ] Sepetteki ürünleri listele
                                [ 4 ] Sepet tutarı hesaplama
                                Seçiniz[1,2,3,4] :""");
                                String musteriSecim = scanner.nextLine();
                                if(intPattern.matcher(musteriSecim).matches()){
                                    int musteriScm = Integer.parseInt(musteriSecim);
                                    if(musteriScm==1||musteriScm==2||musteriScm==3||musteriScm==4){
                                        switch (musteriScm){
                                            case 1 :
                                                alisveriseDevamStatus = false;
                                                do{
                                                    System.out.println("--------Sepete ürün ekleme başlıyor--------");
                                                    if(!urunKayitlari.isEmpty()){
                                                        urunKayitlariListele(urunKayitlari);
                                                        System.out.print("Sepete eklenecek ürün adı :");
                                                        String urunAdi = scanner.nextLine();
                                                        System.out.print("Sepete eklenecek ürünün adedi :");
                                                        String urunAdedi = scanner.nextLine();
                                                        if(stringPattern.matcher(urunAdi).matches()&&intPattern.matcher(urunAdedi).matches()){
                                                            if (urunKayitlari.containsKey(urunAdi)){
                                                                Customer.sepeteUrunEkle(urunKayitlari,urunAdi, Integer.parseInt(urunAdedi));
                                                                System.out.print("Ürün eklemeye devam edilsin mi[evet[e]/hayır[h]] :");
                                                                String eklemeyeDevamDurumu = scanner.nextLine();
                                                                if (stringPattern.matcher(eklemeyeDevamDurumu).matches()){
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
                                                                if (stringPattern.matcher(eklemeyeDevamDurumu).matches()){
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
                                                        System.out.println("Listelenecek ürün bulunmamaktadır...");
                                                        alisveriseDevamStatus = false;
                                                    }
                                                }while(alisveriseDevamStatus==true);
                                                break;
                                            case 2:
                                                sepettenCikarDevamStatus = false;
                                                do {

                                                }while (sepettenCikarDevamStatus);
                                                break;
                                            case 3:
                                                if(!Customer.sepetUrunListesi.isEmpty()){
                                                    Customer.sepettekiUrunListesiniGetir(urunKayitlari);
                                                    break;
                                                }else {
                                                    System.out.println("Sepette ürün yok.");
                                                    break;
                                                }
                                            case 4:
                                                double toplamTutar = Customer.sepetToplamı();
                                                if(toplamTutar != 0.0){
                                                    System.out.println("Toplam sepet tutarı = "+toplamTutar);
                                                    break;
                                                }else{
                                                    System.out.println("Sepet boş. Lüften sepete ürün ekleyin...!");
                                                    break;
                                                }
                                        }
                                        System.out.print("Başka bir işlem yapmak ister misiniz[evet/hayır] :");
                                        String devam = scanner.nextLine();
                                        if(stringPattern.matcher(devam).matches()){
                                            if(devam.equals("evet")||devam.equals("hayır")){
                                                if (devam.equals("evet")){
                                                    musteriIslemeDevamStatus = true;
                                                } else{
                                                    musteriIslemeDevamStatus = false;
                                                    continuee = 0;
                                                    System.out.println("Çıkış yapılıyor...");
                                                }
                                            }else{
                                                musteriIslemeDevamStatus = true;
                                                System.out.println("Hatalı seçim yaptınız ...");
                                            }
                                        }
                                    }
                                }
                            }while(musteriIslemeDevamStatus = true);
                    }
                }
            }
        }while(continuee == 1);
        urunKayitlari.clear();
        Customer.sepetUrunListesi.clear();
    }
}