package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.GearPage;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.MenPage;
import com.softwaretestingboard.magento.pages.ShoppingCartPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Listeners(CustomListeners.class)
public class MenPageTest extends BaseTest {
    MenPage menPage;
    HomePage homePage;
    GearPage gearPage;
    ShoppingCartPage shoppingCartPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setBrowser() {
        menPage = new MenPage();
        gearPage = new GearPage();
        homePage = new HomePage();
        shoppingCartPage = new ShoppingCartPage();
        softAssert = new SoftAssert();
    }

    @Test(groups = {"smoke","regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        homePage.hoverMouseOnMenMenu();
        homePage.hoverMouseOnMenBottom();
        homePage.clickOnMenPantsMenu();
        menPage.sortByProductName();
        menPage.clickOnCronousSize32();
        menPage.clickOnCronousBlack();
        menPage.mouseHoverOnCronusYogaAndClickAddCart();
        softAssert(menPage.getSuccessMsgText(), "You added Cronus Yoga Pant to your shopping cart.","Product is not added in cart");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        menPage.clickOnShoppingCartLink();
        softAssert(shoppingCartPage.getTheShoppingCartPageTitle(), "Shopping Cart","Shopping cart not displayed");
        softAssert(shoppingCartPage.verifyTheProductsName(), "Cronus Yoga Pant","Product is not right");
        softAssert(shoppingCartPage.getTheSizeOfThePants(), "32","Size is not correct");
        softAssert(shoppingCartPage.getTheColourOfThePants(), "Black","Colour is not correct");
        softAssert.assertAll();
    }
}
