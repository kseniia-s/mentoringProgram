package com.epam.spring.configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.*;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "com.epam.spring")
@PropertySource("classpath:github.properties")
@PropertySource("classpath:test.properties")
public class ApplicationConfig {

    @Bean(destroyMethod = "close")
    @Profile("chrome")
    public WebDriver getChromeDriver() {
        WebDriverManager.globalConfig().setForceCache(false);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }

    @Bean(destroyMethod = "close")
    @Profile("firefox")
    public WebDriver getFirefoxDriver() {
        WebDriverManager.globalConfig().setForceCache(false);
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().window().maximize();
        firefoxDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        return firefoxDriver;
    }
}
