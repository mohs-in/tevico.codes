package org.tevico;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuestionFive {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/Users/mohsin/Downloads/chromedriver-mac-arm64/chromedriver");
        SafariDriver driver = new SafariDriver();

        driver.get("https://console.tevi.co/home");
        driver.manage().window().maximize();

        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signinSrEmail")));
            // Clear any existing text in the email field and enter the specified email address
            email.clear();
            email.sendKeys("tevicouser@gmail.com");

            WebElement password = driver.findElement(By.id("signupSrPassword"));
            // Clear any existing password in the password field and enter the specified password
            password.clear();
            password.sendKeys("@10724e2eF");

            WebElement SignInButton = driver.findElement(By.className("btn-primary"));
            // Click on the Sign-In button
            SignInButton.click();

            System.out.println("User Sign In Successful.");

            WebElement tevicoText = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Tevico Engineering")));
            // Click on the Tevico Engineering in homepage to switch user to 60011
            js.executeScript("arguments[0].click()", tevicoText);
            System.out.println("Switching to User 60011");

            WebElement securitySection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/security']//span[@class='nav-link-title'][contains(text(),'Security')]")));
            // Click on Security from nav bar to view the security report
            securitySection.click();

            driver.navigate().to("https://console.tevi.co/security");
            driver.get("https://console.tevi.co/security");
            System.out.println("Opened Security Page");

            System.out.println("Viewing the report");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
//solved