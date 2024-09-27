package com.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test
    public void openTheWebsite(){
        registerPage.openWebsite();
        registerPage.makeRegister();
        Assert.assertFalse(registerPage.isRegisterPageDisplayed());
    }
}
