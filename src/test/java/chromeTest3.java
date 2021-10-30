import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class chromeTest3 {
    public static RemoteWebDriver driver;


    @Test
    public static void test3() throws MalformedURLException {

    ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

    URL url = new URL("http://localhost:4444/wd/hub");


    driver = new RemoteWebDriver(url, options);
    driver.get("http://facebook.com");
    System.out.println(driver.getTitle());
        driver.get("http://cnn.com");
        System.out.println(driver.getTitle());
        driver.get("https://bbc.com/");
        System.out.println(driver.getTitle());

//Start docker - docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:latest
        //      docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-firefox:latest

    }
}
