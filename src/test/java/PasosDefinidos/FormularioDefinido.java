package PasosDefinidos;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FormularioDefinido {

    WebDriver driver;

    @Given("that the DEMOQA website is available")
    public void that_the_demoqa_website_is_available() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @When("register my data")
    public void register_my_data() {
        driver.findElement(By.id("userName")).sendKeys("Jose Munoz");
        driver.findElement(By.id("userEmail")).sendKeys("josem9507@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("House");
        driver.findElement(By.id("permanentAddress")).sendKeys("Working");
    }

    @And ("I click on the button")
    public void i_click_on_the_button() {
        //driver.findElement(By.id("submit")).click();
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));
    }

    @Then("my data is displayed on the screen")
    public void my_data_is_displayed_on_the_screen() {
        System.out.printf(driver.findElement(By.id("name")).getText());
        System.out.println(driver.findElement(By.id("email")));
        driver.findElement(By.id("currentAddress"));
        driver.findElement(By.id("permanentAddress"));

        //Clean cookies and close window
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
