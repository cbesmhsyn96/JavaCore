package helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class JsonProcessing extends APIUsingMethods {
    public static void activityRecommendation(String cityInputValue) throws URISyntaxException, IOException, InterruptedException {
        setKeyValueGuncelSehirler();
        if(keyValueGuncelSehirler.keySet().contains(cityInputValue)){
            ObjectMapper mapper = new ObjectMapper();
            if(getResponse(cityInputValue).statusCode()==200){
                JsonNode rootNode = mapper.readTree(getResponse(cityInputValue).body().toString());
                ArrayNode resultsArrayNode = (ArrayNode)  rootNode.get("result");
                List<String> degreesList = new ArrayList<>();
                for (JsonNode node : resultsArrayNode){
                    degreesList.add(node.get("degree").asText());
                }
                double todaysTemperature = Double.parseDouble(degreesList.get(0));
                System.out.println("Bugünkü beklenen sıcaklık = "+todaysTemperature);
                if(todaysTemperature>=25){
                    System.out.println("Bugün dışarı çıkma günü. Lütfen gün boyu evde durmayın. Çıkın gezin.");
                }else{
                    System.out.println("Bugünkü beklenen sıcaklıktan dolayı eğer dışarı çıkacaksanız bir hırka alıp öyle çıkmalısınız.");
                }
            }
        }
    }
}
