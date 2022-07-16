package ru.mos.emias.onco.helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

public class SelenideHelper {

    public static SelenideElement getRandomListValue(ElementsCollection list){
        return list.get(new Random().nextInt(list.size()));
    }
}
