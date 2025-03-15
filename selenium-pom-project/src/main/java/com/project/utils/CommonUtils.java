package com.project.utils;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CommonUtils {

    private WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Wait for an element to be visible
    public WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Click on an element
    public void clickElement(By locator, int timeoutInSeconds) {
        WebElement element = waitForElementVisible(locator, timeoutInSeconds);
        element.click();
    }

    // Send text to an input field
    public void sendText(By locator, String text, int timeoutInSeconds) {
        WebElement element = waitForElementVisible(locator, timeoutInSeconds);
        element.clear();
        element.sendKeys(text);
    }

    // Check if an element is displayed
    public boolean isElementDisplayed(By locator, int timeoutInSeconds) {
        try {
            WebElement element = waitForElementVisible(locator, timeoutInSeconds);
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Scroll to an element
    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
