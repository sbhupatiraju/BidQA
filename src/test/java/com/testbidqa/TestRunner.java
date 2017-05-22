package com.testbidqa;

//import com.testbidqa.TestMethods.POLogin;

import com.testbidqa.PageResources.Helper;
import com.testbidqa.data.DataProviderClass;
import com.testbidqa.PageResources.DataClass;
import com.testbidqa.PageResources.PageResources;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by soumya on 4/30/17.
 */
public class TestRunner {

    WebDriver driver;
    private PageResources pageResources;
    private DataClass data;

    public String createdProjectTitle;
    //WebDriverWait wait = new WebDriverWait(driver,20);

    public class SameClassDataProvider {
        //WebDriver driver;
        @DataProvider(name = "PORegisterCred")
        public Object[][] method1() {
            return new Object[][]{{"sam_po1", "letmein"}};
        }

       /* @DataProvider(name = "QAEngineerCred")
        public Object[][] method2() {
            return new Object[][]{{"sam_qa2","letmein"}, {"sam_qa3","letmein"}};
        }
        //{"sam_qa1","letmein"},
        */

        @BeforeTest
        public void setup() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1280, 800));
            //System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
            //driver = new FirefoxDriver();

            driver.get("http://test.bidqa.com");
            //driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);
            //new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.id("log")));
        }


 //Test case to login as Project Owner and create a new project
//------------------------------------------------------------------------------------------------------------
        @Test(priority = 2, enabled = false)
        public void POCreateProject() throws InterruptedException {
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

            //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("project_title")));
            Assert.assertEquals(pageResources.getPostNewProject().getPageTitle(), "Post New Project");
            System.out.println("On Post New Project page");

            //Fill in all the Project details
            pageResources.getPostNewProject().setPrjTitle(data.randomPrjName);
            Thread.sleep(3000);
            pageResources.getPostNewProject().setPrjDescription(data.randomPrjDesc);
            Thread.sleep(3000);
            pageResources.getPostNewProject().selectCategories();
            Thread.sleep(3000);
            pageResources.getPostNewProject().selectSkills();
            Thread.sleep(3000);
            pageResources.getPostNewProject().selectPrjBudget(1);
            Thread.sleep(3000);
            pageResources.getPostNewProject().setPrjEndingOn();
            Thread.sleep(3000);
            pageResources.getPostNewProject().setPrjEndingDate();
            Thread.sleep(3000);
            pageResources.getPostNewProject().setButtonDone();
            Thread.sleep(3000);
            pageResources.getPostNewProject().setPrjCountry(2);
            Thread.sleep(3000);
            pageResources.getPostNewProject().setPrjAddress(data.randomPrjAddress);
            Thread.sleep(3000);

            //Proceed to the next step
            pageResources.getPostNewProject().clickNextStepBtn1();
            Thread.sleep(8000);
            pageResources.getPostNewProject().clickNextStepBtn2();
            Thread.sleep(8000);
            //new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next Step →")));
            pageResources.getPostNewProject().clickNextStepBtn3();
            Thread.sleep(9000);
            //new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("cb-payment")));
            pageResources.getPostNewProject().chkTerms();
            Thread.sleep(9000);

            //Using Pay By PayPal option to pay
            pageResources.getPostNewProject().clickPayByPayPal();
            Thread.sleep(15000);
            //new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));

            //To verify that we are on the PayPal site
            Assert.assertEquals(pageResources.getPostNewProject().getPayPalHeader(), "Pay with PayPal");

            //Enter PayPal account login credentials and login to pay
            pageResources.getPostNewProject().setPayPalEmail(data.payPalUsr);
            Thread.sleep(3000);
            pageResources.getPostNewProject().setPayPalPwd(data.payPalPwd);
            Thread.sleep(3000);
            pageResources.getPostNewProject().clickPayPalLogin();
            Thread.sleep(20000);
            pageResources.getPostNewProject().clkPayNow();
            Thread.sleep(10000);
            pageResources.getPostNewProject().clickMerchantReturn();
            Thread.sleep(6000);

            //To store the new project name in a variable
            createdProjectTitle = pageResources.getPostNewProject().toGetProjectTitle();
            System.out.println("Title of the project created: " + createdProjectTitle);

            //To verify that the project is created
            try {
                Assert.assertTrue(true, createdProjectTitle);
            }
            catch(Exception e){
                e.printStackTrace();
                Assert.fail("Assertion failed");
            }

            //Logout from the account
            pageResources.getPostNewProject().clickLogout();
        }
//-------------------------------------------------------------------------------------------------------------


//Test case to bid on a project
//---------------------------------------------------------------------------------------------------------------
        @Test(priority = 3, enabled = false, dataProviderClass = DataProviderClass.class, dataProvider = "QAEngineerCred")
        //dependsOnMethods = "POCreateProject"
        public void qaBid(String sUsername, String sPassword) throws InterruptedException {

            pageResources = new PageResources(driver);
            data = new DataClass();

            //Login as QA Engineer
            Helper.getQALogin(pageResources,driver,sUsername,sPassword);

            /*
            //First login as QA Engineer
            pageResources.getHomePage().clickLogin();
            Thread.sleep(3000);
            pageResources.getLogin().setUsrName(sUsername);
            pageResources.getLogin().setUsrPwd(sPassword);
            pageResources.getLogin().clickSignIn();
            Thread.sleep(3000);
            */

            //Search for the Project to bid on and then bid on it
            pageResources.getQaMyAccount().setPrjSearch("hlzbyrnmhk");//(createdProjectTitle);
            Thread.sleep(8000);
            pageResources.getQaMyAccount().clickSubmitSearch();
            Thread.sleep(5000);
            //pageResources.getQaMyAccount().clkPrjTitle();
            pageResources.getQaMyAccount().clickReadMore();
            Thread.sleep(8000);
            pageResources.getQaMyAccount().clkSubmitProposal();
            Thread.sleep(5000);

            //Verify that you are on the Submit your proposal page
            Assert.assertEquals(pageResources.getQaMyAccount().getSubmitYourProposalTitle(), "Submit Your Proposal");

            //Enter all the fields to submit your proposal
            pageResources.getQaMyAccount().setYourBid(data.randomBidAmount);
            Thread.sleep(3000);
            pageResources.getQaMyAccount().setDaysToComplete(data.randomDaysToComplete);
            Thread.sleep(3000);
            pageResources.getQaMyAccount().setBidDescription(data.randomBidDesc);
            Thread.sleep(3000);
            pageResources.getQaMyAccount().clickCheckBox();
            Thread.sleep(3000);
            pageResources.getQaMyAccount().clickPlaceBid();
            Thread.sleep(8000);

            //Assert to verify that your bid has been placed
            try {
                Assert.assertTrue(true, pageResources.getQaMyAccount().getBidPlaced());
                System.out.println(sUsername + " Bid placed successfully");
            }
            catch(Exception e){
                e.printStackTrace();
                Assert.fail("Assertion failed - Bid could not be placed");
            }

            //Logout from the account
            pageResources.getQaMyAccount().clkLogout();
            Thread.sleep(10000);
        }
    }

//----------------------------------------------------------------------------------------------------------------------


//Test case to accept QA engineer's bid
//----------------------------------------------------------------------------------------------------------------------
    @Test(priority = 4, enabled = false)
    public void poAcceptBid() throws InterruptedException {

        pageResources = new PageResources(driver);
        data = new DataClass();

        //First log in as Project Owner
        pageResources.getHomePage().clickLogin();
        Thread.sleep(3000);
        pageResources.getLogin().setUsrName(data.poUsrName);
        pageResources.getLogin().setUsrPwd(data.poPwd);
        pageResources.getLogin().clickSignIn();
        Thread.sleep(3000);

        //Search for the Project
        pageResources.getPOMyAccount().setSearchProject(createdProjectTitle);
        pageResources.getPOMyAccount().submitPrjSearch();
        Thread.sleep(7000);
        pageResources.getPOMyAccount().clkReadMore();
        Thread.sleep(4000);


         //To Select project winners
          List<WebElement> links = driver.findElements(By.xpath("//a[contains(@href,'http://test.bidqa.com/?p_action=choose_winner')]"));

          int linkCount = links.size();
          System.out.println("Link count = " + linkCount);

          for(;linkCount>0;linkCount--) {
              System.out.println("Inside for loop");

              JavascriptExecutor jse = (JavascriptExecutor)driver;
              jse.executeScript("window.scrollBy(0,400)", "");

              driver.findElements(By.xpath("//a[contains(@href,'http://test.bidqa.com/?p_action=choose_winner')]")).get(linkCount - 1).click();
              Thread.sleep(5000);
              pageResources.getPOMyAccount().clkChooseAWinner();
              Thread.sleep(9000);
          }

        //verify that Bid Flag is now 'Project Winner'
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@id='my_bids']/div/div[6]")), "Project Winner"));
        //Assert.assertEquals(pageResources.getPOMyAccount().getBigFlag(), "Project Winner");
        //System.out.println("Successfully selected project winner");

        //Logout from the account
        Thread.sleep(3000);
        pageResources.getPostNewProject().clickLogout();

    }
//------------------------------------------------------------------------------------------------------------------


//Test case to create a team
//------------------------------------------------------------------------------------------------------------------
    @Test(priority = 5, enabled = false)
    public void prjTeam() throws InterruptedException {
        pageResources = new PageResources(driver);
        data = new DataClass();

        //Login as Project Owner
        pageResources.getHomePage().clickLogin();
        Thread.sleep(3000);
        pageResources.getLogin().setUsrName(data.poUsrName);
        pageResources.getLogin().setUsrPwd(data.poPwd);
        pageResources.getLogin().clickSignIn();
        Thread.sleep(3000);

        //to scroll down
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,400)", "");

        //Go to 'Team Manager' page to create a team
        pageResources.getPOMyAccount().clickTeamManager();
        Thread.sleep(3000);

        //Select the project to create team for from the drop down list
        pageResources.getPoTeamManager().setPrjFilters(createdProjectTitle);
        Thread.sleep(3000);

        //Click on the 'Create New Team' button
        pageResources.getPoTeamManager().clkBtnCreateNewTeam();
        Thread.sleep(3000);

        //Enter details to create a team and click 'Create' button
        pageResources.getPoTeamManager().selectProject(createdProjectTitle);
        Thread.sleep(3000);
        pageResources.getPoTeamManager().setTeamTitle(data.randomTeamTitle);
        pageResources.getPoTeamManager().setTeamDesc(data.randomTeamDesc);
        pageResources.getPoTeamManager().clkCreate();
        Thread.sleep(8000);

        //Now Add users to the above created team
        pageResources.getPoTeamManager().clkAddUsers();
        Thread.sleep(6000);

        //To Team field is auto populated
        //pageResources.getPoTeamManager().selectToTeam(1);
        //Thread.sleep(6000);

        //to add all the available users in the drop down
        int usersCount = pageResources.getPoTeamManager().getTotalUsers()-1;
        for (;usersCount > 0 ; usersCount--) {

            System.out.println("Inside for loop");

            //usersCount = pageResources.getPoTeamManager().getTotalUsers();
            System.out.println("usersCount = "+ usersCount);
            if(usersCount >= 1) {
                System.out.println("inside if block");
                //pageResources.getPoTeamManager().clkAddUsers();
                pageResources.getPoTeamManager().setSelectAddUsers(usersCount);
                Thread.sleep(3000);
                pageResources.getPoTeamManager().clkAdd();
                Thread.sleep(8000);
                pageResources.getPoTeamManager().clkAddUsers();
                Thread.sleep(3000);
            }
            else if (usersCount == 0){
                System.out.println("No more users to select");
                break;
            }
            //pageResources.getPoTeamManager().clkAddUsers();
            //Thread.sleep(3000);
        }

        WebElement close = driver.findElement(By.xpath("//div[@class='modal fade create-new-team-modal']//span[@aria-hidden='true']"));
        Actions action = new Actions(driver);
        action.moveToElement(close).build().perform();
        action.click(close).perform();
        Thread.sleep(3000);

        //Logout from the account
        pageResources.getPoTeamManager().clkLogout();
        Thread.sleep(8000);

    }
//----------------------------------------------------------------------------------------------------------------------


//QAEngineer will start working on the Project
//----------------------------------------------------------------------------------------------------------------------
    @Test(priority = 6, enabled = false, dataProviderClass = DataProviderClass.class, dataProvider = "QAEngineerCred")
    public void qaStartsWork (String uName, String uPwd) throws InterruptedException {
        pageResources = new PageResources(driver);
        DataClass data = new DataClass();

        //QAEngineer logs in
        pageResources.getHomePage().clickLogin();
        Thread.sleep(6000);
        pageResources.getLogin().setUsrName(uName);
        pageResources.getLogin().setUsrPwd(uPwd);
        pageResources.getLogin().clickSignIn();
        Thread.sleep(5000);

        pageResources.getQaMyAccount().clkProjectsInProgress();
        Thread.sleep(5000);

        //To start work on given project
        //1. Get the list of all the Projects in Progress
        List<WebElement> myList = driver.findElements(By.xpath("//div[@class='padd10']//a[contains(@href,'http://test.bidqa.com/projects/bbox')]"));

        int counter = 0;
        for (WebElement myElement : myList) {

            counter++;

            String myProject = myElement.getText();
            System.out.println(myProject);

            //2. If Project title matches the desired project then proceed
            if (myProject.contains(createdProjectTitle)) {

                System.out.println(counter);

                //a. Click on 'Start Work Timer' button
                driver.findElements(By.xpath("//div[@class='padd10']//button[@class='work_timer green_btn']")).get(counter - 1).click();
                Thread.sleep(3000);
                //b. Then click on 'Accept' checkbox
                driver.findElements(By.xpath("//input[@type='checkbox']")).get(counter - 1).click();
                Thread.sleep(3000);
                //c. Then click on 'Ok' button
                driver.findElements(By.xpath("//input[@value='ok']")).get(counter - 1).click();
                //d. Wait for 10 seconds to finish work
                Thread.sleep(10000);
                //e. After 10 seconds stop timer
                driver.findElements(By.xpath("//button[@act='stop']")).get(counter - 1).click();
                Thread.sleep(3000);
                //f. Then click on 'Mark Delivered' button
                driver.findElements(By.xpath("//a[@class='green_btn']")).get(counter - 1).click();
                Thread.sleep(4000);
                //g. Then click on 'Yes, Mark Delivered!' button
                pageResources.getQaProjectsInProgress().clkBtnYesMarkDelivered();

                break;

            } else {
                System.out.println("Project not found");
            }

        }

        Thread.sleep(3000);
        pageResources.getQaMyAccount().clkLogout();
    }
//----------------------------------------------------------------------------------------------------------------------



//Test case to mark all work complete, Make Escrow and Make Payment for the whole team
//----------------------------------------------------------------------------------------------------------------------
    @Test(priority = 7, enabled = false)
    public void completeProjectAndPayment() throws InterruptedException {
        pageResources = new PageResources(driver);
        data = new DataClass();

        //Login with Project Owner credentials
        pageResources.getHomePage().clickLogin();
        Thread.sleep(6000);
        pageResources.getLogin().setUsrName(data.poUsrName);
        pageResources.getLogin().setUsrPwd(data.poPwd);
        pageResources.getLogin().clickSignIn();
        Thread.sleep(4000);

        //scroll down to click on Team Manager
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,400)", "");

        //Go to Team Manager page
        pageResources.getPOMyAccount().clickTeamManager();
        Thread.sleep(3000);

        pageResources.getPoTeamManager().setPrjFilters("hswhtesmqx");
        Thread.sleep(6000);
        driver.findElement(By.xpath("//div[@class='post']")).click();
        Thread.sleep(3000);

        //Get all the Teams available on Team Manager page
        List<WebElement> teams = driver.findElements(By.xpath("//label[@class='team-title']"));

        //get the count of the teams present
        int noOfTeams = teams.size();
        System.out.println("Number of teams: " +noOfTeams);

        for(WebElement myElement : teams){driver.findElement(By.xpath("//div[@class='post']")).click();
            String teamName = myElement.getText();
            System.out.println("Team name: "+teamName);
            if (teamName.contains("Team-hsw")) {
                System.out.println("Inside if block");

                //JavascriptExecutor js = (JavascriptExecutor)driver;
                //js.executeScript("window.scrollBy(0,500)", "");

                //finding User checkbox
                //WebElement userCheckbox =
                driver.findElements(By.xpath("//input[@class='select-all']")).get(noOfTeams-1).click();

                /*
                //Click on 'User' checkbox to select all users, go to actions button and select 'Mark Completed' from drop down
                userCheckbox.click();
                Thread.sleep(3000);
                //To click on 'Action' button
                WebElement btnActions1 = driver.findElements(By.xpath("//button[@id='action']")).get(noOfTeams -1);
                Actions action1 = new Actions(driver);
                action1.moveToElement(btnActions1).build().perform();
                action1.click(btnActions1).perform();
                //to click on 'Mark Completed' action
                WebElement markCompletedAction = driver.findElements(By.xpath("//a[@class='action_mark_completed']")).get(noOfTeams -1);
                action1.click(markCompletedAction).perform();
                //to click on 'Yes, Mark Completed!' to confirm
                driver.findElement(By.xpath("//input[@name='yes']")).click();
                Thread.sleep(3000);
                //Here you have to assert that the Current status is 'Awaiting Payment'
                */

                //JavascriptExecutor js = (JavascriptExecutor)driver;
                //js.executeScript("window.scrollBy(0,250)", "");


                //Click on 'User' checkbox to select all users, go to actions button & select 'Make Escrow' from the drop down
                //userCheckbox.click();
                Thread.sleep(3000);
                //To click on 'Action' button
                WebElement btnActions2 = driver.findElements(By.xpath("//button[@id='action']")).get(noOfTeams -1);
                Actions action2 = new Actions(driver);
                action2.moveToElement(btnActions2).build().perform();
                action2.click(btnActions2).perform();
                Thread.sleep(3000);
                //to click on 'Make Escrow' action
                WebElement makeEscrowAction = driver.findElements(By.xpath("//a[@class='action_make_escrow']")).get(noOfTeams -1);
                action2.click(makeEscrowAction).perform();
                Thread.sleep(3000);

                    //to enter Escrow for all the QA's
                    List<WebElement> inputEscrowAmt = driver.findElements(By.xpath("//input[@name='amount[]']"));
                    for(WebElement amt : inputEscrowAmt){
                        amt.sendKeys("5");
                    }
                    pageResources.getPoOutstandingPayments().clkMakeEscrow();
                    Thread.sleep(4000);


                //Click on 'User' checkbox to select all users, go to actions button & select 'Release Payment' from the drop down
                //userCheckbox.click();
                Thread.sleep(3000);
                //To click on 'Action' button
                WebElement btnActions3 = driver.findElements(By.xpath("//button[@id='action']")).get(noOfTeams -1);
                Actions action3 = new Actions(driver);
                action3.moveToElement(btnActions3).build().perform();
                action3.click(btnActions3).perform();
                Thread.sleep(3000);
                //to click on 'Release Payment' action
                WebElement releasePaymentAction = driver.findElements(By.xpath("//a[@class='action_release_payment']")).get(noOfTeams -1);
                action3.click(releasePaymentAction).perform();
                Thread.sleep(4000);

                break;
            }
            else{
                System.out.println("Team not found");
            }

        }

    }


//----------------------------------------------------------------------------------------------------------------------

//Test case to Accept Project (for individual bids)
//----------------------------------------------------------------------------------------------------------------------
    @Test(priority = 8, enabled = false)
    public void acceptProject() throws InterruptedException {
        pageResources = new PageResources(driver);
        data = new DataClass();
        Thread.sleep(3000);

        // First login in as Project Owner
        pageResources.getHomePage().clickLogin();
        pageResources.getLogin().setUsrName(data.poUsrName);
        pageResources.getLogin().setUsrPwd(data.poPwd);
        pageResources.getLogin().clickSignIn();
        Thread.sleep(3000);

        //Go to 'Awaiting Completion' page
        pageResources.getPOMyAccount().clickAwaitingCompletion();
        Thread.sleep(3000);

        //Go to the given project and Accept it by clicking on 'Mark Completed' button
        List<WebElement> myList = driver.findElements(By.xpath("//a[contains(@href,'http://test.bidqa.com/projects/bbox')]"));
        int counter = 0;

        for (WebElement myElement : myList) {

            counter++;
            String myProject = myElement.getText();
            System.out.println(myProject);

            // If Project title matches the given project then proceed
            if (myProject.contains(createdProjectTitle)) {

                System.out.println(counter);

                //Click on 'Mark Completed' button
                driver.findElements(By.xpath("//a[contains(@href,'http://test.bidqa.com/?p_action=mark_completed')]")).get(counter - 1).click();
                Thread.sleep(3000);

                //Click on 'Yes, Mark Completed!'
                driver.findElements(By.xpath("//input[@type = 'submit']")).get(counter - 1).click();
                Thread.sleep(3000);
                break;
            } else {
                System.out.println("Project Not found");
            }

        }

        //Logout from the account
        Thread.sleep(3000);
        pageResources.getPostNewProject().clickLogout();
        Thread.sleep(3000);
    }

//------------------------------------------------------------------------------------------------------------------------------


    //Test case to Make Escrow payment for completed and accepted Project
//------------------------------------------------------------------------------------------------------------------------------
    @Test(priority = 9, enabled = false)
    public void makeEscrow() throws InterruptedException {

        pageResources = new PageResources(driver);
        data = new DataClass();

        //First Login as Project Owner
        pageResources.getHomePage().clickLogin();
        pageResources.getLogin().setUsrName(data.poUsrName);
        pageResources.getLogin().setUsrPwd(data.poPwd);
        pageResources.getLogin().clickSignIn();
        Thread.sleep(3000);

        //Go to 'Outstanding Payments' page
        pageResources.getPOMyAccount().clickOutstandingPayments();

        //Go to the given project and Make Escrow
        List<WebElement> myList1 = driver.findElements(By.xpath("//a[contains(@href,'http://test.bidqa.com/projects/bbox')]"));
        int counter = 0;

        for (WebElement myElement : myList1) {

            counter++;
            String myProject = myElement.getText();
            System.out.println(myProject);

            // If Project title matches the given project then proceed
            if (myProject.contains(createdProjectTitle)) {

                System.out.println(counter);

                //Click on 'Make Escrow' button
                driver.findElements(By.xpath("//a[contains(@href,'escrow')]")).get(counter - 1).click();
                Thread.sleep(3000);

                //Enter Escrow Amount
                pageResources.getPoOutstandingPayments().setEscrowAmount(5);

                //Select project name from the drop down list
                pageResources.getPoOutstandingPayments().selectEscrowProject(createdProjectTitle);
                Thread.sleep(4000);

                //Select QA Engineer from the drop down list
                pageResources.getPoOutstandingPayments().selectEscrowQAEng(data.qaUsrName);

                //Click on 'Make Escrow' button
                pageResources.getPoOutstandingPayments().clkEscrowMe();
                Thread.sleep(5000);
                break;

            } else {
                System.out.println("Project to make Escrow not found");
            }

        }

        //Logout from the account
        Thread.sleep(3000);
        pageResources.getPostNewProject().clickLogout();
        Thread.sleep(3000);

    }
 //-----------------------------------------------------------------------------------------------------------------------



 //Test Case to Release the payment
 //-----------------------------------------------------------------------------------------------------------------------
        @Test(priority = 10, enabled = false)
        public void releasePayment() throws InterruptedException {

            pageResources = new PageResources(driver);
            data = new DataClass();

            //First Login as Project Owner
            pageResources.getHomePage().clickLogin();
            pageResources.getLogin().setUsrName(data.poUsrName);
            pageResources.getLogin().setUsrPwd(data.poPwd);
            pageResources.getLogin().clickSignIn();
            Thread.sleep(5000);

            pageResources.getPOMyAccount().clkFinances();
            Thread.sleep(3000);

           //Get the list of all projects
           List<WebElement> myList2 = driver.findElements(By.xpath("//a[contains(@href,'http://test.bidqa.com/projects/bbox')]"));
           int count = 0;
           for (WebElement myElement : myList2) {

            count++;
            String myProject = myElement.getText();
            System.out.println(myProject);

            // If Project title matches the given project then proceed
             if (myProject.contains(createdProjectTitle)) {

                 System.out.println("count:" + count);

                 Thread.sleep(3000);

                 JavascriptExecutor jse = (JavascriptExecutor)driver;
                 jse.executeScript("window.scrollBy(0,350)", "");

                //Click on 'Release Payment' button for the given project
                driver.findElements(By.xpath("//a[contains(@href,'releasepayment')]")).get(count - 1).click();
                //System.out.println("txt: " +txt);
                Thread.sleep(3000);

                break;

             } else {
                System.out.println("Project to release payment not found");
             }

        }

    }


//--------------------------------------------------------------------------------------------------------------------------
}