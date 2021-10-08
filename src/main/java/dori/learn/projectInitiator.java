package dori.learn;

import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class projectInitiator {

    private static String POST_API_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args){
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest GETRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(POST_API_URL))
                .build();

        JSONObject POSTexample = new JSONObject();
        POSTexample.put("id",1);
        POSTexample.put("title","foo");
        POSTexample.put("body","bar");
        POSTexample.put("userId",1);

        try{
            HttpResponse<String> GETresponse = client.send(GETRequest,HttpResponse.BodyHandlers.ofString());
            System.out.println(GETresponse.body());
        }
        catch (IOException | InterruptedException io){
            System.out.print(io.toString());
        }
    }
}
