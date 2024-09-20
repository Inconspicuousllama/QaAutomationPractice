package streamApi;

import lombok.Builder;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        //Старый метод
/*        List<Animal> animals = getAnimals();
        List<Animal> predators = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getClassification().equals(Classification.PREDATOR)) {
                predators.add(animal);
            }
        }
        predators.forEach(System.out::println);*/

        //Новый метод
        //Filter
        List<Animal> filteredAnimals = getAnimals().stream().filter(x->x.getClassification().equals(Classification.PREDATOR)).toList();
        //filteredAnimals.forEach(System.out::println);

        //Sort
        List<Animal> sortedAnimals = getAnimals().stream().sorted(Comparator.comparing(Animal::getAge).reversed()).toList();
        //sortedAnimals.forEach(System.out::println);

        //All match
        boolean allMatch = getAnimals().stream().allMatch(animal -> animal.getAge() > 10);
        //System.out.println(allMatch);

        //Any match
        boolean anyMatch = getAnimals().stream().anyMatch(animal -> animal.getAnimalName().equals("Bear"));
        //System.out.println(anyMatch);

        //Non match
        boolean nonMatch = getAnimals().stream().noneMatch(animal -> animal.getAge() < 2);
        //System.out.println(nonMatch);

        //Max
        //getAnimals().stream().max(Comparator.comparing(Animal::getAge)).ifPresent(System.out::println);

        //Min
        //getAnimals().stream().min(Comparator.comparing(Animal::getAge)).ifPresent(System.out::println);

        //Group
/*        Map<Classification, List<Animal>> classificationAnimalMap =  getAnimals().stream()
                .collect(Collectors.groupingBy(Animal::getClassification));

        classificationAnimalMap.forEach((classification, animals) -> {
            System.out.println(classification);
            animals.forEach(System.out::println);
            System.out.println();
        });*/
        Optional<String> oldestPredatorAge = getAnimals().stream()
                .filter(animal -> animal.getClassification().equals(Classification.PREDATOR))
                .max(Comparator.comparing(Animal::getAge))
                .map(Animal::getAnimalName);
        oldestPredatorAge.ifPresent(System.out::println);
    }
    private static List<Animal> getAnimals() {
        return List.of(
                new Animal("Elephant", 40, Classification.HERBIVORE),
                new Animal("Tiger", 10, Classification.PREDATOR),
                new Animal("Monkey", 2, Classification.HERBIVORE),
                new Animal("Behemoth", 13, Classification.OMNIVORE),
                new Animal("Hyena", 4, Classification.PREDATOR),
                new Animal("Velociraptor", 19, Classification.PREDATOR),
                new Animal("Giraffe", 23, Classification.HERBIVORE)
        );
    }
}

