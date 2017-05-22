package com.testbidqa.PageResources;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * Created by soumya on 5/10/17.
 */
public class DataClass {

    //Data to create a Project
    public String randomPrjName = RandomStringUtils.randomAlphabetic(10).toLowerCase();
    public String randomPrjDesc = RandomStringUtils.randomAlphabetic(20).toLowerCase();
    public String randomPrjAddress = RandomStringUtils.randomAlphanumeric(10).toLowerCase();


    //Data to submit a proposal
    public String randomBidDesc = RandomStringUtils.randomAlphabetic(25).toLowerCase();
    Random ranNum = new Random();
    public int randomBidAmount = ranNum.nextInt(1);
    public int randomDaysToComplete = ranNum.nextInt(1);


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

    //Login credentials for PayPal account
    public String payPalUsr = "bh.soumya@yahoo.com";
    public String payPalPwd = "letmepay!9";

    //Data to create a Project Team
    public String randomTeamTitle = "Team-"+RandomStringUtils.randomAlphabetic(6).toLowerCase();
    public String randomTeamDesc = RandomStringUtils.randomAlphabetic(10).toLowerCase();

}
