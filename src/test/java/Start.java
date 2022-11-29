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
        wd.get("file:///D:/Learning/Video/QA%20Automation/Vebinar/Vevinar_3/index.html");

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
    public void tableTests(){
        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        System.out.println("Count of Rows -->" + rows.size());
        List<WebElement> colums = wd.findElements(By.cssSelector("th"));
        System.out.println("Count of Colums -->" + colums.size());
        //print contetnt of row3
        List<WebElement> row3 = wd.findElements(By.cssSelector("tr:nth-child(3) td"));
        for (WebElement el:row3) {
            System.out.println(el.getText());

            System.out.println("**********************");
            WebElement r3 = wd.findElement(By.cssSelector("tr:nth-child(3)"));
            System.out.println(r3.getText());

            System.out.println("**********************");
            System.out.println(wd.findElement(By.cssSelector("table")).getText());
            //print content of last col
            List<WebElement> lastColums = wd.findElements(By.cssSelector("td:last-child"));
            for (WebElement el1:lastColums) {
                System.out.println(el1.getText());

            }
            //Assert with name "Canada"
            WebElement canada = wd.findElement(By.cssSelector("tr:nth-child(3) td:last-child"));
            String text = canada.getText();
            Assert.assertEquals(text,"Canada");
        }
    }
//    public void isItem2Select(){
//        //step 1 find item2 + click
//        //Assert (text from alert, text item2)
//
//        //click by item2 != item2
//        Assert.assertTrue(text1.contacns(text2));
//    }

    @AfterMethod
    public void postCondition() {

        wd.close();
       // wd.quit();
    }
}
