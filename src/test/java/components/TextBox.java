package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBox {
    private SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitInput = $("#submit");

    public TextBox openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBox setUserName (String name){
        userNameInput.setValue(name);
        return this;
    }

    public TextBox setUserEmail (String email){
        userEmailInput.setValue(email);
        return this;
    }

    public TextBox setAllAdresses (String current, String permanent){
        currentAddressInput.setValue(current);
        permanentAddressInput.setValue(permanent);
        return this;
    }

    public TextBox clickOnSubmit(){
        submitInput.click();
        return this;
    }

    public TextBox chekResults (String name, String email, String currentAddress, String permanentAddress){
        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text(email));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
        return this;
    }
}
