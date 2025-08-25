package tests;

import pages.TextBox;
import pages.components.BoxResultsComponent;
import org.junit.jupiter.api.Test;

public class TextBoxWithPageObjectsTests extends TestBase {

    TextBox textBox = new TextBox();
    BoxResultsComponent textBoxResults = new BoxResultsComponent();

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