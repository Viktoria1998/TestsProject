package ru.mos.emias.onco.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.mos.emias.onco.helpers.SelenideHelper;
import ru.mos.emias.onco.helpers.XpathHelper;

import java.util.Objects;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.time.Duration.*;
import static org.junit.jupiter.api.Assertions.*;


public class BasePage {
    @Getter
    @Setter
    public SelenideElement selenideElement;

    public BasePage() {}

    public BasePage getChildXpathElementTextArea(){
        this.selenideElement = selenideElement.find(By.xpath("." + new XpathHelper().getElementLuTextArea().getElementDiv().useContainsByClassName("lu-textarea").getXpath()));
        return this;
    }

    public BasePage getChildXpathElementInput(){
        this.selenideElement = selenideElement.find(By.xpath("." + new XpathHelper().getElementInput().getXpath()));
        return this;
    }

    public BasePage getChildXpathLuSvgIcon(String ariaIconName){
        this.selenideElement = selenideElement.find(By.xpath("." + new XpathHelper().getElementLuSvgIconByAttributeAriaIcon(ariaIconName).getXpath()));
        return this;
    }

    public BasePage getChildXpathElementMaskPlaceholder(){
        this.selenideElement = selenideElement.find(By.xpath("." + new XpathHelper().getElementLuMaskPlaceholder().getXpath()));
        return this;
    }

    @Step("Кликнуть по элементу")
    public BasePage click(){
        selenideElement.scrollIntoView(true).shouldBe(visible, ofSeconds(15)).click();
        return this;
    }

    @Step("Очистить поле")
    public BasePage clearField(){
        selenideElement.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a", Keys.DELETE));
        return this;
    }

    @Step("Навести курсор на  элемент")
    public BasePage hover(){
        selenideElement.hover();
        return this;
    }

    @Step("Проверить значение элемента")
    public BasePage shouldBeCondition(Condition condition){
        selenideElement.shouldBe(condition);
        return this;
    }

    @Step("Проверить значение элемента")
    public BasePage shouldBeValue(String value){
        selenideElement.shouldBe(value(value));
        return this;
    }

    @Step("Проверить значение элемента")
    public BasePage shouldBeText(String text){
        selenideElement.shouldBe(text(text));
        return this;
    }

    @Step("Проверить текст элемента")
    public BasePage shouldHaveCondition(Condition condition){
        selenideElement.shouldHave(condition);
        return this;
    }

    @Step("Проверить текст элемента")
    public BasePage shouldHaveText(String text){
        selenideElement.shouldHave(text(text));
        return this;
    }

    @Step("Передать значение в поле")
    public BasePage sendKeys(CharSequence value){
        selenideElement.sendKeys(value);
        return this;
    }

    @Step("Передать значение в поле")
    public BasePage sendText(String value){
        selenideElement.sendKeys(value);
        return this;
    }

    @Step("Передать значение в поле с датой")
    public BasePage sendTextForDataField(String value){
        selenideElement.sendKeys(Keys.BACK_SPACE, value);
        return this;
    }

    @Step("Уствновить значение в поле")
    public BasePage setValue(String value){
        selenideElement.setValue(value);
        return this;
    }

    @Step("Сравнить значение элемента с ожидаемым значением")
    public BasePage getValueAndCompare(String expectedValue){
        assertEquals(expectedValue, selenideElement.getValue(), "Полученное значение элемента не совпадает с ожидаемым");
        return this;
    }

    @Step("Сравнить текст элемента с ожидаемым значением")
    public BasePage getTextAndCompare(String expectedText){
        assertEquals(expectedText, selenideElement.getText(), "Полученный текст элемента не совпадает с ожидаемым");
        return this;
    }

    @Step("Проверить видимость элемента")
    public BasePage checkIsDisplayed(boolean isDisplayed){
        assertEquals(isDisplayed, selenideElement.isDisplayed(), "Ожидается что элемент на форме " + (isDisplayed ? "displayed = true" : "displayed = false"));
        return this;
    }

    @Step("Проверить видимость элемента")
    public BasePage checkIsEnabled(boolean isEnabled){
        assertEquals(isEnabled, selenideElement.isEnabled(), "Ожидается что элемент на форме " + (isEnabled ? "enabled = true" : "enabled = false т.е. он (disabled)"));
        return this;
    }

    @Step("Проверить активацию чек-бокса")
    public BasePage checkIsSelected(boolean isSelected){
        assertEquals(isSelected, selenideElement.isSelected(), "Ожидается что элемент на форме " + (isSelected ? "selected = true" : "selected = false т.е. он не выбран на форме"));
        return this;
    }

    @Step("Проверить активацию чек-бокса")
    public BasePage checkActivateCheckBox(boolean isSelected){
        SelenideElement newSelenideElement = selenideElement.find(By.xpath(".//label"));
        if(isSelected){
            assertTrue(Objects.requireNonNull(newSelenideElement.getAttribute("class")).contains("-is-checked"), "Ошибка! Ожидалось что чек-бокс будет активным.");
        } else {
            assertFalse(Objects.requireNonNull(newSelenideElement.getAttribute("class")).contains("-is-checked"), "Ошибка! Ожидалось что чек-бокс не будет автивным.");
        }
        return this;
    }

    @Step("Проверить что поле является обязательным")
    public BasePage checkObligatoryField(boolean isObligatoryField){
        SelenideElement newSelenideElement = selenideElement.find(By.xpath(".//lu-form-message"));
        if(isObligatoryField){
            if(newSelenideElement.exists()){
                assertEquals("Обязательное поле", newSelenideElement.getText(), "Текст в поле не соответвует ожидаемому");
            } else {
                throw new Error("Не найден элемент //lu-form-message в DOM");
            }
        } else {
            assertFalse(newSelenideElement.exists(), "Ошибка! Ожидалось что у данного поля не будет содержаться текстовый элемент //lu-form-message, " +
                    "убедитесь, что данное поле не является обязательным к заполнению.");
        }
        return this;
    }

    @Step("Выбрать значение = \"{textName}\" из открытого списка")
    public BasePage getElementInListByTextAndClick(String textName) {
        if($(By.xpath(new XpathHelper().getOverlayElements().getXpath())).exists()) {
            $(By.xpath(new XpathHelper().getOverlayElementLuOptionOnText(textName).getXpath())).shouldHave(exist, ofSeconds(10)).click();
        } else {
        throw new Error("Нет открытого списка на стринице");
        }
        return this;
    }

    @Step("Выбрать элемент = \"{item}\" из открытого списка")
    public BasePage getElementInListByItemAndClick(int item) {
        if($(By.xpath(new XpathHelper().getOverlayElements().getXpath())).exists()){
            $$(By.xpath(new XpathHelper().getOverlayElementLuOption().getXpath())).shouldHave(sizeGreaterThan(0), ofSeconds(10)).get(item).click();
        } else {
            throw new Error("Нет открытого списка на стринице");
        }

        return this;
    }

    @Step("Выбрать рандомное значение из открытого списка")
    public BasePage getElementInListByRandom() {
        if($(By.xpath(new XpathHelper().getOverlayElements().getXpath())).exists()) {
            SelenideHelper.getRandomListValue($$(By.xpath(new XpathHelper().getOverlayElementLuOption().getXpath())).shouldHave(sizeGreaterThan(0), ofSeconds(10))).click();
        } else {
            throw new Error("Нет открытого списка на стринице");
        }
        return this;
    }

    @Step("Проверка дефолтного сообщения для поля с поиском, при неудачном поиске")
    public BasePage checkErrorMessageNotFoundForField() {
        if($(By.xpath(new XpathHelper().getOverlayElements().getXpath())).exists()) {
            $(By.xpath(new XpathHelper().getOverlayElementLuReplacementMessage().getXpath())).shouldHave(exactText("Ничего не найдено. Введите другое значение для поиска"));
        } else {
            throw new Error("Нет открытого списка на стринице");
        }
        return this;
    }

    @Step("Проверка сообщения в placeholder")
    public BasePage checkPlaceHolderMessage(String message) {
        if(selenideElement.exists()){
            assertEquals(message, selenideElement.getAttribute("placeholder"), "Текст в placeholder для поля не соответвует ожидаемому");
        } else {
            throw new Error("Ошибка! SelenideElement is not exist");
        }
        return this;
    }

    @Step("Выбрать месяц {month} в датапикере")
    public BasePage setMonthInDataPicker(String month) {
        if($(By.xpath(new XpathHelper().getOverlayCalendarNavigation().getXpath())).exists()) {
            $(By.xpath(new XpathHelper().getOverlayCalendarNavigation().getElementButton().useContainsByClassName("-select-month").getXpath())).click();
            getElementInListByTextAndClick(month);
        } else {
            throw new Error("Нет открытого списка на стринице");
        }
        return this;
    }

    @Step("Выбрать год {year} в датапикере")
    public BasePage setYearInDataPicker(String year) {
        if($(By.xpath(new XpathHelper().getOverlayCalendarNavigation().getXpath())).exists()) {
            $(By.xpath(new XpathHelper().getOverlayCalendarNavigation().getElementButton().useContainsByClassName("-select-year").getXpath())).click();
            getElementInListByTextAndClick(year);
        } else {
            throw new Error("Нет открытого списка на стринице");
        }
        return this;
    }

    @Step("Выбрать день текущего месяца {day} в датапикере")
    public BasePage setDayInDataPicker(String day) {
        if($(By.xpath(new XpathHelper().getOverlayCalendarNavigation().getXpath())).exists()) {
            $$(By.xpath(new XpathHelper().getOverlayCalendarDaysForCurrentMonth().getXpath())).find(exactText(day)).shouldBe(text(day)).click();
        } else {
            throw new Error("Нет открытого списка на стринице");
        }
        return this;
    }
}
