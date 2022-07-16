package ru.mos.emias.onco.oncologist;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junitpioneer.jupiter.SetEnvironmentVariable;
import ru.mos.emias.onco.pages.AuthPage;
import ru.mos.emias.onco.pages.oncologist.AdmissionPlanPage;
import ru.mos.emias.onco.pages.oncologist.CreateProtocolPage;
import ru.mos.emias.onco.pages.oncologist.DoctorPage;
import ru.mos.emias.onco.utils.Users;

@SetEnvironmentVariable(key = "E2E_PROJECT", value = "oncologist")
@Feature(value = "Функциональное тестирование Онкология")
@Story(value = "Врач Онколог")
@DisplayName("Создание Протокола осмотра")
public class CreateProtocolTest extends TestBase {
    private static final AuthPage authPage = new AuthPage();
    private static final AdmissionPlanPage admissionPlanPage = new AdmissionPlanPage();
    private static final DoctorPage doctorPage = new DoctorPage();
    private static final CreateProtocolPage createProtocolPage = new CreateProtocolPage();

    @BeforeAll
    static void auth(){
        app.auth(Users.MMaturov.LOGIN, Users.MMaturov.ROLE_DOCTOR_ONCOLOGIST);
        authPage.getFieldAdditionalHealthWorker().click();
        authPage.getElementInListByRandom();
        authPage.getButtonConfirm().click();
        admissionPlanPage.getElementAdmissionPlanHeader().shouldHaveText("План приёма пациентов");
        admissionPlanPage.getFieldSearchPatientsFullNameOrPolicyOms().getChildXpathElementInput().sendText("7795789723000479");
        admissionPlanPage.getButtonFound().click();
        admissionPlanPage.getElementOpenCardPatient("7795789723000479").hover().click();
        doctorPage.getElementPatientBanner().shouldHaveText("Перцев Тимур Павлович");
        doctorPage.getButtonStartAppointment().click();
        doctorPage.getButtonProtocol().click();
    }

    @Test
    @DisplayName("Успешное заполнение формы протокола")
    public void test_createProtocol_01() {
        createProtocolPage.getButtonSaveProtocol().click();
        createProtocolPage.getFieldPurposeOfAdmission().getChildXpathElementInput().click();
        createProtocolPage.getElementInListByTextAndClick("Первичная консультация по направлению другой МО");
        createProtocolPage.getFieldPurposeOfAdmission().getChildXpathElementInput().shouldBeValue("Первичная консультация по направлению другой МО");
        createProtocolPage.getFieldSpecializationDoctor().click();
        createProtocolPage.getElementInListByRandom();
        createProtocolPage.getFieldMoReferredThePatient()
                .checkObligatoryField(true)
                .getChildXpathElementInput()
                .click();
        createProtocolPage.getElementInListByRandom();
        createProtocolPage.getCheckBoxMoReferredThePatient()
                .checkActivateCheckBox(false)
                .shouldHaveText("МО нет в справочнике")
                .click()
                .checkActivateCheckBox(true);
        createProtocolPage.getRadioComplaints("Предъявляет").click();
        createProtocolPage.getFieldComplaints()
                .checkObligatoryField(true)
                .getChildXpathElementTextArea()
                .sendText("У меня вот такие вот жалобы")
                .shouldBeText("У меня вот такие вот жалобы");
    }

    @AfterEach
    void closeCardPatient(){
        doctorPage.getButtonCancelAppointment().click();
        doctorPage.getRadioCancelAppointment("Ошибка").click();
        doctorPage.getButtonModalCancelAppointment().click();
        doctorPage.getButtonCloseCardPatient().click();
    }
}
