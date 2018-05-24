/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Valentin
 */
public class DbConn implements AutoCloseable{
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DB_NAME = "componentadb";
    
    public Connection conn;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException
    {
        if(conn == null)
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, USERNAME, PASSWORD);
        }
        return conn;
    }
    
    @Override
    public void close() throws Exception
    {
        if(conn != null)
        {
            conn.close();
        }
    }
}

