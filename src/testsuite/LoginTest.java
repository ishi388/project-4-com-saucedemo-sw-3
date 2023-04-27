package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *
 * 1. LoginTest
 *
 * 3. Write down the following test into ‘LoginTest’
 * class
 * 1. userShouldLoginSuccessfullyWithValid
 *Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 *
 * 2. verifyThatSixProductsAreDisplayedOnPage
 *
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed
 * on page
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //username element
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.sendKeys("standard_user");

        //Password element
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("secret_sauce");

        //Login element
        WebElement LoginField = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginField.click();

        //actual result
        WebElement actualresult = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualmsg = actualresult.getText();
        System.out.println(actualmsg);

        //expected result
        String expectedmsg = "Products";

        //match actual and expected result
        Assert.assertEquals(actualmsg, expectedmsg);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //username element
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.sendKeys("standard_user");

        //Password element
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("secret_sauce");

        //Login element
        WebElement LoginField = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginField.click();

        // actualmsg
        List<WebElement> productNo = driver.findElements(By.className("inventory_item"));
        int Size = productNo.size();
        System.out.println(Size);

        //expectedmsg
        int expectedmsg = 6;

        //match actual and expected msg
        Assert.assertEquals("product number not match", expectedmsg, Size);

    }

    @After
    //Here After method for close the browser
    public void teardown() {
        closeBrowser();

    }
}