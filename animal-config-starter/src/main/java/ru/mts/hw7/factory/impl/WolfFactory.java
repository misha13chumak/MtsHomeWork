package ru.mts.hw7.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.hw7.config.AnimalProperties;
import ru.mts.hw7.animal.Wolf;
import ru.mts.hw7.factory.type.AnimalType;

import static ru.mts.hw7.factory.type.AnimalType.WOLF;

@Component(WolfFactory.NAME)
public class WolfFactory<T extends Wolf> extends BaseAnimalFactory<T> {

    public static final String NAME = "mts_WolfFactory";

    @Autowired
    public WolfFactory(AnimalProperties animalDataProperties) {
        super(animalDataProperties.getAnimalData());
    }

    @Override
    public boolean isApplicable(AnimalType animalType) {
        return WOLF.equals(animalType);
    }

    @Override
    public Class<? extends Wolf> getCreatedClass() {
        return Wolf.class;
    }

}
