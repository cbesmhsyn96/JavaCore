import environment.ConstansVariables;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Scanner;

public class Trying extends TryingTwo {
    public static void main(String[] args) //throws IOException, InterruptedException, URISyntaxException {
    {
        /*HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        HttpResponse response = null;
        try {
            String endPoint = "https://postman-echo.com/get";
            URI uri = URI.create(endPoint+"?foo1=bar1&foo2=bar2");
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Status code = "+response.statusCode());
        System.out.println("Response body = "+response.body());*/

        /*HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        HttpRequest request = HttpRequest.newBuilder(new URI("https://api.collectapi.com/weather/getWeather?data.lang=tr&data.city=ankara"))
                .header("content-type","application/json")
                .header("authorization",API_KEY)
                .GET()
                .build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code = "+response.statusCode());*/


        /*HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        HttpResponse response = null;
        try {
            String endPoint = "https://api.collectapi.com/weather/getWeather";
            URI uri = URI.create(endPoint+"?data.lang=tr&data.city=agri");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("content-type","application/json")
                    .header("authorization",API_KEY)
                    .build();
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Status code = "+response.statusCode());
        System.out.println("Response body = "+response.body());*/
        TryingTwo tryingTwo;
        setKeyValueGuncelSehirler();
        for (HashMap.Entry enty : keyValueGuncelSehirler.entrySet()){
            System.out.println(enty.getValue());
        }
        /*for (HashMap.Entry enty : TryingTwo.keyValueGuncelSehirler.entrySet()){
            if(sehir.equals(enty.getKey())){
                System.out.println(enty.getValue()+" kullanıma hazır.");
                break;
            }
        }*/





        /*HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        HttpRequest request = HttpRequest.newBuilder(new URI("https://api.collectapi.com/weather/getWeather?data.lang=tr&data.city=ankara"))
                .header("content-type","application/json")
                .header("authorization",API_KEY)
                .GET()
                .build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code = "+response.statusCode());*/


    }
}