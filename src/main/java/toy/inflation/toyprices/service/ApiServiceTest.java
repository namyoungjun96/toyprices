package toy.inflation.toyprices.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.List;

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
public class ApiServiceTest {
	@Autowired ApiService openApi;
	@Value("${gasstation.key}") private String key;
	@Value("${gasstation.type}") private String type;
	
	GasStation station;
	
	@BeforeEach
	public void setUp() {
		station = new GasStation(key, type, "동해", "10", "1");
	}
	
	@Test
	public void modifyValues() throws IOException {
		String value = openApi.findValues(station);
		String value2 = openApi.modifyValues(station);
		
		assertNotEquals(value, equalTo(value2));
	}
}
