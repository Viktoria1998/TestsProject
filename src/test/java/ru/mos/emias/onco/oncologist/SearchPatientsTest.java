package ru.mos.emias.onco.oncologist;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junitpioneer.jupiter.SetEnvironmentVariable;
import ru.mos.emias.onco.pages.AuthPage;
import ru.mos.emias.onco.pages.oncologist.AdmissionPlanPage;
import ru.mos.emias.onco.utils.Users;

@SetEnvironmentVariable(key = "E2E_PROJECT", value = "oncologist")
@Feature(value = "Функциональное тестирование Онкология")
@Story(value = "Врач Онколог")
@DisplayName("Поиск пациентов во враче онкологе")
public class SearchPatientsTest extends TestBase {
    private static final AuthPage authPage = new AuthPage();
    private static final AdmissionPlanPage admissionPlanPage = new AdmissionPlanPage();

    @BeforeAll
    static void auth(){
        app.auth(Users.MMaturov.LOGIN, Users.MMaturov.ROLE_DOCTOR_ONCOLOGIST);
        authPage.getFieldAdditionalHealthWorker().click();
        authPage.getElementInListByRandom();
        authPage.getButtonConfirm().click();
    }

    @BeforeEach
    void checkBeforeTests(){
        admissionPlanPage.getElementAdmissionPlanHeader().shouldHaveText("План приёма пациентов");
    }

    @Test
    @DisplayName("Успешеный поиск пациента по корректному полису ОМС - 770000 1046030757")
    public void test_searchPatients_01() {
        admissionPlanPage.getFieldSearchPatientsFullNameOrPolicyOms().getChildXpathElementInput().sendText("770000 1046030757");
        admissionPlanPage.getButtonFound().click();
        admissionPlanPage.checkFoundItemsCount(1);
        admissionPlanPage.getElementSearchPatientsItem(0)
                .shouldHaveText("Якушева Татьяна Васильевна")
                .shouldHaveText("64 года")
                .shouldHaveText("770000 1046030757")
                .hover();
        admissionPlanPage.getElementStartAppointment(0).shouldBeCondition(Condition.visible);
        admissionPlanPage.getElementOpenCardPatient(0).shouldBeCondition(Condition.visible);
        admissionPlanPage.getFieldSearchPatientsFullNameOrPolicyOms().getChildXpathLuSvgIcon("close").click();
    }

    @AfterEach
    void closeCardPatient(){
    }
}
