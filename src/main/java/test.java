import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by Ban on 12.06.2016.
 */
public class test {
    public static void main(String[] args) {
        WebDriver driver;
        driver = new FirefoxDriver();
        driver.get("http://tut.by");
        driver.findElement(By.linkText("Работа")).click();
        driver.findElement(By.xpath("//input[@data-qa='vacancy-serp__query']")).sendKeys("специалист по тестированию");
        driver.findElement(By.className("navi-search-button__text")).click();
        List<WebElement> searchResults = driver.findElements(By.className("search-result-item__head"));
        int count = 0;
        for (WebElement element : searchResults) {
            if (element.getText().toLowerCase().contains("специалист по тестированию"))
                count++;
            }

        System.out.println("Number of suitable vacancies: " + count);
        }
    }
