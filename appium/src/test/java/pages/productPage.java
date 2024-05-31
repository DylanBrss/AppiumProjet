package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class productPage {
    //private AndroidDriver driver;

    public productPage(AndroidDriver driver){
        //this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   //initialiser les composants facilement
    }

    //Atributs
    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"red circle\"]/android.view.ViewGroup") 
    private WebElement productColor;

    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView") 
    private WebElement productQuantity;

    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]") 
    private WebElement addToCartButton;

    
    //Méthodes
    public void clickOnProductColor(String productItemName){   
        productColor.click();
    }

    public void clickOnProductQuantity(String productItemName){   
        productQuantity.click();
    }
    
    public void clickOnButtonAddToCart(String productItemName){   
        addToCartButton.click();
    }

}
