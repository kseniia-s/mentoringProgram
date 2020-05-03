package com.epam.spring;

import com.epam.spring.configurations.ApplicationConfig;
import com.epam.spring.pageObjects.HomePage;
import com.epam.spring.pageObjects.LoginPage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ApplicationConfig.class)
@ActiveProfiles(profiles = "chrome")
public class SpringIntegrationTest {
}
