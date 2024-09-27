package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement pass;

    @FindBy(xpath = "//input[@class='button']")
    WebElement btn;

    @FindBy(id="rightPanel")
    WebElement ishome;

    public void openWebsite(){
        driver.get(" https://parabank.parasoft.com/parabank/index.htm");
    }

    public void enterDetails(String username ,String password){
        userName.sendKeys(username);
        pass.sendKeys(password);
        btn.click();

    }
    public boolean inhomePage(){
        return btn.isDisplayed();
    }
    public boolean inLoginPage(){
        return ishome.isDisplayed();
    }
}
