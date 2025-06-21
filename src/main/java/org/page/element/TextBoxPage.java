package org.page.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.page.Path;

import java.util.List;

public class TextBoxPage {
    private WebElement fullNameInput;
    private WebElement emailInput;
    private WebElement currentAddressTextArea;
    private WebElement permanentAddressTextArea;
    private WebElement submitButton;
    private WebElement output;

    public TextBoxPage (WebDriver driver){
        this.fullNameInput = driver.findElement(By.xpath(Path.TEXT_BOX_FULL_NAME));
        this.emailInput = driver.findElement(By.xpath(Path.TEXT_BOX_EMAIL));
        this.currentAddressTextArea = driver.findElement(By.xpath(Path.TEXT_BOX_CURRENT_ADDRESS));
        this.permanentAddressTextArea = driver.findElement(By.xpath(Path.TEXT_BOX_PERMANENT_ADDRESS));
        this.submitButton = driver.findElement(By.xpath(Path.TEXT_BOX_SUBMIT_BUTTON));
        this.output = driver.findElement(By.xpath(Path.TEXT_BOX_OUTPUT));
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
        submitButton.click();
    }

    // Перебираєм виведені в output значення і виводим в рядок
    public String getOutputText(){
        List<WebElement> elements = output.findElements(By.xpath("//*[@class=\"mb-1\"]"));
        StringBuilder stringBuilder = new StringBuilder();

        for (WebElement element : elements){
            stringBuilder.append(element);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
