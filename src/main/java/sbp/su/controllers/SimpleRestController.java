package sbp.su.controllers;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.web.bind.annotation.*;
import sbp.su.Injection.Injection;
import sbp.su.adressAndProduct.ProductRepository;
import sbp.su.person.Person;

@RestController
@RequestMapping("simpleRestController")
public class SimpleRestController
{
    /**
     * Добавление персонажа
     * @param person
     * @return
     */
    @PostMapping("/postProcessing")
    public Person postProcessing(@RequestBody Person person)
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Injection.class);
        ProductRepository repository = applicationContext.getBean(ProductRepository.class);

        repository.addPerson(person);
        applicationContext.close();
        return person;
    }
}
