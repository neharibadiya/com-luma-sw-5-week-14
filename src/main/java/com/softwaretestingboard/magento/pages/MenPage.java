package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MenPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//select[@id='sorter']")
    WebElement selectFromDropDown;
    @CacheLookup
    @FindBy(xpath = "//strong[@class='product name product-item-name']//a[@class='product-item-link']")
    WebElement cronusYogaPant;

    @CacheLookup
    @FindBy(xpath = "//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']")
    WebElement CronusPant32;
    @CacheLookup
    @FindBy(xpath = "//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']")
    WebElement CronusBlackColour;
    @CacheLookup
    @FindBy(xpath = "//form[@action='https://magento.softwaretestingboard.com/checkout/cart/add/uenc/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9tZW4vYm90dG9tcy1tZW4vcGFudHMtbWVuLmh0bWw_cHJvZHVjdF9saXN0X29yZGVyPW5hbWU%2C/product/880/']//button[@class='action tocart primary']")
    WebElement buttonAddToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@data-product-id='880']")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='page messages']//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;
    @CacheLookup
    @FindBy(xpath = "//select[@id='sorter']")
    WebElement selectByProductName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='message-success success message']")
    WebElement successMessage;
    public void clickOnShoppingCartLink(){
        clickOnElement(shoppingCart);
        CustomListeners.test.log(Status.PASS, "Click on " + shoppingCart);
        Reporter.log("click on " + shoppingCart.toString());
    }

    public void sortByProductName() {
        selectByVisibleTextFromDropDown(selectByProductName, "Product Name");
        CustomListeners.test.log(Status.PASS, "Sort by product name " + selectByProductName);
        Reporter.log("sort by product name " + selectByProductName.toString());
    }

    public void clickOnCronousSize32() {
        clickOnElement(CronusPant32);
        CustomListeners.test.log(Status.PASS, "Click on " + CronusPant32);
        Reporter.log("click on " + cronusYogaPant.toString());
    }
    public void clickOnCronousBlack() {
        clickOnElement(CronusBlackColour);
        CustomListeners.test.log(Status.PASS, "Click on " + CronusBlackColour);
        Reporter.log("click on " + CronusBlackColour.toString());
    }

    public void mouseHoverOnCronusYogaAndClickAddCart() {
        mouseHoverToElement(productName);
        clickOnElement(buttonAddToCart);
        CustomListeners.test.log(Status.PASS, "Click on " + buttonAddToCart);
        Reporter.log("click on " + buttonAddToCart.toString());
    }

    public String getSuccessMsgText() {
        CustomListeners.test.log(Status.PASS, "Get message " + successMessage);
        Reporter.log("Get message " + successMessage.toString());
        return getTextFromElement(successMessage);
    }
}
