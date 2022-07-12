package toy.inflation.toyprices.service;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import toy.inflation.toyprices.config.AppContext;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppContext.class)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class OpenApiServiceTest {
	@Autowired OpenApiService openApi;
	
	@Test
	public void testSample() throws IOException {
		openApi.sample();
	}
}
