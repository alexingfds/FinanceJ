package ca.etsmtl.log240.financej;

import javax.swing.table.AbstractTableModel;
import java.sql.*;


public class AccountTableModel extends AbstractTableModel {

        private String[] columnNames = {"Name", "Description"};
        private Connection conn;

        AccountDAO accountDAO;

        public  AccountTableModel (Connection DBConn) {
             conn = DBConn;
             //a voir
            accountDAO=new AccountDAO(conn);

            //se connecter à la bdd
//            DerbyUtils derbyUtils = DerbyUtils.getInstance();
//            conn = derbyUtils.getConnexion();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {

            return accountDAO.getRowCount();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {

            return accountDAO.getCategory(row,col);
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


            return col != 0;
        }

        public void setValueAt(Object value, int row, int col) {
            String SQLString;

            String AccountName;
            AccountName = (String) getValueAt(row, 0);

            try {
                accountDAO.updateAccount(value,AccountName);
                fireTableCellUpdated(row, col);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        void DeleteAccount(int row) {

            String AccountName;
            AccountName = (String) getValueAt(row, 0);
            accountDAO.deleteAccount(AccountName);
            fireTableDataChanged();

        }

        public int AddAccount(String Name, String Description) {

            int ErrorCode = 0;

            ErrorCode=accountDAO.addAccount(Name, Description);
            if(ErrorCode == 0)
                  fireTableRowsInserted(getRowCount() + 1, getRowCount() + 1);
            return ErrorCode;
        }


    }


