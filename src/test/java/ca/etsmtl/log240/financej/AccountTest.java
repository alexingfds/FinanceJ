package ca.etsmtl.log240.financej;
import org.junit.After;
import org.junit.Test;
import org.uispec4j.Table;
import org.uispec4j.Trigger;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;
public class AccountTest extends FinancejAbstractTest {
    private Table accountsTable;

    public void testAddingAndDeletingAccount() throws Exception {
        /* Voici comment traiter une fenêtre modale avec uispec4j.
         * Voir "Intercepting windows and dialogs" dans la documentation en ligne.
         */
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();
// ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("Jo Bleault");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Savings");
                        window.getButton("Add Account").click();
                        assertEquals("not right",accountsTable.getRowCount(), initialRowCount+1);
// supprimer le compte cree precedemment en cherchant le nom
                        accountsTable.selectRowsWithText(0, "Jo Bleault");

                         accountsTable.selectAllRows();
                         window.getButton("Delete Account").click();


                  //      assertEquals("not right testdelete",accountsTable.getRowCount(), 0);
// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    public void testT1() throws Exception {
        /* Voici comment traiter une fenêtre modale avec uispec4j.
         * Voir "Intercepting windows and dialogs" dans la documentation en ligne.
         */
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();
// ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("NameDescription");
                        window.getButton("Add Account").click();
                        assertEquals("NE DOIT  PAS ACCEPTER UN NOM VIDE",accountsTable.getRowCount(), initialRowCount+1);

//tear down
                        while (accountsTable.getRowCount() !=0){
                            accountsTable.selectAllRows();
                            window.getButton("Delete Account").click();
                        }


                        return window.getButton("Close").triggerClick();
                }
                }).run();
    }
    public void testT2() throws Exception {
        /* Voici comment traiter une fenêtre modale avec uispec4j.
         * Voir "Intercepting windows and dialogs" dans la documentation en ligne.
         */
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();
// ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("MO");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("NameDescription");
                        window.getButton("Add Account").click();
                        int FinalRowCount = accountsTable.getRowCount();
                        //tear down vider le tableau avant  de verifier  l'assertion
                        while (accountsTable.getRowCount() !=0){
                            accountsTable.selectAllRows();
                            window.getButton("Delete Account").click();
                        }

                        assertEquals("NE DOIT  PAS ACCEPTER UN NOM VIDE",FinalRowCount, initialRowCount+1);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    public void testT3() throws Exception {
        /* Voici comment traiter une fenêtre modale avec uispec4j.
         * Voir "Intercepting windows and dialogs" dans la documentation en ligne.
         */
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();
// ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("Azertyuiopqsdfghjklwxcvbnmet");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("NameDescription");
                        window.getButton("Add Account").click();
                        int FinalRowCount = accountsTable.getRowCount();
                        //tear down vider le tableau avant  de verifier  l'assertion
                        while (accountsTable.getRowCount() !=0){
                            accountsTable.selectAllRows();
                            window.getButton("Delete Account").click();
                        }

                        assertEquals("NE DOIT  PAS ACCEPTER UN NOM VIDE",FinalRowCount, initialRowCount+1);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    public void testT4() throws Exception {
        /* Voici comment traiter une fenêtre modale avec uispec4j.
         * Voir "Intercepting windows and dialogs" dans la documentation en ligne.
         */
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();
// ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("=&l$!”3!”/ùù¨^^@£’");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("NameDescription");
                        window.getButton("Add Account").click();
                        int FinalRowCount = accountsTable.getRowCount();
                        //tear down vider le tableau avant  de verifier  l'assertion
                       Teardown(accountsTable,window);
//                        while (accountsTable.getRowCount() !=0){
//                            accountsTable.selectAllRows();
//                            window.getButton("Delete Account").click();
//                        }

                        assertEquals("NE DOIT  PAS ACCEPTER UN NOM VIDE",FinalRowCount, initialRowCount+1);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    static  void Teardown(Table Tabletoteardown,Window window){
        while (Tabletoteardown.getRowCount() !=0){
            Tabletoteardown.selectAllRows();
            window.getButton("Delete Account").click();
        }

    }

}
