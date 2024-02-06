package ru.mts.hw6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mts.hw6.abstraction.Animal;
import ru.mts.hw6.config.SpringConfig;
import ru.mts.hw6.repository.AnimalRepository;



public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class)
                ;

        AnimalRepository animalRepository = context.getBean(AnimalRepository.class);

        System.out.println("======================");
        System.out.println("FindLeapYearNames: ");
        String[] arrayForFindLeapYearNames = animalRepository.findLeapYearNames();
        for (String Name : arrayForFindLeapYearNames) {
            System.out.println(Name);
        }
        System.out.println("======================");

        System.out.println("FindOlderAnimal: ");
        Animal[] arrayForfindOlderAnimal = animalRepository.findOlderAnimal(10);
        for (Animal animal : arrayForfindOlderAnimal) {
            System.out.println(animal);
        }

        animalRepository.printDuplicate();
    }
}
