package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class paymentPage {
    //private AndroidDriver driver;

    public paymentPage(AndroidDriver driver){
        //this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   //initialiser les composants facilement
    }

    //Atributs
    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Rebecca Winter\"]") 
    private WebElement fullName;

    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Card Number* input field\"]") 
    private WebElement cardNumber;

    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]") 
    private WebElement expirationDate;

    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Security Code* input field\"]") 
    private WebElement securityCode;

    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Review Order button\"]") 
    private WebElement gotToReviewOrderButton;

    
    //Méthodes
    public void inputPayementPage(String fullnameI, String carNb, String expDate, String secuCode){   
        fullName.clear();
        fullName.sendKeys(fullnameI);

        cardNumber.clear();
        cardNumber.sendKeys(carNb);

        expirationDate.clear();
        expirationDate.sendKeys(expDate);

        securityCode.clear();
        securityCode.sendKeys(secuCode);
    }

    public void clickOnGotToReviewOrderButton(){   
        gotToReviewOrderButton.click();
        gotToReviewOrderButton.click();
    }

}
