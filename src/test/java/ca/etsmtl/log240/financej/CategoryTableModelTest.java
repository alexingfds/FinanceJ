package ca.etsmtl.log240.financej;
import org.junit.*;
import java.sql.Connection;
import static org.junit.Assert.*;
public class CategoryTableModelTest {
    private static Connection conn ;
    private static CategoryTableModel cat;


    public void setupDb(){

        conn =DerbyUtils.getInstance().getConnexion();
        cat = new CategoryTableModel(conn);
        for(int i = 0; i< cat.getRowCount(); i++){
            cat.DeleteCategory(0);
        }
    }

    @Test
    public void AddCategoryTest(){
        setupDb();
        cat.AddCategory("Firstcat", "DescriptiFistcat", 200);
        assertEquals(1, cat.getRowCount());

    }

    @Test
    public void getColumnNameTest(){
        setupDb();
        assertEquals("Name", cat.getColumnName(0));
        assertEquals("Description", cat.getColumnName(1));
        assertEquals("Budget", cat.getColumnName(2));
    }
    @Test
    public void getRowCountTest(){
        setupDb();
        assertEquals(cat.getRowCount(), 0);
    }

    @Test
    public void getColumnCountTest(){
        setupDb();
        assertEquals(cat.getColumnCount(), 3);
    }

    @Test
    public void isCellEditableTest(){
        setupDb();
        cat.AddCategory("Firstcat", "DescriptiFistcat", 200);
        assertTrue(cat.isCellEditable(1,1));
        assertFalse(cat.isCellEditable(1,0));
    }
    @Test
    public void DeleteCategoryTest(){
        setupDb();
        cat.AddCategory("Firstcat", "DescriptiFistcat", 200);
        cat.DeleteCategory(0);
        assertEquals(0, cat.getRowCount());
    }
    @Test
    public void getValueAttest(){
        setupDb();
        cat.AddCategory("Firstcat", "DescriptiFistcat", 200);
        assertEquals(cat.getValueAt(0,0), "Firstcat");
    }

    @Test
    public void getColumnClassTest(){
        setupDb();
        assertEquals("class java.lang.String", cat.getColumnClass(0).toString());
        assertEquals("class java.lang.String", cat.getColumnClass(1).toString());
        assertEquals("class java.lang.String", cat.getColumnClass(2).toString());
    }

}
