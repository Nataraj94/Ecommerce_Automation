package page_objects;


import excelreading.ReadExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage {

   private static WebDriver driver;

    protected By searchBarText =  By.xpath("//input[@type='text']");
    protected By searchButton = By.xpath("//input[@type='submit']");
    protected By selectProduct = By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']");

    protected By addToCart = By.xpath("//input[@name='submit.addToCart']");

    protected By goToCart = By.xpath("//a[@id='nav-cart']");

    protected By removeCart = By.xpath("//div[@class='a-row sc-action-links']//span[@class='a-declarative']//input[@value='Delete']");



    public SearchPage(WebDriver driver){
        this.driver=driver;

    }
    public void SearchBar(){

        driver.findElement(searchBarText).sendKeys(ReadExcel.readExcel("Product",0,0));

    }
    public void SearchButton(){

        driver.findElement(searchButton).click();
    }

    public void SelectProduct(){

        String productName = "Dell Inspiron 3583";
        List<WebElement> list = driver.findElements(selectProduct);

        //boolean flag = false;
        //int counter=0;

        for(int i=0;i< list.size();i++){
            if(list.get(i).getText().contains(productName)){
                list.get(i).click();
                break;
            }
        }

    }

    public void AddToCart(){

        driver.findElement(addToCart).click();

    }
    public void GoToCart(){

        driver.findElement(goToCart).click();
    }
    public void RemoveProduct(){

        driver.findElement(removeCart).click();
    }


}
