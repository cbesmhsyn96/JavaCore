import java.util.*;

public class RunnerClass extends Admin{
    public static void main(String[] args) {
        HashMap<String,Double> urunKayitlari = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
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
                    System.out.println("Panele yönlendiriliyorsunuz...\n...\n....\n.....\n......\n.......\n........");
                    continuee = 1;
                    switch (Integer.valueOf(secim)){
                        case 1:
                            adminCoveredMethod_allAdminMethods(false,urunKayitlari);
                            break;
                        case 2:
                            Customer.musteriCoveredMethod_allMusteriMethods(false,urunKayitlari);
                    }
                }
            }
        }while(continuee == 1);
        urunKayitlari.clear();
        Customer.sepetUrunListesi.clear();
    }
}