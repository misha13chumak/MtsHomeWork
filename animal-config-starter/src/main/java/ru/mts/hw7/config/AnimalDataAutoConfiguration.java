package ru.mts.hw7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mts.hw7.animal.intefaces.Animal;
import ru.mts.hw7.factory.AbstractAnimalFactory;
import ru.mts.hw7.factory.AnimalFactory;
import ru.mts.hw7.factory.impl.AbstractAnimalFactoryImpl;
import ru.mts.hw7.provider.AnimalDataProvider;

import java.util.Map;

@Configuration
@ConditionalOnClass(AnimalDataProvider.class)
@EnableConfigurationProperties(AnimalProperties.class)
public class AnimalDataAutoConfiguration {

    private final AnimalProperties animalDataProperties;

    @Autowired
    public AnimalDataAutoConfiguration(AnimalProperties animalDataProperties) {
        this.animalDataProperties = animalDataProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public AnimalConfiguration animalDataConfig() {
        return AnimalConfiguration.createInstance(animalDataProperties.getAnimalData());
    }

    @Bean
    @ConditionalOnMissingBean
    public AnimalDataProvider animalData(@Autowired AnimalConfiguration config) {
        return new AnimalDataProvider(config);
    }

    @ConditionalOnMissingBean
    @Bean(name = AbstractAnimalFactory.NAME)
    public AbstractAnimalFactory abstractAnimalFactory(@Autowired Map<String, AnimalFactory<? extends Animal>> animalFactorys) {
        return new AbstractAnimalFactoryImpl(animalFactorys);
    }

}

