package page.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.page.element.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TextBoxPageTest {
    private TextBoxPage TextBoxPage;
    private WebDriver driver;

    @BeforeMethod
    public void SetUp (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        TextBoxPage = new TextBoxPage(driver);
    }

    @Test
    public void fillFullName(){
        String nameInput = "Marina";
        String expectedResult = "Marina";

        TextBoxPage.fillFullName(nameInput);
        TextBoxPage.clickSubmitButton();
        String actualResult = TextBoxPage.getOutputText();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }



    @AfterMethod
    public void Clear(){
        TextBoxPage = null;
        driver.quit();
    }

}
