package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {
  //loaded after select in other place - user actions
        static WebDriver driver;
  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

    driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

    /*driver.findElement(By.xpath("//a[@value='BLR']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();*/
    //you can give unique Xpath through parent

    driver.findElement(By.xpath("//a[@value='BLR']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
  }
}
