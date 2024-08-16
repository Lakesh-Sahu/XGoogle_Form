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
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
        ChromeDriver driver;
        WebDriverWait wait;
        Wrappers wp;
        /*
         * TO DO: Write your tests here with testng @Test annotation.
         * Follow `testCase01` `testCase02`... format or what is provided in
         * instructions
         */

         // Opening url
        @Test
        public void testCase01() throws InterruptedException {
                System.out.println("Start Tese case: testCase01");
                wp.openUrl(
                                "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
                System.out.println("URL Opened");
                System.out.println("end Test case: testCase01");
        }

         // Entering Name
        @Test
        public void testCase02() throws InterruptedException {
                System.out.println("Start Tese case: testCase02");
                WebElement nameTxtBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//span[text()='Name']/ancestor::div[3]/following-sibling::div//input")));
                Thread.sleep(1000);
                wp.sendKeys(nameTxtBox, "Crio Learner");
                System.out.println("Crio Learner is entered in the input box");
                System.out.println("end Test case: testCase02");
        }

        // Entering Why are you practicing Automation? answer
        @Test
        public void testCase03() throws InterruptedException {
                System.out.println("Start Tese case: testCase03");
                WebElement practAuto = driver.findElement(By.xpath(
                                "//span[text()='Why are you practicing Automation?']/ancestor::div[3]/following-sibling::div//textarea"));
                long epochTime = wp.epochTime();
                String text = "I want to be the best QA Engineer! " + epochTime;
                wp.sendKeys(practAuto, text);
                System.out.println("epoch time : " + epochTime);
                System.out.println("end Test case: testCase03");
        }

        // Selecting radio button How much experience do you have in Automation Testing?
        @Test
        public void testCase04() throws InterruptedException {
                System.out.println("Start Tese case: testCase04");
                WebElement expRadioBtn = driver.findElement(By.xpath(
                                "//span[text()='How much experience do you have in Automation Testing?']/ancestor::div[3]/following-sibling::div//span[text()='0 - 2']/ancestor::div[2]/preceding-sibling::div"));
                wp.click(expRadioBtn);
               System.out.println("0 - 2 experieance selected");
               System.out.println("end Test case: testCase04");
        }

        //Selecting checkbox Which of the following have you learned in Crio.Do for Automation Testing?
        @Test
        public void testCase05() throws InterruptedException {
                System.out.println("Start Tese case: testCase05");
                wp.checkBoxSelect("Java");
                wp.checkBoxSelect("Selenium");
                wp.checkBoxSelect("TestNG");
                System.out.println("Java, Selenium and TestNG is selected");
                System.out.println("end Test case: testCase05");
        }
        
        //Selecting How should you be addressed?
        @Test
        public void testCase06() throws InterruptedException {
                System.out.println("Start Tese case: testCase06");
                Thread.sleep(1500);
                WebElement dropDown = driver.findElement(
                                By.xpath("//span[text()='How should you be addressed?']/ancestor::div[4]//span[text()='Choose']"));
                wp.click(dropDown);
                wp.dropDownOptionClick("Mr");
                System.out.println("Mr selected");
                System.out.println("end Test case: testCase06");
        }

        // Entering date before 7 days form today
        @Test
        public void testCase07() throws InterruptedException {
                System.out.println("Start Tese case: testCase07");
                wp.day7Before(7);
                System.out.println("end Test case: testCase07");
        }
         // Entering current time and clicking submit button
        @Test
        public void testCase08() throws InterruptedException {
                System.out.println("Start Tese case: testCase08");
                wp.time("07:30");
                
                WebElement submitBtn = driver.findElement(By.xpath("//span[text()='Submit']"));
                wp.click(submitBtn);
                System.out.println("07:30 Entered");
                System.out.println("end Test case: testCase08");
        }

        //Checking successful message and printing
        @Test
        public void testCase09() throws InterruptedException {
                System.out.println("Start Tese case: testCase09");
                WebElement result = wait.until(ExpectedConditions
                                .visibilityOfElementLocated(By.xpath(
                                                "//div[text()='Thanks for your response, Automation Wizard!']")));
                System.out.println(result.getText());
                System.out.println("end Test case: testCase09");
        }


        /*
         * Do not change the provided methods unless necessary, they will help in
         * automation and assessment
         */
        @BeforeTest
        public void startBrowser() {
                System.setProperty("java.util.logging.config.file", "logging.properties");

                // NOT NEEDED FOR SELENIUM MANAGER
                // WebDriverManager.chromedriver().timeout(30).setup();

                ChromeOptions options = new ChromeOptions();
                LoggingPreferences logs = new LoggingPreferences();

                logs.enable(LogType.BROWSER, Level.ALL);
                logs.enable(LogType.DRIVER, Level.ALL);
                options.setCapability("goog:loggingPrefs", logs);
                options.addArguments("--remote-allow-origins=*");

                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

                driver = new ChromeDriver(options);
                wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                driver.manage().window().maximize();

                wp = new Wrappers(driver, wait);
                System.out.println("starting browser");
        }

        @AfterTest
        public void endTest() {
                // driver.close();
                driver.quit();
        }
}