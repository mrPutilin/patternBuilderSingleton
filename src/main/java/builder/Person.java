package builder;

import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected String city;
    protected int age;


    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.city = personBuilder.city;
        this.age = personBuilder.age;

    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public boolean hasAge() {
        return this.age > 0;
    }

    public void happyBirthday() {
        if (hasAge())
            this.age += 1;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setCity(city);
        personBuilder.setSurname(surname);
        return personBuilder;

    }

    @Override
    public String toString() {
        return "Pers{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, city, age);
    }

    public static class PersonBuilder {

        protected String name;
        protected String surname;
        protected int age;
        protected String city;


        public String getSurname() {
            return surname;
        }

        public PersonBuilder setName(String name) {
            if (this.name == null)
                this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            if (this.surname == null)
                this.surname = surname;
            return this;
        }

        public PersonBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public PersonBuilder setAge(int age) {
            if (age < 1 || age > 100)
                throw new IllegalArgumentException("Введен не корректный возраст");
            this.age = age;
            return this;
        }


        public Person build() {
            if (this.name == null || this.surname == null)
                throw new IllegalStateException("Не введены имя или фамилия");
            return new Person(this);
        }

    }
}
