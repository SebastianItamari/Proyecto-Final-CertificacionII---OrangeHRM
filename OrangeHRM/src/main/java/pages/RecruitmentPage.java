package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RecruitmentPage extends CommonPage {
    WebDriver driver;

    public RecruitmentPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnVacancies()
    {
        WebElement employeeListButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Vacancies")));
        employeeListButton.click();
    }
    public void clickOnFirstEditIcon()
    {
        List<WebElement> editIcons = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//i[@class='oxd-icon bi-pencil-fill']")));
        editIcons.get(0).click();
    }

    public void setVacancyNameTextBox(String name){
        WebElement vacancyNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Vacancy Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input")));

        vacancyNameTextBox.sendKeys(Keys.CONTROL + "a");
        vacancyNameTextBox.sendKeys(Keys.DELETE);
        vacancyNameTextBox.sendKeys(name);
    }

    public void setVacancyDescriptionTextBox(String description){
        WebElement vacancyDescriptionTextBox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")));
        vacancyDescriptionTextBox.sendKeys(Keys.CONTROL + "a");
        vacancyDescriptionTextBox.sendKeys(Keys.DELETE);
        vacancyDescriptionTextBox.sendKeys(description);
    }

    public void setNumberOfPositionsTextBox(String number){
        WebElement numberOfPositionsTextBox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Number of Positions']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input")));
        numberOfPositionsTextBox.sendKeys(Keys.CONTROL + "a");
        numberOfPositionsTextBox.sendKeys(Keys.DELETE);
        numberOfPositionsTextBox.sendKeys(number);
    }

    public void setJobTitleOption(String option){
        WebElement jobTitleOptions = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Job Title']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div[@class='']")));
        jobTitleOptions.click();

        WebElement selectedOption = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + option + "']")));
        selectedOption.click();
    }

    public void clickOnSaveButton() {
        WebElement saveButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()=' Save ']")));
        saveButton.click();
    }

    public boolean firstVacancyNameIsDisplayed(String name)
    {
        try {
            WebElement vacancyName = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='" + name + "']")));
            return vacancyName.getText().equalsIgnoreCase(name);
        }
        catch (Exception e)
        {
            logout();
            return false;
        }
    }

    public boolean firstJobTitleIsDisplayed(String title)
    {
        try {
            WebElement jobTitle = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='" + title + "']")));
            return jobTitle.getText().equalsIgnoreCase(title);
        }
        catch (Exception e)
        {
            logout();
            return false;
        }
    }
}
