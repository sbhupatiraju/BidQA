package com.testbidqa;

import com.testbidqa.PageResources.DataClass;
import com.testbidqa.PageResources.PageResources;
import javafx.scene.chart.PieChart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by soumya on 5/11/17.
 */
public class RegisterTest {

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

    // Test case to register as Project Owner
    //------------------------------------------------------------------------------------------------------------
    //@Parameters({"usrName", "usrPwd"})
    @Test(priority = 0, enabled = false)
    public void poRegister() throws InterruptedException {

        pageResources = new PageResources(driver);
        DataClass data = new DataClass();

        //Steps to register as  Project Owner
        pageResources.getHomePage().clickRegister();
        Thread.sleep(5000);
        pageResources.getRegisterPage().setUsrName(data.randomUserName);
        Thread.sleep(3000);
        pageResources.getRegisterPage().setUsrEmail(data.randomEmail);
        Thread.sleep(3000);
        pageResources.getRegisterPage().setUsrPwd(data.randomPwd);
        pageResources.getRegisterPage().setUsrRPwd(data.randomPwd);
        pageResources.getRegisterPage().setUsrTypePO();
        Thread.sleep(3000);
        pageResources.getRegisterPage().clickNotRobot();
        Thread.sleep(60000);
        pageResources.getRegisterPage().submit();
    }
    //------------------------------------------------------------------------------------------------------------



    // Test case to register as QA Engineer
    //------------------------------------------------------------------------------------------------------------
    //@Parameters({"usrName", "usrPwd"})
    @Test(priority = 0, enabled = false) //, dataProvider = "PORegisterCred")
    public void qaRegister() throws InterruptedException {

        pageResources = new PageResources(driver);
        DataClass data = new DataClass();

        //Steps to register as QA Engineer
        Thread.sleep(3000);
        pageResources.getHomePage().clickRegister();
        Thread.sleep(5000);
        pageResources.getRegisterPage().setUsrName(data.randomUserName);
        Thread.sleep(3000);
        pageResources.getRegisterPage().setUsrEmail(data.randomEmail);
        Thread.sleep(3000);
        pageResources.getRegisterPage().setUsrPwd(data.randomPwd);
        pageResources.getRegisterPage().setUsrRPwd(data.randomPwd);
        Thread.sleep(3000);
        pageResources.getRegisterPage().clickNotRobot();
        Thread.sleep(60000);
        pageResources.getRegisterPage().submit();
    }
    //------------------------------------------------------------------------------------------------------------
}
