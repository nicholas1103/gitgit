import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) {
        String url = "https://example.com/check_hash?hash="; // Đường link truy cập /check_hash

        String hash = "your_hash_value"; // Giá trị của hash bạn muốn truyền

        HttpClient httpClient = HttpClientBuilder.create().build();
         httpGet = new HttpGet(url + hash);

        try {
            HttpResponse response = httpClient.execute(httpGet);

            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder responseString = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                responseString.append(line);
            }

            String result = responseString.toString();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}