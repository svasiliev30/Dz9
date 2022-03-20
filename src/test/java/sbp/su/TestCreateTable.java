package sbp.su;

import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sbp.su.Injection.Injection;
import sbp.su.adressAndProduct.ProductRepository;
import sbp.su.person.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestCreateTable {

    /**
     * Create table with id, name, age, city.
     * @throws SQLException
     */
    @Test
    public void createTable()  {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Injection.class);
        ProductRepository adress = context.getBean(ProductRepository.class);

        String sql = "CREATE TABLE person (" +
                "id VARCHAR(50)," +
                "name VARCHAR(50)," +
                "age VARCHAR(50)," +
                "city VARCHAR(100)" +
                ");";

        ProductRepository repository = context.getBean(ProductRepository.class);
        Assertions.assertTrue(repository.createTable(sql));
        context.close();
    }

    /**
     * Added information to the table. Table person creating/
     * @throws SQLException
     */
    @Test
    public void addInformation() throws SQLException {

            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Injection.class);
            ProductRepository repository = context.getBean(ProductRepository.class);
            List<Person> list = new ArrayList<>();
            list.add(new Person(12, "Дурин1", "Кхазад-Дум", 160 ));

            for (int i = 0; i < list.size(); i++) {
                Assertions.assertTrue(repository.addPerson(list.get(i)));
            }
             context.close();
    }

    /**
     * Delete table.
     * @throws SQLException
     */
    @Test
    public void deleteTable() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Injection.class);

        String nameTable = "DROP TABLE person";

        ProductRepository repository = context.getBean(ProductRepository.class);
        Assertions.assertTrue(repository.deleteTable(nameTable));
        context.close();
    }

    /**
     * Запуск и добавление персонажа через постман
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

