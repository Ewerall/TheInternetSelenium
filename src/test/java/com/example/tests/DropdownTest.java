package com.example.tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.pages.DropdownPage;

public class DropdownTest {
    private WebDriver driver;
    private DropdownPage dropdownPage;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        dropdownPage = new DropdownPage(driver);
        dropdownPage.dropdownUrl();
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"Option 1", "Option 2"})
    public void testDropdown(String option) {
        dropdownPage.selectOption(option);
        assertEquals(option, dropdownPage.getSelectedOption());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
