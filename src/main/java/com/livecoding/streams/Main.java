package com.livecoding.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative approach ❌

    /*

    List<Person> females = new ArrayList<>();

    for (Person person : people) {

      if (person.getGender().equals(Gender.FEMALE)) {
        females.add(person);
      }
    }

    females.forEach(System.out::println);

    */

        // Declarative approach ✅

        //filter
        List<Person> females = people.stream().filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
       // females.forEach(System.out::println);
        //sorted
        List<Person> sorted = people.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
        //sorted.forEach(System.out::println);
        //allMatch
        boolean allMatch = people.stream().allMatch(person -> person.getAge() > 11);
       // System.out.println(allMatch);
        //anyMatch
        boolean anyMatch = people.stream().anyMatch(person -> person.getAge() > 45);
       // System.out.println(anyMatch);

        //noneMatch
        boolean noneMatch = people.stream().noneMatch(person -> person.getName().equals("Bob"));
        //System.out.println(noneMatch);
        //max
        people.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);
        //min
        people.stream().min(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);


    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("John", 25, Gender.MALE),
                new Person("Mary", 30, Gender.FEMALE),
                new Person("Tom", 45, Gender.MALE),
                new Person("Anna", 18, Gender.FEMALE),
                new Person("Mike", 65, Gender.MALE),
                new Person("Lucy", 12, Gender.FEMALE),
                new Person("Bob", 80, Gender.MALE)
        );
    }
}
