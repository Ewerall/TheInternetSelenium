package com.example.pages;

import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage{
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void baseauth(String username, String password) {
        String authUrl = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        driver.get(authUrl);
    }
    
    public boolean loginSuccessful() {
        String pageSource = driver.getPageSource();
        return pageSource.contains("Congratulations");
    }
}