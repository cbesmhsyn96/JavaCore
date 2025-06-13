import java.util.HashMap;

public class Customer {
    public static double toplam = 0;
    public static double sepeteUrunEkle(HashMap<String,Double>urunler,String urunAdi,int urunAdedi){
        toplam = urunler.get(urunAdi)*urunAdedi+toplam;
        return toplam;
    }
}
