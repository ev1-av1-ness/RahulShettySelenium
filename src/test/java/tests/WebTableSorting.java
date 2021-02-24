package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableSorting {
  //sorted order in table or not?
          static WebDriver driver;
  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

    //click on column
    //Xpath: //tr/th[1]
    driver.findElement(By.xpath("//tr/th[1]")).click();
    //capture all webelements --> values to the list
    List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
    //apply getText() --> text of all webelements into new (original) list <-- also should have sorted way!
    List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());

    //already sorted
    //sort on the original list of step 3 --> sorted list
    List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
    //compare original list vs sorted original list
    Assert.assertTrue(originalList.equals(sortedList));
    
    //get the price of the Beans
    //scan the name column with getText --> and ancestor --> Beans --> Print the price of the Rice
   
    //все цены мы хотим с помощью stream собрать в лист
    //elementList.stream().map(s->getPriceVeggie()).collect(Collectors.toList());
    //мы хотим только Beans
    //filter with getText() Beans
    List<String>price = elementList.stream().filter(s->s.getText().contains("Beans"))
            .map(s->getPriceVeggie(s)).collect(Collectors.toList()); //s - Beans
    //td and td siblings common parent
    //Xpath //tr/td[1]/following-sibling::td[1]
            price.forEach(a->System.out.println(a));
    //what do you do if beans present not the first page

  }

  private static String getPriceVeggie(WebElement s) {
    String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
    return pricevalue;
  }

}
