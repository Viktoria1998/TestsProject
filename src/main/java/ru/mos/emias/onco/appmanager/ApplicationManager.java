package ru.mos.emias.onco.appmanager;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Value;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.mos.emias.onco.pages.BasePage;
import ru.mos.emias.onco.helpers.ProxyHelper;
import ru.mos.emias.onco.utils.TestSettings;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class ApplicationManager {
    private static final TestSettings testSettings = new TestSettings();
    public BasePage basePage;
    ProxyHelper proxyHelper;
    String selenoidUrl;
    String browser;
    BrowserMobProxyServer proxy;
    Proxy seleniumProxy;
    String baseUrl;
    protected String etdParam = "etd-access-point?";
    String chromeVer;
    String firefoxVer;
    @Getter
    String userName;
    @Getter
    String userRole;

    public ApplicationManager() {}

    public void init() throws Exception {
        String e2e_selenoid = System.getenv("E2E_SELENOID_ADDRESS");
        String e2e_browser = System.getenv("E2E_BROWSER");
        String e2e_base_url = System.getenv("E2E_BASE_URL");

        if(e2e_selenoid != null){
            switch (e2e_selenoid) {
                case "office":
                    selenoidUrl = testSettings.getSelenoidAddressOffice();
                    break;
                case "local":
                    selenoidUrl = testSettings.getSelenoidAddressLocal();
                    break;
            }
        } else {
            selenoidUrl = testSettings.getSelenoidAddressLocal();
        }
        if(e2e_browser != null){
            switch (e2e_browser.split(":")[0]) {
                case "chrome":
                    browser = "chrome";
                    if(e2e_base_url.split(":").length > 1){
                        chromeVer = e2e_browser.split(":")[1];
                    } chromeVer = testSettings.getDefaultChromeVersion();
                    break;
                case "firefox":
                    browser = "firefox";
                    if(e2e_base_url.split(":").length > 1){
                        firefoxVer = e2e_browser.split(":")[1];
                    } firefoxVer = testSettings.getDefaultFirefoxVersion();
                    break;
            }
        } else {
            browser = testSettings.getDefaultBrowser();
        }
        if(e2e_base_url != null){
            switch (e2e_base_url) {
                case "office":
                    baseUrl = testSettings.getBaseUrlOffice();
                    break;
                case "test":
                    baseUrl = testSettings.getBaseUrlTest();
                    break;
                case "local":
                    baseUrl = testSettings.getBaseUrlLocal();
                    break;
            }
        } else {
            baseUrl = testSettings.getBaseUrlOffice();
//            baseUrl = testSettings.getBaseUrlTest();
        }

        proxyHelper = new ProxyHelper();
        basePage = new BasePage();
    }

    @Step("Авторизация под пользователем:\"{userName}\" c ролью:\"{userRole}\" на стенде \"${stand}\"")
    public void auth(String userName, String userRole) {
        this.userName = userName;
        this.userRole = userRole;
        Configuration.remote = selenoidUrl;
        Configuration.timeout = Integer.parseInt(testSettings.getDefaultSelenideTimeout()) * 1000;
        Configuration.reportsFolder = "./target/test-result/selenide-reports";
        Configuration.downloadsFolder = "./target/test-result/selenide-downloads";
        Configuration.browserSize = "1920x1080";

        proxy = proxyHelper.setUpProxy(userName);
        seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        seleniumProxy.setSslProxy(proxyHelper.getIpAddress() + ":" + proxy.getPort());
        seleniumProxy.setHttpProxy(proxyHelper.getIpAddress() + ":" + proxy.getPort());

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setProxy(seleniumProxy);
                Configuration.browserCapabilities = chromeOptions;
                Configuration.browser = browser;
                Configuration.browserVersion = "76";
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProxy(seleniumProxy);
                Configuration.browserCapabilities = firefoxOptions;
                Configuration.browser = browser;
                Configuration.browserVersion = "45";
                break;
        }

        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
//        options.put("enableVideo", true);
        options.put("enableLog", true);
        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities.setCapability("selenoid:options", options);

        open(baseUrl + etdParam + userRole);
    }

    public void getHar(String harName) throws Exception{
        Har har = proxy.getHar();
        File harFile = new File(harName + ".har");
        har.writeTo(harFile);
    }

    @Step("Закрытие драйвера и остановка прокси")
    public void stop() {
        closeWebDriver();
        proxy.stop();
    }
}

