import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.qase.io.pages.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import util.CardData;
import util.UserData;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;


public class FirstTests {

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.browser = "chrome";
        Configuration.browserSize = "1600x1000";
    }

    @Test
    public void loginAsRegisteredUser() throws Exception {
        UserData user = new UserData("forEducationBelov@yandex.ru", "ViVaLaFreedom");
        LoginPage loginPage = open("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin(user.getUserLogin());
        loginPage.enterPassword(user.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
    }

    @Test
    public void openProjects() {
        UserData user = new UserData("forEducationBelov@yandex.ru", "ViVaLaFreedom");
        LoginPage loginPage = open("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin(user.getUserLogin());
        loginPage.enterPassword(user.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
    }

    @Test
    public void createCard() {
        CardData defect = new CardData("title5", "desc1");
        UserData user = new UserData("forEducationBelov@yandex.ru", "ViVaLaFreedom");
        LoginPage loginPage = open("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin(user.getUserLogin());
        loginPage.enterPassword(user.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        DefectsPage defectsPage = projectDashboardPage.openDefects();
        defectsPage.checkDefectsPage();
        defectsPage.addNewDefect(defect.getCardName(), defect.getCardDescription());
        defectsPage.checkDefectAdded(defect.getCardName());
    }

    @Test
    public void deleteDefectCard() {
        UserData user = new UserData("forEducationBelov@yandex.ru", "ViVaLaFreedom");
        LoginPage loginPage = open("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin(user.getUserLogin());
        loginPage.enterPassword(user.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        DefectsPage defectsPage = projectDashboardPage.openDefects();
        defectsPage.checkDefectsPage();
        defectsPage.deleteDefect("title5");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        closeWindow();
    }
}

