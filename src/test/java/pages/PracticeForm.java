package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import entities.User;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class PracticeForm {
    public void fillFormWithUser(User user) {
        $(By.id("firstName")).setValue(user.getFirstName());
        $(By.id("lastName")).setValue(user.getLastName());
        $(By.id("userEmail")).setValue(user.getEmail());
        $(By.xpath("//*[.='" + user.getGender() + "']")).click();
        $(By.id("userNumber")).setValue(user.getPhoneNumber());
        $(By.id("dateOfBirthInput")).sendKeys(Keys.CONTROL + "a");
        $(By.id("dateOfBirthInput")).sendKeys(user.getDateOfBirth() + Keys.ENTER);
        user.getSubjects().forEach(subject -> {
            $(By.id("subjectsInput")).sendKeys(subject);
            $(By.id("subjectsInput")).sendKeys(Keys.ENTER);
        });
        user.getHobbies()
                .forEach(hobby -> $(By.xpath("//label[.='" + hobby + "']")).click());
        $(By.id("uploadPicture")).uploadFile(new File(user.getPhotoFile()));
        $(By.id("currentAddress")).setValue(user.getCurrentAddress());
        $(By.id("react-select-3-input")).scrollTo().setValue(user.getState() + Keys.ENTER);
        $(By.id("react-select-4-input")).scrollTo().setValue(user.getCity() + Keys.ENTER);

        $(By.id("submit")).scrollTo().click();
    }
}
