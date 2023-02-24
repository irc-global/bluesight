package com.vaznoe.bluesight.tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoTest extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setup(ITestContext testContext) throws Exception {
        this.springTestContextPrepareTestInstance();
        testContext.setAttribute("WebDriver", this.driver);
        driver.manage().window().maximize();
    }

    @Test(groups = "regression")
    public void partialFormTest() {
        homePage.openPage()
                .verifyHomePageOpened()
                .navigateToMainMenu()
                .clickOnRequestDemo()
                .verifyRequestDemoWindowDisplayed()
                .fillOutCompanyStateProduct();

    }

    @Test(groups = "regression")
    public void costcheckSavingsTest() {
        String result = costCheckSavingsPage.openPage()
                .verifyCostCheckSavingsPageOpened()
                .setHospitalSize()
                .setRecommendedChangesPerMonth()
                .setOverchargesCorrectedPerMonth()
                .checkPotentialSavingsGeneratedPerMonth();
        assertThat(result).isEqualToIgnoringCase("$40,000");
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}
