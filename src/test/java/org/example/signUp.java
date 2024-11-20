package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class signUp {

    @Test
    public void checkPositiveSignUp()
        {
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys( "12345");
        driver.findElement(By.cssSelector("[value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("Andrey");
        driver.findElement(By.name("email")).sendKeys("ga95@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1234566");
        driver.findElement(By.name("password2")).sendKeys("1234566");
        driver.findElement(By.cssSelector("[value = 'Register']")).click();
        boolean elementOnPage = driver.findElement(By.cssSelector(".confirmation_message")).isDisplayed();
        Assert.assertTrue(elementOnPage);
        driver.quit();


    }
}
