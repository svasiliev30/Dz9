package sbp.su.person;
import java.util.Comparator;
public class Person implements Comparable <Person> {
    private String name;
    private String city;
    private int age;
    private int id;

    /**
     * Пустой конструктор
     */
    public Person()
    {
        super();
    }
    /**
     * Получаем параметры String name, String city, int age.
     * @param name
     * @param city
     * @param age
     */
    public Person(int id, String name, String city, int age) {

        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    /**
     * Возвращает name
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Возвращает id
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Возвращает city
     * @return
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * Возвращает age
     * @return
     */
    public int getAge() {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * идет сравнение, эквивалентен первый объект второму
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == null ){
            return false ;
        }

        if (this == obj){
            return true;
        }

        if (this.getClass() != obj.getClass()){
            return false;
        }
        Person person = (Person) obj;

       return this.city == person.city && this.name == person.name && this.age == person.age;
    }

    /**
     * Сортировка сначала по полю city, а затем по полю name;
     * @param another
     * @return
     */
    @Override
    public int compareTo(Person another) {

        return Comparator.comparing(Person::getId)
                  .thenComparing(Person::getName)
                  .thenComparing(Person::getCity)
                  .thenComparing(Person::getAge)
                  .compare(this,another);
    }

    /**
     * Возвращает данные объекта
     *
     * @return
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

