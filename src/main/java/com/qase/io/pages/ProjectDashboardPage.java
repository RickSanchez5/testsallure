package com.qase.io.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class ProjectDashboardPage {

    @FindBy(xpath = "//h1[.='DEMO repository']")
    public SelenideElement projectOverview;

    @FindBy(xpath = "//span[.='Defects']")
    public SelenideElement defectsLink;

    @Step
    public void checkProjectDashboardPage() {
        projectOverview.shouldBe(Condition.visible);
    }

    @Step
    public DefectsPage openDefects() {
        defectsLink.click();
        return Selenide.page(DefectsPage.class);
    }
}


