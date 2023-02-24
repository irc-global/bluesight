package com.vaznoe.bluesight.pages;

import static com.codeborne.selenide.Selenide.open;

public class CostCheckSavingsPage extends BasePage {
    @Override
    public CostCheckSavingsPage openPage() {
        open(property.getBaseUrl() + "/costcheck-savings/");
        return new CostCheckSavingsPage();
    }
}
