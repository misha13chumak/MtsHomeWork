package ru.mts.hw7.animal.intefaces;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Интерфейс Animal представляет абстракцию для описания животных.
 * Животные, реализующие этот интерфейс, должны предоставлять информацию
 * о своей породе, имени, стоимости и характере.
 */
public interface Animal {

    String getBreed();

    String getName();

    BigDecimal getCost();

    String getCharacter();

    LocalDate getBirthDate();

}
