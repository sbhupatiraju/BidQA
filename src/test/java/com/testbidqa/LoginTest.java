package com.testbidqa;

import com.testbidqa.PageResources.PageResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by soumya on 5/11/17.
 */
public class LoginTest {

    WebDriver driver;
    public PageResources pageResources;

    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
        //driver = new FirefoxDriver();
        driver.get("http://test.bidqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        //new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.id("log")));
    }


    //Test case to login with registered account
    //------------------------------------------------------------------------------------------------------------
    @Parameters({"usrName", "usrPwd"})
    @Test(priority = 1, enabled = false)
    public void login(String usrName, String usrPwd) throws InterruptedException {
        pageResources = new PageResources(driver);
        Thread.sleep(8000);
        pageResources.getLogin().setUsrName(usrName);
        pageResources.getLogin().setUsrPwd(usrPwd);
        pageResources.getLogin().clickSignIn();
        pageResources.getLogin().clickLogout();
    }
    //------------------------------------------------------------------------------------------------------------
}
