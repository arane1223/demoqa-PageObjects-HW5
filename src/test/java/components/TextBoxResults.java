package components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class TextBoxResults {
    private SelenideElement
            nameCheck = $("#output #name"),
            emailCheck = $("#output #email"),
            currentAddressCheck = $("#output #currentAddress"),
            permanentAddressCheck = $("#output #permanentAddress");

    public TextBoxResults checkResults(String name, String email,
                                       String currentAddress, String permanentAddress) {
        nameCheck.shouldHave(text(name));
        emailCheck.shouldHave(text(email));
        currentAddressCheck.shouldHave(text(currentAddress));
        permanentAddressCheck.shouldHave(text(permanentAddress));
        return this;
    }
}