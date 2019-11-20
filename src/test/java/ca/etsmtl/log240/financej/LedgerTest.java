package ca.etsmtl.log240.financej;

import org.uispec4j.Table;
import org.uispec4j.Trigger;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

public class LedgerTest extends FinancejAbstractTest {
    private Table ledgerTable;
    private Table accountsTable;
    private Table categoriesTable;
    public void setup(){
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();

                        // ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("Com1");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        // fin ajout de la ligne
                        window.getButton("Add Account").click();
                        return window.getButton("Close").triggerClick();

                    }

                }).run();


        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("Cat1");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Savings");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("120");
                        window.getButton("Add Category").click();

                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }


       public void testL20() throws Exception {
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
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("1200");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");


                        window.getButton("Add Transaction").click();

// supprimer la transaction cree precedemment en cherchant la descritption
                        ledgerTable.selectRowsWithText(4, "Description");
                        window.getButton("Delete Transaction").click();
                        assertEquals(ledgerTable.getRowCount(), initialRowCount);
// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    public void testL21() throws Exception {
        /* Voici comment traiter une fenêtre modale avec uispec4j.
         * Voir "Intercepting windows and dialogs" dans la documentation en ligne.
         */
        WindowInterceptor.init(ledgerButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        ledgerTable = window.getTable();
                        int initialRowCount = ledgerTable.getRowCount();
//

// supprimer la transaction cree precedemment en cherchant la descritption

                        window.getButton("Delete Transaction").click();
                        assertEquals(ledgerTable.getRowCount(), initialRowCount);
// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    public void testL1() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("1200");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");


                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("la date il ne doit pas être null",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    public void testL2() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("03-30-19995");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("1200");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("il doit respecter la forme date yyyy-mm-dd",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }


    public void testL3() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-3-70");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("1400");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("il doit respecter la forme date yyyy-mm-dd",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    public void testL4() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-3-00");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("1500");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("il doit respecter la forme date yyyy-mm-dd",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    public void testL5() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-70-05");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("1600");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("il doit respecter la forme date yyyy-mm-dd",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    public void testL6() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-00-05");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("1700");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("il doit respecter la forme date yyyy-mm-dd",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    public void testL7() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1000-04-05");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("1800");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("date <1900",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    public void testL8() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-01-20");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("1900");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("d’erreur champs description vide",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    public void testL9() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-01-20");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("RT");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("2000");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("description moins de 5 caractères",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    public void testL10() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-01-20");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description4superieura250Description4superieura250Description4superieura250Description4superieura250Description4superieura250Description4superieura250Description4superieura250Description4superieura250Description4superieura250Description4superieura250w");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("2100");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("description moins de 5 caractères",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    public void testL11() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-01-20");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("&éd »");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("amount ne doit pas contenir des caractères non numériques",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    public void testL12() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-01-20");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("2300");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("payee ne doit pas être nul",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    public void testL13() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-01-20");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("ME");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("2400");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("il faut que la longueur PAYEE soit supérieure à 3",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    public void testL14() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-01-20");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("AZERTYUIOPQSDFGhjklmwxcvbna");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("2500");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("Message d’erreur il faut que la longueur soit supérieure à 3",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    public void testL15() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-02-29");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("2500");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("Message d’erreur année non Bissextile",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    public void testL16() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1999-02-29");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("2500");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals("Message d’erreur année non Bissextile",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    public void testL17() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("2018-04-31");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("2900");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        Teardown(ledgerTable,window);
                        assertEquals(" avril contient 30 jours",ledgerTable.getRowCount(), initialRowCount);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }

    public void testL18() throws Exception {




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
                        window.getTextBox("DATE_TEXT_FIELD").setText("2018-03-12");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("2900");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        int finalRowCount = ledgerTable.getRowCount();
                        Teardown(ledgerTable,window);
                        assertEquals("",finalRowCount, initialRowCount+1);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    public void testL19() throws Exception {
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
                        window.getTextBox("DATE_TEXT_FIELD").setText("1900-12-31");
                        window.getTextBox("PAYEE_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getCheckBox("REC_CHECK_BOX").select();
                        window.getComboBox("CATEGORY_COMBO_BOX").select("Cat1");
                        window.getTextBox("AMOUNT_TEXT_FIELD").setText("2900");
                        window.getComboBox("ACCOUNTS_COMBO_BOX").select("Com1");

                        window.getButton("Add Transaction").click();
                        int finalRowCount = ledgerTable.getRowCount();
                        Teardown(ledgerTable,window);
                        assertEquals("",finalRowCount, initialRowCount+1);

                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    static  void Teardown(Table Tabletoteardown,Window window){
        while (Tabletoteardown.getRowCount() !=0){
            Tabletoteardown.selectAllRows();
            window.getButton("Delete Transaction").click();
        }

    }
}
