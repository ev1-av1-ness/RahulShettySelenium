package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropDownLooping {
  static WebDriver driver;

  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


    System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
    driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
    System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());


    //count the number of checkboxes


    driver.findElement(By.id("divpaxinfo")).click();
    Thread.sleep(2000);
    //6 adults

       /*int i = 1;
    while (i<5) {
        driver.findElement(By.id("hrefIncAdt")).click();
        i++;
    }*/
    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

    for (int i = 1; i < 5; i++) {//i = 1; because 1 adult already selected
      driver.findElement(By.id("hrefIncAdt")).click();
    }
    driver.findElement(By.id("btnclosepaxoption")).click();

    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
  }
}
