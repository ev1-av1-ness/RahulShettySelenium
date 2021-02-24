package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestiveDropdowns {
  //based on input
         static WebDriver driver;
  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    driver.findElement(By.id("autosuggest")).sendKeys("ind");
    Thread.sleep(3000);

    //child css li[class='ui-menu-item'] a
    //child XPath li[class='ui-menu-item']/a

    List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));

    for(WebElement option : options) {
      if (option.getText().equalsIgnoreCase("India")) {
          option.click();
          break;
      }

    }
  }
}
