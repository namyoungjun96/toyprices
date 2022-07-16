package toy.inflation.toyprices.repository;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.IOException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import toy.inflation.toyprices.config.AppContext;
import toy.inflation.toyprices.domain.GasStation;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppContext.class)
public class GasApiDaoTest {
	@Value("${gasstation.key}") private String key;
	@Value("${gasstation.type}") private String type;
	@Autowired ApiDao apiDao;
	private GasStation station;
	private GasStation station2;
	
	@BeforeEach
	public void setUp() {
		station = new GasStation(key, type);
		station2 = new GasStation(key, type, "동해", "10", "1");
	}
	
	@Test
	public void updateURL() throws IOException {
		URL urlValue = apiDao.get(station);
		station.setRouteName("동해");
		station.setNumOfRows("10");
		station.setPageNo("1");
		URL urlValue2 = apiDao.get(station2);
		urlValue = apiDao.update(station);
		
		assertNotEquals(urlValue, equalTo(urlValue2));
		
		urlValue2 = apiDao.update(station2);
		assertThat(urlValue, equalTo(urlValue2));
	}
}
