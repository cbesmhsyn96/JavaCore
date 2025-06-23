package helper;

import environment.ConstansVariables;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class APIUsingMethods extends ConstansVariables {
    private static HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();

    private static HttpRequest setRequest(String cityName) throws URISyntaxException {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        HttpRequest request = HttpRequest.newBuilder(new URI("https://api.collectapi.com/weather/getWeather?data.lang=tr&data.city="+cityName))
                .header("content-type","application/json")
                .header("authorization",API_KEY)
                .GET()
                .build();
        return request;
    }

    public static HttpResponse getResponse(String cityName) throws URISyntaxException, IOException, InterruptedException {
        HttpResponse response = client.send(setRequest(cityName), HttpResponse.BodyHandlers.ofString());
        return response;
    }
}
