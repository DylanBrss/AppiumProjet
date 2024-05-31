package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class catalogProductsPage {
    //private AndroidDriver driver;

    public catalogProductsPage(AndroidDriver driver){
        //this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   //initialiser les composants facilement
    }

    //Attributs
    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]") 
    private WebElement productChoice;
    
    //Méthodes
    public void clickOnProductChoice(){   
        productChoice.click();
    }

}
