package ru.mts.hw6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.hw6.repository.AnimalRepository;
import ru.mts.hw6.repository.Impl.AnimalRepositoryImpl;
import ru.mts.hw6.services.CreateAnimalService;
import ru.mts.hw6.services.Impl.CreateAnimalServiceImpl;

@Configuration
public class SpringConfig {
    @Bean
    @Scope("prototype")
    public CreateAnimalService createAnimalService(){
        return new CreateAnimalServiceImpl();
    }

    @Bean
    public AnimalRepository animalRepository(CreateAnimalService createAnimalService){
        return new AnimalRepositoryImpl(createAnimalService);
    }
}
