package com.vaznoe.bluesight.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RequestDemoPage extends BasePage {
    private static final By PAGE_TITLE = By.cssSelector(".modal-content h2");
    private static final By COMPANY = By.id("company-1a1d4855-3949-40d3-924a-a409c35d79bf");
    private static final By STATE = By.id("state_dropdown-1a1d4855-3949-40d3-924a-a409c35d79bf");
    private static final By PRODUCT = By.id("web_req_demo_product__c-1a1d4855-3949-40d3-924a-a409c35d79bf");

    @Override
    public RequestDemoPage openPage() {
        open(property.getBaseUrl());
        Selenide.$x("//a[text()='Request a Demo']").click();
        return new RequestDemoPage();
    }

    @Step("Verify the 'Request a Demo' modal window is displayed")
    public RequestDemoPage verifyRequestDemoWindowDisplayed() {
        $(PAGE_TITLE).isDisplayed();
        $(PAGE_TITLE).shouldHave(Condition.text("Request Demo"));
        return this;
    }

    @Step("Fill out form")
    public RequestDemoPage fillOutCompanyStateProduct() {
        Faker faker = new Faker();
        $(COMPANY).sendKeys(faker.company().name());
        $(STATE).selectOption("NJ");
        $(PRODUCT).selectOption("ControlCheck (Formerly Bluesight for Controlled Substances)");
        return this;
    }
}
