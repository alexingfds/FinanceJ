package ca.etsmtl.log240.financej;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;


public class DerbyUtils {

    // define the driver to use
    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    // the database name
    private static String dbName = "FinanceJDB";
    // define the Derby connection URL to use
    private static String connectionURL = "jdbc:derby:" + dbName + ";create=true";
    private static Connection connexion = null;
    private javax.swing.JLabel TotalLabel;

    /** Constructeur privé */
    private DerbyUtils()
    {
        LoadDBDriver();
        CreateDBConnection();
        CreateDBTables();

    }
    /** Instance unique non préinitialisée */
    private static DerbyUtils INSTANCE = null;

    /** Point d'accès pour l'instance unique du singleton */
    public static DerbyUtils getInstance()
    {
        if (INSTANCE == null)
        {   INSTANCE = new DerbyUtils();
        }
        return INSTANCE;
    }
    /************************* getter setter  *********************/
    public  Connection getConnexion() {
        return connexion;
    }

    public static void setConnexion(Connection connexion) {
        DerbyUtils.connexion = connexion;
    }
    /************************* Methodes BDD  *********************/

    private static void LoadDBDriver() {
        try {
            /*
             **  Load the Derby driver.
             **     When the embedded Driver is used this action start the Derby engine.
             **  Catch an error and suggest a CLASSPATH problem
             */
            Class.forName(driver).newInstance();
            System.out.println(driver + " loaded. ");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
            System.out.println("\n    >>> Please check your CLASSPATH variable   <<<\n");
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            System.out.println("\n    >>> Instantiation Exception   <<<\n");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            System.out.println("\n    >>> Illegal Access Exception   <<<\n");
            e.printStackTrace();
        }
    }

    public static void CreateDBConnection() {
        try {
            connexion = DriverManager.getConnection(connectionURL);
            System.out.println("Connected to database " + dbName);
        } catch (Throwable e) {
            /*       Catch all exceptions and pass them to
             **       the exception reporting method             */
            System.out.println(" . . . exception thrown:");
            errorPrint(e);
        }
    }
    private static void CreateDBTables() {
        String CreateStringAccount = "create table account (name varchar(50) primary key, description varchar(250))";
        String CreateStringCategory = "create table category (name varchar(50) primary key, description varchar(250), budget float)";
        String CreateStringLedger = "create table ledger (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),rec integer, tdate date, payee  varchar(50), description varchar(250), account varchar(50), category varchar(50), amount float)";
        Statement s;

        try {
            s = connexion.createStatement();
            if (!DBUtils.ChkTableAccount(connexion)) {
                System.out.println(" . . . . creating table account");
                s.execute(CreateStringAccount);
            }
            if (!DBUtils.ChkTableCategory(connexion)) {
                System.out.println(" . . . . creating table category");
                s.execute(CreateStringCategory);
            }
            if (!DBUtils.ChkTableLedger(connexion)) {
                System.out.println(" . . . . creating table ledger");
                s.execute(CreateStringLedger);
            }

            s.close();
        } catch (Throwable e) {
            System.out.println(" . . . exception thrown:");
            errorPrint(e);
        }
    }
    public static void ShutdownDB() {
        try {
            connexion.close();
            System.out.println("Closed connection");
        } catch (Throwable e) {
            System.out.println(" . . . exception thrown:");
            errorPrint(e);
        }
        /*** In embedded mode, an application should shut down Derby.
         Shutdown throws the XJ015 exception to confirm success. ***/
        if (driver.equals("org.apache.derby.jdbc.EmbeddedDriver")) {
            boolean gotSQLExc = false;
            try {
                DriverManager.getConnection("jdbc:derby:;shutdown=true");
            } catch (SQLException se) {
                if (se.getSQLState().equals("XJ015")) {
                    gotSQLExc = true;
                }
            }
            if (!gotSQLExc) {
                System.out.println("Database did not shut down normally");
            } else {
                System.out.println("Database shut down normally");
            }
        }
    }

    //   ## DERBY EXCEPTION REPORTING CLASSES  ##
    /***     Exception reporting methods
     **      with special handling of SQLExceptions
     ***/
    static void errorPrint(Throwable e) {
        if (e instanceof SQLException) {
            SQLExceptionPrint((SQLException) e);
        } else {
            System.out.println("A non SQL error occured.");
            e.printStackTrace();
        }

    }  // END errorPrint

    //  Iterates through a stack of SQLExceptions
    static void SQLExceptionPrint(SQLException sqle) {
        while (sqle != null) {
            System.out.println("\n---SQLException Caught---\n");
            System.out.println("SQLState:   " + (sqle).getSQLState());
            System.out.println("Severity: " + (sqle).getErrorCode());
            System.out.println("Message:  " + (sqle).getMessage());
            sqle.printStackTrace();
            sqle =
                    sqle.getNextException();
        }
    }  //  END SQLExceptionPrint
    public void UpdateTotal() {
        ResultSet LedgerResult;
        Statement s;
        String TotalStr;

        TotalStr = "$0.00";
        if (connexion != null) {
            try {
                s = connexion.createStatement();
                LedgerResult = s.executeQuery("select sum(amount) from ledger");
                while (LedgerResult.next()) {
                    if (LedgerResult.getFloat(1) <= 0) {
                        Color fg = new Color(255,51,50);
                        TotalLabel.setForeground(fg);
                    } else {
                        Color fg = new Color(0, 0, 0);
                        TotalLabel.setForeground(fg);
                    }
                    TotalStr = String.format("$%12.2f", LedgerResult.getFloat(1));
                    TotalLabel.setText(TotalStr);
                }
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in AccountListTableModel getValueAt");
                e.printStackTrace();
            }
        }

    }
public  ResultSet requetSetAcount(){

    ResultSet AccountResult = null;
    Statement s;

    if (connexion != null) {
        try {
            s = connexion.createStatement();
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

}






