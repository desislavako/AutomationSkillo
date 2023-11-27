package lecture14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Homework {
    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuit() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        ChromeDriver driver = new ChromeDriver();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{
                {"dessikol@abv.bg", "D3sislava", "dessisslava"}
        };
    }

    //invocationCount add value how much time test
    @Test(invocationCount = 3, dataProvider = "getUsers")

    public void testLoginWithWaits(String email, String password, String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Open iskillo page
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));


        //validate page title is matching the expected page
        String pageTitle = driver.getTitle();
        Assert.assertEquals("ISkillo", pageTitle);

        //Click on Login link
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        wait.until(ExpectedConditions.visibilityOf(loginLink));
        loginLink.click();

        //Validate URL
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));
       /* String expectedLoginPageUrl = "http://training.skillo-bg.com:4300/users/login";
        String actualLoginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualLoginPageUrl, expectedLoginPageUrl, "Login page URL is incorrect!");*/

        //Validate Sign in form is visible
        WebElement signInElement = driver.findElement(By.xpath("//p[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInElement));
        //Assert.assertTrue(signInElement.isDisplayed(), "The 'Sign in' form is not displayed!");

        //Enter valid email address
        //WebElement userNameField = driver.findElement(By.xpath("//*[@id=\"defaultLoginFormUsername\"]"));
        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys("dessikol@abv.bg");

        //Enter valid password
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys("D3sislava");

        //Click on Remember me button
        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//*[@formcontrolname=\"rememberMe\"]"));
        rememberMeCheckbox.click();

        //Validate Remember me is checked
        Assert.assertTrue(rememberMeCheckbox.isSelected(), "The Remember me checkbox is not selected");

        //Check Sign in button is enabled
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));


        //Click on Sign in button
        signInButton.click();

        //Check profile link is present
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));

        //Click on link Profile
        profileLink.click();

        //Validate current user URL
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/5083"));

        //Validate username on profile page "h2"
        Boolean isElementTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), name));
        Assert.assertTrue(isElementTextDisplayed, "The name of the user is displayed.");

        WebElement userNameProfilePage = driver.findElement(By.tagName("h2"));
        String actualUserName = userNameProfilePage.getText();


        //Validate profile picture
        WebElement profilePicture = driver.findElement(By.className("edit-profile-pic ng-star-inserted"));
        //is opened file task?  wait.until(ExpectedConditions.elementToBeSelected()


        //Validate posts link is present
        WebElement posts = driver.findElement(By.className("profile-stat-count"));
        wait.until(ExpectedConditions.visibilityOf(signInElement));

        //Validate followers link
        WebElement followersLink = driver.findElement(By.id("followers"));
        followersLink.click();

        //Validate following link
        WebElement followingLink = driver.findElement(By.id("following"));
        followingLink.click();

        //Validate "All" label
        WebElement allLabel = driver.findElement(By.className("btn-all btn btn-primary active"));
        allLabel.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-all btn btn-primary active")));

        WebElement postNotFound = driver.findElement(By.className("posts-not-found-container"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("posts-not-found-container")));

        //Validate "Public" label
        WebElement publicLabel = driver.findElement(By.className("btn-public btn btn-primary"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("posts-not-found-container")));

        //Validate "Private" Label
        WebElement privateLabel = driver.findElement(By.className("btn-private btn btn-primary"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("posts-not-found-container")));
    }
}