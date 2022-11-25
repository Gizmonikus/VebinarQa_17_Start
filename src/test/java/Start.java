import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class Start {
    WebDriver wd;


    @BeforeMethod//анотация
    public void precondition() {
        wd = new ChromeDriver();
        wd.get("file:///C:/Users/fight/Downloads/index.html");

    }

    @Test
    public void testIndexFile() {
//items
        //item 1
        WebElement item1 = wd.findElement(By.tagName("li"));
        wd.findElement(By.cssSelector("li"));
        //item 2
        List<WebElement> items = wd.findElements(By.cssSelector("li"));
        WebElement item2 = items.get(1);
        wd.findElement(By.cssSelector("#nav li:nth-child(2)"));
        //item3
        //List<WebElement> items = wd.findElements(By.cssSelector("li"));
        WebElement item3 = items.get(2);
        wd.findElement(By.cssSelector("#nav li:nth-child(3)"));
        //item4
        WebElement item4 = items.get(3);
        wd.findElement(By.cssSelector("#nav li:last-child"));

// form

        //name
        WebElement inputName = wd.findElement(By.tagName("input"));
        wd.findElement(By.name("name"));
        wd.findElement(By.cssSelector("input[name='name']"));
        //surename
        List <WebElement> names = wd.findElements(By.cssSelector("input"));
        WebElement inputSureName = names.get(1);
        wd.findElement(By.cssSelector("input[name='surename']"));

        //button
        WebElement buttonSend = wd.findElement(By.className("btn"));
        wd.findElement(By.cssSelector(".btn"));
// table
        //rows
        wd.findElement(By.cssSelector("table#country-table>tbody>tr"));
        wd.findElement(By.cssSelector("#country-table tr:first-child"));
        wd.findElement(By.cssSelector("#country-table tr:nth-child(2)"));
        wd.findElement(By.cssSelector("#country-table tr:nth-child(3)"));
        wd.findElement(By.cssSelector("#country-table tr:last-child"));

        //td Germany
        //String text = wd.findElement(By.cssSelector("#country-table tr:nth-child(3)>td:first-child")).getText();
        String text = wd.findElement(By.cssSelector("tr:nth-child(3)>td:first-child")).getText();
        Assert.assertEquals(text,"Germany");

    }
    @Test
    public void isItem2Select(){
        //step 1 find item2 + click
        //Assert (text from alert, text item2)

        //click by item2 != item2
        Assert.assertTrue(text1.contacns(text2));
    }

    @AfterMethod
    public void postCondition() {

        wd.close();
       // wd.quit();
    }
}
