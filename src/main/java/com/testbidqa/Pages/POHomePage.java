package com.testbidqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Soumya on 5/15/17.
 */

//This class locates all the web elements on Project Owner's home page, along with actions on the elements
public class POHomePage {
    WebDriver driver;

    public POHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//li[@class = 'user_type']")
    WebElement userType;
    public String getUserType(){
        return userType.getText();
    }

}
