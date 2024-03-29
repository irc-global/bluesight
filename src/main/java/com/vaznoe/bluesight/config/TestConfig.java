package com.vaznoe.bluesight.config;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.vaznoe.bluesight", "com.codeborne.selenide", "io.qameta.allure"})
public class TestConfig {

    @Bean
    public WebDriver getDriver() {
        return WebDriverRunner.getAndCheckWebDriver();
    }
}