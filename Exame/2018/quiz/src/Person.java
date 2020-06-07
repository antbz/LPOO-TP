import java.util.Objects;

public abstract class Person extends User implements Comparable {
    String name;
    int age = 0;

    public Person(String name) {
        super(name, 0);
        this.name = name;
    }

    public Person(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {
        if (this.equals(o)) return 0;
        return 1;
    }
}
