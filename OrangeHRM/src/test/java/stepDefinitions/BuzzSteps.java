package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.BuzzPage;
import utilities.DriverManager;

public class BuzzSteps {
    BuzzPage buzzPage  = new BuzzPage(DriverManager.getDriver().driver);

    @And("I click on the first comment icon")
    public void clickOnFirstCommentIcon()
    {
        buzzPage.clickOnFirstMessageIcon();
    }

    @And("I comment {string} on the first post")
    public void commentOnTheFirstPost(String comment) {
        buzzPage.comment(comment);
    }

    @Then("Comment {string} is displayed")
    public void commentIsDisplayed(String comment)
    {
        Assertions.assertTrue(buzzPage.someCommentIsDisplayed(comment));
    }

    @And("I click on post button")
    public void clickOnPostButton(){
        buzzPage.clickOnPostButton();
    }

    @When("I set the post field with {string}")
    public void setPostField(String postText){
        buzzPage.setPostTextArea(postText);
    }

    @Then("The post {string} is displayed")
    public void textPostIsDisplayed(String postText) {
        Assertions.assertTrue(buzzPage.postTextIsDisplayed(postText));
    }
}
