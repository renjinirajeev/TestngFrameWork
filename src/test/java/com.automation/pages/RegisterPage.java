package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Currency;
import java.util.Random;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//p/a[text()='Register']")
    WebElement RegBtn;

    @FindBy(id = "customer.firstName")
    WebElement firstName;

    @FindBy(id = "customer.lastName")
    WebElement lastName;

    @FindBy(id = "customer.address.street")
    WebElement address;

    @FindBy(id = "customer.address.city")
    WebElement city;

    @FindBy(id = "customer.address.state")
    WebElement state;

    @FindBy(id = "customer.address.zipCode")
    WebElement zip;

    @FindBy(id = "customer.phoneNumber")
    WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    WebElement ssn;

    @FindBy(id = "customer.username")
    WebElement userName;

    @FindBy(id = "customer.password")
    WebElement passWord;

    @FindBy(id = "repeatedPassword")
    WebElement cnfPassWord;

    @FindBy(xpath = "//td/input[@class='button']")
    WebElement submitRegBtn;

    @FindBy(xpath = "//h1[@class='title']")
    WebElement welcome;

    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully.')]")
    WebElement successMsg;

    @FindBy(id="rightPanel")
    WebElement welcomeMsg;

    public void openWebsite(){
        driver.get(" https://parabank.parasoft.com/parabank/index.htm");
    }
    
    public void makeRegister(){
        RegBtn.click();
        firstName.sendKeys(ConfigReader.getConfig("firstname"));
        lastName.sendKeys(ConfigReader.getConfig("lastname"));
        address.sendKeys(ConfigReader.getConfig("Address"));
        city.sendKeys(ConfigReader.getConfig("City"));
        state.sendKeys(ConfigReader.getConfig("State"));
        zip.sendKeys(ConfigReader.getConfig("ZipCode"));
        phoneNumber.sendKeys(ConfigReader.getConfig("Phone"));
        ssn.sendKeys(ConfigReader.getConfig("SSN"));

        Random random=new Random();
        int n=random.nextInt(1,100);
        String CurrentString=ConfigReader.getConfig("Username");
        CurrentString+=n;
        ConfigReader.setConfig("NewUserName",CurrentString);
        userName.sendKeys(ConfigReader.getConfig("NewUserName"));
        passWord.sendKeys(ConfigReader.getConfig("Password"));
        cnfPassWord.sendKeys(ConfigReader.getConfig("Password"));
        submitRegBtn.click();


    }

    public boolean isRegisterPageDisplayed(){
        return welcomeMsg.isDisplayed();
    }

}
