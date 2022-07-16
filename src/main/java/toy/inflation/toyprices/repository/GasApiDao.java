package toy.inflation.toyprices.repository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Repository;

import toy.inflation.toyprices.domain.GasStation;

@Repository
public class GasApiDao implements ApiDao {
	@Override
	public URL get(Object data) throws IOException {
		GasStation station = (GasStation) data;
		URI uri = null;
		
		try {
			uri = new URIBuilder().setScheme("http")
					.setHost("data.ex.co.kr")
					.setPath("/openapi/business/curStateStation")
					.setParameter("key", station.getKey())			//	Service Key
					.setParameter("type", station.getType())
					.build();
		} catch (URISyntaxException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		URL url = new URL(uri.toString());
		return url;
	}

	@Override
	public URL update(Object data) throws IOException {
		GasStation station = (GasStation) data;
		URI uri = null;
		
		try {
			uri = new URIBuilder().setScheme("http")
					.setHost("data.ex.co.kr")
					.setPath("/openapi/business/curStateStation")
					.setParameter("key", station.getKey())			//	Service Key
					.setParameter("type", station.getType())
					.setParameter("routeName", station.getRouteName())
					.setParameter("numOfRows", station.getNumOfRows())
					.setParameter("pageNo", station.getPageNo())
					.build();
		} catch (URISyntaxException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		URL url = new URL(uri.toString());
		return url;
	}
}

// http://data.ex.co.kr/openapi/business/curStateStation?key=8210613408&type=json&numOfRows=10&pageNo=1