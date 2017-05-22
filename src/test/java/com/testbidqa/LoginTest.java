package com.testbidqa;

import com.testbidqa.PageResources.DataClass;
import com.testbidqa.PageResources.PageResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by soumya on 5/11/17.
 */
public class LoginTest {

    WebDriver driver;
    private PageResources pageResources;
    private DataClass data;

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


    //Test case to login with registered PO account
    //------------------------------------------------------------------------------------------------------------
    //@Parameters({"usrName", "usrPwd"}) String usrName, String usrPwd
    @Test(priority = 1, enabled = false)
    public void login() throws InterruptedException {
        pageResources = new PageResources(driver);
        data = new DataClass();

        Thread.sleep(8000);
        pageResources.getHomePage().clickLogin();
        pageResources.getLogin().setUsrName(data.poUsrName);
        pageResources.getLogin().setUsrPwd(data.poPwd);
        pageResources.getLogin().clickSignIn();
        Thread.sleep(5000);
        Assert.assertEquals(pageResources.getPoHomePage().getUserType(), "You are logged in as a Project Owner");
        System.out.println("User successfully logged in as Project Owner");
        Thread.sleep(5000);
        pageResources.getLogin().clickLogout();
    }
    //------------------------------------------------------------------------------------------------------------
}
