package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

    // Declare WebDriver and properties variables
    public static WebDriver driver;
    static Properties p;
    public static Logger logger;

    // Create ChromeOptions and EdgeOptions objects
  

    // Method to initialize the browser
    public static WebDriver initilizeBrowser() throws IOException {
        // Check if execution environment is remote
        if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Set platform based on properties
            if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No matching OS..");
            }

            // Set browser based on properties
            switch (getProperties().getProperty("browser").toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.addArguments("--disable-notifications");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    EdgeOptions option = new EdgeOptions();
                    option.addArguments("--disable-blink-features=AutomationControlled");
                    option.addArguments("--disable-notifications");
                    capabilities.setCapability(EdgeOptions.CAPABILITY, option);
                    break;
                default:
                    System.out.println("No matching browser");
            }

            // Create RemoteWebDriver object with URL and capabilities
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        } else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
            // Check if execution environment is local
            switch (getProperties().getProperty("browser").toLowerCase()) {
                case "chrome":
                	 ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.addArguments("--disable-notifications");
                    driver = new ChromeDriver(options);
                    break;
                case "edge":
                	EdgeOptions option = new EdgeOptions();
                    option.addArguments("--disable-blink-features=AutomationControlled");
                    option.addArguments("--disable-notifications");
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("No matching browser");
                    driver = null;
            }
        }

        // Initialize logger and manage driver settings
        logger = LogManager.getLogger();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        return driver;
    }

    // Method to get the driver
    public static WebDriver getDriver() {
        return driver;
    }

    // Method to load properties from file
    public static Properties getProperties() throws IOException {
        FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

        p = new Properties();
        p.load(file);
        return p;
    }

    // Method to take a screenshot
    public static void takeScreenshot(String fileName) throws IOException {
        // Convert the WebDriver instance to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture the screenshot and save it as a source file
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Define the destination path for the screenshot
        File targetFile = new File("./screenshots/" + fileName + ".png");

        // Copy the source file to the destination path, replacing it if it already exists
        FileUtils.copyFile(sourceFile, targetFile);

        // Print to check the saved screenshot
        System.out.println("Screenshot taken: " + "\n");
    }
}
