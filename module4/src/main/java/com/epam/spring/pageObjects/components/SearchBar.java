package com.epam.spring.pageObjects.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;


@Component
@Scope(SCOPE_PROTOTYPE)
public class SearchBar {
}
