package ru.mos.emias.onco.helpers;

public class EhrFormXpathHelper extends XpathHelper{

    private final StringBuffer xpath;

    public EhrFormXpathHelper() {
        this.xpath = new StringBuffer();
    }

    public String getXpath(){
        return xpath.toString();
    }

    public EhrFormXpathHelper getNavigationSection(String sectionName){
        xpath.append("//span[contains(@class, 'label') and normalize-space(.)='")
                .append(sectionName)
                .append("']//ancestor::ehr-navigation-section");
        return this;
    }

    public EhrFormXpathHelper getNavigationHideableSection(String sectionName){
        xpath.append("//span[contains(@class, 'label') and normalize-space(.)='")
                .append(sectionName)
                .append("']//ancestor::ehr-navigation-hideable-section");
        return this;
    }

    public EhrFormXpathHelper getPanel(String panelName){
        xpath.append("//span[contains(@class, 'label-container') and normalize-space(.)='")
                .append(panelName)
                .append("']//ancestor::ehr-panel");
        return this;
    }

    public EhrFormXpathHelper getRepeaterSlot(String slotName){
        xpath.append("//div[contains(text(), '")
                .append(slotName)
                .append("')]//ancestor::ehr-repeater-slot");
        return this;
    }

    public EhrFormXpathHelper getRepeaterSlotWithPagination(String slotName){
        xpath.append("//div[contains(text(), '")
                .append(slotName)
                .append("')]//ancestor::lib-page-repeater");
        return this;
    }

    public EhrFormXpathHelper getMenu(){
        xpath.append("//ehr-form//ehr-navigation/div[contains(@class, 'menu')]");
        return this;
    }

    public EhrFormXpathHelper getHiddenMenu(){
        xpath.append("//ehr-navigation-hidden-contents/div[contains(@class, 'body')]");
        return this;
    }

    public EhrFormXpathHelper getMenuSection(String sectionName){
        xpath.append("//div[contains(text(), '")
                .append(sectionName)
                .append("')]/../../..");
        return this;
    }

    public EhrFormXpathHelper getMenuElement(String elementName){
        xpath.append("//div[contains(text(), '")
                .append(elementName)
                .append("')]/..");
        return this;
    }

    public EhrFormXpathHelper getMenuWholeElement(String elementName){
        xpath.append("//div[contains(text(), '")
                .append(elementName)
                .append("')]/../..");
        return this;
    }

    public EhrFormXpathHelper getButtonPlus(){
        xpath.append("//lu-svg-icon[contains(@aria-icon, 'plus')]/..");
        return this;
    }

    public EhrFormXpathHelper getButtonClose(){
        xpath.append("//lu-svg-icon[contains(@aria-icon, 'close')]/..");
        return this;
    }

    public EhrFormXpathHelper getFormButton(String buttonName){
        xpath.append("//span[contains(text(), '")
                .append(buttonName)
                .append("')]//ancestor::button");
        return this;
    }

    public EhrFormXpathHelper getElementLuFormField(String fieldName){
        xpath.append("//span[normalize-space(.)='")
                .append(fieldName)
                .append("']//ancestor::lu-form-field");
        return this;
    }

    public EhrFormXpathHelper getFormFieldOnInputPlaceholder(String inputPlaceholder){
        xpath.append("//input[@placeholder='")
                .append(inputPlaceholder)
                .append("']//ancestor::lu-form-field");
        return this;
    }

    public EhrFormXpathHelper getElementMessage(String message){
        xpath.append("//lu-form-message/span[contains(text(),'")
                .append(message)
                .append("')]");
        return this;
    }

    public EhrFormXpathHelper getElementMessage(){
        xpath.append("//lu-form-message");
        return this;
    }



    public EhrFormXpathHelper getElementScSvgIconByAttributeType(String attributeTypeName){
        xpath.append("//lu-svg-icon[contains(@aria-icon, '")
                .append(attributeTypeName)
                .append("')]/..");
        return this;
    }

    public EhrFormXpathHelper getElementSvgIconByAttributeType(){
        xpath.append("//lu-svg-icon");
        return this;
    }

    public EhrFormXpathHelper getElementCheckbox(){
        xpath.append("//lu-checkbox");
        return this;
    }

    public EhrFormXpathHelper getElementCalendar(){
        xpath.append("//lu-calendar-field");
        return this;
    }

    public EhrFormXpathHelper getElementComboboxMultiple(){
        xpath.append("//lu-combobox-multiple");
        return this;
    }

    public EhrFormXpathHelper getElementTag(){
        xpath.append("//lu-tag");
        return this;
    }

    public EhrFormXpathHelper getElementRadio(String radioName){
        xpath.append("//div[contains(@class, 'lu-radio-text') and normalize-space(.)='")
                .append(radioName)
                .append("']//ancestor::lu-radio/label");
        return this;
    }

    public EhrFormXpathHelper getElementCustomRadio(String radioName){
        xpath.append("//span[contains(text(), '")
                .append(radioName)
                .append("')]//ancestor::label[contains(@class, 'custom-radio')]");
        return this;
    }

    //todo Дописать для работы с таблицами
}
