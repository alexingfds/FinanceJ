package ca.etsmtl.log240.financej;

import org.uispec4j.Table;
import org.uispec4j.Trigger;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

public class AccountTest extends FinancejAbstractTest {

    private Table accountsTable;


    public void testAddT1() throws Exception {
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();

                        // ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("NameDescription");
                        // fin ajout de la ligne
                        window.getButton("Add Account").click();

                        int finalRowCount =  accountsTable.getRowCount();
                        Teardown(accountsTable,window);
                        assertEquals("« Name not null»",finalRowCount, initialRowCount);
                        return window.getButton("Close").triggerClick();

                    }

                }).run();
    }
    // fin Methode
    // ajout methode
    public void testAddT2() throws Exception {
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();

                        // ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("MO");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("NAMEDESCRIPTION");
                        // fin ajout de la ligne
                        window.getButton("Add Account").click();
                        int finalRowCount =  accountsTable.getRowCount();
                        Teardown(accountsTable,window);
                        assertEquals("le nom doit être supérieur >2",finalRowCount, initialRowCount);


                        // retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    //Fin methode
    //ajout Methode
    public void testAddT3() throws Exception {
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();

                        // ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("Azertyuiopqsdfghjklwxcvbnmet");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("NameDescription");
                        // fin ajout de la ligne
                        window.getButton("Add Account").click();
                        int finalRowCount =  accountsTable.getRowCount();

                        Teardown(accountsTable,window);
                        assertEquals("la longueur doit être inferieur a 25",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    //fin methode

    // ajout methode
    public void testAddT4() throws Exception {
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();

                        // ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("=&l$!!/ùù^^@£");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("NameDescription");
                        // fin ajout de la ligne
                        window.getButton("Add Account").click();

                        int finalRowCount =  accountsTable.getRowCount();

                        Teardown(accountsTable,window);
                        assertEquals("on doit avoir un nom exact",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }

                }).run();
    }
    //fin methode
    // ajout methode
    public void testAddT5() throws Exception {
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();

                        // ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("");
                        // fin ajout de la ligne
                        window.getButton("Add Account").click();

                        int finalRowCount =  accountsTable.getRowCount();

                        Teardown(accountsTable,window);
                        assertEquals("il faut donne une description pour chaque catégorie",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }

                }).run();
    }
    //fin methode
    //ajout methhode
    public void testAddT6() throws Exception {
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();

                        // ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Me");
                        // fin ajout de la ligne
                        window.getButton("Add Account").click();

                        int finalRowCount =  accountsTable.getRowCount();

                        Teardown(accountsTable,window);
                        assertEquals(" il faut que la longueur soit supérieure à 5",finalRowCount, initialRowCount);

// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }

                }).run();
    }
    //fin methode
    //ajout methode
    public void testAddT7() throws Exception {
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();

                        // ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Dans ce laboratoire nous nous sommes familiarisés avec la librairie de classes UISpec4j, qui permet de développer des tests unitaires et fonctionnels faisant abstraction des composantes swings pour en faciliter l'implémentation. Nous avons utilisé ce framework pour faire des cas de tests en liens avec les méthodes ajouter ");
                        // fin ajout de la ligne
                        window.getButton("Add Account").click();
                        int finalRowCount =  accountsTable.getRowCount();

                        Teardown(accountsTable,window);
                        assertEquals("il faut que la longueur soit inférieure à 250",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }

                }).run();
    }
    //fin methode
    //ajout methode
    public void testAddT8() throws Exception {
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();

                        // ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Descr");
                        // fin ajout de la ligne
                        window.getButton("Add Account").click();
                        int finalRowCount =  accountsTable.getRowCount();

                        Teardown(accountsTable,window);
                        // assertEquals("add account",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();
    }
    //fin methode
    //ajout methode
    public void testAddT9() throws Exception {
        WindowInterceptor.init(accountsButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
                        // setup
                        accountsTable = window.getTable();
                        int initialRowCount = accountsTable.getRowCount();

                        // ajouter un compte
                        window.getTextBox("NAME_TEXT_FIELD").setText("azertyuiopqsdfghjklmwxcvb");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Medfnfjznizunfiznfiefninefi");
                        // fin ajout de la ligne
                        window.getButton("Add Account").click();

                        Teardown(accountsTable,window);
                        // assertEquals("add account",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }

                }).run();
    }
    //fin methode

    static  void Teardown(Table Tabletoteardown,Window window) {
        while (Tabletoteardown.getRowCount() != 0) {
            Tabletoteardown.selectAllRows();
            window.getButton("Delete Account").click();
        }


    }
}
