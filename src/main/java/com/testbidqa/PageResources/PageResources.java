package com.testbidqa.PageResources;

import com.testbidqa.Pages.*;
//import com.testbidqa.TestData.DataProviderClass;
import org.openqa.selenium.WebDriver;

//
public class PageResources {

    WebDriver driver;

    HomePage homePage;
    public HomePage getHomePage() {
        return homePage;
    }

    LoginPage login;
    public LoginPage getLogin() {
        //System.out.println("Inside getter method");
        return login;
    }

    POMyAccount poMyAccount;
    public POMyAccount getPOMyAccount() {
        //System.out.println("Inside getPoMyAccount getter");
        return poMyAccount;
    }

    POPostNewProject postNewProject;
    public POPostNewProject getPostNewProject() {
        return postNewProject;
    }

    QAMyAccount qaMyAccount;
    public QAMyAccount getQaMyAccount() {
        return qaMyAccount;
    }

    /*DataProviderClass dataProviderClass;
    public DataProviderClass getDataProviderClass() {
        return dataProviderClass;
    }*/

    POTeamManager poTeamManager;
    public POTeamManager getPoTeamManager() {
        return poTeamManager;
    }

    QAProjectsInProgress qaProjectsInProgress;
    public QAProjectsInProgress getQaProjectsInProgress() {
        return qaProjectsInProgress;
    }

    POOutstandingPayments poOutstandingPayments;
    public POOutstandingPayments getPoOutstandingPayments() {
        return poOutstandingPayments;
    }

    POAwaitingCompletion poAwaitingCompletion;
    public POAwaitingCompletion getPoAwaitingCompletion() {
        return poAwaitingCompletion;
    }

    RegisterPage registerPage;
    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public PageResources(WebDriver driver){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        login = new LoginPage(driver);
        poMyAccount = new POMyAccount(driver);
        postNewProject = new POPostNewProject(driver);
        qaMyAccount = new QAMyAccount(driver);
        poTeamManager = new POTeamManager(driver);
        qaProjectsInProgress = new QAProjectsInProgress(driver);
        poOutstandingPayments = new POOutstandingPayments(driver);
        poAwaitingCompletion = new POAwaitingCompletion(driver);
    }

}
