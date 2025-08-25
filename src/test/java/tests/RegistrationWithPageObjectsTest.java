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
                .setHobbies("Sports","Music")
                .setPicture("Sega.jpg")
                .setAdress("Ekaterinberg")
                .setStateAndCity("NCR","Delhi")
                .clickOnSubmit();

        registrationResults //проверки
                .chekFormVisible("Thanks for submitting the form")
                .chekFormResults("Student Name","Alex Terrible")
                .chekFormResults("Student Email","test@test.com")
                .chekFormResults("Gender","Other")
                .chekFormResults("Mobile","0123456789")
                .chekFormResults("Date of Birth","15 May,1995")
                .chekFormResults("Subjects","Maths")
                .chekFormResults("Hobbies","Sports, Music")
                .chekFormResults("Picture","Sega.jpg")
                .chekFormResults("Address","Ekaterinberg")
                .chekFormResults("State and City","NCR Delhi");
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
                .chekFormVisible("Thanks for submitting the form")
                .chekFormResults("Student Name","Alex Terrible")
                .chekFormResults("Gender","Other")
                .chekFormResults("Mobile","0123456789");
    }

    @Test
    void negativeFillFormTest(){
        registrationPage
                .openPage()
                .deleteAdds()
                .clickOnSubmit();

        registrationResults
                .chekFormUnvisible();
    }
}