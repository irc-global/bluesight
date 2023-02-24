package com.vaznoe.bluesight.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CostCheckSavingsPage extends BasePage {
    private static final By PAGE_TITLE = By.cssSelector(".row h1");
    private static final By HOSPITAL = By.id("hospitalSize");
    private static final By CHANGES = By.id("changesPerMonth");
    private static final By OVERCHANGES = By.id("overchargesPerMonth");
    private static final By SAVINGS = By.cssSelector(".row.mb-2.flex-nowrap--.align-items-end .flourish");

    @Override
    public CostCheckSavingsPage openPage() {
        open(property.getBaseUrl() + "/costcheck-savings/");
        return new CostCheckSavingsPage();
    }

    @Step("Verify Home page opened")
    public CostCheckSavingsPage verifyCostCheckSavingsPageOpened() {
        $(PAGE_TITLE).isDisplayed();
        $(PAGE_TITLE).shouldHave(Condition.text("Savings Calculator"));
        return this;
    }

    @Step("Set hospital/ idn size to 'Medium (between 3–60M annual spend)'")
    public CostCheckSavingsPage setHospitalSize() {
        $(HOSPITAL).selectOption("Medium (between $3 – $60M annual spend)");
        return this;
    }

    @Step("Set Recommended Changes per Month to '10'")
    public CostCheckSavingsPage setRecommendedChangesPerMonth() {
        $(CHANGES).selectOption("10");
        return this;
    }

    @Step("Set Overcharges Corrected per Month to '10'")
    public CostCheckSavingsPage setOverchargesCorrectedPerMonth() {
        $(OVERCHANGES).scrollTo();
        $(OVERCHANGES).selectOption("10");
        return this;
    }

    @SneakyThrows
    @Step("Check new value Potential Savings Generated per Month")
    public String checkPotentialSavingsGeneratedPerMonth() {
        Thread.sleep(2000);
        return $$(SAVINGS).get(2).getText();
    }
}
