import helper.CityMapping;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import static helper.APIUsingMethods.getResponse;

public class RunnerClass extends CityMapping {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.out.print("Türkiye' deki bir şehri girin :");
        cityInputValue = new Scanner(System.in).nextLine();
        setKeyValueGuncelSehirler();
        if(keyValueGuncelSehirler.keySet().contains(cityInputValue)){
            String temperature;
            if(getResponse(cityInputValue).statusCode()==200){
               /*
               pom.xml
               Jackson dependency ile response ta gezinme kodları buraya
               1 data üzerinden işlem yaptığı için bir Desialization sınıfı oluşturmaya gerek görmedim
               */
                System.out.println("Durum kodu = "+getResponse(cityInputValue).statusCode());
            }
        }
    }
}