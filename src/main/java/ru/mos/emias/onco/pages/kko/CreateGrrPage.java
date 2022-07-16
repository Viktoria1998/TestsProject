package ru.mos.emias.onco.pages.kko;

import io.qameta.allure.Step;
import ru.mos.emias.onco.helpers.EhrFormXpathHelper;
import ru.mos.emias.onco.helpers.XpathHelper;
import ru.mos.emias.onco.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CreateGrrPage extends BasePage {
    public CreateGrrPage(){}

    @Step("Найти поле - Этническая группа")
    public CreateGrrPage getFieldEthnicGroup() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementLuFormField("Этническая группа").getXpath()));
        return this;
    }

    @Step("Найти кнопку - Сохранить и подписать")
    public CreateGrrPage getButtonSaveAndSign() {
        this.selenideElement = $(xpath(new XpathHelper().getElementScButton("Сохранить и подписать").getXpath()));
        return this;
    }

    @Step("Найти поле - Житель")
    public CreateGrrPage getFieldCitizen() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementLuFormField("Житель").getXpath()));
        return this;
    }

    @Step("Найти поле - Социально-профессиональная группа")
    public CreateGrrPage getFieldSocioProfessionalGroup() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementLuFormField("Социально-профессиональная группа").getXpath()));
        return this;
    }

    @Step("Найти поле - Прочее")
    public CreateGrrPage getFieldOther() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementLuFormField("Прочее").getXpath()));
        return this;
    }

    @Step("Найти поле - Дата установления")
    public CreateGrrPage getFieldDateEstablishment() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementLuFormField("Дата установления").getXpath()));
        return this;
    }

    @Step("Найти поле - Инвалидность по основному заболеванию")
    public CreateGrrPage getFieldDisabilityByUnderlyingDisease() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementLuFormField("Инвалидность по основному заболеванию").getXpath()));
        return this;
    }
}
