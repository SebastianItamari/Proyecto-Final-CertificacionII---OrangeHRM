package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage extends CommonPage{
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickOnPIM() {
        WebElement pimButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='PIM']")));
        pimButton.click();
    }

    public void ClickOnBuzz() {
        WebElement buzzButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Buzz']")));
        buzzButton.click();
    }

    public void ClickOnRecruitment() {
        WebElement recruitmentButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Recruitment']")));
        recruitmentButton.click();
    }

    public boolean dashboardTittleIsDisplayed(){
        try{
            WebElement dashboardTittle = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")));

            return dashboardTittle.isDisplayed();
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
