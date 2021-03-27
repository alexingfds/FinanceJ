package ca.etsmtl.log240.financej;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

public class CategoryDaoTest {
    @Test

    public void  testConnection(){
        //test connexion
        Connection  conn =null;
        conn =DerbyUtils.getInstance().getConnexion();
        assertNotNull(conn);
    }
}
