package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;

import java.util.List;

public class WebUtil   {
    
    protected WebDriver driver;

	// Constructor
    public WebUtil(WebDriver driver) {
        this.driver = driver;
    }

    // Click an element
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    // Enter text into a field
    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Get text from an element
    public String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Check if an element is displayed
    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Select from a dropdown by visible text
    public void selectDropdownByVisibleText(By locator, String value) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(value);
    }

    // Move to an element (Hover)
    public void hoverOverElement(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    // Scroll to an element
    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Get list of elements
    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    // Check if an element is enabled
    public boolean isElementEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }
}
