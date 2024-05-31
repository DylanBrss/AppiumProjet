package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class confirmationPage {
    // private AndroidDriver driver;

    public confirmationPage(AndroidDriver driver) {
        // this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // initialiser les composants facilement
    }

    // Attributs
    @CacheLookup // optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Thank you for your order\"]")
    private WebElement confirmationMessage1;

    @CacheLookup // optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Your new swag is on its way\"]")
    private WebElement confirmationMessage2;

    @CacheLookup // optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\" Your order has been dispatched and will arrive as fast as the pony gallops!\"]")
    private WebElement confirmationMessage3;

    @CacheLookup // optimiser les temps de réponse
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Continue Shopping\"]")
    private WebElement continueShoppingButton;

    // Méthodes
    public void checkMessageConfirmation(String msg1, String msg2, String msg3) {
        assert(msg1.equals(confirmationMessage1.getText()));
        assert(msg2.equals(confirmationMessage2.getText()));
        assert(msg3.equals(confirmationMessage3.getText()));
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }
}
