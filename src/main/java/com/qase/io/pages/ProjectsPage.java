package com.qase.io.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage {

    @FindBy(xpath = "//h1[.='Projects']")
    public SelenideElement projectsHeader;

    @FindBy(xpath = "//a[@class='defect-title']")
    public SelenideElement projectName;

    @Step
    public void checkProjectsPage(){
        projectsHeader.shouldBe(Condition.visible);
    }

    @Step
    public ProjectDashboardPage openProject(){
        projectName.click();
        return Selenide.page(ProjectDashboardPage.class);
    }
}
