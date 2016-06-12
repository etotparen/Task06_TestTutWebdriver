import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestTutBySearchVacancy {

    private WebDriver driver;

    @Parameters({"testUrl","testVacancy"})
    @BeforeTest
    public void setUp(String testUrl, String testVacancy) {
        driver = new FirefoxDriver();
        driver.get(testUrl);
        driver.findElement(By.linkText("Работа")).click();
        WebElement searchField = driver.findElement(By.xpath("//input[@data-qa='vacancy-serp__query']"));
        searchField.clear();
        searchField.sendKeys(testVacancy);
        driver.findElement(By.className("navi-search-button__text")).click();
    }
    @Parameters({"testVacancy"})
    @Test
    public void testSearchVacancySuccess(String testVacancy) {
        List<WebElement> searchResults = driver.findElements(By.className("search-result-item__head"));
        int count = 0;
        for (WebElement element : searchResults) {
            if (element.getText().toLowerCase().contains(testVacancy))
                count++;
        }
        Assert.assertTrue(count > 0);
        System.out.println(String.format("Number of suitable vacancies: %1d", count));

        }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}