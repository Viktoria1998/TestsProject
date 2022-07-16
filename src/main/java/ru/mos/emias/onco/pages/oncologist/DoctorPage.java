package ru.mos.emias.onco.pages.oncologist;

import io.qameta.allure.Step;
import ru.mos.emias.onco.helpers.EhrFormXpathHelper;
import ru.mos.emias.onco.helpers.XpathHelper;
import ru.mos.emias.onco.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class DoctorPage extends BasePage {
    public DoctorPage(){}

    @Step("Найти элемент - Банер пациента")
    public DoctorPage getElementPatientBanner() {
        this.selenideElement = $(xpath(new XpathHelper().getElementDiv().useContainsByClassNameFullCompliance("patient-banner").getXpath()));
        return this;
    }

    @Step("Найти кнопку - Начать прием")
    public DoctorPage getButtonStartAppointment() {
        this.selenideElement = $(xpath(new XpathHelper().getElementScButton("Начать прием").getXpath()));
        return this;
    }

    @Step("Найти кнопку - Работа с картой вне приема")
    public DoctorPage getButtonWorkingWithCardOutsideAppointment() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("Работа с картой вне приема").getXpath()));
        return this;
    }

    @Step("Найти кнопку - свернуть карту пациента")
    public DoctorPage getButtonMinimizeCardPatient() {
        this.selenideElement = $(xpath(new XpathHelper().getElementScSvgIconByAttributeType("minimize").getXpath()));
        return this;
    }

    @Step("Найти кнопку - закрыть карту пациента")
    public DoctorPage getButtonCloseCardPatient() {
        this.selenideElement = $(xpath(new XpathHelper().getElementScSvgIconByAttributeType("close").getXpath()));
        return this;
    }

    @Step("Найти кнопку - Протокол")
    public DoctorPage getButtonProtocol() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("Протокол").getXpath()));
        return this;
    }

    @Step("Найти кнопку - Отменить прием")
    public DoctorPage getButtonCancelAppointment() {
        this.selenideElement = $(xpath(new XpathHelper().getElementScSvgIconByAttributeType("d-close").getXpath()));
        return this;
    }

    @Step("Найти кнопку в модальном окне - Не сохранять")
    public DoctorPage getButtonModalNotSave() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("Не сохранять").getXpath()));
        return this;
    }

    @Step("Найти кнопку в модальном окне - Сохранить")
    public DoctorPage getButtonModalSave() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("Сохранить").getXpath()));
        return this;
    }

    @Step("Найти кнопку в модальном окне - Отменить приём")
    public DoctorPage getButtonModalCancelAppointment() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("Отменить приём").getXpath()));
        return this;
    }

    @Step("Найти кнопку в модальном окне - Закрыть окно")
    public DoctorPage getButtonModalCloseWindow() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("Закрыть окно").getXpath()));
        return this;
    }

    @Step("Найти радоигруппу - Причина отмены приема")
    public DoctorPage getRadioCancelAppointment(String cause) {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getElementRadio(cause).getXpath()));
        return this;
    }
}
