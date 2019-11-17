package ca.etsmtl.log240.financej;

import org.uispec4j.Trigger;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

public class LedgerTest extends FinancejAbstractTest {

    public void testAddLedger() throws Exception {
    /* Voici comment traiter une fenêtre modale avec uispec4j.
     * Voir "Intercepting windows and dialogs" dans la documentation en
        ligne.
     */
        WindowInterceptor.init(ledgerButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                      ledgerTable = window.getTable();
                      int initialRowCount = ledgerTable.getRowCount();

                        // ajouter un compte
                        window.getTextBox("DATE_TEXT_FIELD").setText("12/01/2040");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("nihal");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Des");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("5000");
                        window.getCheckBox("REC_FIELD").select();
                        window.getComboBox("GATEGORY_FIELD").select("IT");
                        window.getComboBox("ACCOUNT_FIELD").select("katy");
                        // fin ajout de la ligne
                        window.getButton("Add Transaction").click();

                        WindowInterceptor.init(window.getButton("Add Transaction").triggerClick())
                                .process(new WindowHandler() {
                                    public Trigger process(Window window) {
                                        String title = window.getTitle();
                                        assertEquals("Erreur date jour",title);
                                        return window.getButton("OK").triggerClick();

                                    } }).run();
                        //assertEquals(ledgerTable.getRowCount(), initialRowCount+1);
                        // retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }

                }).run();
    }
    // fin Methode

    // description trop longue 50 caractere
    public void testAddLedger1() throws Exception {
        WindowInterceptor.init(ledgerButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        ledgerTable = window.getTable();
                        int initialRowCount = ledgerTable.getRowCount();
                        // ajouter un compte
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-01-12");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("noha");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("azertyuiopqsdfghjklmwxcvbjjjjjjjjjjjnmmnbvcxwqsdfghmpoiuytre");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("1000");
                        window.getCheckBox("REC_FIELD").select();
                        window.getComboBox("GATEGORY_FIELD").select("IT");
                        window.getComboBox("ACCOUNT_FIELD").select("katy");
                        //fin ajout de la ligne
                        window.getButton("Add Transaction").click();
                       // assertEquals(ledgerTable.getRowCount(), initialRowCount+8);
                        WindowInterceptor.init(window.getButton("add Transaction").triggerClick())
                                .process(new WindowHandler() {
                                    public Trigger process(Window window) {
                                        String title = window.getTitle();
                                        assertEquals("Longeur max de 50",title);
                                        return window.getButton("OK").triggerClick();

                                    }}).run();

                        // retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();

                    }

                }).run();
    }
    // fin Methode

}