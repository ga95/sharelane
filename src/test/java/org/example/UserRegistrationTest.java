package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

    public class UserRegistrationTest {

        private WebDriver driver;
        private String email = "testuser@example.com"; // Уникальный email для каждой регистрации
        private String password1 = "1111";
        private String password2 = "1111";
        private String last_name = "Andrey";
        private String first_name = "Gorev";
        @BeforeEach
        public void setUp() {
            // Укажите путь к вашему драйверу Chrome

            WebDriver driver = new ChromeDriver();
            driver.get("https://sharelane.com/");
        }

        @Test
        public void testUserRegistrationAndLogin() {
            // Переход на страницу регистрации
            driver.get("https://sharelane.com/cgi-bin/register.py?page=1&zip_code=33333");

            // Заполнение полей регистрации
            WebElement firstname = driver.findElement(By.name("email")); // замените на актуальный селектор
            firstname.sendKeys(first_name);
            WebElement lastname = driver.findElement(By.name("email")); // замените на актуальный селектор
            lastname.sendKeys(last_name);
            WebElement emailField = driver.findElement(By.name("email")); // замените на актуальный селектор
            emailField.sendKeys(email);
            WebElement password3 = driver.findElement(By.name("email")); // замените на актуальный селектор
            password3.sendKeys(password1);
            WebElement passwordField = driver.findElement(By.name("password")); // замените на актуальный селектор
            passwordField.sendKeys(password2);

            // Отправка формы
            WebElement registerButton = driver.findElement(By.id("registerButton")); // замените на актуальный селектор
            registerButton.click();

            // Переход на главную страницу
            driver.get("https://sharelane.com/");

            // Вход в систему
            WebElement loginEmailField = driver.findElement(By.name("email")); // замените на актуальный селектор
            loginEmailField.sendKeys(email);

            WebElement loginPasswordField = driver.findElement(By.name("password")); // замените на актуальный селектор
            loginPasswordField.sendKeys(password1);

            // Отправка формы входа
            WebElement loginButton = driver.findElement(By.id("loginButton")); // замените на актуальный селектор
            loginButton.click();

            // Добавьте проверки для подтверждения успешного входа (например, наличие элемента на странице)
        }

        @AfterEach
        public void tearDown() {
            // Закрываем драйвер
            if (driver != null) {
                driver.quit();
            }
        }
    }

