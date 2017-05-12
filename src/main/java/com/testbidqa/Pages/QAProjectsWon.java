package com.testbidqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by soumya on 5/1/17.
 */
public class QAProjectsWon {

    WebDriver driver;

    public QAProjectsWon(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
