import environment.ConstansVariables;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Trying extends ConstansVariables {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
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

        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(new URI("https://www.meteosource.com/api/v1/free/point?place_id=postal-tr-34570&sections=daily&timezone=Europe%2FIstanbul&language=en&units=metric&key="+API_KEY)).header("accept","application/json").build();
        HttpResponse response = client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code = "+response.statusCode());

    }
}