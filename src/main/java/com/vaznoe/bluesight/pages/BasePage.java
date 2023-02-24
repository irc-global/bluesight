package com.vaznoe.bluesight.pages;

import com.vaznoe.bluesight.config.PageObjectConfig;
import com.vaznoe.bluesight.config.TestConfig;
import com.vaznoe.bluesight.config.properties.TestProperty;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = { TestConfig.class, PageObjectConfig.class })
public abstract class BasePage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected TestProperty property;

    public abstract <T> T openPage();
}