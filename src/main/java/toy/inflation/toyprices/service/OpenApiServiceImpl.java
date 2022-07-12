package toy.inflation.toyprices.service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;

@Service("openApi")
public class OpenApiServiceImpl implements OpenApiService {
	public void sample() throws IOException {
		String key = "y9SkTqAk%2BAPxOoyb%2BMCtec%2BgIYjLQc%2FDfJTK0IDDs31JPqBJb4h43NKQW%2BBh9kgzmTQTmghbtYBylVJtp%2B0cSg%3D%3D";
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6430000/priceInformationService/getPriceInformation"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + key); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("currentPage","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("SE","UTF-8") + "=" + URLEncoder.encode("17년 11월", "UTF-8")); /*날짜구분*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}