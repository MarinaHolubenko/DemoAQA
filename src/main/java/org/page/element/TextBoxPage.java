package org.page.element;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TextBoxPage {
    public WebDriver driver;
    @FindBy(xpath = "//*[@id=\"userName\"]")
    private WebElement fullNameInput;

    @FindBy(xpath = "//*[@id=\"userEmail\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"currentAddress\"]")
    private WebElement currentAddressTextArea;

    @FindBy(xpath = "//*[@id=\"permanentAddress\"]")
    private WebElement permanentAddressTextArea;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"output\"]")
    private WebElement output;

    public TextBoxPage (WebDriver driverParameter){
        PageFactory.initElements(driverParameter, this);
        this.driver = driverParameter;
//        this.fullNameInput = driver.findElement(By.xpath(Path.TEXT_BOX_FULL_NAME));
//        this.emailInput = driver.findElement(By.xpath(Path.TEXT_BOX_EMAIL));
//        this.currentAddressTextArea = driver.findElement(By.xpath(Path.TEXT_BOX_CURRENT_ADDRESS));
//        this.permanentAddressTextArea = driver.findElement(By.xpath(Path.TEXT_BOX_PERMANENT_ADDRESS));
//        this.submitButton = driver.findElement(By.xpath(Path.TEXT_BOX_SUBMIT_BUTTON));
//        this.output = driver.findElement(By.xpath(Path.TEXT_BOX_OUTPUT));
    }

    public void fillFullName (String value){
        fullNameInput.clear();
        fullNameInput.sendKeys(value);
    }

    public void fillEmail (String email){
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void fillCurrentAddress (String currentAddressText){
        currentAddressTextArea.clear();
        currentAddressTextArea.sendKeys(currentAddressText);
    }

    public void fillPermanentAddress (String permanentAddressText){
        permanentAddressTextArea.clear();
        permanentAddressTextArea.sendKeys(permanentAddressText);
    }

    public void clickSubmitButton (){

        FluentWait<WebElement> wait = new FluentWait<>(submitButton);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(ElementClickInterceptedException.class);

        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,10);
        actions.perform();
        actions.click(submitButton);
        actions.perform();
    }

    // Перебираєм виведені в output значення і виводим в рядок
    public String getOutputText(){
//        WebDriverWait waitOutput = new WebDriverWait(driver, Duration.ofSeconds(10));
//        waitOutput.until(ExpectedConditions.visibilityOf(output));


        List<WebElement> elements = output.findElements(By.xpath("//*[@class=\"mb-1\"]"));
        StringBuilder stringBuilder = new StringBuilder();

        for (WebElement element : elements){
            stringBuilder.append(element);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


}
