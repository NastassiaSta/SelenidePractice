package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.PracticeForm;
import entities.User;
import entities.Users;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class Tests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void practiceFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        User user = new Users().getValidUser();
        PracticeForm testFormPage = new PracticeForm();

        testFormPage.fillFormWithUser(user);

        $(By.className("modal-body")).shouldHave(
                text(user.getFirstName()),
                text(user.getLastName()),
                text(user.getEmail()),
                text(user.getGender()),
                text(user.getEmail()),
                text(user.getPhoneNumber()),
                text(user.getDateOfBirth()),
                text(user.getSubjects().toString().replaceAll("[\\[\\]]", "")),
                text(user.getHobbies().toString().replaceAll("[\\[\\]]", "")),
                text("photo.jpg"),
                text(user.getCurrentAddress()),
                text(user.getState()),
                text(user.getCity()));
    }
}