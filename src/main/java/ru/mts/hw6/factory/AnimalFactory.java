package ru.mts.hw6.factory;

import ru.mts.hw6.abstraction.Animal;
import ru.mts.hw6.animal.Cat;
import ru.mts.hw6.animal.Dog;
import ru.mts.hw6.animal.Shark;
import ru.mts.hw6.animal.Wolf;
import ru.mts.hw6.random.RandomGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

/**
 * Класс для создания одного уникального животного с случайными характеристиками.
 */
public class AnimalFactory {

    // Максимальное количество лет в прошлом для генерации случайной даты рождения.
    private static final int MAX_YEARS_IN_PAST = 20;

    // Количество месяцев в году.
    private static final int MONTHS_IN_YEAR = 12;

    // Максимальное количество типов характеров животных.
    private static final int MAX_COUNT_CHARACTER = 5;

    // Максимальное количество пород для животных.
    private static final int MAX_COUNT_BREED_ANIMAL = 10;

    // Возможные характеры животных.
    private static final String[] CHARACTERS = {"Friendly", "Playful", "Aggressive", "Calm", "Energetic"};

    /**
     * Создать одно уникальное животное.
     *
     * @param type Тип животного.
     * @return Экземпляр животного.
     * @throws IllegalArgumentException если передан неизвестный тип животного.
     */
    public Animal createAnimal(AnimalTypes type) {
        RandomGenerator randomGenerator = new RandomGenerator();
        String breed = randomGenerator.generateRandomBreed(type);
        String name = randomGenerator.generateRandomName();
        BigDecimal cost = randomGenerator.generateRandomCost();
        LocalDate birthDate = randomGenerator.generateRandomBirthDate();
        String character = randomGenerator.generateRandomCharacter();

        switch (type) {
            case Cat:
                return new Cat(breed, name, cost, character, birthDate);
            case Dog:
                return new Dog(breed, name, cost, character, birthDate);
            case Shark:
                return new Shark(breed, name, cost, character, birthDate);
            case Wolf:
                return new Wolf(breed, name, cost, character, birthDate);
            default:
                throw new IllegalArgumentException("Unknown animal type: " + type);
        }
    }


}

