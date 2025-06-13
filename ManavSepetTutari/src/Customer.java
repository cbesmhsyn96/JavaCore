import java.util.HashMap;

public class Customer {
    public static double toplam = 0;

         /*
        ____Müşteri İşlemleri____
        1. Sepete ürün ekleme tamam
        2. Sepetten ürün çıkarma
        3. Toplam Tutar hesaplama tamam
        1 ve 3 şuan birleşik. 2 eklemeye benzer toplam = toplam-fiyat*adet
        ______1 2 ve 3 menü seçenekleri______
         */


    public static double sepeteUrunEkle(HashMap<String,Double>urunler,String urunAdi,int urunAdedi){
        toplam = urunler.get(urunAdi)*urunAdedi+toplam;
        return toplam;
    }
}
