package ca.etsmtl.log240.financej;

import org.uispec4j.Table;
import org.uispec4j.Trigger;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

public class LedgerTest extends FinancejAbstractTest {

    private Table ledgerTable;
    public void testAddingAndDeletingLedger() throws Exception {
        /* Voici comment traiter une fenêtre modale avec uispec4j.
         * Voir "Intercepting windows and dialogs" dans la documentation en ligne.
         */
        WindowInterceptor.init(ledgerButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        ledgerTable = window.getTable();
                        int initialRowCount = ledgerTable.getRowCount();
// ajouter un transaction
                        window.getTextBox("DATE_TEXT_FIELD").setText("2019-11-11");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("payee");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("descritpionledger");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("nom");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("120");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("nom");


                        window.getButton("Add Transaction").click();
                        assertEquals(ledgerTable.getRowCount(), initialRowCount+1);
// supprimer la transaction cree precedemment en cherchant la descritption
                        ledgerTable.selectRowsWithText(4, "descritpionledger");
                        window.getButton("Delete Transaction").click();
                        assertEquals(ledgerTable.getRowCount(), initialRowCount);
// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
}
