package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            celendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            adressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitInput = $("#submit");

    public RegistrationForm openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationForm deleteAdds(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationForm setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationForm setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationForm setEmail(String email){
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationForm setGender(String gender){
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationForm setUserNumber(String number){
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationForm setDayOfBirthday(String day, String month, String year){
        celendarInput.click();
        RegistrationFormCalendar celendarComponent = new RegistrationFormCalendar();
        celendarComponent.setDate("15","May","1995");
        return this;
    }

    public RegistrationForm setSubjects(String subject){
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationForm setHobbies(String value1, String value2){
        hobbiesWrapper.$(byText(value1)).click();
        hobbiesWrapper.$(byText(value2)).click();
        return this;
    }

    public RegistrationForm setPicture(String fileName){
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationForm setAdress(String adress){
        adressInput.setValue(adress);
        return this;
    }

    public RegistrationForm setStateAndCity (String state, String city){
        $("#stateCity-wrapper").scrollTo();
        stateInput.setValue(state).pressEnter();
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public RegistrationForm clickOnSubmit(){
        submitInput.click();
        return this;
    }
}
