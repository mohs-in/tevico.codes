package org.tevico;

import org.openqa.selenium.By;
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signinSrEmail")));
            email.clear();
            email.sendKeys("tevicouser@gmail.com");

            WebElement password = driver.findElement(By.id("signupSrPassword"));
            password.clear();
            password.sendKeys("@10724e2eF");

            WebElement SignInButton = driver.findElement(By.className("btn-primary"));
            SignInButton.click();

            System.out.println("User Sign In Successful.");

//            driver.get("https://console.tevi.co/home");

            WebElement tevicoText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/ng-component/div/div[2]/div/div/div[2]/app-profile-switch-account/div/div[2]/ul/li[2]/div/a/div[2]/span[2]")));
            tevicoText.click();
            System.out.println("Switching user to 60011");
            

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
