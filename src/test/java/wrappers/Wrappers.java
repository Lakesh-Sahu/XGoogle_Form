package wrappers;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrappers {
    //Creating ChromeDriver instance variable
    ChromeDriver driver;

    //Creating WebDriverWait instance variable
    WebDriverWait wait; 

    //Constructor of Wrappers class
    public Wrappers(ChromeDriver driver, WebDriverWait wait) {
        System.out.println("Creating wrapper constructor");

        //Initializing the class ChromeDriver instance variable
        this.driver = driver;

        //Initializing the class WebDriverWait instance variable
        this.wait = wait;
    }

    //To click an WebElement
    public void click(WebElement element) {
        element.click();
    }

    //To enter text in a WebElement
    public void sendKeys(WebElement element, String text) {
        //Clearing the WebElement
        element.clear();

        //Sending text to the WebElement
        element.sendKeys(text);
    }

    //To open url
    public void openUrl(String url) {
        System.out.println("open url called");

        //Opening url
        driver.get(url);
    }

    //To return epoch time
    public long epochTime() {
        //Storing epoch time
        long epochTime = System.currentTimeMillis();

        //returning epoch time
        return epochTime;
    }

    //Selecting radio button for given experience
    public void experieanceRadioBtn(String exp) {
        //Locating Radio Button for given experience 
        WebElement expRadioBtn = driver.findElement(By.xpath(
            "//span[text()='How much experience do you have in Automation Testing?']/ancestor::div[3]/following-sibling::div//span[text()='" + exp + "']/ancestor::div[2]/preceding-sibling::div"));

        //Clicking on radio button                 
        click(expRadioBtn);

        System.out.println(exp + " experieance selected");
    }

    //Selecting Checkbox for given option text
    public void checkBoxSelect(String option) {
        //Locating the checkbox for given option text
        WebElement optionChkBox = driver.findElement(By.xpath(
                "//span[text()='Which of the following have you learned in Crio.Do for Automation Testing?']/ancestor::div[3]/following-sibling::div//span[text()='"
                        + option + "']/ancestor::div[2]/preceding-sibling::div"));

        //Selecting the checkbox
        optionChkBox.click();
    }

    //To select option from the dropdown of "How should you be addressed"
    public void dropDownOptionClick(String option) throws InterruptedException {

        //Waiting for the dropdown to open
        Thread.sleep(1500);

        //Locating the dropdown option with given option 
        WebElement optionSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//span[text()='How should you be addressed?']/ancestor::div[4]//span[text()='" + option + "'])[2]")));

        //Clicking on the dropdown option
        optionSelect.click();
    }

    //Selecting the date before today
    public void day7Before(int minusDay) throws InterruptedException {

        //Getting todays date in the "yyy-MM-dd" pattern
        LocalDate currentDate = LocalDate.now();

        //Getting given number of days before todays date
        LocalDate newDate = currentDate.minusDays(minusDay);

        //Formate the stored date into "dd-MM-yyyy" pattern
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        //Converting formated date into String
        String date = newDate.format(dtf);

        //Locating the input box
        WebElement input = driver
                .findElement(By.xpath("//span[text()='What was the date 7 days ago?']/ancestor::div[4]//input"));

        //Entering date to the inputbox 
        sendKeys(input, String.valueOf(date));
    }

    //Entering the given time
    public void time(String timeToEnter) {        
        //Locating the hour inputbox
        WebElement hourInput = driver
                .findElement(By.xpath("(//span[text()='What is the time right now?']/ancestor::div[4]//input)[1]"));

        //Entering the hour part
        hourInput.sendKeys(timeToEnter.substring(0, 2));

        //Locating the minute inputbox
        WebElement minInput = driver
                .findElement(By.xpath("(//span[text()='What is the time right now?']/ancestor::div[4]//input)[2]"));
        
        //Entering the minutes part
        minInput.sendKeys(timeToEnter.substring(3, 5));
    }

    //Entering the current time
    public void currentTime() {

        //Getting the current time
        LocalTime currentTime = LocalTime.now();

        //Formatting the currentTime in "HH" pattern
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");

        //Converting formatted hour into String
        String hr = currentTime.format(dtf);

        //Formatting the currentTime in "mm" pattern
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("mm");

        //Converting formated minute into String
        String mm = currentTime.format(dtf2);

        //Locating hour inputbox
        WebElement hourInput = driver.findElement(By.xpath("(//span[text()='What is the time right now?']/ancestor::div[4]//input)[1]"));

        //Entering hour part in the hour inputbox
        hourInput.sendKeys(hr);

        //Locating the minute inputbox
        WebElement minInput = driver.findElement(By.xpath("(//span[text()='What is the time right now?']/ancestor::div[4]//input)[2]"));

        //Entering the minute part in the minute inputbox
        minInput.sendKeys(mm);
    }
} 