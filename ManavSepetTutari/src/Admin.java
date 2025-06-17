import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin extends ValidityCheck{

    private static ProductEntry urunKayit = new ProductEntry();
    static Scanner scanner = new Scanner(System.in);

    public static boolean login(String username, String password){
        if (username.equals(Credentials.username)&&password.equals(Credentials.password)){
            return true;
        }else{
            return false;
        }
    }

    public static void urunKaydiEkle(String urunAdi, Double urunFiyati, HashMap<String,Double> urunKayitlari){
        urunKayit.setUrunAdi(urunAdi);
        urunKayit.setUrunBirimFiyati(urunFiyati);
        urunKayitlari.put(urunKayit.getUrunAdi(),urunKayit.getUrunBirimFiyati());
    }

    public static void urunKayitlariListele(HashMap<String,Double> urunKayitlari){
        if (urunKayitlari.isEmpty()){
            System.out.println("Kayıtlı ürün yok...!");
        }else{
            System.out.println("--------------Ürün Listesi--------------");
            int i = 0;
            for (Map.Entry urunKaydi : urunKayitlari.entrySet()){
                ++i;
                System.out.println(i+"--> <"+urunKaydi.getKey()+" === "+urunKaydi.getValue()+" TL>");
            }
            System.out.println(i+" ürün bulunmaktadır.");
        }

    }

    public static void urunKaydiSil(HashMap<String,Double> urunKayitlari,String urunAdi){
        int status;
            status = 0;
            for (Map.Entry kayit : urunKayitlari.entrySet()){
                if(kayit.getKey().equals(urunAdi)){
                    System.out.println(urunAdi+" adlı ürünün kaydı silindi.");
                    status = 1;
                    break;
                }
            }
            urunKayitlari.remove(urunAdi);
            if (status==0) {
                System.out.println(urunAdi + " adlı bir ürün kaydı olmadığından silinemedi.");
            }
    }

    public static void urunKaydiGuncelle(HashMap<String,Double> urunKayitlari,String urunAdi, double urunYeniFiyat){
        int status;
        status = 0;
        if(!urunKayitlari.isEmpty()){
            for (Map.Entry kayit : urunKayitlari.entrySet()){
                if(kayit.getKey().equals(urunAdi)){
                    System.out.println(urunAdi+" adlı ürünün fiyatı güncellendi.");
                    status = 1;
                    break;
                }
            }
        }
        urunKayitlari.replace(urunAdi,urunYeniFiyat);
        if (status==0) {
            System.out.println(urunAdi+ " adlı urun kayıt listesinde olmadığından güncellenemedi...!");
        }
    }

    public static void adminUrunKaydiEkle(boolean urunEkleDevamStatusStartingValue, HashMap<String,Double> urunKayitlari){
        boolean urunEkleDevamStatus = urunEkleDevamStatusStartingValue;
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
    }

    public static void adminUrunKayitGuncelle(boolean urunKayitGuncelleDevamStatusStartingValue, HashMap<String,Double> urunKayitlari){
        boolean urunKayitGuncelleDevamStatus = urunKayitGuncelleDevamStatusStartingValue;
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
    }

    public static void adminUrunKayitSil(boolean urunSilDevamStatusStartingValue, HashMap<String,Double> urunKayitlari){
        boolean urunKayitSilDevamStatus = urunSilDevamStatusStartingValue;
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
                urunKayitSilDevamStatus = false;
            }
        }while (urunKayitSilDevamStatus==true);
    }

    public static void adminCoveredMethod_allAdminMethods(boolean adminDevamStatusStarting, HashMap<String,Double> urunKayitlari){
        System.out.println("-------------Admin Login Paneli-------------");
        System.out.print("Username :");
        String username = scanner.nextLine();
        System.out.print("Password :");
        String password = scanner.nextLine();
        if (passwordPattern.matcher(username).matches()&&passwordPattern.matcher(password).matches()){
            boolean deger = login(username.toString(),password.toString());
            if (deger){
                System.out.println("Login başarılı.");
                boolean adminDevamStatus=adminDevamStatusStarting;
                do {
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
                                    adminUrunKaydiEkle(false,urunKayitlari);
                                    break;
                                case 2:
                                    adminUrunKayitGuncelle(false,urunKayitlari);
                                    break;
                                case 3:
                                    adminUrunKayitSil(false,urunKayitlari);
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
        }
    }
}
