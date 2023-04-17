package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoginPage {
    WebDriver driver;
    LoginPage objLoginPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.example.com/login");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testLogin() {
        objLoginPage = new LoginPage(driver);

        objLoginPage.setUsername("username");
        objLoginPage.setPassword("password");
        objLoginPage.clickLogin();

        Assert.assertEquals(driver.getTitle(), "Homepage - Example");
    }
}

