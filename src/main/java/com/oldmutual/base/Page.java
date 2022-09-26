package com.oldmutual.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;

public class Page {
    public static WebDriver driver;
    public static Logger log = Logger.getLogger("loanCalculator_Logs");
//	public static WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
    public static String browser;
    public static Properties config = new Properties();

    public static void initConfiguration() {


        if((System.getenv("browser")!=null) && (System.getenv("browser").equals("")))
            browser = System.getenv("browser");
        else{
            browser = Constants.browser;

        }

        config.setProperty("browser", browser);

        if (config.getProperty("browser").equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            log.debug("firefox Launched !!!");
        } else if (config.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            log.debug("Chrome Launched !!!");
        } else if (config.getProperty("browser").equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            log.debug("InternetExplorerDriver Launched !!!");
        } else if (config.getProperty("browser").equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            log.debug("Edge Launched !!!");
        }

        driver.get(Constants.baseUrl);
        driver.manage().window().maximize();

    }
    public static void click(WebElement element) {
//		wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        log.debug("Clicking on an Element : " + element);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void type(WebElement element, String value) {

//		wait.until(ExpectedConditions.visibilityOf(element));
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            log.debug(e);
        }

        log.debug("Typing in an Element : " + element + " entered value as : " + value);

//		test.log(LogStatus.INFO, "Typing in : " + element + " entered value as " + value);

    }
    public void select(WebElement locator, String value) {
        Select select = new Select(locator);
        select.selectByVisibleText(value);
        log.debug("Selecting from dropdown : " + locator + " value as " + value);
//		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as " + value);
    }
    public boolean isElementPresent(By by) {

        try {

            driver.findElement(by);
            return true;

        } catch (NoSuchElementException e) {

            return false;

        }

    }
    public static void verifyEquals(String expected, String actual) throws IOException {

        try {

            Assert.assertEquals(actual, expected);

        } catch (Throwable t) {

        }

    }
    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView();", element);
//		js.executeScript("window.scrollBy(0,2000)");
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        js.executeScript("window.scrollBy(0,800)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//		js.executeScript("window.scrollBy(0,3000)");

        log.debug("Scrolling Until element is visible : " + element);
//		test.log(LogStatus.INFO, "ScrollingIntoVisible : " + element);
    }
    public static void quitBrowser() {

        driver.quit();

    }


}
