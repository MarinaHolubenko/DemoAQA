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
import java.util.NoSuchElementException;

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

    private FluentWait <WebDriver> wait;


    public TextBoxPage (WebDriver driverParameter){
        PageFactory.initElements(driverParameter, this);
        this.driver = driverParameter;
//        this.fullNameInput = driver.findElement(By.xpath(Path.TEXT_BOX_FULL_NAME));
//        this.emailInput = driver.findElement(By.xpath(Path.TEXT_BOX_EMAIL));
//        this.currentAddressTextArea = driver.findElement(By.xpath(Path.TEXT_BOX_CURRENT_ADDRESS));
//        this.permanentAddressTextArea = driver.findElement(By.xpath(Path.TEXT_BOX_PERMANENT_ADDRESS));
//        this.submitButton = driver.findElement(By.xpath(Path.TEXT_BOX_SUBMIT_BUTTON));
//        this.output = driver.findElement(By.xpath(Path.TEXT_BOX_OUTPUT));

        this.wait = new FluentWait<>(driverParameter)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    public void fillFullName (String value){
        wait.until(ExpectedConditions.visibilityOf(fullNameInput));
        fullNameInput.clear();
        fullNameInput.sendKeys(value);
        wait.until(ExpectedConditions.textToBePresentInElementValue(fullNameInput, value));
    }

    public void fillEmail (String email){
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);
        wait.until(ExpectedConditions.textToBePresentInElementValue(emailInput, email));
    }

    public void fillCurrentAddress (String currentAddressText){
        wait.until(ExpectedConditions.visibilityOf(currentAddressTextArea));
        currentAddressTextArea.clear();
        currentAddressTextArea.sendKeys(currentAddressText);
        wait.until(ExpectedConditions.textToBePresentInElementValue(currentAddressTextArea, currentAddressText));
    }

    public void fillPermanentAddress (String permanentAddressText){
        wait.until(ExpectedConditions.visibilityOf(permanentAddressTextArea));
        permanentAddressTextArea.clear();
        permanentAddressTextArea.sendKeys(permanentAddressText);
        wait.until(ExpectedConditions.textToBePresentInElementValue(permanentAddressTextArea, permanentAddressText));
    }

    public void clickSubmitButton (){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));

        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 200);
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        actions.click(submitButton).perform();
    }

    // Перебираєм виведені в output значення і виводим в рядок
//    public String getOutputText(){
//      wait.until(ExpectedConditions.visibilityOf(output));
//
//
//        List<WebElement> elements = output.findElements(By.xpath("//*[@class=\"mb-1\"]"));
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (WebElement element : elements){
//            stringBuilder.append(element);
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//    }

    public String verifyOutputText (String result){
        wait.until(ExpectedConditions.visibilityOf(output));
        String actualOutput = output.getText();
        return actualOutput;
    }

}
