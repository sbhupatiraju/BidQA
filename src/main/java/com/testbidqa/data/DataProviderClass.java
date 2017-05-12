package com.testbidqa.data;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

/**
 * Created by soumya on 5/9/17.
 */
public class DataProviderClass {

    WebDriver driver;

    //Provides login credentials for 3 QA Engineers
    @DataProvider(name = "QAEngineerCred")
    public static Object[][] getLoginData() {
        //if (m.getName().equalsIgnoreCase("qaBid")) {

        Object[][] data = new Object[3][2];

            // 1st row
            data[0][0] = "sam_qa1";
            data[0][1] = "letmein";

            // 2nd row
            data[1][0] = "sam_qa2";
            data[1][1] = "letmein";

            // 3rd row
            data[2][0] = "sam_qa3";
            data[2][1] = "letmein";

        return data;
        }

}

