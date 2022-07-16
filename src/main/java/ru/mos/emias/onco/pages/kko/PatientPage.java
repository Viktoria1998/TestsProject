package ru.mos.emias.onco.pages.kko;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mos.emias.onco.helpers.XpathHelper;
import ru.mos.emias.onco.pages.BasePage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class PatientPage extends BasePage {
    public PatientPage(){}

    @Step("Найти кнопку - Создать")
    public PatientPage getButtonCreate() {
        this.selenideElement = $(xpath(new XpathHelper().getElementScButton("Создать").getXpath()));
        return this;
    }

    @Step("Найти элемент - Банер пациента")
    public PatientPage getPatientBanner() {
        this.selenideElement = $(xpath(new XpathHelper().getElementDiv().useContainsByClassNameFullCompliance("patient-banner").getXpath()));
        return this;
    }

    @Step("Выбрать значение = \"{documentName}\" из открытого списка")
    public PatientPage getElementInListByDocumentName(String documentName) {
        this.selenideElement = $$(xpath(new XpathHelper().getElementDiv().useContainsByClassName("supported-documents__short-list-item").getXpath()))
                .find(exactText(documentName));
        return this;
    }

}
