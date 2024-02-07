package ru.mts.hw6.services.Impl;

import ru.mts.hw6.abstraction.Animal;
import ru.mts.hw6.factory.AnimalFactory;
import ru.mts.hw6.services.CreateAnimalService;

import java.util.Random;

import static ru.mts.hw6.factory.AnimalTypes.*;

/**
 * Реализация сервиса создания животных.
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {

    /**
     * Поле для хранения типа животного.
     */
    private Animal animalType;

    public Animal getAnimal() {
        return animalType;
    }

    public void setAnimalType(Animal animalType) {
        this.animalType = animalType;
    }

    /**
     * Заполнить поле для хранения типа животного.
     */
    public void fillingTypeAnimal(){
        setAnimalType(createOneUniqueAnimal());
    }
    private final Random random = new Random();

    /**
     * Создание 10 животных.
     *
     * @return Массив животных.
     */
    @Override
    public Animal[] createUniqueAnimals() {
        int animalCounter = 0;
        Animal[] animals = new Animal[10];
        do {
            animals[animalCounter++] = createOneUniqueAnimal();
        } while (animalCounter < 10);
        return animals;
    }

    /**
     * Создать и вывести указанное количество животных.
     *
     * @param n Количество животных для создания.
     * @return Массив уникальных животных.
     */
    @Override
    public Animal[] createUniqueAnimals(int n) {
        Animal[] animals = new Animal[n];
        for (int animalCounter = 0; animalCounter < n; animalCounter++) {
            animals[animalCounter] = createOneUniqueAnimal();
        }
        return animals;
    }

    /**
     * Создание животного случайного типа.
     *
     * @return животное.
     */
    protected Animal createOneUniqueAnimal() {
        int randomNum = random.nextInt(MAX_COUNT_TYPE_ANIMAL);
        AnimalFactory animalFactory = new AnimalFactory();
        switch (randomNum) {
            case 0:
                return animalFactory.createAnimal(Cat);
            case 1:
                return animalFactory.createAnimal(Dog);
            case 2:
                return animalFactory.createAnimal(Shark);
            case 3:
                return animalFactory.createAnimal(Wolf);
            default:
        }
        return null;
    }

    /**
     * Создать и вывести указанное количество уникальных животных с дублированием.
     *
     * @param n            Количество уникальных животных для создания.
     * @param duplicateNum Количество дубликатов для каждого уникального животного.
     * @return Массив уникальных животных с дублированием.
     */
    @Override
    public Animal[] createUniqueAnimals(int n, int duplicateNum) {
        Animal[] animals = new Animal[n * duplicateNum];
        int animalCounter = 0;
        for (int i = 0; i < n; i++) {
            Animal uniqueAnimal = createOneUniqueAnimal();
            for (int j = 0; j < duplicateNum; j++) {
                animals[animalCounter++] = uniqueAnimal;
            }
        }
        return animals;
    }
}
