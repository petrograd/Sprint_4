package ru.yandex.Sprint4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заголовок страницы
    private final String homePageTitle = "undefined";

    //адрес стартовой страницы
    private final String homePageURL = "https://qa-scooter.praktikum-services.ru/";

    //адрес страницы заказа
    private final String orderPageURL = "https://qa-scooter.praktikum-services.ru/order";

    //кнопка куки
    private By cookieButton = By.cssSelector("button#rcc-confirm-button.App_CookieButton__3cvqF");
    //Кнопка "Заказать" наверху страницы
    private By OrderTopButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Кнопка "Заказать" внизу страницы
    private By OrderBottomButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Поле ввода * Имя
    private By firstnameField = By.xpath(".//input[@placeholder='* Имя']");

    //Поле ввода * Фамилия
    private By lastnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле ввода * Адрес: куда привезти заказ
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле выбора * Станция метро
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");

    // локатор станции "Бульвар Рокоссовского"
    private By metroStationField = (By.xpath("//*[@class='select-search__select']//*[text() = 'Бульвар Рокоссовского']"));

    //Поле ввода * Телефон: на него позвонит курьер
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка "Далее"
    private By orderNextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Поле выбора даты * Когда привезти самокат
    private By deliveryDateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //Поле выбора (выпадающий список) * Срок аренды
    private By rentalField = By.xpath("//*[text() = 'Про аренду']");
    private By rentalPeriod = (By.xpath("//*[@class='Dropdown-control']"));
    private By day = (By.xpath("//*[text() = 'сутки']"));

    //Поле чекбокса Цвет самоката
    private By blackColorScooterField = By.id("black");

    //Поле ввода Комментарий для курьера
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Кнопка "Назад"
    private By returnButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");

    //Кнопка "Заказать"
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Модальное окно "Хотите оформить зазаз?"
    //Кнопка "Да" Модальное окно "Хотите оформить зазаз?"
    private By yesButton = By.xpath("//*[text() = 'Да']");

    //Кнопка "Нет" Модальное окно "Хотите оформить зазаз?"
    private By noButton = By.xpath("//*[text() = 'Нет']");

    //Модальное окно "Заказ оформлен"
    //Кнопка "Посмотреть статус" Модальное окно "Заказ оформлен"
    private By orderHasBeenPlacedButton = By.xpath("//button[text()='Посмотреть статус']");

    public void open() {
        driver.get(homePageURL);
    }
    public boolean atPage() {
        return homePageTitle.equals(driver.getTitle());
    }
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }
    public void clickOrderTopButton() {
        driver.findElement(OrderTopButton).click();
    }
    public void clickOrderBottomButton() {
        driver.findElement(OrderBottomButton).click();
    }
    public void waitToLoadOrderPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10));
        //.until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
    }

    public void setFirstnameField(String firstname) {
        driver.findElement(firstnameField).sendKeys(firstname);
    }

    public void setLastnameField(String lastname) {
        driver.findElement(lastnameField).sendKeys(lastname);
    }

    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetroStationField() {
        driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroStationField).click();
    }

    public void setPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickOrderNextButton() {
        driver.findElement(orderNextButton).click();
    }

    public void setDeliveryDateField(String date) {
        driver.findElement(deliveryDateField).sendKeys(date);
    }

    public void setRentalPeriod() {
        driver.findElement(rentalField).click();
        driver.findElement(rentalPeriod).click();
        driver.findElement(day).click();
    }

    public void setColor() {
        driver.findElement(blackColorScooterField).click();
    }

    public void setComment(String s) {
        driver.findElement(commentField).sendKeys(s);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public boolean orderHasBeenPlacedTrue() {
        return driver.findElement(orderHasBeenPlacedButton).isDisplayed();
    }
}
