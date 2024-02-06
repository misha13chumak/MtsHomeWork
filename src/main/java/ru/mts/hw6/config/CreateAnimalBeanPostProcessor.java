package ru.mts.hw6.config;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import ru.mts.hw6.services.CreateAnimalService;


public class CreateAnimalBeanPostProcessor implements BeanPostProcessor {

    /**
     * Этот метод вызывается после инициализации экземпляра бина.
     *
     * @param bean     Инициализированный экземпляр бина.
     * @param beanName Имя бина.
     * @return Экземпляр бина после любой обработки инициализации.
     */
    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CreateAnimalService){
            ((CreateAnimalService) bean).fillingTypeAnimal();
        }
        return bean;
    }
}