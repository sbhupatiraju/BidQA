package com.testbidqa;

//import com.testbidqa.TestMethods.POLogin;

import com.testbidqa.data.DataProviderClass;
import com.testbidqa.PageResources.DataClass;
import com.testbidqa.PageResources.PageResources;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by soumya on 4/30/17.
 */
public class TestRunner {

    WebDriver driver;
    private PageResources pageResources;
    private DataClass data;
    //PageResources pageResources = new PageResources(driver);

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
            //System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
            //driver = new FirefoxDriver();
            driver.get("http://test.bidqa.com");
            driver.manage().window().maximize();
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

            //First login as Project Owner
            pageResources.getHomePage().clickLogin();
            pageResources.getLogin().setUsrName(data.poUsrName);
            pageResources.getLogin().setUsrPwd(data.poPwd);
            pageResources.getLogin().clickSignIn();
            Thread.sleep(3000);

            //Steps to Post a new project by using PayPal
            new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(By.linkText("Post New Project")));
            pageResources.getPOMyAccount().clickPostNewProject();
            //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("project_title")));
            Thread.sleep(8000);
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
            pageResources.getPostNewProject().clickPayByPayPal();
            Thread.sleep(15000);
            //new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
            pageResources.getPostNewProject().setPayPalEmail("bh.soumya@yahoo.com");
            Thread.sleep(5000);
            pageResources.getPostNewProject().setPayPalPwd("letmepay!9");
            Thread.sleep(5000);
            pageResources.getPostNewProject().clickPayPalLogin();
            Thread.sleep(12000);
            pageResources.getPostNewProject().clkPayNow();
            Thread.sleep(10000);
            pageResources.getPostNewProject().clickMerchantReturn();
            Thread.sleep(6000);

            //To store the new project name in a variable
            createdProjectTitle = pageResources.getPostNewProject().toGetProjectTitle();
            System.out.println("Title of the project created: " + createdProjectTitle);

            pageResources.getPostNewProject().clickLogout();
        }
        //-------------------------------------------------------------------------------------------------------------


        //Test case to bid on a project
        //---------------------------------------------------------------------------------------------------------------
    @Test(priority = 3, enabled = false, dataProviderClass = DataProviderClass.class,dataProvider = "QAEngineerCred") //dependsOnMethods = "POCreateProject"
     public void qaBid(String sUsername, String sPassword) throws InterruptedException {

            pageResources = new PageResources(driver);
            data = new DataClass();

            //First login as QA Engineer
            pageResources.getHomePage().clickLogin();
            Thread.sleep(3000);
            pageResources.getLogin().setUsrName(sUsername);
            pageResources.getLogin().setUsrPwd(sPassword);
            pageResources.getLogin().clickSignIn();
            Thread.sleep(3000);

            //Search for the Project to bid on and then bid on it
            pageResources.getQaMyAccount().setPrjSearch("ijnsaunztw");//(createdProjectTitle);
            Thread.sleep(8000);
            pageResources.getQaMyAccount().clickSubmitSearch();
            Thread.sleep(5000);
            //pageResources.getQaMyAccount().clkPrjTitle();
             pageResources.getQaMyAccount().clickReadMore();
            Thread.sleep(8000);
            pageResources.getQaMyAccount().clkSubmitProposal();
            Thread.sleep(5000);
            pageResources.getQaMyAccount().setYourBid(5);
            Thread.sleep(3000);
            pageResources.getQaMyAccount().setDaysToComplete(2);
            Thread.sleep(3000);
            pageResources.getQaMyAccount().setBidDescription(data.randomBidDesc);
            Thread.sleep(3000);
            pageResources.getQaMyAccount().clickCheckBox();
            Thread.sleep(3000);
            pageResources.getQaMyAccount().clickPlaceBid();
            Thread.sleep(8000);
            pageResources.getQaMyAccount().clkLogout();
            Thread.sleep(10000);
        }
    }

//-------------------------------------------------------------------------------------------------------------------



//Test case to log in as Project Owner and accept QA engineer's bid
//--------------------------------------------------------------------------------------------------------------------
        @Test(priority = 4, enabled = true)
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
            pageResources.getPOMyAccount().setSearchProject("ijnsaunztw");
            pageResources.getPOMyAccount().submitPrjSearch();
            Thread.sleep(5000);
            pageResources.getPOMyAccount().clkReadMore();
            Thread.sleep(4000);

            //To Select project winners
            List<WebElement> links = driver.findElements(By.xpath("//a[contains(@href,'http://test.bidqa.com/?p_action=choose_winner')]"));
            int linkCount = links.size();
            System.out.println("Link count = " + linkCount);
            for (WebElement myElement : links) {
                String link = myElement.getText();
                System.out.println("Link text = " + link);
                if (link.equals("Select as Winner")) {
                    System.out.println("Inside if block");
                    driver.findElement(By.xpath("//a[contains(@href,'http://test.bidqa.com/?p_action=choose_winner')]"));
                    new WebDriverWait(driver, 300).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'http://test.bidqa.com/?p_action=choose_winner')]")));

                    JavascriptExecutor jse = (JavascriptExecutor)driver;
                    jse.executeScript("window.scrollBy(0,300)", "");

                    //pageResources.getPOMyAccount().clkSelectAsWinner();
                    myElement.click();
                    Thread.sleep(5000);
                    pageResources.getPOMyAccount().clkChooseAWinner();
                    Thread.sleep(5000);
                }
                else {
                    System.out.println("In the else block");
                }
            }
       /*Thread.sleep(3000);
       pageResources.getPOMyAccount().clkSelectAsWinner();
       Thread.sleep(3000);
       pageResources.getPOMyAccount().clkChooseAWinner();*/

        }
//---------------------------------------------------------------------------------------------


//Test case to create a team
//----------------------------------------------------------------------------------------------
        @Test(priority = 5, enabled = false)
        public void prjTeam() throws InterruptedException {
            pageResources = new PageResources(driver);
            Thread.sleep(3000);
            pageResources.getHomePage().clickLogin();
            Thread.sleep(3000);
            pageResources.getLogin().setUsrName("sam_po");
            pageResources.getLogin().setUsrPwd("letmein");
            pageResources.getLogin().clickSignIn();
            Thread.sleep(3000);
            pageResources.getPOMyAccount().clickTeamManager();
            Thread.sleep(3000);
            pageResources.getPoTeamManager().setPrjFilters(2);
            Thread.sleep(3000);
            pageResources.getPoTeamManager().clkBtnCreateNewTeam();
            Thread.sleep(3000);
            pageResources.getPoTeamManager().selectProject(2);
            Thread.sleep(3000);
            pageResources.getPoTeamManager().setTeamTitle("Team1");
            pageResources.getPoTeamManager().setTeamDesc("This is Team1");
            pageResources.getPoTeamManager().clkCreate();
            Thread.sleep(6000);
            //Need to add logic to loop until all the users are added to the team
            pageResources.getPoTeamManager().clkAddUsers();
            Thread.sleep(6000);
            pageResources.getPoTeamManager().selectToTeam(1);
            Thread.sleep(6000);
            pageResources.getPoTeamManager().setSelectAddUsers(1);
            Thread.sleep(6000);
            pageResources.getPoTeamManager().clkAdd();
        }


        //QAEngineer will start work timer and work for 10seconds
        @Test(priority = 6, enabled = false)
        public void qaStartsWorkTimer() throws InterruptedException {
            pageResources = new PageResources(driver);

            //QAEngineer logs in
            pageResources.getHomePage().clickLogin();
            Thread.sleep(3000);
            pageResources.getLogin().setUsrName("sam_qa2");
            pageResources.getLogin().setUsrPwd("letmein");
            pageResources.getLogin().clickSignIn();
            Thread.sleep(3000);

            pageResources.getQaMyAccount().clkProjectsInProgress();
            pageResources.getQaProjectsInProgress().clkBtnStartWorkTimer();
            pageResources.getQaProjectsInProgress().clkCheckBoxAccept();
            pageResources.getQaProjectsInProgress().clkBtnOk();
            Thread.sleep(10000);
            pageResources.getQaProjectsInProgress().clkBtnStopWorkTimer();


        }
    }
