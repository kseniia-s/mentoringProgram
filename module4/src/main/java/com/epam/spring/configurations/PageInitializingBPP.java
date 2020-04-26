package com.epam.spring.configurations;

import com.epam.spring.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PageInitializingBPP implements BeanPostProcessor {

    @Autowired
    private WebDriver driver;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAssignableFrom(BasePage.class)){
            ((BasePage) bean).init(driver);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
