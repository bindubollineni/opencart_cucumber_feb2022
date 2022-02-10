package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class steps {

    WebDriver driver;
    HomePage hp;
    LoginPage lp;
    MyAccountPage ap;
    AccountRegistrationPage ar;
    public List<HashMap<String, String>> datamap;
    Logger logger;
    ResourceBundle rb;
    String br;

    @Before
    public void setup() {
        logger = LogManager.getLogger(this.getClass());
        rb = ResourceBundle.getBundle("config");
        br = rb.getString("browser");
    }

   /* @After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario status====>" + scenario.getStatus());
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
*/
    @Given("User Launch browser")
    public void user_launch_browser() {
        if (br.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (br.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("opens URL {string}")
    public void opens_url(String url) {
        driver.get(url);
        logger.info("URL launched");
    }

    @When("User navigate to MyAccount menu")
    public void user_navigate_to_my_account_menu() {
        hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("Clicked My Account ");

    }

    @When("Click on Login")
    public void click_on_login() {
        hp.clickLogin();
        logger.info("Clicked on Login Link");
    }

    @When("User enters Email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {
        lp = new LoginPage(driver);
        lp.setEmailId(email);
        logger.info("Set Provided email");
        lp.setPwd(pwd);
        logger.info("Set Provided password");
    }

    @When("Click Login button")
    public void click_login_button() {
        lp.click_LoginBtn();
    }

    @Then("User navigates to MyAccount Page")
    public void user_navigates_to_my_account_page() {
        boolean target_page = lp.validateLogin();
        if (target_page) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
        driver.close();
    }

    @Then("Check User navigates to MyAccount Page by passing email and password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_row(String rows) {

        datamap = DataReader.data(System.getProperty("user.dir") + "/testData/Opencart_LoginData.xlsx", "Sheet1");

        int index = Integer.parseInt(rows) - 1;
        String email = datamap.get(index).get("username");
        String pwd = datamap.get(index).get("password");
        String exp_res = datamap.get(index).get("res");

        ap = new MyAccountPage(driver);
        lp = new LoginPage(driver);
        lp.setEmailId(email);
        lp.setPwd(pwd);
        lp.click_LoginBtn();

        try {
            boolean target_page = lp.validateLogin();
            if (exp_res.equals("Valid")) {
                if (target_page == true) {
                    ap.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (exp_res.equals("Invalid")) {
                if (target_page == true) {
                    ap.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            Assert.fail();
        }
        driver.close();
    }

    //Account Registration
    @When("Click on Register")
    public void click_on_register() {
        hp.clickRegister();
        logger.info("Clicked on Register");
    }

    @When("User provides Valid user details")
    public void user_provides_valid_user_details() {
        ar = new AccountRegistrationPage(driver);
        ar.setFirstName("abcdef");
        logger.info("Provided First Name");
        ar.setLastName("abcdef");
        logger.info("Provided Last Name");
        ar.setEmail(RandomStringUtils.randomAlphabetic(5) + "@gmail.com");
        logger.info("Provided email");
        ar.setTelephone("123456");
        logger.info("Provided Telephone");
        ar.setPassword("bankbank");
        logger.info("Provided Password");
        ar.setConfirmPassword("bankbank");
        logger.info("Provided Confirm Password");
        ar.click_RadioBtn();
        logger.info("Clicked on Radio Button");
        ar.check_PrivacyPolicy();
        logger.info("Clicked on Privacy Policy");

    }

    @When("Click on Continue")
    public void click_on_continue() {
        ar.click_Continue();
        logger.info("Clicked on Continue Button");
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String expmsg) {
        String confmsg = ar.checkConfirmation();
        driver.close();
        if (confmsg.equals(expmsg)) {
            logger.info("Validation Passed");
            Assert.assertTrue(true);
        } else {
            logger.info("Validation Failed");
            Assert.assertTrue(false);
        }

    }
}
