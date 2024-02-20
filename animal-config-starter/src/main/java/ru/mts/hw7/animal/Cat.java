package ru.mts.hw7.animal;

import ru.mts.hw7.animal.abstraction.Pet;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Cat extends Pet {

    @SuppressWarnings("unused")
    public Cat(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Cat(String breed, String name, BigDecimal cost, LocalDate birthDate) {
        super(breed, name, cost, birthDate);
    }

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                super.toString() +
                '}';
    }

}
