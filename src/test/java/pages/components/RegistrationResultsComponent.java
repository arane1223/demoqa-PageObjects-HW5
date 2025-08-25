package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsComponent {
    private SelenideElement
            resultTitle = $("#example-modal-sizes-title-lg"),
            tableResponsive = $(".table-responsive");

    public RegistrationResultsComponent chekFormVisible(String title){
        resultTitle.shouldBe(visible).shouldHave(text(title));
        return this;
    }

    public RegistrationResultsComponent chekFormResults (String key, String resultValue){
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(resultValue));
        return this;
    }

    public RegistrationResultsComponent chekFormUnvisible (){
        resultTitle.shouldNotBe(visible);
        return this;
    }
}