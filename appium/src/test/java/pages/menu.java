package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class menu {
    //private AndroidDriver driver;

    public menu(AndroidDriver driver){
        //this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   //initialiser les composants facilement
    }

    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView") 
    private WebElement cart;
    
    //Méthodes
    public void clickOnCart(){   
        cart.click();
    }
}