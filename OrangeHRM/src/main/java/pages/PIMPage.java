package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PIMPage extends CommonPage{
    WebDriver driver;

    public PIMPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddEmployee()
    {
        WebElement addEmployeeButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Add Employee")));
        addEmployeeButton.click();
    }

    public void setFirstNameTextBox(String firstName){
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("firstName")));
        userNameTextBox.sendKeys(firstName);
    }

    public void setMiddleNameTextBox(String middleName){
        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("middleName")));
        passwordTextBox.sendKeys(middleName);
    }

    public void setLastNameTextBox(String lastName){
        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("lastName")));
        passwordTextBox.sendKeys(lastName);
    }

    public void clickOnSaveButton()
    {
        WebElement saveButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")));
        saveButton.click();
    }

    public void clickOnEmployeeList()
    {
        WebElement employeeListButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Employee List")));
        employeeListButton.click();
    }

    public void setEmployeeNameTextBox(String name){
        WebElement employeeNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Employee Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/div/div/input")));
        employeeNameTextBox.sendKeys(name);
    }

    public void clickOnSearchButton()
    {
        WebElement searchButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")));
        searchButton.click();
    }
    public boolean someEmployeeIsDisplayed(){
        try {
            List<WebElement> results = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']")));
            return !results.isEmpty();
        }
        catch (Exception e)
        {
            logout();
            return false;
        }
    }
}
