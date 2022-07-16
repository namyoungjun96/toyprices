package toy.inflation.toyprices.service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toy.inflation.toyprices.repository.ApiDao;

import java.io.BufferedReader;
import java.io.IOException;

@Service("openApi")
public class GasStationApiServiceImpl implements ApiService {
	@Autowired ApiDao apiDao;
	
	public void setApiDao(ApiDao apiDao) {
		this.apiDao = apiDao;
	}
	
	public String findValues(Object data) throws IOException {
		URL url = apiDao.get(data);
		return getValue(url);
	}
	
	public String modifyValues(Object data) throws IOException {
		URL url = apiDao.update(data);
		return getValue(url);
	}
	
	protected String getValue(URL url) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.connect();
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
		return sb.toString();
	}
}