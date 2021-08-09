package assesment.test;

import assesment.base.TestBase;
import assesment.pages.USLocators;
import assesment.utulities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileWriter;
import java.io.IOException;


public class US2_changePhrase extends TestBase {

    //Step 1: Create a web automation project that navigates to https://www.sandbox.ebay.com/
    //Step 2: Once on that webpage, have the automation search for a phrase in the search box.
    //        Allow this phrase to be substituted for any word or phrase of our choosing and allow this phrase
    //        to be easily configured so that people not familiar with the automation can easily change the search
    //        phrase to control how the automation performs.
    //Step 3: Once the phrase has been typed into the search box, have the automation click the search button.

    @Test(description = "Verify user can search info from search box(non technical people can change the phrase)")
    public void test1() throws InterruptedException {
        USLocators test = new USLocators();
        test.searchBoxField("Light");
    }


    //Step 4: Have the automation change the items per page dropdown to be 200 items.

    @Test(description = "Have the automation change the items per page dropdown to be 200 items.")
    public void test2() throws InterruptedException, IOException {
        //implement our first page to get our search page
        USLocators test = new USLocators();
        test.searchBoxField("Light");
        //navigate our WebDriver to found our DropDown list to choose item200
        WebElement text = Driver.getDriver().findElement(By.xpath("//span[@class='srp-ipp__label']"));
        text.click();
        WebElement dropdown = Driver.getDriver().findElement(By.xpath("//button[@class='fake-menu-button__button expand-btn expand-btn--small expand-btn--secondary']"));
        dropdown.click();
        WebElement item200 = Driver.getDriver().findElement(By.xpath("//div[@class='fake-menu-button__items']//a[3]"));
        item200.click();

        //Step 5: If there is more than one page of results, have the automation
        // navigate to the very last page of results.
        WebElement nextPage = Driver.getDriver().findElement(By.xpath("//a[@type='next']"));
        nextPage.click();

        //Step 6: Once on the last page, have the automation click on the last
        // item in the list of search results.
        WebElement lastItem = Driver.getDriver().findElement(By.xpath("//li[@data-view='mi:1686|iid:33']"));
        //use the actions object to reach Actions class methods
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(lastItem).perform();
        lastItem.click();

        WebElement price = Driver.getDriver().findElement(By.xpath("//span[@content='11.99']"));
        Assert.assertTrue(price.isDisplayed(), "$11.99");

        //Step 8: Make the automation retrieve the information for the following
        // fields from the item listing: Condition, Shipping, Item location, Seller.
        WebElement condition = Driver.getDriver().findElement(By.xpath("//span[@id='vi-cond-addl-info']"));
        System.out.println("Item condition: " + condition.getText());
        //findElement(By.xpath("//span[@id='vi-cond-addl-info']").getText();
        WebElement shipping = Driver.getDriver().findElement(By.xpath("//span[@id='fShippingSvc']"));
        System.out.println("Shipping from: " + shipping.getText());
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        WebElement itemLocation = Driver.getDriver().findElement(By.xpath("//span[@itemprop='availableAtOrFrom']"));
        System.out.println("Item Location is: " + itemLocation.getText());
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        WebElement seller = Driver.getDriver().findElement(By.xpath("//span[@class='mbg-nw']"));
        System.out.println("Seller is: " + seller.getText());

        //Step 9: Write these fields to a CSV file where each field is on a separate row.
        // Allow the CSV file to be written to anyone’s machine
        // (i.e. file path not hardcoded to run for a certain user on your machine).

        String dataOutput = condition.getText()+ "\n" + shipping.getText()+ "\n" +
                             itemLocation.getText()+ "\n" + seller.getText();
        String csvOutput = "table.csv";

        try (FileWriter writecsv = new FileWriter("table.csv")) {
            writecsv.append(dataOutput);
        }









    }
}











