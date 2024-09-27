package com.automation.test;

import com.automation.pages.RegisterPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {


    RegisterPage registerPage;
    @BeforeMethod
    public void setUp(){
        ConfigReader.initConfig();
        DriverManager.createDriver();
        registerPage=new RegisterPage();
    }

    @AfterMethod
    public void tearDown(){
//        DriverManager.getDriver().quit();
    }

}
