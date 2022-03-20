package sbp.su.adressAndProduct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import sbp.su.person.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository  {

    /**
     * Пустой конструктор
     */
    public ProductRepository()
    {
        super();
    }

    /**
     *Получение ссылки на базу данных
     */
    @Value("${provider.create.table}")
    private String url;

    /**
     * Takes an information of table.Create new table.
     * @param informationTable
     * @return
     */
    public boolean createTable(String informationTable) {

        String sql = informationTable;

        try(Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();) {
            int affectedRows = statement.executeUpdate(informationTable);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * Takes an information of person and name table. Added this information to table.
     * @param person
     * @return
     */
    public boolean addPerson (Person person){

       try (Connection connection = DriverManager.getConnection(url);
               Statement statement = connection.createStatement();){

           String sql = String.format("INSERT INTO person ('id', 'name', 'age', 'city') VALUES (%s, '%s', %s, '%s')",
                   person.getId(), person.getName(), person.getAge(), person.getCity());

           boolean hasResultSet = statement.execute(sql);
           int affectedRows = statement.getUpdateCount();
           System.out.println( "affectedRows = " + affectedRows);

       }catch (SQLException e) {
           return false;
       }
        return true;
    }

    /**
     * Takes a name table and delete his.
     * @param nameTable
     * @return
     */
    public boolean deleteTable(String nameTable){

        String sqlNameTable = nameTable;

       try (Connection connection = DriverManager.getConnection(url);
               Statement statement = connection.createStatement();){
           statement.executeUpdate(sqlNameTable);
       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }
       return true;
    }

    /**
     * Read information from database.
     * @return
     */
    public List<Person> readAllPersons()
    {
        final String readAllPersonsQuery = "select * from person";

        try(Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(readAllPersonsQuery))
        {
         List<Person> personRead = new ArrayList<>();

            while (resultSet.next())
            {
                Person localPerson = new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getInt("age"));
                personRead.add(localPerson);
            }
            return personRead;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

