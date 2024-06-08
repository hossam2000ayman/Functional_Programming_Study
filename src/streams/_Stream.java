package streams;

import java.util.List;
import java.util.stream.Collectors;

public class _Stream {
    
    public static void main(String args[]) {
        
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("ALice", Gender.FEMALE),
                new Person("Robot", Gender.PREFER_NOT_TO_SAY)
        );

//        Set<Gender> genders =  people.stream()
//                .map(person -> person.gender)
//                .collect(Collectors.toSet());
//        System.out.println(genders);
//        people.stream()
//                .map(person -> person.gender)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);
//
//        people.stream()
//                .map((person) -> person.name)
//                .map(name -> name.length())
//                .forEach(System.out::println);
//
//        people.stream()
//                .map(person -> person.name)
//                .mapToInt((name) -> name.length())
//                .forEach(System.out::println);
        //more about streams 
        boolean containOnlyFemales = people.stream()
                //                .filter((person) -> person.gender.equals(Gender.FEMALE))
                .allMatch((person) -> person.gender.equals(Gender.FEMALE));
        System.out.println("is this list contain only females : " + containOnlyFemales);
        
        boolean containAtLeastOneFemale = people.stream()
                //                .filter((person) -> person.gender.equals(Gender.MALE))
                .anyMatch((person) -> person.gender.equals(Gender.FEMALE));
        
        System.out.println("is this list contain at least one females : " + containAtLeastOneFemale);
        
        boolean isNotIncludePreferNotSay = people.stream()
                .filter((person) -> person.gender.equals(Gender.FEMALE) || person.gender.equals(Gender.MALE))
                .noneMatch((person) -> person.gender.equals(Gender.PREFER_NOT_TO_SAY));
        
        System.out.println("isNotIncludePreferNotSay : " + isNotIncludePreferNotSay);
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
        PREFER_NOT_TO_SAY, MALE, FEMALE
    }
}
