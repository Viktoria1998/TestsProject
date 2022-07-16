package ru.mos.emias.onco.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class TestSettings {
    private static final String SYSTEM_PROPERTIES_FILE_NAME = "/settings.properties";
    private final Properties properties;
    String e2e_project;

    public TestSettings() {
        this(null);
    }

    public TestSettings(String filename) {
        if (filename == null) {
            filename = SYSTEM_PROPERTIES_FILE_NAME;
        }

        properties = new Properties();
        try (InputStream inputStream = ru.mos.emias.onco.utils.TestSettings.class.getResourceAsStream(filename); InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF8")) {
            properties.load(inputStreamReader);
            System.out.println(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkSystemEnv(){
        if(System.getenv("E2E_PROJECT") == null){
            throw new Error("E2E_PROJECT is required, Please set SystemEnvironment: 'E2E_PROJECT'");
        } else {
            e2e_project = System.getenv("E2E_PROJECT");
        }
    }

    public String getSelenoidAddressOffice() {
        return properties.getProperty("selenoid.office");
    }

    public String getSelenoidAddressLocal() {
        return properties.getProperty("selenoid.local");
    }

    public String getBaseUrlOffice() {
        checkSystemEnv();
        String baseUrl;
            switch (e2e_project) {
                case "kko":
                    baseUrl = properties.getProperty("baseUrl.kko.office");
                    break;
                case "oncologist":
                    baseUrl = properties.getProperty("baseUrl.oncologist.office");
                    break;
                default:
                    throw new Error("There is no project with this name '" + e2e_project
                            +"', please specify the correct value for system environment 'E2E_PROJECT'. Valid values can be found in readme.md");
            }
        return baseUrl;
    }

    public String getBaseUrlTest () {
        checkSystemEnv();
        String baseUrl;
        switch (e2e_project) {
            case "kko":
                baseUrl = properties.getProperty("baseUrl.kko.test");
                break;
            case "oncologist":
                baseUrl = properties.getProperty("baseUrl.oncologist.test");
                break;
            default:
                throw new Error("There is no project with this name '" + e2e_project
                        +"', please specify the correct value for system environment 'E2E_PROJECT'. Valid values can be found in readme.md");
        }
        return baseUrl;
    }

    public String getBaseUrlLocal () {
        return properties.getProperty("baseUrl.local");
    }

    public String getDefaultBrowser () {
        return properties.getProperty("default.browser");
    }

    public String getDefaultChromeVersion () {
        return properties.getProperty("default.chrome.version");
    }

    public String getDefaultFirefoxVersion () {
        return properties.getProperty("default.firefox.version");
    }

    public String getDefaultSelenideTimeout () {
        return properties.getProperty("default.selenide.timeout.sec");
    }
}
