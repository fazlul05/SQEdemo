package com.sample.test.demo;

import static org.testng.Assert.fail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.sample.test.demo.util.ElementActions;

public class TestBase {

    private Configuration config;
    protected WebDriver driver;
    protected String url;

    @BeforeClass(alwaysRun = true)
    public void init() throws Throwable {
        config = new Configuration();
        url = config.getUrl();
        initializelDriver();
        navigateToSite();
       }

    private void navigateToSite() {
        driver.get(url);
        System.out.println("The URL is : "+url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();

        } catch (Exception e) {
        }
    }

    private void initializelDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            if (config.getPlatform().equalsIgnoreCase("windows")) {
//                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/windows/chromedriver.exe");

            } else {
//                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver");
            }
            driver = new ChromeDriver();
        }
        else {
            fail("Unsupported bfrowser " + config.getBrowser());
        }
       
    }


}
