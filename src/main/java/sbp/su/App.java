package sbp.su;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sbp.su.Injection.Injection;
import sbp.su.adressAndProduct.ProductRepository;

/**
 * Запуск приложения */
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Injection.class);
        ProductRepository repository = applicationContext.getBean(ProductRepository.class);
    }
}
