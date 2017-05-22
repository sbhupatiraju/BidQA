package com.testbidqa;

import com.testbidqa.PageResources.DataClass;
import com.testbidqa.PageResources.Helper;
import com.testbidqa.PageResources.PageResources;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by soumya on 5/19/17.
 */
public class UsingArraysTest {

    WebDriver driver;
    private PageResources pageResources;
    private DataClass data;

    public String createdProjectTitle;


    @BeforeTest
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");

        driver = new ChromeDriver();
        //To increase window size
        driver.manage().window().setSize(new Dimension(1280, 800));

        //Open BidQA site
        driver.get("http://test.bidqa.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    @Test()
    public void createPrj() throws InterruptedException{

        pageResources = new PageResources(driver);
        data = new DataClass();

        //Login as Project Owner (using Helper class)
        Helper.getPOLogin(pageResources,driver,data);

        //To verify that you are logged in as Project Owner
        Assert.assertEquals(pageResources.getPoHomePage().getUserType(), "You are logged in as a Project Owner");

        //Steps to create and post a new project using PayPal
        new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(By.linkText("Post New Project")));

        //click on 'Post New Project' link
        pageResources.getPOMyAccount().clickPostNewProject();
        Thread.sleep(5000);

        //JavascriptExecutor jse = (JavascriptExecutor)driver;
        //jse.executeScript("window.scrollBy(0,250)", "");


        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("project_title")));
        Assert.assertEquals(pageResources.getPostNewProject().getPageTitle(), "Post New Project");
        System.out.println("On Post New Project page");

        //Fill in all the Project details
        pageResources.getPostNewProject().setPrjTitle(data.randomPrjName);
        Thread.sleep(3000);
        pageResources.getPostNewProject().setPrjDescription(data.randomPrjDesc);


        //To randomly select one project category
        List<WebElement> categories = driver.findElements(By.xpath("//li[6]/div[@class='multi_cat_placeholder_thing']/label"));

        //Get the categories size
        int cSize = categories.size();
        System.out.println("Number of categories available: " +cSize);

        //Create an array to store all the categories
        String checkValues[]=new String[cSize];

        //To store all the values in the array
        for(int j=0;j<cSize;j++)
        {
            //get the name of each category
            String cvalue= categories.get(j).getText();

            //Assign the category name to the checkValues Array
            checkValues[j]=cvalue;
            System.out.println(j +":" + checkValues[j]);

            Thread.sleep(2000);
        }


        for(int k=checkValues.length-1;k>0;k--)
        {
            //To randomly generate a number in the range of the category size
            Random rnd = new Random();
            System.out.println("k = " + k);

            if(rnd.nextInt(k+1)==k)
            {
                //System.out.println("Random number = " + rnd.nextInt(k+1));
                String cat = categories.get(k).getText();
                System.out.println("Category option:" + cat);

                categories.get(k).click();
                Thread.sleep(3000);
            }

        }


    }
}
