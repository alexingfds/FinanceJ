package ca.etsmtl.log240.financej;
import org.uispec4j.Table;
import org.uispec4j.Trigger;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

public class CategoryTest extends  FinancejAbstractTest{
    private Table categoriesTable;
    public void testC11() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
         // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
       WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("Category name");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Savings");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("120");
                        window.getButton("Add Category").click();
                       // assertEquals(categoriesTable.getRowCount(), initialRowCount+1);
// supprimer la categorie cree precedemment en cherchant le nom de la categorie
                        categoriesTable.selectRowsWithText(0, "Category name");
                        window.getButton("Delete Category").click();
                        assertEquals(categoriesTable.getRowCount(), initialRowCount);
// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }

    public void testC12() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
        // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
// supprimer la categorie cree precedemment en cherchant le nom de la categorie

                        window.getButton("Delete Category").click();
                        //assertEquals(categoriesTable.getRowCount(), initialRowCount);
                        assertEquals("Non Suppression de la catégorie",categoriesTable.getRowCount(), initialRowCount);

// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }

    public void testC1() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
        // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("5000");
                        window.getButton("Add Category").click();
                        int finalRowCount =  categoriesTable.getRowCount();

                        Teardown(categoriesTable,window);
                        assertEquals("« Name not null»",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }

    public void testC2() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
        // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("ME");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("5000");
                        window.getButton("Add Category").click();
                        int finalRowCount =  categoriesTable.getRowCount();

                        Teardown(categoriesTable,window);
                        assertEquals("le nom doit être supérieur >2",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }

    public void testC3() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
        // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("Azertyuiopqsdfghjklmwxcvbngazetgsd");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("7000");
                        window.getButton("Add Category").click();
                        int finalRowCount =  categoriesTable.getRowCount();

                        Teardown(categoriesTable,window);
                        assertEquals("la longueur doit être inferieur a 25",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }

    public void testC4() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
        // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("&@£$!”3!”/¢ »’”");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("80000");
                        window.getButton("Add Category").click();
                        int finalRowCount =  categoriesTable.getRowCount();

                        Teardown(categoriesTable,window);
                        assertEquals("on doit avoir un nom exact",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }

    public void testC5() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
        // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("MED");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("9000");
                        window.getButton("Add Category").click();
                        int finalRowCount =  categoriesTable.getRowCount();

                        Teardown(categoriesTable,window);
                        assertEquals("il faut donne une description pour chaque catégorie",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }

    public void testC6() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
        // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("MED");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("ME");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("10000");
                        window.getButton("Add Category").click();
                        int finalRowCount =  categoriesTable.getRowCount();

                        Teardown(categoriesTable,window);
                        assertEquals(" il faut que la longueur soit supérieure à 5",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }

    public void testC7() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
        // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("MED");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("DescriptionNamesuperieur250DescriptionNamesuperieur250DescriptionNamesuperieur250DescriptionNamesuperieur250DescriptionNamesuperieur250DescriptionNamesuperieur250DescriptionNamesuperieur250DescriptionNamesuperieur250DescriptionNamesuperieur250DescriptionNamesuperieur250DescriptionNamesuperieur250");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("11000");
                        window.getButton("Add Category").click();
                        int finalRowCount =  categoriesTable.getRowCount();

                        Teardown(categoriesTable,window);
                        assertEquals("il faut que la longueur soit inférieure à 250",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }

    public void testC8() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
        // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Description");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("-1");
                        window.getButton("Add Category").click();
                        int finalRowCount =  categoriesTable.getRowCount();

                        Teardown(categoriesTable,window);
                        assertEquals("Message d’erreur budget négative",finalRowCount, initialRowCount);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }

    public void testC9() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
        // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("Med");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Descri");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("12000");
                        window.getButton("Add Category").click();
                        int finalRowCount =  categoriesTable.getRowCount();

                        Teardown(categoriesTable,window);
                        assertEquals(finalRowCount, initialRowCount+1);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }


    public void testC10() throws Exception {
        //* Voici comment traiter une fenêtre modale avec uispec4j.
        // Voir "Intercepting windows and dialogs" dans la documentation en ligne.
        WindowInterceptor.init(categoriesButton.triggerClick())
                .process(new WindowHandler() {
                    public Trigger process(Window window) {
// setup
                        categoriesTable = window.getTable();
                        int initialRowCount = categoriesTable.getRowCount();
// ajouter un categorie
                        window.getTextBox("NAME_TEXT_FIELD").setText("azertyuiopqsdfghjklmwxcvb");
                        window.getTextBox("DESCRIPTION_TEXT_FIELD").setText("Descriptionegalea250caracDescriptionegalea250caracDescriptionegalea250caracDescriptionegalea250caracDescriptionegalea250caracDescriptionegalea250caracDescriptionegalea250caracDescriptionegalea250caracDescriptionegalea250caracDescriptionegalea250carac");
                        window.getTextBox("BUDGET_TEXT_FIELD").setText("13000");
                        window.getButton("Add Category").click();
                        int finalRowCount =  categoriesTable.getRowCount();

                        Teardown(categoriesTable,window);
                        assertEquals(finalRowCount, initialRowCount+1);


// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }

    static  void Teardown(Table Tabletoteardown,Window window) {
        while (Tabletoteardown.getRowCount() != 0) {
            Tabletoteardown.selectAllRows();
            window.getButton("Delete Category").click();
        }


    }
    }
