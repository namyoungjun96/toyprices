

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.utils.URIBuilder;

public class Chungbuk {
//	public void test() {
//		String key = "y9SkTqAk+APxOoyb+MCtec+gIYjLQc/DfJTK0IDDs31JPqBJb4h43NKQW+Bh9kgzmTQTmghbtYBylVJtp+0cSg==";
//		// 디코딩된 상태임
//		URI uri = null;
//		try {
//			uri = new URIBuilder().setScheme("http")
//					.setHost("apis.data.go.kr")
//					.setPath("/6430000/priceInformationService/getPriceInformation")
//					.setParameter("serviceKey", key)			//	Service Key
//					.setParameter("currentPage", "1")			//	페이지 번호
//					.setParameter("perPage", "10")				//	한 페이지 결과 수
//					.setParameter("SE", "17년 11월")				//	날짜구분				
//					.build();
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		URL url = new URL(uri.toString());
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Content-type", "application/json");
//		conn.connect();
//		BufferedReader rd;
//		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		} else {
//			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//		}
//		StringBuilder sb = new StringBuilder();
//		String line;
//		while ((line = rd.readLine()) != null) {
//			sb.append(line);
//		}
//		rd.close();
//		conn.disconnect();
//		System.out.println(sb.toString());
//	}
}
