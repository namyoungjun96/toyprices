package toy.inflation.toyprices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static toy.inflation.toyprices.controller.Auth_key.key; //serviceKey 인증정보

@RestController
public class RestTestController {

    @GetMapping("/api")
    public String callApi() throws IOException {
    	StringBuilder result = new StringBuilder();
        
        
    	String urlStr = "http://apis.data.go.kr/5080000/pricesInfoService/getPricesInfo?" + 
				"serviceKey=" + key + //부여받은 serviceKey 정보 입력
				"&pageNo=1" +
				"&numOfRows=10";
        URL url = new URL(urlStr);
        
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

        String returnLine;
        
        while((returnLine = br.readLine()) != null) {
            result.append(returnLine+"n\r");
        }
        
        urlConnection.disconnect();
            
        return result.toString();
    }
}