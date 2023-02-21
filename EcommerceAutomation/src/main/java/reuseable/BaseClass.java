package reuseable;

import org.apache.log4j.Logger;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseClass {

    public static WebDriver driver;
    private static Logger log=null;
    public static Properties prop;


    public static WebDriver browserCall() throws IOException {

        String path = System.getProperty("user.dir");

        FileInputStream fileInputStream = new FileInputStream(new File(path+"//src//main//resources//configurations//Config.properties"));
        prop = new Properties();
        prop.load(fileInputStream);


        switch (prop.getProperty("Browser").toLowerCase())
        {
            case "chrome":

                System.setProperty("webdriver.chrome.driver", path + "//src//main//resources//drivers//chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "edge":

                driver = new EdgeDriver();
                break;

            case "firefox" :

                driver = new FirefoxDriver();
                break;

            default:

                throw new InvalidArgumentException("provide the correct browser name");
        }


        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;

    }
}
