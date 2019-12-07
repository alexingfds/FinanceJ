package ca.etsmtl.log240.financej;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CategoryDAO {
    private Connection conn = null;


    public CategoryDAO(Connection DBConn) {
        conn = DBConn;
    }



    /***********     recuperer catégorie
     * * **/
    public Object getCategory(int row, int col) {
        ResultSet CategoryResult;
        Statement s;
        int CurrentRow = 0;

        if (conn != null) {
            try {
                s = conn.createStatement();
                CategoryResult = s.executeQuery("select * from category order by name");
                while (CategoryResult.next()) {
                    if (CurrentRow == row) {
                        if (col == 0) {
                            return CategoryResult.getString(1);
                        } else if (col == 1) {
                            return CategoryResult.getString(2);
                        } else if (col == 2) {
                            return CategoryResult.getFloat(3);
                        }
                    }
                    CurrentRow++;
                }
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in CategoryListTableModel getValueAt");
                e.printStackTrace();
            }
        }
        return "";
    }
    /**          Ajouter catégorie
     * **/
    public int addCategory(String Name, String Description, float budget) {
        int ErrorCode = 0;
        PreparedStatement psInsert;

        try {
            psInsert = conn.prepareStatement("insert into category(name, description, budget) values(?,?,?)");
            psInsert.setString(1, Name);
            psInsert.setString(2, Description);
            psInsert.setFloat(3, budget);

            psInsert.executeUpdate();
           // fireTableRowsInserted(getRowCount() + 1, getRowCount() + 1);
        } catch (Throwable e) {
            System.out.println(" . . . exception thrown: AddCategory");
            e.printStackTrace();
            ErrorCode = 1;
        }

        return ErrorCode;
    }
    /**        supprimer catégorie
     * **/
    public void deleteCategory(int row,String CategoryName) {
        Statement s;
        String SQLString;

        if (conn != null) {
            try {
                s = conn.createStatement();
                SQLString = "DELETE FROM category WHERE name = '" + CategoryName + "'";
                System.out.println(SQLString);
                s.executeUpdate(SQLString);
               // fireTableDataChanged();
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in CategoryTableModel DeleteAccount");
                e.printStackTrace();
            }
        }
    }

    /**        modifier catégorie
     * **/
    public void updateCategory( String CategoryName, String budget, int col, Object description){

            String SQLString = "";

            try {

                Statement s = conn.createStatement();
                if (col == 1) {
                    SQLString = "update category set description ='" + (String) description + "' where name = '" + CategoryName + "'";
                } else if (col == 2) {

                    SQLString = "update category set budget = " + budget + " where name = '" + CategoryName + "'";
                }
                System.out.println(SQLString);
                s.execute(SQLString);

            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in setValueAt in Category.java");
                e.printStackTrace();
            }
        }
    /**        getRowCount
     * **/

    public int getRowCount() {
        ResultSet AccountResult;
        Statement s;

        if (conn != null) {
            try {
                s = conn.createStatement();
                AccountResult = s.executeQuery("select count(name) from category");
                while (AccountResult.next()) {
                    return AccountResult.getInt(1);
                }
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in CategoryListTableModel getRowCount");
                e.printStackTrace();
            }
        }

        return 0;
    }


}
