package ru.mos.emias.onco.pages.oncologist;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mos.emias.onco.helpers.EhrFormXpathHelper;
import ru.mos.emias.onco.helpers.XpathHelper;
import ru.mos.emias.onco.pages.BasePage;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class AdmissionPlanPage extends BasePage {
    public AdmissionPlanPage() {
    }

    @Step("Найти элемент - Header")
    public AdmissionPlanPage getElementAdmissionPlanHeader() {
        this.selenideElement = $(xpath("//kpi-admission-plan-header"));
        return this;
    }

    @Step("Найти кнопку с названием - Найти")
    public AdmissionPlanPage getButtonFound() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("Найти").getXpath()));
        return this;
    }

    @Step("Найти кнопку с названием - По полису ОМС или ФИО")
    public AdmissionPlanPage getButtonFoundOnPolicyOmsOrFullName() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("По полису ОМС или ФИО").getXpath()));
        return this;
    }

    @Step("Найти кнопку с названием - По ФИО и дате рождения")
    public AdmissionPlanPage getButtonFoundOnFullNameOrBirthDate() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("По ФИО и дате рождения").getXpath()));
        return this;
    }

    @Step("Найти кнопку с названием - Вне ЕМИАС")
    public AdmissionPlanPage getButtonFoundOnOutsideEmias() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("Вне ЕМИАС").getXpath()));
        return this;
    }

    @Step("Найти поле - ФИО пациента или полис ОМС")
    public AdmissionPlanPage getFieldSearchPatientsFullNameOrPolicyOms() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getFormFieldOnInputPlaceholder("ФИО пациента или полис ОМС").getXpath()));
        return this;
    }

    @Step("Найти поле - Фамилия *")
    public AdmissionPlanPage getFieldSearchPatientsLastName() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getFormFieldOnInputPlaceholder("Фамилия *").getXpath()));
        return this;
    }

    @Step("Найти поле - Имя *")
    public AdmissionPlanPage getFieldSearchPatientsFirstName() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getFormFieldOnInputPlaceholder("Имя *").getXpath()));
        return this;
    }

    @Step("Найти поле - Отчество")
    public AdmissionPlanPage getFieldSearchPatientsMiddleName() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getFormFieldOnInputPlaceholder("Отчество").getXpath()));
        return this;
    }

    @Step("Найти поле - Дата рождения *")
    public AdmissionPlanPage getFieldSearchPatientsBirthDate() {
        this.selenideElement = $(xpath(new EhrFormXpathHelper().getFormFieldOnInputPlaceholder("Дата рождения *").getXpath()));
        return this;
    }

    @Step("Выбрать значение = \"{variantSearch}\" из открытого списка")
    public AdmissionPlanPage getElementInListByVariantSearchName(String variantSearch) {
        this.selenideElement = $$(xpath(new XpathHelper().getElementDiv().useContainsByClassName("lu-dropdown-wrapper").getElementLuOption().getXpath())).find(exactText(variantSearch));
        return this;
    }

    @Step("Найти {item} элемент в результатах поиска пациентов")
    public AdmissionPlanPage getElementSearchPatientsItem(int item) {
        this.selenideElement = $$(xpath("//kpi-admission-plan-categories" + new XpathHelper().getElementDiv().useContainsByClassNameFullCompliance("group_body").getXpath())).get(item);
        return this;
    }

    @Step("Найти элемент в результатах поиска пациентов по Полису ОМС = \"{policyOms}\"")
    public AdmissionPlanPage getElementSearchPatientsOnPolicyOms(String policyOms) {
//        if(policyOms.replaceAll(" ", "").length() > 16){
//            throw new Error("Введено некорректное значение полиса ОМС, длина полиса больше 16 символов, проверьте введенное значение.");
//        }
//        String correctPolicyOms = new StringBuilder(policyOms.replaceAll(" ", "")).insert(6, " ").toString();
        this.selenideElement = $$(xpath("//kpi-admission-plan-categories" + new XpathHelper().getElementDiv().useContainsByClassNameFullCompliance("group_body").getXpath() + "/kpi-admission-plan-item"))
                .findBy(text(policyOms));
        return this;
    }

    @Step("Найти элемент - Начать прием, у {item} пациента в результатах поиска")
    public AdmissionPlanPage getElementStartAppointment(int item) {
        this.selenideElement = $$(xpath("//kpi-admission-plan-categories" + new XpathHelper().getElementDiv().useContainsByClassNameFullCompliance("group_body").getXpath() + "/kpi-admission-plan-item"))
                .get(item).find(By.xpath(".//div[normalize-space(.)='Начать приём']"));
        return this;
    }

    @Step("Найти элемент - иконка Открыть карточку пациента, у {item} пациента в результатах поиска")
    public AdmissionPlanPage getElementOpenCardPatient(int item) {
        this.selenideElement = $$(xpath("//kpi-admission-plan-categories" + new XpathHelper().getElementDiv().useContainsByClassNameFullCompliance("group_body").getXpath() + "/kpi-admission-plan-item"))
                .get(item).find(By.xpath("." + new XpathHelper().getElementLuSvgIconByAttributeAriaIcon("health-card").getXpath()));
        return this;
    }

    @Step("Найти элемент - иконка Открыть карточку пациента, по Полису ОМС = \"{policyOms}\"")
    public AdmissionPlanPage getElementOpenCardPatient(String policyOms) {
        this.selenideElement = $$(xpath("//kpi-admission-plan-categories" + new XpathHelper().getElementDiv().useContainsByClassNameFullCompliance("group_body").getXpath() + "/kpi-admission-plan-item"))
                .findBy(text(policyOms)).find(By.xpath("." + new XpathHelper().getElementLuSvgIconByAttributeAriaIcon("health-card").getXpath()));
        return this;
    }

    @Step("Найти кнопку - Сбросить результаты поиска")
    public AdmissionPlanPage getButtonResetSearchResult() {
        this.selenideElement = $(xpath(new XpathHelper().getElementButtonOnName("Сбросить результаты поиска").getXpath()));
        return this;
    }

    @Step("Найти элемент содержащий текст кол-ва найденных результатов поиска")
    public AdmissionPlanPage getElementFoundItemsCount() {
        this.selenideElement = $(xpath(new XpathHelper().getElementDiv().useContainsByClassName("search-result").getXpath()));
        return this;
    }

    @Step("Найти элемент содержащий текст неудачного поиска")
    public AdmissionPlanPage getElementFailedSearch() {
        this.selenideElement = $(xpath(new XpathHelper().getElementDiv().useContainsByClassName("replacement-message").getXpath()));
        return this;
    }

    @Step("Проверить сколько найденных результатов поиска")
    public AdmissionPlanPage checkFoundItemsCount(int count) {
        getElementFoundItemsCount().shouldBeText("Найдено: " + count);
        this.selenideElement = $(xpath(new XpathHelper().getElementDiv().useContainsByClassName("search-result").getXpath()));
        return this;
    }

}
