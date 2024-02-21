package ru.mts.hw7.factory;

import ru.mts.hw7.animal.intefaces.Animal;
import ru.mts.hw7.factory.type.AnimalType;


public interface AbstractAnimalFactory extends Factory {

    String NAME = "mts_AbstractAnimalFactory";

    AnimalFactory<? extends Animal> createAnimalFactory(final AnimalType animalType);

}
