package ru.mts.hw6.repository;

import ru.mts.hw6.abstraction.Animal;

import java.util.Set;

public interface AnimalRepository {
    String[] findLeapYearNames();
    Animal[] findOlderAnimal(int age);
    Set<Animal> findDuplicate();
    void printDuplicate();
}
