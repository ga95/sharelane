package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SharelaneTest {
    private String email = "testuser" + System.currentTimeMillis() + "@example.com"; // Уникальный email
    private String password = "1111";

//    @BeforeEach
//    public void setUp() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://sharelane.com/cgi-bin/register.py");
//    }

    @Test
    public void testUserRegistrationAndLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys( "12345");
        driver.findElement(By.cssSelector("[value='Continue']")).click();

        // Заполнение полей регистрации
        WebElement firstName = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input"));
        firstName.sendKeys("Andrey");

       WebElement emailField = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")); // Или используйте актуальный селектор
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input")); // Или используйте актуальный селектор
        passwordField.sendKeys(password);

        WebElement passwordField2 = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/input")); // Или используйте актуальный селектор
        passwordField2.sendKeys(password);

        // Отправка формы регистрации
        WebElement registerButton = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input")); // Или используйте актуальный селектор
        registerButton.click();

        // Переход на главную страницу
        driver.get("https://sharelane.com/");

        // Вход в систему
        WebElement loginEmailField = driver.findElement(By.name("email")); // Или используйте актуальный селектор
        loginEmailField.sendKeys(email);

        WebElement loginPasswordField = driver.findElement(By.name("password")); // Или используйте актуальный селектор
        loginPasswordField.sendKeys(password);

        // Отправка формы входа
        WebElement loginButton = driver.findElement(By.id("login")); // Или используйте актуальный селектор
        loginButton.click();

        // Добавьте проверки для подтверждения успешного входа, например, проверка наличия элемента на странице
    }

//    @AfterEach
//    public void tearDown() {
//        // Закрываем драйвер
//        if (driver != null) {
//            driver.quit();
//    }
//  }
}