package ru.yandex.Sprint4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuestionPage {

    final private WebDriver driver;

    public QuestionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        String homePageURL = "https://qa-scooter.praktikum-services.ru/";
        driver.get(homePageURL);
    }

    public boolean atPage() {
        String homePageTitle = "undefined";
        return homePageTitle.equals(driver.getTitle());
    }

    public String getAnswer(String question, String answer) {

        By questionPath = By.xpath("//*[text()='" + question + "']");
        By answerPath = By.xpath("//*[text()='" + answer + "']");
        WebElement questionElement = driver.findElement(questionPath);
        WebElement answerElement = driver.findElement(answerPath);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionElement);
        questionElement.click();

        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answerPath));
        return firstResult.getText();

    }
}
