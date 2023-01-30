import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class TestSetupUtilities {


    public static WebDriver setupDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/miro/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriverWait setupWait(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait;
    }

    public static void getToMainPageSteam(WebDriver driver){

        WebDriverWait wait = TestSetupUtilities.setupWait(driver);
        driver.get("https://store.steampowered.com/");
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='global_action_link']"))));
    }

    public static void getToLoginPageSteam(WebDriver driver){
        WebDriverWait wait = TestSetupUtilities.setupWait(driver);
        driver.get("https://store.steampowered.com/login/");
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))));
    }

    public static void loginWithRandStrings(WebDriver driver){
        String lgnACCBtnXPATH = new String("//button[@type='submit']");
        String usrNmField = new String("//input[@class='newlogindialog_TextInput_2eKVn']");
        String usrPswrdField = new String("//input[@type='password']");
        driver.findElement(By.xpath(usrNmField)).sendKeys(generateRandomString());
        driver.findElement(By.xpath(usrPswrdField)).sendKeys(generateRandomString());
        driver.findElement(By.xpath(lgnACCBtnXPATH)).click();
    }

    public static String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }



}
