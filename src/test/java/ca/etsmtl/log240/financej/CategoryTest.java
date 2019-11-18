package ca.etsmtl.log240.financej;
import org.uispec4j.Table;
import org.uispec4j.Trigger;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

public class CategoryTest extends  FinancejAbstractTest{
    private Table categoriesTable;
    public void testAddingAndDeletingCategory() throws Exception {
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
                        assertEquals(categoriesTable.getRowCount(), initialRowCount+1);
// supprimer la categorie cree precedemment en cherchant le nom de la categorie
                        categoriesTable.selectRowsWithText(0, "Category name");
                        window.getButton("Delete Category").click();
                        assertEquals(categoriesTable.getRowCount(), initialRowCount);
// retourner un "trigger" qui ferme la fenêtre modale
                        return window.getButton("Close").triggerClick();
                    }
                }).run();

    }
}
