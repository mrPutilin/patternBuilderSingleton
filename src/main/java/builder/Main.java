package builder;

public class Main {
    public static void main(String[] args) {


        Person mom = new Person.PersonBuilder()
                .setName("Оксана")
                .setSurname("Семенова")
                .setCity("Воронеж")
                .setAge(33)
                .build();


        Person son = mom.newChildBuilder()
                .setAge(10)
                .setName("Антошка")
                .build();


        System.out.println("У мамы " + mom + " есть сын " + son);


        try {
            new Person.PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new Person.PersonBuilder().setAge(101).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


    }
}
