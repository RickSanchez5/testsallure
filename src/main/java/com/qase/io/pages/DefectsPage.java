package com.qase.io.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class DefectsPage {
    @FindBy(xpath = "//h1[.='Defects']")
    public SelenideElement defectsHeader;

    @FindBy(xpath = "//a[.='Create new defect']")
    public SelenideElement createNewDefectBtn;

    @FindBy(id = "title")
    public SelenideElement defectTitle;

    @FindBy(xpath = "//div[@class='ProseMirror toastui-editor-contents']")
    public SelenideElement defectResult_container;

    @FindBy(xpath = "//div[@class='ProseMirror toastui-editor-contents ProseMirror-focused']")
    public SelenideElement defectResult_field;

    @FindBy(xpath = "//div[@id='severityGroup']/div/div/div")
    public SelenideElement defectPrioritySelector;

    @FindBy(xpath = "//div[.='Blocker']")
    public SelenideElement defectPriorityBlocker;

    @FindBy(xpath = "//div[.='Critical']")
    public SelenideElement defectPriorityCritical;

    @FindBy(xpath = "//div[.='Major']")
    public SelenideElement defectPriorityMajor;

    @FindBy(xpath = "//div[.='Normal']")
    public SelenideElement defectPriorityNormal;

    @FindBy(xpath = "//div[.='Minor']")
    public SelenideElement defectPriorityMinor;

    @FindBy(xpath = "//div[.='Trivial']")
    public SelenideElement defectPriorityTrivial;

    @FindBy(xpath = "//button[.='Create defect']")
    public SelenideElement saveDefectBtn;

    @FindBy(xpath = "//a[.='title5']")
    public SelenideElement cardName;

    @FindBy(xpath = "//a[.='Delete']")
    public SelenideElement deleteDefectBtn;

    @FindBy(xpath = "//button[.='Delete']")
    public SelenideElement confirmDeleteDefectBtn;

    @Step
    public void checkDefectsPage(){
        defectsHeader.shouldBe(Condition.visible);
        createNewDefectBtn.shouldBe(Condition.visible);
    }

    @Step
    public void setDefectPriority(String priority){
        defectPrioritySelector.click();
        switch (priority) {
            case "blocker":
                defectPriorityBlocker.click();
                break;
            case "critical":
                defectPriorityCritical.click();
                break;
            case "major":
                defectPriorityMajor.click();
                break;
            case "normal":
                defectPriorityNormal.click();
                break;
            case "minor":
                defectPriorityMinor.click();
                break;
            case "trivial":
                defectPriorityTrivial.click();
                break;
        }
    }

    @Step
    public void addNewDefect(String cardTitle,String cardResult) {
        createNewDefectBtn.click();
        defectTitle.click();
        defectTitle.sendKeys(cardTitle);

        defectResult_container.click();
        defectResult_field.sendKeys(cardResult);
        setDefectPriority("critical");
        saveDefectBtn.click();
    }

    @Step
    public void checkDefectAdded(String defectName){
        cardName.shouldBe(Condition.text(defectName));
    }

    @Step
    public void deleteDefect(String name) {
        Selenide.$(By.xpath("//td//div[.='"+name+"']/../following::td/following::td/following::td/following::td/following::td/following::td/div/a")).click();
        deleteDefectBtn.click();
        confirmDeleteDefectBtn.click();
    }
}

