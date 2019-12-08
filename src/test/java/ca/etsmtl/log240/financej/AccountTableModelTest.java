package ca.etsmtl.log240.financej;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AccountTableModelTest {
    private static Connection conn ;
    private static AccountTableModel comp;


    public void setupDb(){

        conn =DerbyUtils.getInstance().getConnexion();
        comp = new AccountTableModel(conn);
        for(int i = 0; i< comp.getRowCount(); i++){
            comp.DeleteAccount(0);
        }
    }

    @Test
    public void AddCategoryTest(){
        setupDb();
        comp.AddAccount("Firstcomp", "DescriptiFistcomp");
        assertEquals(1, comp.getRowCount());

    }

    @Test
    public void getColumnNameTest(){
        setupDb();
        assertEquals("Name", comp.getColumnName(0));
        assertEquals("Description", comp.getColumnName(1));

    }
    @Test
    public void getRowCountTest(){
        setupDb();
        assertEquals(comp.getRowCount(), 0);
    }

    @Test
    public void getColumnCountTest(){
        setupDb();
        assertEquals(comp.getColumnCount(), 2);
    }

    @Test
    public void isCellEditableTest(){
        setupDb();
        comp.AddAccount("Firstcomp", "DescriptiFistcomp");
        assertTrue(comp.isCellEditable(1,1));
        assertFalse(comp.isCellEditable(1,0));
    }
    @Test
    public void DeleteCategoryTest(){
        setupDb();
        comp.AddAccount("Firstcomp", "DescriptiFistcomp");
        comp.DeleteAccount(0);
        assertEquals(0, comp.getRowCount());
    }
    @Test
    public void getValueAttest(){
        setupDb();
        comp.AddAccount("Firstcomp", "DescriptiFistcomp");
        assertEquals(comp.getValueAt(0,0), "Firstcomp");
    }

    @Test
    public void getColumnClassTest(){
        setupDb();
        assertEquals("class java.lang.String", comp.getColumnClass(0).toString());
        assertEquals("class java.lang.String", comp.getColumnClass(1).toString());
        assertEquals("class java.lang.String", comp.getColumnClass(2).toString());
    }

}
