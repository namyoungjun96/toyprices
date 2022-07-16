package toy.inflation.toyprices.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "toy.inflation.toyprices")
@PropertySource("/application.properties")
public class AppContext {

}
