package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BuzzPage extends CommonPage{
    WebDriver driver;
    Actions actions;

    public BuzzPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnFirstMessageIcon()
    {
        List<WebElement> commentIcons = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='orangehrm-buzz-post-actions']/button/i[@class='oxd-icon bi-chat-text-fill']")));
        commentIcons.get(0).click();
    }

    public void comment(String comment) {
        WebElement commentTextBox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Write your comment...']")));
        commentTextBox.sendKeys(comment);
        actions.sendKeys(commentTextBox, Keys.ENTER).perform();
    }

    public boolean someCommentIsDisplayed(String comment)
    {
        try {
            List<WebElement> comments = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='oxd-text oxd-text--span orangehrm-post-comment-text']")));

            for(WebElement element : comments){
                if(element.getText().equalsIgnoreCase(comment)){
                    return true;
                }
            }
            return false;
        }
        catch (Exception e)
        {
            logout();
            return false;
        }
    }

    public void setPostTextArea(String post){
        WebElement postTextArea = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@class='oxd-buzz-post-input']")));
        postTextArea.sendKeys(post);
    }

    public void clickOnPostButton(){
        WebElement postButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main']")));
        postButton.click();
    }

    public boolean postTextIsDisplayed(String postText)
    {
        try {
            WebElement postButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"" + postText + "\"]")));
            return postButton.isDisplayed();
        }
        catch (Exception e)
        {
            logout();
            return false;
        }
    }
}
