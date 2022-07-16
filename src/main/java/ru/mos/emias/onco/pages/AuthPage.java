package ru.mos.emias.onco.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mos.emias.onco.helpers.XpathHelper;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AuthPage extends BasePage {
    public AuthPage(){}

    @Step("Найти поле с выбором медицинской организации")
    public AuthPage getFieldChoiceMO() {
        this.selenideElement = $(By.xpath(new XpathHelper().getElementLuCombobox().getElementInput().getXpath()));
        return this;
    }

    @Step("Найти кнопку \"Подтвердить\"")
    public AuthPage getButtonConfirm() {
        this.selenideElement = $(By.xpath(new XpathHelper().getElementButtonOnName("Подтвердить").getXpath()));
        return this;
    }

    @Step("Найти кнопку \"Отменить\"")
    public AuthPage getButtonCancel() {
        this.selenideElement = $(By.xpath(new XpathHelper().getElementButtonOnName("Отменить").getXpath()));
        return this;
    }

    @Step("Найти кнопку закрытия модалки - \"крестик\"")
    public AuthPage getButtonClose() {
        this.selenideElement = $(By.xpath(new XpathHelper().getElementLuSvgIcon().getXpath())).find(by("aria-icon", "close"));
        return this;
    }

    @Step("Найти поле с выбором дополнительного медработника")
    public AuthPage getFieldAdditionalHealthWorker() {
        this.selenideElement = $(By.xpath(new XpathHelper().getElementLuFormField("ФИО медработника").getElementInput().getXpath()));
        return this;
    }

    @Step("Найти поле с поиском группы мед. учереждений")
    public AuthPage getFieldSearch() {
        this.selenideElement = $(By.xpath(new XpathHelper().getElementLuFormField("Поиск").getElementInput().getXpath()));
        return this;
    }
}
