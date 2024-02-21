package ru.mts.hw7.animal;

import ru.mts.hw7.animal.abstraction.Pet;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Dog extends Pet {

    @SuppressWarnings("unused")
    public Dog(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Dog(String breed, String name, BigDecimal cost, LocalDate birthDate) {
        super(breed, name, cost, birthDate);
    }

    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog{" +
                super.toString() +
                '}';
    }

}
