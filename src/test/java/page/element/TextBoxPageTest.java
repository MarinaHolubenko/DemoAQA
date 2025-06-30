package page.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.page.element.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TextBoxPageTest {
    private TextBoxPage textBoxPage;
    private WebDriver driver;

    @BeforeMethod
    public void SetUp (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        textBoxPage = new TextBoxPage(driver);
    }

    @Test
    public void fillFullName(){
        String nameInput = "Marina";
        String expectedResult = "Marina";

        textBoxPage.fillFullName(nameInput);
        textBoxPage.clickSubmitButton();
        String actualResult = textBoxPage.verifyOutputText(expectedResult);

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void fillEmail(){
        String emailInput = "dkfkds@dksjfk.com";
        String expectedResultEmail = "dkfkds@dksjfk.com";

        textBoxPage.fillEmail(emailInput);
        textBoxPage.clickSubmitButton();
        String actualResult = textBoxPage.verifyOutputText(expectedResultEmail);

        Assert.assertTrue(actualResult.contains(expectedResultEmail));
    }



    @AfterMethod
    public void Clear(){
        textBoxPage = null;
        driver.quit();
    }

}
