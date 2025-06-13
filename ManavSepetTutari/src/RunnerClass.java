import java.util.*;
import java.util.regex.Pattern;


public class RunnerClass extends Admin{
    public static void main(String[] args) {
        /*
        Ürün kaydı yapma
        Sepete ürün ekleme
        Toplam Tutar hesaplama
         */
        HashMap<String,Double> urunKayitlari = new LinkedHashMap<>();
        Admin admin = new Admin();
        boolean adminDevamStatus;
        boolean urunEkleDevamStatus;
        boolean urunKayitSilDevamStatus;
        boolean urunKayitGuncelleDevamStatus;

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
                                                            continuee = 0;
                                                            System.out.println("Çıkış yapılıyor...");
                                                        }
                                                    }else{
                                                        adminDevamStatus = true;
                                                        continuee = 0;
                                                        System.out.println("Hatalı seçim yaptınız ...");
                                                    }
                                                }
                                            }
                                        }
                                    }while(adminDevamStatus==true);
                                }else{
                                    System.out.println("Geçersiz login.");
                                    continuee = 1;
                                }
                            }else{
                                System.out.println("Geçersiz login.");
                                continuee = 1;
                            }break;

                        case 2:
                            System.out.println("-------------Müşteri işlemleri-------------");
                            System.out.println("""
                            
                            """);break;
                    }
                }
            }
        }while(continuee == 1);
        urunKayitlari.clear();
    }
}
