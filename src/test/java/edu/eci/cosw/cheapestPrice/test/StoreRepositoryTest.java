package edu.eci.cosw.cheapestPrice.test;

import edu.eci.cosw.cheapestPrice.CheapestPriceApplication;
import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Daniela on 14/03/17.
 */

public class StoreRepositoryTest {

    public StoreRepositoryTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb2;MODE=MYSQL", "anonymous", "");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from TIENDAS");
        conn.commit();
    }

}
