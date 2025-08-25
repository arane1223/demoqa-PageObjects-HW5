package tests;

import components.TextBox;
import components.TextBoxResults;
import org.junit.jupiter.api.Test;

public class TextBoxWithPageObjectsTests extends TestBase {

    TextBox textBox = new TextBox();
    TextBoxResults textBoxResults = new TextBoxResults();

    @Test
    void fillFormTest() {
        textBox
                .openPage()
                .deleteAdds()
                .setUserName("Alex")
                .setUserEmail("alex@egorov.com")
                .setAllAddresses("Some street 1","Another street 1")
                .clickOnSubmit();

        textBoxResults
                .checkResults("Alex","alex@egorov.com",
                "Some street 1","Another street 1");
    }
}