package ru.mts.hw7.animal;

import ru.mts.hw7.animal.abstraction.Predator;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Wolf extends Predator {

    @SuppressWarnings("unused")
    public Wolf(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Wolf(String breed, String name, BigDecimal cost, LocalDate birthDate) {
        super(breed, name, cost, birthDate);
    }

    public Wolf() {
    }

    @Override
    public String toString() {
        return "Wolf{" +
                super.toString() +
                '}';
    }

}
