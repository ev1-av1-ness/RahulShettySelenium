package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {
       static WebDriver driver;
  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    //dropdown with select tag - static
    WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
    Select dropdown = new Select(staticDropdown);
    dropdown.selectByIndex(3);
    System.out.println(dropdown.getFirstSelectedOption().getText());
    dropdown.selectByVisibleText("AED");
    System.out.println(dropdown.getFirstSelectedOption().getText());
    dropdown.selectByValue("INR"); //select by value of attribute
    System.out.println(dropdown.getFirstSelectedOption().getText());
  }
}
