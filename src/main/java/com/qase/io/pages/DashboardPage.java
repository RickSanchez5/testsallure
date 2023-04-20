package com.qase.io.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

    @FindBy(xpath = "//a[.='Demo Project']")
    public SelenideElement projectLink;

    @FindBy(xpath = "//a[.='Projects']")
    public SelenideElement myProjectsLink;

    @Step
    public void checkUserAuthorized() {
        projectLink.shouldBe(Condition.visible);
    }

    @Step
    public ProjectsPage openMyProjects(){
        myProjectsLink.click();
        return Selenide.page(ProjectsPage.class);
    }
}

