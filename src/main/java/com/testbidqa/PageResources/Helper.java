package com.testbidqa.PageResources;

import com.testbidqa.PageResources.PageResources;
import com.testbidqa.PageResources.DataClass;
import com.testbidqa.data.DataProviderClass;
import org.openqa.selenium.WebDriver;


/**
 * This class has methods that are reused in test case scripts
 */
public class Helper {

    //Method to login as Project Owner
    public static void getPOLogin(PageResources pageResources,WebDriver driver, DataClass data ) throws InterruptedException {
        //PageResources pageResources = new PageResources(driver);
        pageResources.getHomePage().clickLogin();
        pageResources.getLogin().setUsrName(data.poUsrName);
        pageResources.getLogin().setUsrPwd(data.poPwd);
        pageResources.getLogin().clickSignIn();
        Thread.sleep(3000);
    }

    //Method to login as QA Engineer
    public static void getQALogin(PageResources pageResources, WebDriver driver, String sUsername, String sPassword) throws InterruptedException {
        pageResources.getHomePage().clickLogin();
        Thread.sleep(3000);
        pageResources.getLogin().setUsrName(sUsername);
        pageResources.getLogin().setUsrPwd(sPassword);
        pageResources.getLogin().clickSignIn();
        Thread.sleep(3000);
    }
}
