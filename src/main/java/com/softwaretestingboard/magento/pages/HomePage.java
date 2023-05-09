package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @FindBy(xpath = "//span[normalize-space()='Women']")
    WebElement womenMenu;
    @FindBy(id = "ui-id-5")
    WebElement menMenu;
    @FindBy(xpath = "//ul[@class='ui-menu ui-widget ui-widget-content ui-corner-all']/li[4]")
    WebElement gearMenu;
    @FindBy(xpath = "//a[@id='ui-id-9']")
    WebElement womenTopMenu;
    @FindBy(id = "ui-id-11")
    WebElement womenJacketMenu;
    @FindBy(id = "ui-id-18")
    WebElement menBottomMenu;
    @FindBy(linkText = "Pants")
    WebElement menPantsMenu;
    @FindBy(xpath = "//span[normalize-space()='Bags']")
    WebElement gearBagMenu;

    public void mouseHoverOnWomenMenu(){
        CustomListeners.test.log(Status.PASS, "Mouse hover on women menu" + womenMenu);
        mouseHoverToElement(womenMenu);
        Reporter.log("Mouse hover " + womenMenu.toString());

    }

    public void mouseHoverOnWomenTopMenu() {
        CustomListeners.test.log(Status.PASS, "selecting top menu" + womenTopMenu);
        Reporter.log("Select top " + womenTopMenu.toString());
        mouseHoverToElement(womenTopMenu);
    }

    public void clickOnWomenJacketMenu() {
        CustomListeners.test.log(Status.PASS, "selecting jacket " + womenJacketMenu);
        clickOnElement(womenJacketMenu);
        Reporter.log("Select jacket " + womenJacketMenu.toString());
    }

    public void hoverMouseOnMenMenu() {
        CustomListeners.test.log(Status.PASS, "Men menu " + menMenu);
        mouseHoverToElement(menMenu);
        Reporter.log("Men menu" + menMenu.toString());
    }

    public void hoverMouseOnMenBottom() {
        CustomListeners.test.log(Status.PASS, "Bottom menu " + menBottomMenu);
        mouseHoverToElement(menBottomMenu);
        Reporter.log("Bottom menu" + menBottomMenu.toString());
    }

    public void clickOnMenPantsMenu() {
        CustomListeners.test.log(Status.PASS, "Pants menu " + menPantsMenu);
        clickOnElement(menPantsMenu);
        Reporter.log("Pants menu" + menPantsMenu.toString());
    }

    public void mouseHoverOnGearMenu() {
        CustomListeners.test.log(Status.PASS, "gear menu " + gearMenu);
        mouseHoverToElement(gearMenu);
        Reporter.log("Gear menu" + gearMenu.toString());
    }

    public void clickOnBagMenu() {
        CustomListeners.test.log(Status.PASS, "gear bag menu " + gearBagMenu);
        clickOnElement(gearBagMenu);
        Reporter.log("click on bag menu " + gearBagMenu.toString());
    }
}
