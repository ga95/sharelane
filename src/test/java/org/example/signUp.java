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
        driver.findElement(By.xpath( "//input[@name='first_name']")).sendKeys("Ruslan");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys( "Mazitov");
        driver.findElement(By.xpath( "//input[@name='email']")).sendKeys("mazitov@mail.ru");
        driver.findElement(By.xpath( "//input[@name 'password1']")).sendKeys("12345678");
        driver.findElement(By.xpath( "//input[@name='password2']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("[value = 'Register']")).click();
        boolean elementOnPage = driver.findElement(By.cssSelector(".confirmation_message")).isDisplayed(); Assert.assertTrue (elementOnPage);
        driver.quit();


    }
}
