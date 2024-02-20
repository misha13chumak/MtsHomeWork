package ru.mts.hw7.repository;

import ru.mts.hw7.animal.intefaces.Animal;

import java.util.Map;

public interface AnimalsRepository {

    String NAME = "mts_AnimalsRepository";

    /**
     * @return Массив из имен животных
     */
    String[] findLeapYearNames();

    /**
     * @param n Возраст, выше которого нужно найти
     * @return Массив подходящих животных
     */
    Animal[] findOlderAnimal(int n);

    //Ищет дубликаты животных
    Map<Animal, Integer> findDuplicate();

    //Печатает дубликаты животных
    void printDuplicate();

}
