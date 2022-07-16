package ru.mos.emias.onco.pages.kko;

import io.qameta.allure.Step;
import ru.mos.emias.onco.helpers.XpathHelper;
import ru.mos.emias.onco.pages.BasePage;

import javax.annotation.Nullable;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.*;

public class SearchPatientPage extends BasePage {
    public SearchPatientPage(){
    }

    @Step("Найти поле - Полис ОМС")
    public SearchPatientPage getFieldPolicyOms() {
        this.selenideElement = $(xpath(new XpathHelper().getElementLuFormField("Полис ОМС").getXpath()));
        return this;
    }

    @Step("Найти поле - СНИЛС")
    public SearchPatientPage getFieldSnils() {
        this.selenideElement = $(xpath(new XpathHelper().getElementLuFormField("СНИЛС").getXpath()));
        return this;
    }

    @Step("Найти поле - ФИО")
    public SearchPatientPage getFieldFullName() {
        this.selenideElement = $(xpath(new XpathHelper().getElementLuFormField("ФИО").getXpath()));
        return this;
    }

    @Step("Найти поле - Дата рождения")
    public SearchPatientPage getFieldBirthDate() {
        this.selenideElement = $(xpath(new XpathHelper().getElementLuFormField("Дата рождения").getXpath()));
        return this;
    }

    @Step("Найти поле - ID пациента")
    public SearchPatientPage getFieldPatientId() {
        this.selenideElement = $(xpath(new XpathHelper().getElementLuFormField("ID пациента").getXpath()));
        return this;
    }

    @Step("Найти кнопку - Найти")
    public SearchPatientPage getButtonFound() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("Найти").getXpath()));
        return this;
    }

    @Step("Найти кнопку - Очистить")
    public SearchPatientPage getButtonClear() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("Очистить").getXpath()));
        return this;
    }

    @Step("Найти кнопку - Сбросить результаты поиска")
    public SearchPatientPage getButtonResetSearchResult() {
        this.selenideElement = $(xpath(new XpathHelper().getElementScButton("Сбросить результаты поиска").getXpath()));
        return this;
    }

    @Step("Найти элемент содержащий текст кол-ва найденных результатов поиска")
    public SearchPatientPage getElementFoundItemsCount() {
        this.selenideElement = $(xpath(new XpathHelper().getElementDiv().useContainsByClassName("search-result").getXpath()));
        return this;
    }

    @Step("Найти элемент содержащий текст неудачного поиска")
    public SearchPatientPage getElementFailedSearch() {
        this.selenideElement = $(xpath(new XpathHelper().getElementDiv().useContainsByClassName("replacement-message").getXpath()));
        return this;
    }

    @Step("Найти {item} элемент в результатах поиска пациентов")
    public SearchPatientPage getElementSearchPatientsItem(int item) {
        this.selenideElement = $$(xpath(new XpathHelper().getElementDiv().useContainsByClassNameFullCompliance("group_body").getXpath())).get(item);
        return this;
    }

    @Step("Найти элемент в результатах поиска пациентов по ID = \"{patientId}\"")
    public SearchPatientPage getElementSearchPatientsOnPatientId(String patientId) {
        this.selenideElement = $$(xpath(new XpathHelper().getElementDiv().useContainsByClassNameFullCompliance("group_body").getXpath())).findBy(text("ID " + patientId));
        return this;
    }

    @Step("Найти счётсчик для поля - Полис ОМС")
    public SearchPatientPage getElementCounterForFieldPolicyOms() {
        this.selenideElement = $(xpath(new XpathHelper().getElementLuFormField("Полис ОМС").getElementSpan().useContainsByClassNameFullCompliance("ng-star-inserted").getXpath()));
        return this;
    }

    @Step("Найти счётсчик для поля - СНИЛС")
    public SearchPatientPage getElementCounterForFieldSnils() {
        this.selenideElement = $(xpath(new XpathHelper().getElementLuFormField("СНИЛС").getElementSpan().useContainsByClassNameFullCompliance("ololo ng-star-inserted").getXpath()));
        return this;
    }


    @Step("Убедиться что по указанным параметрам поиска пациент не найден и есть соответвующий текст")
    public SearchPatientPage checkErrorMessageForFailedSearch(@Nullable String policyOms, @Nullable String snilsNumber,
                                                         @Nullable String fullName, @Nullable String birthDate,
                                                         @Nullable String patientId){
        selenideElement.shouldHave(text("По указанным параметрам поиска"));
        if(policyOms != null) {
            if(policyOms.length() > 16){
                String newPolicy = policyOms.substring(0, 16);
                selenideElement.shouldHave(text("полис ОМС "+ newPolicy));
            } else {
                selenideElement.shouldHave(text("полис ОМС "+ policyOms));
            }
        }
        if(snilsNumber != null) selenideElement.shouldHave(text("СНИЛС "+ snilsNumber));
        if(fullName != null) selenideElement.shouldHave(text("ФИО "+ fullName));
        if(birthDate != null) selenideElement.shouldHave(text("дата рождения "+ birthDate));
        if(patientId != null) selenideElement.shouldHave(text("ID пациента "+ patientId));
        selenideElement.shouldHave(text("пациентов не найдено."));
        selenideElement.shouldHave(text("Рекомендации:"));
        selenideElement.shouldHave(text("Проверьте корректность введенных данных для поиска"));
        return this;
    }

    @Step("Убедиться что все поля на форме поиска пустые")
    public SearchPatientPage checkAllInputFieldAreEmpty(){
        getFieldPolicyOms().getChildXpathElementInput().shouldBeCondition(empty);
        getFieldSnils().getChildXpathElementInput().shouldBeCondition(empty);
        getFieldFullName().getChildXpathElementInput().shouldBeCondition(empty);
        getFieldBirthDate().getChildXpathElementInput().shouldBeCondition(empty);
        getFieldPatientId().getChildXpathElementInput().shouldBeCondition(empty);
        return this;
    }

    @Step("Проверить сколько найденных результатов поиска")
    public SearchPatientPage checkFoundItemsCount(int count) {
        getElementFoundItemsCount().shouldBeText("Найдено: " + count);
        this.selenideElement = $(xpath(new XpathHelper().getElementDiv().useContainsByClassName("search-result").getXpath()));
        return this;
    }
}
