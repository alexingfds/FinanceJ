package ca.etsmtl.log240.financej;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
public class AccountDaoTest {

    @Test

    public void  testConnection(){
        Connection  conn =null;
         conn =DerbyUtils.getInstance().getConnexion();
        assertNotNull(conn);
    }
}
