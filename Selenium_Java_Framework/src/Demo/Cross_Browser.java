package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_Browser {

    WebDriver driver = null;
    String projectPath = System.getProperty("user.dir");

    @Parameters("browserName")
    @BeforeTest
    public void setup(String browserName) {
        System.out.println("Browser name is : " + browserName);
        System.out.println("Thread ID : "+ Thread.currentThread().getId());

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodrivernew.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", projectPath+"/drivers/msedgedrivernew.exe");
            driver = new EdgeDriver();
        }
    }
    
    @Test
    public void test1() throws Exception {
    	driver.get("https://google.com");
    	Thread.sleep(4000);
    }
    
    @AfterTest
    public void finish() {
    	driver.close();
    	System.out.println("Test is successful");
    }

}