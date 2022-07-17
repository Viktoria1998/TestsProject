package ru.mos.emias.onco.helpers;

public class XpathHelper {

    private final StringBuffer xpath;

    public XpathHelper() {
        this.xpath = new StringBuffer();
    }

    public String getXpath(){
        return xpath.toString();
    }

    public XpathHelper getElementLuFormField(String fieldName){
        xpath.append("//label[normalize-space(.)='")
                .append(fieldName)
                .append("']//ancestor::lu-form-field");
        return this;
    }

    public XpathHelper getElementLuSvgIcon(){
        xpath.append("//lu-svg-icon");
        return this;
    }

    public XpathHelper getElementScSvgIconByAttributeType(String attributeTypeName){
        xpath.append("//sc-svg-icon[@type='")
                .append(attributeTypeName)
                .append("']");
        return this;
    }

    public XpathHelper getElementLuSvgIconByAttributeAriaIcon(String attributeAriaIconName){
        xpath.append("//lu-svg-icon[@aria-icon='")
                .append(attributeAriaIconName)
                .append("']");
        return this;
    }

    public XpathHelper getElementButton(){
        xpath.append("//button");
        return this;
    }

    public XpathHelper getElementButtonOnName(String buttonName){
        xpath.append("//span[normalize-space(.)='")
                .append(buttonName)
                .append("']//ancestor::button");
        return this;
    }

    public XpathHelper getElementScButton(String buttonName){
        xpath.append("//span[normalize-space(.)='")
                .append(buttonName)
                .append("']//ancestor::sc-button");
        return this;
    }

    public XpathHelper getElementScButtonWithoutName(String attributeTypeName){
        getElementScSvgIconByAttributeType(attributeTypeName);
        xpath.append("//ancestor::sc-button");
        return this;
    }

    public XpathHelper getElementLuCombobox(){
        xpath.append("//lu-combobox");
        return this;
    }

    public XpathHelper getElementLuTextArea(){
        xpath.append("//lu-textarea");
        return this;
    }

    public XpathHelper getElementLuMaskPlaceholder(){
        xpath.append("//lu-mask-placeholder");
        return this;
    }

    public XpathHelper getElementInput(){
        xpath.append("//input");
        return this;
    }

    public XpathHelper getElementLuInputWrapper(){
        xpath.append("//lu-input-wrapper");
        return this;
    }

    public XpathHelper getElementLabel(){
        xpath.append("//label");
        return this;
    }

    public XpathHelper getElementDiv(){
        xpath.append("//div");
        return this;
    }

    public XpathHelper getElementSpan(){
        xpath.append("//span");
        return this;
    }

    public XpathHelper useContainsByClassName(String className){
        xpath.append("[contains(@class, '");
        xpath.append(className);
        xpath.append("')]");
        return this;
    }

    public XpathHelper useContainsByClassNameFullCompliance(String className){
        xpath.append("[@class='");
        xpath.append(className);
        xpath.append("']");
        return this;
    }

    public XpathHelper getElementLuOption(){
        xpath.append("//lu-option");
        return this;
    }






    
    
    public XpathHelper getOverlayElements(){
        xpath.append("//div[@class='cdk-overlay-pane']");
        return this;
    }

    public XpathHelper getOverlayElementLuOption(){
        xpath.append("//lu-options-wrapper//lu-option");
        return this;
    }

    public XpathHelper getOverlayElementLuReplacementMessage(){
        xpath.append("//lu-options-wrapper//lu-replacement-message");
        return this;
    }

    public XpathHelper getOverlayElementLuOptionOnText(String elementName){
        xpath.append("//lu-options-wrapper//lu-option[normalize-space(.)='")
                .append(elementName)
                .append("']");
        return this;
    }

    public XpathHelper getOverlayCalendarNavigation(){
        xpath.append("//lu-calendar//lu-calendar-navigation");
        return this;
    }

    1 exampl
    2 exampl

    public XpathHelper getOverlayCalendarMonthWrapper(){
        xpath.append("//lu-calendar//lu-calendar-months-wrapper");
        return this;
    }

    public XpathHelper getOverlayCalendarDaysForCurrentMonth(){
        xpath.append("//lu-calendar-months-wrapper//div[contains(@class,'month')]/div[contains(@class,'week')]/div[not(contains(@class,'another-month'))]");
        return this;
    }
}
