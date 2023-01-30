import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SteamTests {

    @DataProvider(name = "basic_driver")
    public static Object[][] setupMainPageTest() {

        return new Object[][]{
                new Object[]{TestSetupUtilities.setupDriver()}
        };

    }


    @Test(dataProvider = "basic_driver")
    public static void testLoadMainPage(WebDriver driver) {
        TestSetupUtilities.getToMainPageSteam(driver);
        WebElement loginMainpageButton = driver.findElement(By.xpath("//a[@class='global_action_link']"));
        Assert.assertEquals(loginMainpageButton.isDisplayed(), true, "main page didn't load");

    }

    @Test(dataProvider = "basic_driver")
    public static void testLoadLoginPage(WebDriver driver) {
        String lgnACCBtnXPATH = new String("//button[@type='submit']");

        TestSetupUtilities.getToMainPageSteam(driver);
        driver.findElement(By.xpath("//a[@class='global_action_link']")).click();
        TestSetupUtilities.setupWait(driver).until((ExpectedConditions.visibilityOfElementLocated(By.xpath(lgnACCBtnXPATH))));

        WebElement loginAccountButton = driver.findElement(By.xpath(lgnACCBtnXPATH));
        Assert.assertEquals(loginAccountButton.isDisplayed(), true, "login page didn't load");
    }

    @Test(dataProvider = "basic_driver")
    public static void testLoginPageLoadingElement(WebDriver driver) {
        TestSetupUtilities.getToLoginPageSteam(driver);
        TestSetupUtilities.loginWithRandStrings(driver);

        WebElement loadingAnimation = driver.findElement(By.xpath("//div[@class='newlogindialog_LoadingContainer_OYHj3']"));
        Assert.assertEquals(loadingAnimation.isDisplayed(), true, "login animation didn't appear");
    }

    @Test(dataProvider = "basic_driver")
    public static void testLoginPageError(WebDriver driver) {
        TestSetupUtilities.getToLoginPageSteam(driver);
        TestSetupUtilities.loginWithRandStrings(driver);

        WebElement wariningText = driver.findElement(By.xpath("//div[@class='newlogindialog_FormError_1Mcy9']"));
        Assert.assertEquals(wariningText.isDisplayed(), true, "login animation didn't appear");
    }


}