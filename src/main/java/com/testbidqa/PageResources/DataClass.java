package com.testbidqa.PageResources;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by soumya on 5/10/17.
 */
public class DataClass {

    public String randomPrjName = RandomStringUtils.randomAlphabetic(10).toLowerCase();
    public String randomPrjDesc = RandomStringUtils.randomAlphabetic(20).toLowerCase();
    public String randomPrjAddress = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    public String randomBidDesc = RandomStringUtils.randomAlphabetic(25).toLowerCase();

    //Registration data
    public String randomUserName = RandomStringUtils.randomAlphabetic(7).toLowerCase();
    public String randomPwd = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    public String randomEmail = randomUserName + "@mailinator.com";


    //Login credentials for Project Owner
    public String poUsrName = "sam_po";
    public String poPwd = "letmein";

    //Login credentials for QA Engineer
    public String qaUsrName = "sam_qa1";
    public String qaPwd = "letmein";
}
