import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import helper.CityMapping;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.List;

import static helper.APIUsingMethods.getResponse;
/*
ObjectMapper objectMapper = new ObjectMapper();
                String responseBody = getResponse(cityInputValue).body().toString();
                JsonNode jsonNode = objectMapper.readTree(responseBody);
                System.out.println("success = "+jsonNode.get("success").asText());
 */
public class Trying extends CityMapping {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        cityInputValue = "Adıyaman";
        setKeyValueGuncelSehirler();
        if (keyValueGuncelSehirler.keySet().contains(cityInputValue)) {
            ObjectMapper mapper = new ObjectMapper();
            if(getResponse(cityInputValue).statusCode() == 200){
                
            }
        }
    }
}