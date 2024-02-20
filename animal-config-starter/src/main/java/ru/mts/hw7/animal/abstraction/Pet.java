package ru.mts.hw7.animal.abstraction;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Абстрактный класс Pet является подклассом класса AbstractAnimal
 * и представляет общие характеристики для домашних питомцев
 */
public abstract class Pet extends AbstractAnimal {

    protected Pet(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    protected Pet(String breed, String name, BigDecimal cost, LocalDate birthDate) {
        super(breed, name, cost, "Kind", birthDate);
    }

    public Pet() {
    }

    @Override
    public String toString() {
        return "Pet{" +
                super.toString() +
                '}';
    }
}
