package tests;

import components.TextBox;
import org.junit.jupiter.api.Test;

public class TextBoxWithPageObjectsTests extends TestBase {

    TextBox textBox = new TextBox();

    @Test
    void fillFormTest() {
        textBox
                .openPage()
                .setUserName("Alex")
                .setUserEmail("alex@egorov.com")
                .setAllAdresses("Some street 1","Another street 1")
                .clickOnSubmit();
        textBox //проверка
                .chekResults("Alex","alex@egorov.com","Some street 1","Another street 1");
    }
}