package edu.eci.cosw.cheapestPrice.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.boot.test.SpringApplicationConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by daniela on 14/03/17.
 */

@SpringApplicationConfiguration
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
