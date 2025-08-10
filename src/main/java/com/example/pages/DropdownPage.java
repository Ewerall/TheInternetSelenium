package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void dropdownUrl() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    
    public void selectOption(String optionText) {
        WebElement dropdownElement = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("dropdown"))
        );
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);
    }
    
    public String getSelectedOption() {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        return dropdown.getFirstSelectedOption().getText();
    }
}
