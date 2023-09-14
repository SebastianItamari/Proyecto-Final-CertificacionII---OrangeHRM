package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.BuzzPage;
import pages.RecruitmentPage;
import utilities.DriverManager;

import java.util.List;

public class RecruitmentSteps {
    RecruitmentPage recruitmentPage  = new RecruitmentPage(DriverManager.getDriver().driver);

    @And("I click on Vacancies button")
    public void clickOnVacancies(){
        recruitmentPage.clickOnVacancies();
    }

    @And("I click on the first edit icon")
    public void clickOnFirstCommentIcon()
    {
        recruitmentPage.clickOnFirstEditIcon();
    }

    @And("I update the vacancy information with")
    public void updateVacancyInformation(DataTable vacancyInformation) {
        List<String> data = vacancyInformation.transpose().asList(String.class);

        recruitmentPage.setVacancyDescriptionTextBox(data.get(2));
        recruitmentPage.setNumberOfPositionsTextBox(data.get(3));
        recruitmentPage.setVacancyNameTextBox(data.get(0));
        recruitmentPage.setJobTitleOption(data.get(1));
    }

    @When("I click on the save button")
    public void saveButton(){
        recruitmentPage.clickOnSaveButton();
    }

    @Then("A vacancy appears with the values")
    public void vacancyIsDisplayed(DataTable vacancyInformation) {
        List<String> data = vacancyInformation.transpose().asList(String.class);
        Assertions.assertTrue(recruitmentPage.firstVacancyNameIsDisplayed(data.get(0)));
        //recruitmentPage.firstVacancyNameIsDisplayed(data.get(0));
        //recruitmentPage.firstJobTitleIsDisplayed(data.get(1));
        Assertions.assertTrue(recruitmentPage.firstJobTitleIsDisplayed(data.get(1)));
    }
}
