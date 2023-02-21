package com.amazon.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import reuseable.BaseClass;

public class Hooks extends BaseClass {


    @Before
    public void preCondition(){
        String path = System.getProperty("user.dir") + "/src/test/resources/log4j.properties";
        PropertyConfigurator.configure(path);
    }

    @AfterStep
    public void captureScreenshot(Scenario sc){

        byte[] screenshot =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        sc.attach(screenshot,"image/png",null);

    }
    @After
    public void TearDown(){

        driver.quit();
    }

}
