package assesment.pages;


import assesment.utulities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class USLocators {

    //locator field searchBox
    @FindBy (xpath = "//input[@class='gh-tb ui-autocomplete-input']")
    public WebElement searchBox; // --> on ebay page

    @FindBy (xpath = "//input[@class='btn btn-prim gh-spr']")
    public WebElement searchButton;


    public void searchBoxField( String phrase){

        searchBox.sendKeys(phrase);
        searchButton.click();


    }

    public USLocators() throws InterruptedException {
        // Constructor is mandatory if we will use @Find by Elements annotations
        PageFactory.initElements(Driver.getDriver(), this);
    }



}
