package ru.mts.hw7.service.impl;

import ru.mts.hw7.animal.intefaces.Animal;
import ru.mts.hw7.factory.type.AnimalType;
import ru.mts.hw7.factory.AbstractAnimalFactory;
import ru.mts.hw7.service.CreateAnimalService;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Класс CreateAnimalServiceImpl предоставляет конкретную реализацию интерфейса CreateAnimalService.
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {

    private final AbstractAnimalFactory abstractAnimalFactory;

    private AnimalType animalType;

    public CreateAnimalServiceImpl(AbstractAnimalFactory abstractAnimalFactory) {
        checkArgument(Objects.nonNull(abstractAnimalFactory), "'abstractAnimalFactory' is null");
        this.abstractAnimalFactory = abstractAnimalFactory;
    }

    /**
     * Получить животное из поля Animal
     * @return Animal
     */
    @Override
    public Animal createAnimal() {
        var animalFactory = abstractAnimalFactory.createAnimalFactory(animalType);

        return animalFactory.createAnimal();
    }


    @Override
    public void initAnimalType() {
        int randCoefficient = ThreadLocalRandom.current().nextInt(0, 3);
        animalType = AnimalType.values()[randCoefficient];
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    // Метод createUniqueAnimals() создает 10 уникальных животных.
    @Override
    public Animal[] createUniqueAnimals() {
        var factory = abstractAnimalFactory.createAnimalFactory(animalType);
        int animalCounter = 0;
        Animal[] animals = new Animal[10];

        do {
            animals[animalCounter] = factory.createAnimal();
            animalCounter++;
        } while (animalCounter < 10);

        return animals; // Возвращаем массив созданных животных
    }

    /**
     * Метод createUniqueAnimals(int n) создает заданное количество уникальных животных и выводит информацию
     */
    public Animal[] createUniqueAnimals(int n) {
        var factory = abstractAnimalFactory.createAnimalFactory(animalType);

        Animal[] animals = new Animal[n]; // Создаем массив для хранения животных
        for (int i = 0; i < n; i++) {
            animals[i] = factory.createAnimal();
        }

        return animals;
    }

}
