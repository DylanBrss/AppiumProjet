package tests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import helpers.baseTest;
import pages.cartPage;
import pages.catalogProductsPage;
import pages.checkoutPage;
import pages.confirmationPage;
import pages.loginPage;
import pages.menu;
import pages.paymentPage;
import pages.productPage;
import pages.reviewPage;
// import utils.config;

public class firstTest extends baseTest{

    @Test
    public void test() throws InterruptedException, MalformedURLException {

        //startDevice();
        startAppiumServer();
        emulatorDriver();

        catalogProductsPage catalog = new catalogProductsPage(driver);   
        catalog.clickOnProductChoice();

        productPage produP = new productPage(driver);
        produP.clickOnProductColor(null);
        produP.clickOnProductQuantity(null);
        produP.clickOnButtonAddToCart(null);

        menu menuP = new menu(driver);
        menuP.clickOnCart();

        cartPage cartP = new cartPage(driver);
        cartP.clickOnCheckoutButton();

        loginPage LoginP = new loginPage(driver);
        LoginP.inputInfoLogin("bob@example.com", "10203040");
        LoginP.clickOnLoginButton();

        checkoutPage checkOutP = new checkoutPage(driver);
        checkOutP.inputCheckoutInfo("Boby Jones", "12 avenue de Paris", "Niort", "79000", "France");
        checkOutP.clickOnGoToPayementButton();

        paymentPage payementP =  new paymentPage(driver);
        payementP.inputPayementPage("Boby", "3258 1265 7568 789", "03/25", "123");
        payementP.clickOnGotToReviewOrderButton();

        reviewPage reviewP = new reviewPage(driver);
        reviewP.clickOnPlaceOrderButton();

        confirmationPage confirmP = new confirmationPage(driver);
        confirmP.checkMessageConfirmation("Thank you for your order", "Your new swag is on its way", " Your order has been dispatched and will arrive as fast as the pony gallops!");
        confirmP.clickOnContinueShoppingButton();
    }

}
