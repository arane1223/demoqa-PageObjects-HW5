package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormResults {
    private SelenideElement
            resultTitle = $("#example-modal-sizes-title-lg"),
            tableResponsive = $(".table-responsive");

    public RegistrationFormResults chekFormVisible(String title){
        resultTitle.shouldBe(visible).shouldHave(text(title));
        return this;
    }

    public RegistrationFormResults chekFormResults (String key, String resultValue){
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(resultValue));
        return this;
    }

    public RegistrationFormResults chekFormUnvisible (){
        resultTitle.shouldNotBe(visible);
        return this;
    }
}