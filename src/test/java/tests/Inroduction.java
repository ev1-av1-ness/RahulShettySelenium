package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Inroduction {
       static WebDriver driver;
  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(); //создаем объект для хромдрайвер
    driver.get("https://www.google.ru");
    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());
    //System.out.println(driver.getPageSource());

    driver.get("https://www.yahoo.com");
    //driver.navigate().back();
    //driver.navigate().forward();
    driver.close(); //closes current browser
    //driver.quit(); //closes all the browsers opened by selenium script
  }

}
