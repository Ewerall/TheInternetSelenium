package com.example.tests;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.pages.LoginPage;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }
    
    @Test
    public void testValidLogin() {
        loginPage.baseauth("admin", "admin");
        assertTrue(loginPage.loginSuccessful(), "Вход успешный");
    }
    
    @Test
    public void testInvalidLogin() {
        loginPage.baseauth("wrong", "wrong");
        assertFalse(loginPage.loginSuccessful(), "Вход неуспешный");
    }
    
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}