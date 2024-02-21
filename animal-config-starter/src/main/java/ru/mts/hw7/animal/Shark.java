package ru.mts.hw7.animal;

import ru.mts.hw7.animal.abstraction.Predator;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Shark extends Predator {

    @SuppressWarnings("unused")
    public Shark(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Shark(String breed, String name, BigDecimal cost, LocalDate birthDate) {
        super(breed, name, cost, birthDate);
    }

    public Shark() {
    }

    @Override
    public String toString() {
        return "Shark{" +
                super.toString() +
                '}';
    }

}
