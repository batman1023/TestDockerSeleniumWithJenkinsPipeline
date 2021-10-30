import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class chromeTest1 {
    @BeforeTest
    public void startDocker() throws IOException, InterruptedException {
        startDocker start = new startDocker();
        start.startFile();
    }

    @AfterTest
    public void stopDocker() throws IOException, InterruptedException {
        stopDocker stop = new stopDocker();
        stop.stopFile();
    }



    public static RemoteWebDriver driver;

    @Test
    public static void test1() throws MalformedURLException {

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
