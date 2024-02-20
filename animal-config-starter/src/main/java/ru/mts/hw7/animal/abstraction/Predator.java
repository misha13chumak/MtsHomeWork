package ru.mts.hw7.animal.abstraction;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Абстрактный класс Predator является подклассом класса AbstractAnimal
 * и представляет общие характеристики для хищных животных.
 */
public abstract class Predator extends AbstractAnimal {

    protected Predator(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    protected Predator(String breed, String name, BigDecimal cost, LocalDate birthDate) {
        super(breed, name, cost, "Angry", birthDate);
    }

    public Predator() {
    }

    @Override
    public String toString() {
        return "Predator{" +
                super.toString() +
                '}';
    }
}
