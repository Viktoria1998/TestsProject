package ru.mos.emias.onco.pages.oncologist;

import io.qameta.allure.Step;
import ru.mos.emias.onco.helpers.EhrFormXpathHelper;
import ru.mos.emias.onco.helpers.XpathHelper;
import ru.mos.emias.onco.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class CreateProtocolPage extends BasePage {
    public CreateProtocolPage(){}



    @Step("Найти поле - Цель приема")
    public CreateProtocolPage getFieldPurposeOfAdmission() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementLuFormField("Цель приёма").getXpath()));
        return this;
    }

    @Step("Найти поле - Специализация врача")
    public CreateProtocolPage getFieldSpecializationDoctor() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementLuFormField("Специализация врача").getXpath()));
        return this;
    }

    @Step("Найти поле - МО приема")
    public CreateProtocolPage getFieldMoReception() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementLuFormField("МО приема").getXpath()));
        return this;
    }

    @Step("Найти поле - МО, направившая пациента")
    public CreateProtocolPage getFieldMoReferredThePatient() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementLuFormField("МО, направившая пациента").getXpath()));
        return this;
    }

    @Step("Найти чек-бокс - МО, направившая пациента")
    public CreateProtocolPage getCheckBoxMoReferredThePatient() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getNavigationSection("Общая информация").getElementLuFormField("Чекбокс").getXpath()));
        return this;
    }

    @Step("Найти радио - Жалобы на момент осмотра")
    public CreateProtocolPage getRadioComplaints(String radioName) {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementCustomRadio(radioName).getXpath()));
        return this;
    }

    @Step("Найти поле - Жалобы")
    public CreateProtocolPage getFieldComplaints() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementLuFormField("Жалобы").getXpath()));
        return this;
    }

    @Step("Найти кнопку - Начать прием")
    public CreateProtocolPage getButtonSaveProtocol() {
        this.selenideElement = $(xpath(new XpathHelper().getElementScButton("Сохранить").getXpath()));
        return this;
    }
}
