package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import pages.PIMPage;
import utilities.DriverManager;

import java.util.List;

public class PIMSteps {

    PIMPage pimPage = new PIMPage(DriverManager.getDriver().driver);

    @And("I click on Add Employee Button")
    public void clickOnAddEmployeeButton()
    {
        pimPage.clickOnAddEmployee();
    }

    @And("I click on save button")
    public void clickOnSaveButton()
    {
        pimPage.clickOnSaveButton();
    }

    @And("I fill the employee information with")
    public void fillEmployeeInformation(DataTable employeeInformation){
        List<String> data = employeeInformation.transpose().asList(String.class);
        pimPage.setFirstNameTextBox(data.get(0));
        pimPage.setMiddleNameTextBox(data.get(1));
        pimPage.setLastNameTextBox(data.get(2));
    }

    @And("I click on Employee List Button")
    public void clickOnEmployeeListButton(){
        pimPage.clickOnEmployeeList();
    }

    @And("I set the employee name field with {string}")
    public void setEmployeeName(String name)
    {
        pimPage.setEmployeeNameTextBox(name);
    }

    @And("I click on search button")
    public void clickOnSearchButton(){
        pimPage.clickOnSearchButton();
    }

    @Then("Register of added employee is displayed")
    public void employeeIsDisplayed(){
        Assertions.assertTrue(pimPage.someEmployeeIsDisplayed());
    }
}
