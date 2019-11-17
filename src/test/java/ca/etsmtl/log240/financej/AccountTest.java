package ca.etsmtl.log240.financej;

import org.uispec4j.Table;
import org.uispec4j.Trigger;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

public class AccountTest extends FinancejAbstractTest {

    private Table accountsTable;

    public void testAddingAndDeletingAccount() throws Exception {
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();
                        // ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("fghjklmwxcvbnazertyuiopqsdfghjklmwxcvbnaze");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Descripti");
                        window.getButton("Add Account").click();
                        //assertEquals(accountsTable.getRowCount(), initialRowCount+1);
                        WindowInterceptor.init(window.getButton("Add Account").triggerClick())
                                .process(new WindowHandler() {
                                    public Trigger process(Window window) {
                                        String title = window.getTitle();
                                        assertEquals("Longeur max de 50",title);
                                        return window.getButton("OK").triggerClick();

                                    }}).run();

                        // supprimer le compte cree precedemment en cherchant le nom
                        accountsTable.selectRowsWithText(0, "dcd");
                        window.getButton("Delete Account").click();
                        assertEquals(accountsTable.getRowCount(), initialRowCount);

                        // retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
}