/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Joel
 */
public class ConSQL {
    static ConSQL instance=null;
    Connection connection;

    public ConSQL()throws Exception{
        String url="jdbc:sqlserver://EQUIPO-JOEL\\SQLEXPRESS:1433;databaseName=testlogindb;user=sa;password=123";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection=DriverManager.getConnection(url);
    }

    public static ConSQL getInstance() throws Exception{
        if (instance==null) {
            instance=new ConSQL();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    protected void finalize() throws Throwable {
        if (!connection.isClosed()) {
            connection.close();
            connection=null;
        }
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
