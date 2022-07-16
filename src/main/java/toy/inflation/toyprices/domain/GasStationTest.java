package toy.inflation.toyprices.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

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
public class GasStationTest {
	GasStation station;
	@Value("${gasstation.key}")
	private String key;
	@Value("${gasstation.type}")
	private String type;
	
	@BeforeEach
	public void setUp() {
		station = new GasStation(key, type, "동해", "10", "1");
	}
	
	@Test
	public void properties() {
		assertThat(station.getKey(), equalTo("8210613408"));
		assertThat(station.getType(), equalTo("json"));
	}
}
