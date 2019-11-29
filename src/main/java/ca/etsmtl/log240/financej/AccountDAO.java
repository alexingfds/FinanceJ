package ca.etsmtl.log240.financej;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//Déplacez tout le code d'accès à la BD d'AccountTableModel dans une nouvelle classe
// AccountDAO qui doit être la seule classe (liée aux comptes) à connaître l'existence de la BD:
public class AccountDAO {

    private String[] columnNames = {"Name", "Description"};
    private Connection conn;


    public AccountDAO(Connection DBConn) {
        conn = DBConn;


    }
    public int getRowCount() {
        ResultSet AccountResult;
        Statement s;

        if (conn != null) {
            try {
                s = conn.createStatement();
                AccountResult = s.executeQuery("select count(name) from account");
                while (AccountResult.next()) {
                    return AccountResult.getInt(1);
                }
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in AccountListTableModel getRowCount");
                e.printStackTrace();
            }
        }

        return 0;
    }



//
    //updateAccount()
    //deleteAccount()
    //addAccount()
//    public List<AccountTotalTableModel> getAccount();
//    public  AccountTotalTableModel getStudent(int rollNo);
//    public void updateAccount(AccountTotalTableModel account);
//    public void deleteAccount(AccountTotalTableModel account);


//    ResultSet AccountResult;
//    Statement s;
//
//            if (conn != null) {
//        try {
//            s = conn.createStatement();
//            AccountResult = s.executeQuery("select count(name) from account");
//            while (AccountResult.next()) {
//                return AccountResult.getInt(1);
//            }
//        } catch (Throwable e) {
//            System.out.println(" . . . exception thrown: in AccountListTableModel getRowCount");
//            e.printStackTrace();
//        }
//    }
//
//    public  AccountTableModel (Connection DBConn) {
//        //conn = DBConn;
//        //se connecter à la bdd
//        DerbyUtils derbyUtils = DerbyUtils.getInstance();
//        conn = derbyUtils.getConnexion();
//    }
}
