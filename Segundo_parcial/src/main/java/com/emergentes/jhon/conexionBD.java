
package com.emergentes.jhon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexionBD {
    static public String driver = "com.mysql.jdbc.Driver";
    static public String url = "jbdc:mysql://localhost:8080/bd_internet";
    static public String usuario ="root";
    static public String password = "juan";
    
    protected Connection conn = null;
    
    public conexionBD(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,usuario,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("error en el driver: "+ ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al realizar la conexion: "+ ex.getMessage());
        }
        
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion: "+ex.getMessage());
        }
    }
    
}
