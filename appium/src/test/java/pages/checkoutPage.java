package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class checkoutPage {
    //private AndroidDriver driver;

    public checkoutPage(AndroidDriver driver){
        //this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   //initialiser les composants facilement
    }


     //Attributs
      @CacheLookup //optimiser les temps de réponse
      @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Full Name* input field\"]") 
      private WebElement fullName;

      @CacheLookup //optimiser les temps de réponse
      @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]") 
      private WebElement addressLine;

      @CacheLookup //optimiser les temps de réponse
      @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"City* input field\"]") 
      private WebElement city;

      @CacheLookup //optimiser les temps de réponse
      @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Zip Code* input field\"]") 
      private WebElement zipCode;

      @CacheLookup //optimiser les temps de réponse
      @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Country* input field\"]") 
      private WebElement country;

      @CacheLookup //optimiser les temps de réponse
      @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"To Payment button\"]") 
      private WebElement goToPayementButton;
      
      //Méthodes
      public void inputCheckoutInfo(String fullnameI, String adressI, String cityI, String zipCodeI, String countryI){   
        fullName.clear();
        fullName.sendKeys(fullnameI);

        addressLine.clear();
        addressLine.sendKeys(adressI);

        city.clear();
        city.sendKeys(cityI);

        zipCode.clear();
        zipCode.sendKeys(zipCodeI);

        country.clear();
        country.sendKeys(countryI);
      }

      public void clickOnGoToPayementButton(){   
        goToPayementButton.click();
      }

}
