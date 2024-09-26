package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.logging.Level;
import demo.wrappers.Wrappers;

public class TestCases {
        // Creating instance variable of ChromeDriver class
        ChromeDriver driver;
        // Creating instance variable of WebDriverWait class
        WebDriverWait wait;
        // Creating instance variable of Wrappers class
        Wrappers wp; 

        // Verify url is opening
        @Test
        public void testCase01() throws InterruptedException {
                try {
                        System.out.println("Start Test case: testCase01");

                        // Opening the required url
                        wp.openUrl(
                                        "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

                        System.out.println("testCase01: Passed");

                } catch (Exception e) {
                        System.out.println("testCase01 Failed");
                        
                        //Printing the exception details
                        e.printStackTrace();
                }

                System.out.println("End Test case: testCase01");
        }

        // Verify user is able to enter name in the Name textbox
        @Test
        public void testCase02() throws InterruptedException {
                try {
                        System.out.println("Start Test case: testCase02");

                        //Locating textbox having "Name" text
                        WebElement nameTxtBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                        By.xpath("//span[text()='Name']/ancestor::div[3]/following-sibling::div//input")));
                        
                        Thread.sleep(1000);

                        //Entering Name
                        wp.sendKeys(nameTxtBox, "Crio Learner");

                        System.out.println("testCase02: Passed");
                } catch (Exception e) {
                        System.out.println("testCase02 Failed");

                        //Printing the exception details
                        e.printStackTrace();
                }
                System.out.println("End Test case: testCase02");
        }

        // Verify user is able to enter details and epoch time in "Why are you practicing Automation?" textbox
        @Test
        public void testCase03() throws InterruptedException {
                try {
                        System.out.println("Start Test case: testCase03");

                        //Locating textbox having "Why are you practicing Automation?" text
                        WebElement practAuto = driver.findElement(By.xpath(
                                        "//span[text()='Why are you practicing Automation?']/ancestor::div[3]/following-sibling::div//textarea"));
                        
                        //Storing epoch time
                        long epochTime = wp.epochTime();

                        //Storing the text to be enter + epoch time
                        String text = "I want to be the best QA Engineer! " + epochTime;

                        //Entering the text to the textbox
                        wp.sendKeys(practAuto, text);
                        System.out.println("epoch time : " + epochTime);

                        System.out.println("testCase03: Passed");
                } catch (Exception e) {
                        System.out.println("testCase03 Failed");
                        
                        //Printing the exception details
                        e.printStackTrace();
                }
                System.out.println("End Test case: testCase03");
        }

        // Selecting radio button for "How much experience do you have in Automation Testing?""
        @Test
        public void testCase04() throws InterruptedException {
                try {
                        System.out.println("Start Test case: testCase04");

                        //Storing experience between options: 0 - 2, 3 - 5, 6 - 10, > 10
                        String experience = "0 - 2";

                        //Selecting radio button for above experience
                        wp.experieanceRadioBtn(experience);

                        System.out.println("testCase04: Passed");
                } catch (Exception e) {
                        System.out.println("testCase04 Failed");

                        //Printing the exception details
                        e.printStackTrace();
                }
                System.out.println("End Test case: testCase04");
        }

        // Selecting checkbox for "Which of the following have you learned in Crio.Do for Automation Testing?"
        @Test
        public void testCase05() throws InterruptedException {
                try {
                        System.out.println("Start Test case: testCase05");

                        //Storing options to be selected
                        String[] optionsToSelect = {"Java", "Selenium", "TestNG"};

                        for(String option : optionsToSelect) {
                                //Selecting checkbox for "Java"
                                wp.checkBoxSelect(option);

                                System.out.println(option + " is selected");
                        }
                        
                        System.out.println("testCase05: Passed");
                } catch (Exception e) {
                        System.out.println("testCase05 Failed");

                        //Printing the exception details
                        e.printStackTrace();
                }
                System.out.println("End Test case: testCase05");
        }

        // Selecting How should you be addressed?
        @Test
        public void testCase06() throws InterruptedException {
                try {
                        System.out.println("Start Test case: testCase06");

                        //Locating the dropdown button
                        WebElement dropDown = driver.findElement(
                                        By.xpath("//span[text()='How should you be addressed?']/ancestor::div[4]//span[text()='Choose']"));

                        //Clicking on the dropdown
                        wp.click(dropDown);

                        //Storing the option to select
                        String optionToSelect = "Mr";

                        //Selecting the option
                        wp.dropDownOptionClick(optionToSelect);

                        System.out.println(optionToSelect + " selected");
                        System.out.println("testCase06: Passed");

                } catch (Exception e) {
                        System.out.println("testCase06 Failed");

                        //Printing the exception details
                        e.printStackTrace();
                }
                System.out.println("End Test case: testCase06");
        }

        // Entering date before 7 days from today
        @Test
        public void testCase07() throws InterruptedException {
                try {
                        System.out.println("Start Test case: testCase07");

                        //Selecting the date before today
                        wp.day7Before(7);

                        System.out.println("testCase07: Passed");
                } catch (Exception e) {
                        System.out.println("testCase07 Failed");

                        //Printing the exception details
                        e.printStackTrace();
                }
                System.out.println("End Test case: testCase07");
        }

        // Entering time and clicking submit button
        @Test
        public void testCase08() throws InterruptedException {
                try {
                        System.out.println("Start Test case: testCase08");

                        //Entering the time in "HH:mm" formate
                        wp.time("07:30");

                        //Locating the submit button
                        WebElement submitBtn = driver.findElement(By.xpath("//span[text()='Submit']"));

                        //Clicking on the submit button
                        wp.click(submitBtn);

                        System.out.println("testCase08: Passed");
                } catch (Exception e) {
                        System.out.println("testCase08 Failed");

                        //Printing the exception details
                        e.printStackTrace();
                }
                System.out.println("End Test case: testCase08");
        }

        // Checking successful message and printing
        @Test
        public void testCase09() throws InterruptedException {
                try {
                        System.out.println("Start Test case: testCase09");

                        //Waiting and locating for the successful WebElement
                        WebElement result = wait.until(ExpectedConditions
                                        .visibilityOfElementLocated(By.xpath(
                                                        "//div[text()='Thanks for your response, Automation Wizard!']")));
                        
                        //Printing the successful message
                        System.out.println(result.getText());

                        System.out.println("testCase09: Passed");
                } catch (Exception e) {
                        System.out.println("testCase09 Failed");

                        //Printing the exception details
                        e.printStackTrace();
                }
                System.out.println("End Test case: testCase09");
        }

        @BeforeTest
        public void startBrowser() {
                System.setProperty("java.util.logging.config.file", "logging.properties");

                //Creating the ChromeOptions class object
                ChromeOptions options = new ChromeOptions();
                LoggingPreferences logs = new LoggingPreferences();

                logs.enable(LogType.BROWSER, Level.ALL);
                logs.enable(LogType.DRIVER, Level.ALL);
                options.setCapability("goog:loggingPrefs", logs);
                options.addArguments("--remote-allow-origins=*");

                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

                //Initializing the ChromeDriver object
                driver = new ChromeDriver(options);

                //Initializing the WebDriverWait object
                wait = new WebDriverWait(driver, Duration.ofSeconds(30));

                //Maximizing the browser window
                driver.manage().window().maximize();

                //Initializing the Wrappers class object
                wp = new Wrappers(driver, wait);

                System.out.println("starting browser");
        }

        //Quitting the browser window
        @AfterTest
        public void endTest() {
                driver.quit();
        }
}