import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import helper.CityMapping;
import helper.JsonProcessing;

import javax.imageio.plugins.tiff.ExifParentTIFFTagSet;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Formattable;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static helper.APIUsingMethods.getResponse;

public class RunnerClass extends JsonProcessing {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        boolean continueeStatus;
        do{
            continueeStatus = false;
            System.out.print("Türkiye' deki bir şehri girin :");
            cityInputValue = new Scanner(System.in).nextLine();
            activityRecommendation(cityInputValue);
            System.out.print("Devam etsin mi[evet|hayır] :");
            String yesNoSelection = new Scanner(System.in).nextLine();
            if(Pattern.compile("^(evet|hayır)$").matcher(yesNoSelection).matches()){
                if(yesNoSelection.equals("evet")||yesNoSelection.equals("hayır")){
                    if(yesNoSelection.equals("evet")){
                        continueeStatus = true;
                    }else{
                        System.out.println("Programdan çıkılıyor...");
                        continueeStatus = false;
                    }
                }
            }
        }while (continueeStatus);

    }
}