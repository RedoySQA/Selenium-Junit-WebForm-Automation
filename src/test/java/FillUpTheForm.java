import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class FillUpTheForm {

    WebDriver driver;

    @BeforeAll
    public void setup() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        driver.get("https://www.digitalunite.com/practice-webform-learners");


        WebElement cookie = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();
        Thread.sleep(1000);

    }


    @DisplayName("Form should be filled up successfully")
    @Test
    public void formFillup() throws InterruptedException {

        driver.findElement(By.id("edit-name")).sendKeys("Redoy Shafaiet");
        driver.findElement(By.id("edit-number")).sendKeys("01767089805");

        driver.findElement(By.cssSelector("[for = \"edit-agnew-20-30\"]")).click();

        String today = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        driver.findElement(By.id("edit-date")).sendKeys(today);

        driver.findElement(By.id("edit-email")).sendKeys("mdredoyhowlader23@gmail.com");

        String myself = "Hello everyone! I am Redoy & I want to build my career in SQA.";
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys(myself);

        WebElement uploadElement = driver.findElement(By.id("edit-uploadocument-upload"));
        File document = new File(".\\src\\test\\resources\\Redoy Cv.docx");
        uploadElement.sendKeys(document.getAbsolutePath());

        JavascriptExecutor sc=(JavascriptExecutor) driver;
        sc.executeScript("window.scrollTo(0,500)");

        driver.findElement(By.id("edit-age")).click();
        driver.findElement(By.id("edit-submit")).click();







    }


}