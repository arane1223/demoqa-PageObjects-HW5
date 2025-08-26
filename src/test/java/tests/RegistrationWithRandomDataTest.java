package tests;

import org.junit.jupiter.api.Test;

import pages.RegistrationForm;
import pages.components.RegistrationResultsComponent;
import utils.RandomDateGeneratorUtils;

import static utils.RandomUtils.*;

public class RegistrationWithRandomDataTest extends TestBase {

    RegistrationForm registrationPage = new RegistrationForm();
    RegistrationResultsComponent registrationResults = new RegistrationResultsComponent();
    RandomDateGeneratorUtils randomDate = new RandomDateGeneratorUtils();
    String
            firstName = getFirstName(),
            lastName = getLastName(),
            userEmail = getEmail(),
            gender = getGender(),
            userNumber = getNumber(),
            birthDay = randomDate.getDay(),
            birthMonth = randomDate.getMonth(),
            birthYear = randomDate.getYear(),
            subjects =getSubjects(),
            hobbies = getHobbies(),
            picture = getPicture(),
            address = getAddress(),
            state = getState(),
            city = getCity(state);

    @Test
    void fullFillFormTest() {
        registrationPage
                .openPage()
                .deleteAdds()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDayOfBirthday(birthDay,birthMonth,birthYear)
                .setRandomSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAdress(address)
                .setStateAndCity(state,city)
                .clickOnSubmit();

        registrationResults //проверки
                .checkFormVisible("Thanks for submitting the form")
                .checkFormResults("Student Name", firstName+" "+lastName)
                .checkFormResults("Student Email", userEmail)
                .checkFormResults("Gender", gender)
                .checkFormResults("Mobile", userNumber)
                .checkDateOfBirth(birthDay, birthMonth, birthYear)
                .checkFormResults("Subjects", subjects)
                .checkFormResults("Hobbies",hobbies)
                .checkFormResults("Picture", picture)
                .checkFormResults("Address", address)
                .checkFormResults("State and City",state+" "+city);
    }

    @Test
    void minimalFillFormTest(){
        registrationPage
                .openPage()
                .deleteAdds()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickOnSubmit();

        registrationResults //проверки
                .checkFormVisible("Thanks for submitting the form")
                .checkFormResults("Student Name", firstName+" "+lastName)
                .checkFormResults("Gender",gender)
                .checkFormResults("Mobile",userNumber);
    }

    @Test
    void negativeFillFormTest(){
        registrationPage
                .openPage()
                .deleteAdds()
                .clickOnSubmit();

        registrationResults
                .checkFormUnvisible();
    }
}