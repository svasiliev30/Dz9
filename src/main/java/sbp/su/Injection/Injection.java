package sbp.su.Injection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("db.properties")
@ComponentScan("sbp")
public class Injection {

}


