package org.tevico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class QuestionTwo {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/Users/mohsin/Downloads/chromedriver-mac-arm64/chromedriver");
        SafariDriver driver = new SafariDriver();

        driver.get("https://console.tevi.co/home");
        driver.manage().window().maximize();

        try {
            // Set up WebDriverWait to wait for a max of given seconds before throwing an exception
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signinSrEmail")));
            // Clear any existing text in the email field and enter the specified email address
            email.clear();
            email.sendKeys("tevicouser@gmail.com");

            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signupSrPassword")));
            // Clear any existing password in the password field and enter the specified password
            password.clear();
            password.sendKeys("@10724e2eF");

            // Click on the Sign-In button
            WebElement SignInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn-primary")));
            SignInButton.click();

            System.out.println("User Sign In Successful.");

            WebElement userSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='nav-link']")));
            // Click on the Users section from nav bar to interact with users section
            userSection.click();

            driver.navigate().to("https://console.tevi.co/user");
            driver.get("https://console.tevi.co/user");
            System.out.println("Opened Users Page");

            WebElement inviteUser = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div/ng-component/div[1]/div/button")));
            // Click on the Invite User
            inviteUser.click();

            WebElement inviteEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-content']//form//div[1]//input[@formcontrolname='email']")));
            // Enter the specified email address
            inviteEmail.sendKeys("in.mohsin@outlook.com");
            System.out.println("Invite Email Added");

            // Select the Drop dowm
            WebElement dropdowm = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ng-select[@formcontrolname='role']//span[@class='ng-arrow-wrapper']")));
            dropdowm.click();

            // Select Read Only Mode from the drop down
            WebElement dropdowninput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ng-select[@formcontrolname='role']//div[contains(@class, 'ng-option')]//span[text()='Read-only Admin']")));
            dropdowninput.click();
            System.out.println("Read Only Mode Selected");

            // Click on the Save button
            WebElement savebtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Save']")));
            savebtn.click();
            System.out.println("Invite Successful");

            // Click on the three dots of invited user
            WebElement threedots = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//em[@class='bi-three-dots-vertical']")));
            threedots.click();
            System.out.println("Three dots clicked");

            WebElement deleteUsr = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Delete User']")));
            // Click on Delete User
            deleteUsr.click();
            System.out.println("Waiting for user to confirm deletion");

            WebElement deleteUser = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Delete']")));
            // Re confirmation for Deleting User
            deleteUser.click();
            System.out.println("Deleted User");

            System.out.println("Test Successful");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
//sovled