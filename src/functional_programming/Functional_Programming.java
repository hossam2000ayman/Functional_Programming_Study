package functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Functional_Programming {

    public static void main(String[] args) {
        // TODO code application logic here

        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("ALice", Gender.FEMALE)
        );

        // Imperative approach
//        System.out.println("// Imperative approach");
//        List<Person> females = new ArrayList<>();
//        for (Person person : people) {
//            if (Gender.FEMALE.equals(person.gender)) {
//                females.add(person);
//            }
//        }
//        for (Person female : females) {
//            System.out.println(female);
//        }
        //Declerative Approach
        System.out.println("//Declerative Approach");
        people.stream()
                .filter((person) -> Gender.FEMALE.equals(person.gender))
                //                .collect(Collectors.toList())
                .forEach(System.out::println);

        Predicate<Person> predicate = (person) -> Gender.FEMALE.equals(person.gender);

        List<Person> females = people.stream()
                .filter(predicate)
                .collect(Collectors.toList());

    }

    static class Person {

        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" + "name=" + name + ", gender=" + gender + '}';
        }

    }

    enum Gender {
        MALE, FEMALE
    }
}
