package ru.yandex.Sprint4;

import org.junit.Test;
import ru.yandex.Sprint4.page.OrderPage;
import static org.junit.Assert.assertTrue;

public class OrderTest extends BaseTestClass{

    // Выбор ChromeDriver или FirefoxDriver происходит в классе BaseTestClass

    // Заказ через верхнюю кнопку "Заказать"
    @Test
    public void orderTestUpperButton() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        assertTrue(orderPage.atPage());

        orderPage.clickCookieButton();
        orderPage.clickOrderTopButton();
        orderPage.setFirstnameField("Иван");
        orderPage.setLastnameField("Иванов");
        orderPage.setAddressField("г. Москва");
        orderPage.setMetroStationField();
        orderPage.setPhoneNumberField("74959662196");
        orderPage.clickOrderNextButton();
        orderPage.setDeliveryDateField("01.08.2022");
        orderPage.setRentalPeriod();
        orderPage.setColor();
        orderPage.setComment("позвонить за 2 часа, пожалуйста");
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        boolean res = orderPage.orderHasBeenPlacedTrue();
        assertTrue(res);
    }

    // Заказ через нижнюю кнопку "Заказать"
    @Test
    public void orderTestBottomButton() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        assertTrue(orderPage.atPage());

        orderPage.clickCookieButton();
        orderPage.clickOrderBottomButton();
        orderPage.setFirstnameField("Петр");
        orderPage.setLastnameField("Петров");
        orderPage.setAddressField("г. Самара");
        orderPage.setMetroStationField();
        orderPage.setPhoneNumberField("78122353478");
        orderPage.clickOrderNextButton();
        orderPage.setDeliveryDateField("01.09.2022");
        orderPage.setRentalPeriod();
        orderPage.setColor();
        orderPage.setComment("оставить у подъезда");
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        boolean res = orderPage.orderHasBeenPlacedTrue();
        assertTrue(res);
    }

}
