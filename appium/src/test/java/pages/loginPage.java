package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPage {
    //private AndroidDriver driver;

    public loginPage(AndroidDriver driver){
        //this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   //initialiser les composants facilement
    }

    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Username input field\"]") 
    private WebElement username;

    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]") 
    private WebElement password;

    @CacheLookup //optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login button\"]") 
    private WebElement loginButton;

    
    //Méthodes
    public void inputInfoLogin(String userN, String pwd){
        username.clear(); 
        username.sendKeys(userN);

        password.clear();
        password.sendKeys(pwd);
    }
    
    public void clickOnLoginButton(){   
        loginButton.click();
    }
}
