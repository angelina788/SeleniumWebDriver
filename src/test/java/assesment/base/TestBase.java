package assesment.base;

import assesment.utulities.BrowserUtils;
import assesment.utulities.ConfigurationReader;
import assesment.utulities.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class TestBase {


    public WebDriver driver;

    @BeforeMethod
    public void user_on_ebay_page() throws InterruptedException{
       String browser = ConfigurationReader.getProperty("browser");
        Driver.getDriver().get(browser);
        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }





}
