/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import java.sql.SQLException;
import java.sql.Statement;
import lab10.DbConn;

/**
 *
 * @author Iuliana
 */
public class Crud implements AutoCloseable {

    protected final DbConn dbConn = new DbConn();
    protected final Statement stmt;

    public Crud() throws SQLException, ClassNotFoundException {
        stmt = dbConn.getConnection().createStatement();
    }

    @Override
    public void close() throws Exception {
        if (stmt != null) {
            stmt.close();
        }
        dbConn.close();
    }
}
