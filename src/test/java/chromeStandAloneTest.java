import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class chromeStandAloneTest {
    public static RemoteWebDriver driver;

    public static void main(String[] args) throws MalformedURLException {

    ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

    URL url = new URL("http://localhost:4444/wd/hub");


    driver = new RemoteWebDriver(url, options);
    driver.get("http://google.com");
    System.out.println(driver.getTitle());
        driver.get("http://linkedin.com");
        System.out.println(driver.getTitle());
        driver.get("https://saucelabs.com/");
        System.out.println(driver.getTitle());

//Start docker - docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:latest
        //      docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-firefox:latest

    }
}
