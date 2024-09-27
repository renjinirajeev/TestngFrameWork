package com.automation.steps;

import com.automation.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class loginSteps {

    loginPage loginpage = new loginPage();

    @Given("user opens the website")
    public void user_opens_the_website() {
       loginpage.openWebsite();
    }

    @Then("verify user is on homePage")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(loginpage.inhomePage());
    }

    @When("user login with valid credentials username {string} and password {string}")
    public void user_login_with_valid_credentials_username_and_password(String username, String password) {
        loginpage.enterDetails(username,password);
    }

    @Then("verify user login successfully")
    public void verify_user_login_successfully() {
        Assert.assertTrue(loginpage.inLoginPage());
    }

}
