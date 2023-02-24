package com.vaznoe.bluesight.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Component
public class HomePage extends BasePage {

    private static final By HOME_PAGE = By.cssSelector("#hero");
    private static final By MAIN_MENU = By.cssSelector(".main-menu.collapse.navbar-collapse.justify-content-end");
    private static final By REQUEST_DEMO_BTN = By.linkText("Request a Demo");

    @Override
    public HomePage openPage() {
        open(property.getBaseUrl());
        return new HomePage();
    }

    @Step("Verify Home page opened")
    public HomePage verifyHomePageOpened() {
        $(HOME_PAGE).isDisplayed();
        return this;
    }

    @Step("Navigate to main menu")
    public HomePage navigateToMainMenu() {
        $(MAIN_MENU).isDisplayed();
        return this;
    }

    @Step("Clikc on 'Request a Demo' button")
    public RequestDemoPage clickOnRequestDemo() {
        $(MAIN_MENU).$(REQUEST_DEMO_BTN).click();
        return new RequestDemoPage();
    }
}