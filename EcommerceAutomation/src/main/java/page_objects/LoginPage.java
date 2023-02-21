package page_objects;

import actiondrivers.UserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reuseable.BaseClass;


import java.io.IOException;


public class LoginPage extends BaseClass {

    private static WebDriver driver;


    protected By txt_username = By.name("email");
    protected By txt_password = By.name("password");
    protected By btn_continue = By.id("continue");
    protected By btn_login = By.id("signInSubmit");



    public LoginPage(WebDriver driver){

        this.driver=driver;

    }

    public void enterUserName() throws IOException {

        driver.findElement(txt_username).sendKeys(prop.getProperty("Username"));


    }
    public void enterPassWord() throws IOException {

        driver.findElement(txt_password).sendKeys(prop.getProperty("Password"));

    }
    public void continueButton(){

        driver.findElement(btn_continue).click();
    }
    public void ClickLogin(){

        driver.findElement(btn_login).click();
    }
}
