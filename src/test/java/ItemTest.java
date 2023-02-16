import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class ItemTest {

    private WebDriver browser;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://Users//lenous//IdeaProjects//qa2-winter//chromedriver.exe");

        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://saucedemo.com");
    }

    @After
    public void tearDown() {
        browser.close();
        browser.quit();
    }

    //Login into the website and add item to the cart. Check that the correct item is in the cart
    @Test
    public void loginIntoWebsite () {

        browser.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        browser.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        browser.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        browser.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        browser.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        assertEquals("Sauce Labs Backpack", browser.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText());
    }

}
