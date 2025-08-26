package tests;

import pages.RegistrationForm;
import pages.components.RegistrationResultsComponent;
import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTest extends TestBase {

    RegistrationForm registrationPage = new RegistrationForm();
    RegistrationResultsComponent registrationResults = new RegistrationResultsComponent();

    @Test
    void fullFillFormTest() {
        registrationPage
                .openPage()
                .deleteAdds()
                .setFirstName("Alex")
                .setLastName("Terrible")
                .setEmail("test@test.com")
                .setGender("Other")
                .setUserNumber("0123456789")
                .setDayOfBirthday("15","May","1995")
                .setSubjects("Math")
                .setHobbies("Sports", "Reading", "Music")
                .setPicture("Sega.jpg")
                .setAdress("Ekaterinberg")
                .setStateAndCity("NCR","Delhi")
                .clickOnSubmit();

        registrationResults //проверки
                .checkFormVisible("Thanks for submitting the form")
                .checkFormResults("Student Name","Alex Terrible")
                .checkFormResults("Student Email","test@test.com")
                .checkFormResults("Gender","Other")
                .checkFormResults("Mobile","0123456789")
                .checkFormResults("Date of Birth","15 May,1995")
                .checkFormResults("Subjects","Maths")
                .checkFormResults("Hobbies","Sports, Reading, Music")
                .checkFormResults("Picture","Sega.jpg")
                .checkFormResults("Address","Ekaterinberg")
                .checkFormResults("State and City","NCR Delhi");
    }

    @Test
    void minimalFillFormTest(){
        registrationPage
                .openPage()
                .deleteAdds()
                .setFirstName("Alex")
                .setLastName("Terrible")
                .setGender("Other")
                .setUserNumber("0123456789")
                .clickOnSubmit();

        registrationResults //проверки
                .checkFormVisible("Thanks for submitting the form")
                .checkFormResults("Student Name","Alex Terrible")
                .checkFormResults("Gender","Other")
                .checkFormResults("Mobile","0123456789");
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