import java.util.HashMap;
import java.util.Map;

public class Admin {

    private static ProductEntry urunKayit = new ProductEntry();

    public boolean login(String username, String password){
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
        int i = 0;
        if (urunKayitlari.isEmpty()){
            System.out.println("Kayıtlı ürün olmadığı için listeleme yapılamaz...!");
        }else{
            System.out.println("--------------Ürün Listesi--------------");
            for (Map.Entry urunKaydi : urunKayitlari.entrySet()){
                System.out.println((i+1)+"--> ["+urunKaydi.getKey()+","+urunKaydi.getValue()+"]");
                i++;
            }
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
}
