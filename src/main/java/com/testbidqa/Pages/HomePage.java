package com.testbidqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by soumya on 4/30/17.
 */
public class HomePage {

    WebDriver driver;

    @FindBy(xpath=".//*[@id='cssmenu']/ul/li[7]/a")
    WebElement register;

    @FindBy(xpath=".//*[@id='cssmenu']/ul/li[8]/a")
    WebElement login;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //This method is used to click on the Register link on the Home Page
    public void clickRegister() throws InterruptedException {
        Thread.sleep(5000);
        register.click();
    }

    //This method is used to click on the Login link on the Home Page
    public void clickLogin(){
        login.click();
    }
}
