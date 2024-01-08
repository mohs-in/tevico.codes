package org.tevico;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuestionFour {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/Users/mohsin/Downloads/chromedriver-mac-arm64/chromedriver");
        SafariDriver driver = new SafariDriver();

        driver.get("https://console.tevi.co/home");
        driver.manage().window().maximize();

        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            System.out.println("Landed on Login Page");

            WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signinSrEmail")));
            // Clear any existing text in the email field and enter the specified email address
            email.clear();
            email.sendKeys("tevicouser@gmail.com");

            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signupSrPassword")));
            // Clear any existing password in the password field and enter the specified password
            password.clear();
            password.sendKeys("@10724e2eF");

            WebElement SignInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn-primary")));
            // Click on the Sign-In button
            SignInButton.click();

            System.out.println("User Signed In Successful.");

            WebElement tevicoText = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Tevico Engineering")));
            // Click on the Tevico Engineering in homepage to switch user to 60011
            js.executeScript("arguments[0].click()", tevicoText);
            System.out.println("Switching to User 60011");

            String text = "60011 (Read-only Admin)";
            String xpathExpression = "//*[contains(text(), '" + text + "')]";

            WebElement userCheck = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));

            // Check the Welcome title is displayed with text "60011 (Read-only Admin)"
            if(userCheck.isDisplayed()) {
                System.out.println("Welcome Title Verified");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
//solved