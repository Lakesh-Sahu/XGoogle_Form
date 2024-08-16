package demo.wrappers;

// import java.time.Instant;
// import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;
// import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    ChromeDriver driver;
    WebDriverWait wait;

    public Wrappers(ChromeDriver driver, WebDriverWait wait) {
        System.out.println("Creating wrapper constructor");
        this.driver = driver;
        this.wait = wait;
    }

    public void click(WebElement element) {
        System.out.println("Click method called");
        element.click();
    }

    public void sendKeys(WebElement element, String message) {
        System.out.println("sendKeys method called");
        element.clear();
        element.sendKeys(message);
    }

    public void openUrl(String url) {
        System.out.println("open url called");
        driver.get(url);
    }

    public long epochTime() {
        System.out.println("epochTime called");
        long epochTime = System.currentTimeMillis();
        return epochTime;
    }

    public void checkBoxSelect(String option) {
        System.out.println("checkBoxSelect called");
        WebElement optionChkBox = driver.findElement(By.xpath(
                "//span[text()='Which of the following have you learned in Crio.Do for Automation Testing?']/ancestor::div[3]/following-sibling::div//span[text()='"
                        + option + "']/ancestor::div[2]/preceding-sibling::div"));
        optionChkBox.click();
    }

    public void dropDownOptionClick(String option) throws InterruptedException {
        System.out.println("dropDownOptionClick called");
        Thread.sleep(1500);
        WebElement optionSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//span[text()='How should you be addressed?']/ancestor::div[4]//span[text()='" + option + "'])[2]")));
        optionSelect.click();
    }

    public void day7Before(int minusDay) {
        System.out.println("day7Before called");
        LocalDate currentDate = LocalDate.now();
        LocalDate newDate = currentDate.minusDays(minusDay);
        // String dateWithoutHyphen = String.valueOf(newDate).replace("-", "");
        // WebElement input = driver
        // .findElement(By.xpath("//span[text()='What was the date 7 days
        // ago?']/ancestor::div[4]//input"));
        // input.sendKeys(dateWithoutHyphen.substring(6));
        // input.sendKeys(dateWithoutHyphen.substring(4, 6));
        // input.sendKeys(dateWithoutHyphen.substring(0, 4));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = newDate.format(dtf);
        WebElement input = driver
                .findElement(By.xpath("//span[text()='What was the date 7 days ago?']/ancestor::div[4]//input"));
        input.sendKeys(String.valueOf(date));
    }

    public void time(String timeToEnter) {
        System.out.println("time called");
        // LocalTime currentTime = LocalTime.now();
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");
        // String hr = currentTime.format(dtf);
        // DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("mm");
        // String mm = currentTime.format(dtf2);
        // WebElement hourInput = driver.findElement(By.xpath("(//span[text()='What is
        // the time right now?']/ancestor::div[4]//input)[1]"));
        // // hourInput.sendKeys(time.substring(0, 2));
        // hourInput.sendKeys(hr);

        // WebElement minInput = driver.findElement(By.xpath("(//span[text()='What is
        // the time right now?']/ancestor::div[4]//input)[2]"));
        // // minInput.sendKeys(time.substring(3, 5));
        // minInput.sendKeys(mm);

        WebElement hourInput = driver
                .findElement(By.xpath("(//span[text()='What is the time right now?']/ancestor::div[4]//input)[1]"));
        hourInput.sendKeys(timeToEnter.substring(0, 2));

        WebElement minInput = driver
                .findElement(By.xpath("(//span[text()='What is the time right now?']/ancestor::div[4]//input)[2]"));
        minInput.sendKeys(timeToEnter.substring(3, 5));
    }
}