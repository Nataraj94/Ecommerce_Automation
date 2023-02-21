package actiondrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import reuseable.BaseClass;

import java.time.Duration;


public class UserAction extends BaseClass {

    public void Click(WebDriver driver, WebElement element){

        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();

    }

    public void SendKeys(String value, WebElement element){

        element.sendKeys(value);

    }

    public void implicitWait(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        }catch(Exception e) {
        }
    }
}
