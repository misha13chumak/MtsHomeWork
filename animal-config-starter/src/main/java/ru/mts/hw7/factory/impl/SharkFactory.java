package ru.mts.hw7.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.hw7.config.AnimalProperties;
import ru.mts.hw7.animal.Shark;
import ru.mts.hw7.factory.type.AnimalType;

import static ru.mts.hw7.factory.type.AnimalType.SHARK;

@Component(SharkFactory.NAME)
public class SharkFactory<T extends Shark> extends BaseAnimalFactory<T> {

    public static final String NAME = "mts_SharkFactory";

    @Autowired
    public SharkFactory(AnimalProperties animalDataProperties) {
        super(animalDataProperties.getAnimalData());
    }

    @Override
    public boolean isApplicable(AnimalType animalType) {
        return SHARK.equals(animalType);
    }

    @Override
    public Class<? extends Shark> getCreatedClass() {
        return Shark.class;
    }

}
