package com.vaznoe.bluesight.tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebTest extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setup(ITestContext testContext) throws Exception {
        this.springTestContextPrepareTestInstance();
        testContext.setAttribute("WebDriver", this.driver);
        driver.manage().window().maximize();
    }

    @Test(groups = "web")
    public void partialFormTest() {
        homePage.openPage()
                .verifyHomePageOpened()
                .navigateToMainMenu()
                .clickOnRequestDemo()
                .verifyRequestDemoWindowDisplayed()
                .fillOutCompanyStateProduct();

    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}
