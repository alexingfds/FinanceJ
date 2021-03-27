package ca.etsmtl.log240.financej;

import javax.swing.table.AbstractTableModel;
import java.sql.Connection;

class CategoryTableModel extends AbstractTableModel {

    private String[] columnNames = {"Name", "Description", "Budget"};
    // private Connection conn = null;
    CategoryDAO categoryDAO;

    public CategoryTableModel(Connection DBConn) {

        // conn = DBConn;
        categoryDAO = new CategoryDAO(DBConn);
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return categoryDAO.getRowCount();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {

        return categoryDAO.getCategory(row, col);
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.


        if (col == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * modifier catégorie
     **/
    public void setValueAt(Object value, int row, int col) {

        String CategoryName = "";
        String budget = "";

        CategoryName = (String) getValueAt(row, 0);
        budget = value.toString();
        categoryDAO.updateCategory(CategoryName, budget, col, value);
        fireTableCellUpdated(row, col);

    }

    /**
     * supprimer catégorie
     **/
    public void DeleteCategory(int row) {

        String CategoryName;
        CategoryName = (String) getValueAt(row, 0);
        categoryDAO.deleteCategory(row, CategoryName);
        fireTableDataChanged();


    }

    /**
     * Ajouter catégorie
     **/
    public int AddCategory(String Name, String Description, float budget) {
        int ErrorCode = 0;
        ErrorCode = categoryDAO.addCategory(Name, Description, budget);
        fireTableRowsInserted(getRowCount() + 1, getRowCount() + 1);

        return ErrorCode;
    }
}
//    public Object getValueAt(int row, int col) {
//        ResultSet CategoryResult;
//        Statement s;
//        int CurrentRow = 0;
//
//        if (conn != null) {
//            try {
//                s = conn.createStatement();
//                CategoryResult = s.executeQuery("select * from category order by name");
//                while (CategoryResult.next()) {
//                    if (CurrentRow == row) {
//                        if (col == 0) {
//                            return CategoryResult.getString(1);
//                        } else if (col == 1) {
//                            return CategoryResult.getString(2);
//                        } else if (col == 2) {
//                            return CategoryResult.getFloat(3);
//                        }
//                    }
//                    CurrentRow++;
//                }
//            } catch (Throwable e) {
//                System.out.println(" . . . exception thrown: in CategoryListTableModel getValueAt");
//                e.printStackTrace();
//            }
//        }
//        return "";
//    }
//    public int getRowCount() {
//        ResultSet AccountResult;
//        Statement s;
//
//        if (conn != null) {
//            try {
//                s = conn.createStatement();
//                AccountResult = s.executeQuery("select count(name) from category");
//                while (AccountResult.next()) {
//                    return AccountResult.getInt(1);
//                }
//            } catch (Throwable e) {
//                System.out.println(" . . . exception thrown: in CategoryListTableModel getRowCount");
//                e.printStackTrace();
//            }
//        }
//
//        return 0;
//    }
    //    public void setValueAt(Object value, int row, int col) {
//        String SQLString = "";
//
//        String CategoryName;
//        try {
//            CategoryName = (String) getValueAt(row, 0);
//            Statement s = conn.createStatement();
//            if (col == 1) {
//                SQLString = "update category set description ='" + (String) value + "' where name = '" + CategoryName + "'";
//            } else if (col == 2) {
//                String StrValue;
//
//                StrValue = value.toString();
//                SQLString = "update category set budget = " + StrValue + " where name = '" + CategoryName + "'";
//            }
//            System.out.println(SQLString);
//            s.execute(SQLString);
//
//            fireTableCellUpdated(row, col);
//        } catch (Throwable e) {
//            System.out.println(" . . . exception thrown: in setValueAt in Category.java");
//            e.printStackTrace();
//        }
//    }

//    public void DeleteCategory(int row) {
//        Statement s;
//        String CategoryName;
//        String SQLString;
//
//        if (conn != null) {
//            try {
//                CategoryName = (String) getValueAt(row, 0);
//                s = conn.createStatement();
//                SQLString = "DELETE FROM category WHERE name = '" + CategoryName + "'";
//                System.out.println(SQLString);
//                s.executeUpdate(SQLString);
//                fireTableDataChanged();
//            } catch (Throwable e) {
//                System.out.println(" . . . exception thrown: in CategoryTableModel DeleteAccount");
//                e.printStackTrace();
//            }
//        }
//    }

//    public int AddCategory(String Name, String Description, float budget) {
//        int ErrorCode = 0;
//        PreparedStatement psInsert;
//
//        try {
//            psInsert = conn.prepareStatement("insert into category(name, description, budget) values(?,?,?)");
//            psInsert.setString(1, Name);
//            psInsert.setString(2, Description);
//            psInsert.setFloat(3, budget);
//
//            psInsert.executeUpdate();
//            fireTableRowsInserted(getRowCount() + 1, getRowCount() + 1);
//        } catch (Throwable e) {
//            System.out.println(" . . . exception thrown: AddCategory");
//            e.printStackTrace();
//            ErrorCode = 1;
//        }
//
//        return ErrorCode;
//    }




