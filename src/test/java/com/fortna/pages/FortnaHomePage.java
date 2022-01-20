package com.fortna.pages;

import com.fortna.utility.ConfigReader;
import com.fortna.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FortnaHomePage {

    @FindBy(xpath = "//a[@class='contact-btn button']")
    private WebElement contact;

    @FindBy(name="s")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@class='button']")
    private WebElement searchBtn;



    public FortnaHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void goTo(){

        Driver.getDriver().get(ConfigReader.read("fortna.url"));

    }


    public boolean isAt(){

        return Driver.getDriver().getTitle().
                equals("Warehouse Optimization, Design, & Automation Services | Fortna");

    }

    public void searchKeyword( String keyword  ){

        this.searchBox.sendKeys(  keyword  );
        this.searchBtn.submit();

    }

}
