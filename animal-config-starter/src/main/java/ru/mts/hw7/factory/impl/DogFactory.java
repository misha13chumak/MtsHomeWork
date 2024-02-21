package ru.mts.hw7.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.hw7.config.AnimalProperties;
import ru.mts.hw7.animal.Dog;
import ru.mts.hw7.factory.type.AnimalType;

import static ru.mts.hw7.factory.type.AnimalType.DOG;

@Component(DogFactory.NAME)
public class DogFactory<T extends Dog> extends BaseAnimalFactory<T> {

    public static final String NAME = "mts_DogFactory";

    @Autowired
    public DogFactory(AnimalProperties animalDataProperties) {
        super(animalDataProperties.getAnimalData());
    }

    @Override
    public boolean isApplicable(AnimalType animalType) {
        return DOG.equals(animalType);
    }

    @Override
    public Class<? extends Dog> getCreatedClass() {
        return Dog.class;
    }

}
