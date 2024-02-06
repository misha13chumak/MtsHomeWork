package ru.mts.hw6.repository.Impl;

import ru.mts.hw6.abstraction.Animal;
import ru.mts.hw6.repository.AnimalRepository;
import ru.mts.hw6.services.CreateAnimalService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Реализация интерфейса {@link AnimalRepository}, управляющая коллекцией животных.
 */
public class AnimalRepositoryImpl implements AnimalRepository {

    private final CreateAnimalService createAnimalService;
    protected List<Animal> animals;

    /**
     * Устанавливает список животных.
     *
     * @param animals Список животных для установки.
     */
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     * Конструктор объекта AnimalRepositoryImpl
     *
     * @param createAnimalService Сервис, используемый для создания животных.
     */
    public AnimalRepositoryImpl(CreateAnimalService createAnimalService) {
        this.createAnimalService = createAnimalService;
    }

    /**
     * Метод заполнения хранилища животными. Вызывается после создания объекта.
     */
    @PostConstruct
    private void fillingTheStorage() {
        animals = List.of(createAnimalService.createUniqueAnimals(10));
    }

    /**
     * Поиск имен животных, родившихся в високосные годы.
     *
     * @return Массив имен животных, родившихся в високосные годы.
     * @throws IllegalArgumentException Если список животных равен {@code null}.
     */
    @Override
    public String[] findLeapYearNames() {
        if (animals == null) {
            throw new IllegalArgumentException("Массив животных не может быть null");
        }

        List<String> leapYearNames;
        leapYearNames = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal != null && animal.getBirthDate() != null && animal.getBirthDate().isLeapYear()) {
                leapYearNames.add(animal.getName());
            }
        }

        if (leapYearNames.equals(new ArrayList<>())) {
            System.out.println("Нет ни одного животного рожденного в вискосный год");
        }
        return leapYearNames.toArray(new String[0]);

    }

    /**
     * Поиск животных, достигших заданного возраста.
     *
     * @param age Возраст для поиска.
     * @return Массив животных, достигших указанного возраста.
     * @throws IllegalArgumentException Если список животных равен {@code null}.
     */
    @Override
    public Animal[] findOlderAnimal(int age) {
        if (animals == null) {
            throw new IllegalArgumentException("Массив животных не может быть null");
        }

        List<Animal> olderAnimals = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal != null && animal.getBirthDate() != null) {
                int animalAge = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();

                if (animalAge >= age) {
                    olderAnimals.add(animal);
                }
            }
        }
        if (olderAnimals.equals(new ArrayList<>())) {
            System.out.println("Нет ни одного животного старше: " + age);
        }
        return olderAnimals.toArray(new Animal[0]);
    }

    /**
     * Поиск дублирующихся животных.
     *
     * @return Множество дублирующихся животных.
     * @throws IllegalArgumentException Если список животных равен {@code null}.
     */
    @Override
    public Set<Animal> findDuplicate() {
        if (animals == null) {
            throw new IllegalArgumentException("Массив животных не может быть null");
        }

        Map<String, List<Animal>> nameToAnimalsMap = new HashMap<>();

        for (Animal animal : animals) {
            if (animal != null) {
                String name = animal.getName();
                List<Animal> animalsWithSameName = nameToAnimalsMap.computeIfAbsent(name, k -> new ArrayList<>());
                animalsWithSameName.add(animal);
            }
        }

        Set<Animal> duplicates = new HashSet<>();

        for (List<Animal> animalList : nameToAnimalsMap.values()) {
            if (animalList.size() > 1) {
                duplicates.addAll(animalList);
            }
        }

        return duplicates;
    }

    /**
     * Метод выводит в консоль информацию о дублирующихся животных.
     */
    @Override
    public void printDuplicate() {
        System.out.println("======================");
        System.out.println("printDuplicate: ");
        Set<Animal> duplicateAnimals = findDuplicate();
        if (duplicateAnimals.equals(new HashSet<>())){
            System.out.println("Дубликатов нет");
        }
        else {
            for (Animal animal : duplicateAnimals) {
                System.out.println(animal.getName() + " - " + animal.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
        }
        System.out.println("======================");
    }
}
