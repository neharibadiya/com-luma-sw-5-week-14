package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.GearPage;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.ShoppingCartPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Listeners(CustomListeners.class)
public class GearPageTest extends BaseTest {
    HomePage homePage;
    GearPage gearPage;
    ShoppingCartPage shoppingCartPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setBrowser() {
        gearPage = new GearPage();
        homePage = new HomePage();
        shoppingCartPage = new ShoppingCartPage();
        softAssert = new SoftAssert();
    }


    @Test(groups = {"smoke", "regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        homePage.mouseHoverOnGearMenu();
        homePage.clickOnBagMenu();
        gearPage.clickOnNightDuffleBag();
        softAssert(gearPage.verifyTheBagText(), "Overnight Duffle", "The bag name is incorrect");
        gearPage.changeTheQuantityOfTheBag("3");
        gearPage.clickOnAddToCartButton();
        softAssert(gearPage.bagAddedToCartSuccessfullyMessage(), "You added Overnight Duffle to your shopping cart.","Bag is added successfully");
        gearPage.clickOnShoppingCartLink();
        softAssert(shoppingCartPage.verifyTheProductsName(), "Overnight Duffle", "The Bag Name is incorrect");
        softAssert(shoppingCartPage.getQuantityOfProduct(), "3", "Wrong quantity");
        softAssert(shoppingCartPage.getPriceOfTheProduct(), "$135.00", "Incorrect price");
        shoppingCartPage.changeTheQuantityOfTheBag("5");
        shoppingCartPage.updateTheShoppingCart();
        softAssert(shoppingCartPage.UpdatedProductPrice(), "$225.00", "Wrong price");
        softAssert.assertAll();
    }
}
