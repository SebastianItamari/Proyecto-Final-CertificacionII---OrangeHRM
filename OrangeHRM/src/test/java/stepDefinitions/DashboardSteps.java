package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en_scouse.An;
import org.junit.jupiter.api.Assertions;
import pages.DashboardPage;
import utilities.DriverManager;

public class DashboardSteps {
    DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver().driver);

    @And("The dashboard page should be displayed")
    public void verifyDashboardPageIsDisplayed(){
        Assertions.assertTrue(dashboardPage.dashboardTittleIsDisplayed());
    }

    @And("I click on PIM button")
    public void clickOnPIM() {
        dashboardPage.ClickOnPIM();
    }

    @And("I click on Buzz button")
    public void clickOnBuzz() {
        dashboardPage.ClickOnBuzz();
    }

    @And("I click on Recruitment button")
    public void clickOnRecruitment(){
        dashboardPage.ClickOnRecruitment();
    }
}
