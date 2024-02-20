package ru.mts.hw7.service;

import ru.mts.hw7.animal.intefaces.Animal;
import ru.mts.hw7.factory.AnimalSimpleFactory;

/**
 * Интерфейс CreateAnimalService предоставляет абстракцию для создания животных.
 */
public interface CreateAnimalService {

    String NAME = "mts_CreateAnimalService";

    /**
     * Получить животное
     *
     * @return Animal
     */
    Animal createAnimal();


    void initAnimalType();

    // Метод createUniqueAnimals() создает 10 уникальных животных и выводит их информацию.
    default Animal[] createUniqueAnimals() {
        int animalCounter = 0;
        Animal[] animals = new Animal[10];

        while (animalCounter < 10) {
            animals[animalCounter] = AnimalSimpleFactory.createRandomAnimal();
            animalCounter++;
        }

        return animals;
    }


}
