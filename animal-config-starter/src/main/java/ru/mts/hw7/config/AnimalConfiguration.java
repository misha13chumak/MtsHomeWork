package ru.mts.hw7.config;

import org.apache.commons.collections4.MapUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import static com.google.common.base.Preconditions.checkArgument;

public class AnimalConfiguration extends ConcurrentHashMap<String, List<String>> {

    private AnimalConfiguration() {
    }

    public static AnimalConfiguration createInstance(Map<String, List<String>> source) {
        checkArgument(MapUtils.isNotEmpty(source), "Пустой");

        final var result = new AnimalConfiguration();
        source.forEach((k, v) -> {
            if (Objects.isNull(v)) {
                throw new IllegalArgumentException("Ошибка");
            }

            result.put(k, v);
        });

        return result;
    }

}