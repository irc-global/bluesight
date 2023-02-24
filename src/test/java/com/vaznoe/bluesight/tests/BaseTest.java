package com.vaznoe.bluesight.tests;

import com.github.javafaker.Faker;
import com.vaznoe.bluesight.config.PageObjectConfig;
import com.vaznoe.bluesight.config.TestConfig;
import com.vaznoe.bluesight.config.properties.TestProperty;
import com.vaznoe.bluesight.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = {TestConfig.class, PageObjectConfig.class})
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    public WebDriver driver;

    @Autowired
    protected TestProperty testProperty;

    @Autowired
    protected HomePage homePage;
}