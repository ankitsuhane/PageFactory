package com.orgname.framework.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Component
@Scope("cucumber-glue")
public class WebDriverFactory {

    public static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
    private static WebDriver webDriver;

    @Value("${browser}")
    private String browser;

    @Value("${geckodriver}")
    private String geckoDriver;

    @Value("${chromedriver}")
    private String chromeDriver;

    @Value("${webdriver.wait.secs}")
    public static int webDriverWait;

    @Bean
    @Scope("cucumber-glue")
    public void setUpWebDriver() throws IllegalStateException {
        switch (browser.toLowerCase()) {
            case "firefox":
                logger.info("Running Firefox Web Driver with Driver Path:- {}", geckoDriver);
                //System.setProperty("webdriver.gecko.driver", geckoDriver);
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();

                break;
            case "chrome":
                logger.info("Running Chrome Web Driver with Driver Path:- {}");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.addArguments("--start-maximized");

                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(chromeOptions);
                break;
            default:
                String errorMessage = String.format("%s is not a recognised option.", browser);
                throw new IllegalStateException(errorMessage);
        }
        logger.info(String.format("Browser is set to %s", browser));
    }

    public final WebDriver getWebDriver() {	return webDriver; }

    public boolean waitForPageTitle(String pageTitle) {
        return new WebDriverWait(getWebDriver(), webDriverWait)
                .until(titleIs(pageTitle));
    }

    public void waitForVisibilityOfElement(WebElement elementIdentifier) {
        new WebDriverWait(getWebDriver(), webDriverWait)
                .until(visibilityOf(elementIdentifier));
    }

    public void waitForVisibilityOfElementClick(WebElement elementIdentifier) {
        new WebDriverWait(getWebDriver(), webDriverWait)
                .until(visibilityOf(elementIdentifier));
        elementIdentifier.click();
    }

    public void waitForElementToBeClickable(WebElement elementIdentifier) {
        new WebDriverWait(getWebDriver(), webDriverWait)
                .until(elementToBeClickable(elementIdentifier));
    }
}