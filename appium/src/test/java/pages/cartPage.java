package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class cartPage {
    //private AndroidDriver driver;

    public cartPage(AndroidDriver driver){
        //this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   //initialiser les composants facilement
    }

      //Attributs
      @CacheLookup //optimiser les temps de réponse
      @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Proceed To Checkout\"]") 
      private WebElement checkoutButton;
      
      //Méthodes
      public void clickOnCheckoutButton(){   
        checkoutButton.click();
      }

}
