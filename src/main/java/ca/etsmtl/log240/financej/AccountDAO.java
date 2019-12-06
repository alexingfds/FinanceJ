package ca.etsmtl.log240.financej;

import java.awt.*;
import java.sql.*;

//Déplacez tout le code d'accès à la BD d'AccountTableModel dans une nouvelle classe
// AccountDAO qui doit être la seule classe (liée aux comptes) à connaître l'existence de la BD:
public class AccountDAO {

    private String[] columnNames = {"Name", "Description"};
    private Connection conn;



    public AccountDAO(Connection DBConn) {
        conn = DBConn;


    }

    public void updateAccount(Object description , String AccountName) throws SQLException {

        String SQLString;
        Statement s = conn.createStatement();
        SQLString = "update account set description ='" + (String) description + "' where name = '" + AccountName + "'";
        System.out.println(SQLString);
        try {
            s.execute(SQLString);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public int addAccount(String Name, String Description) {
        int ErrorCode = 0;
        PreparedStatement psInsert;

        try {
            psInsert = conn.prepareStatement("insert into account(name, description) values(?,?)");
            psInsert.setString(1, Name);
            psInsert.setString(2, Description);
            psInsert.executeUpdate();
        } catch (Throwable e) {
            System.out.println(" . . . exception thrown: AddAccount");
            e.printStackTrace();
            ErrorCode = 1;
        }

        return ErrorCode;
    }

    public void deleteAccount( String AccountName) {
        Statement s;
        String SQLString;

        if (conn != null) {
            try {

                s = conn.createStatement();
                SQLString = "DELETE FROM account WHERE name = '" + AccountName + "'";
                System.out.println(SQLString);
                s.executeUpdate(SQLString);
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in AccountListTableModel DeleteAccount");
                e.printStackTrace();
            }
        }
    }


    public  ResultSet  getAccount(){

        ResultSet AccountResult = null;
        Statement s;
       int CurrentRow = 0;

        if (conn != null) {
            try {
                s = conn.createStatement();
                AccountResult = s.executeQuery("select * from account order by name");
               // return AccountResult;
//                while (AccountResult.next()) {
//                    if (CurrentRow == row) {
//                        if (col == 0) {
//                            return AccountResult.getString(1);
//                        } else if (col == 1) {
//                            return AccountResult.getString(2);
//                        }
//                    }
//                    CurrentRow++;
//                }
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in AccountListTableModel getValueAt");
                e.printStackTrace();
            }
        }
        return AccountResult;
    }

    public ResultSet getRowCount() {
        ResultSet AccountResult = null;
        Statement s;

        if (conn != null) {
            try {
                s = conn.createStatement();
                AccountResult = s.executeQuery("select count(name) from account");
//                while (AccountResult.next()) {
//                    return AccountResult.getInt(1);
//                }
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in AccountListTableModel getRowCount");
                e.printStackTrace();
            }
        }

        return AccountResult;
    }

    //ajouter le 6 dec ken
    public  ResultSet UpdateTotal() {

        ResultSet LedgerResult = null;
        Statement s;
        String TotalStr;

        TotalStr = "$0.00";
        if (conn != null) {
            try {
                s = conn.createStatement();
                LedgerResult = s.executeQuery("select sum(amount) from ledger");
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in AccountListTableModel getValueAt");
                e.printStackTrace();
            }
        }
        return LedgerResult;
    }
//
    //updateAccount()
    //deleteAccount()
    //addAccount()
//    public List<AccountTotalTableModel> getAccount();



}
