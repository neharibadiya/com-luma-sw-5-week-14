package com.softwaretestingboard.magento.testbase;

import com.softwaretestingboard.magento.propertyreader.PropertyReader;
import com.softwaretestingboard.magento.utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Jay Vaghani
 */
public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp() {
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

}
