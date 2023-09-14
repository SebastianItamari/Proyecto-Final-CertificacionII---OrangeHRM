package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.CommonPage;
import utilities.DriverManager;

public class CommonSteps {

    CommonPage commonPage = new CommonPage(DriverManager.getDriver().driver);

    @Given("I am in OrangeHRM web page")
    public void goToOrangeHRMPage(){
        DriverManager.getDriver().driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        DriverManager.getDriver().driver.manage().window().maximize();
    }

    @And("I logout of OrangeHRM")
    public void logout(){
        commonPage.logout();
    }
}
