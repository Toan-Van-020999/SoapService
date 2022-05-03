package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class JDBCConnection {
    protected static Connection con;
     
    public JDBCConnection(){
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost/musicdb?useUnicode=true&characterEncoding=utf8";
            String dbClass = "com.mysql.jdbc.Driver";
            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection (dbUrl, "root", "");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
 }


