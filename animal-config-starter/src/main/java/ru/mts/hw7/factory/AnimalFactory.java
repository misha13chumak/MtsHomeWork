package ru.mts.hw7.factory;

import ru.mts.hw7.animal.intefaces.Animal;
import ru.mts.hw7.factory.type.AnimalType;

public interface AnimalFactory<T extends Animal> extends Factory {

    T createAnimal();

    boolean isApplicable(AnimalType animalType);

    Class<? extends Animal> getCreatedClass();

}
