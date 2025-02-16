package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;
    public WebDriverWait wait;

    // Load configuration
    public static void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties"); // Fixed path
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file.", e);
        }
    }

    // Initialize WebDriver based on config file
    public static void initializeDriver() {
        loadConfig();
        String browserName = prop.getProperty("browser").toLowerCase(); // Default to Chrome

        switch (browserName) {
            case "chrome":
            	WebDriverManager.chromedriver().clearDriverCache();
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url", "https://parabank.parasoft.com/parabank/index.htm")); // Default URL

        long implicitWait = Long.parseLong(prop.getProperty("implicitWait", "30")); // Default 30 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
    }

    // Quit WebDriver
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

