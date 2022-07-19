
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author titi_
 */
public class Persistencia {
    
    private Connection connect;
    private ResultSet result;
    private PreparedStatement prepared;
    //private ResultSetMetaData resultMeta;
    
    public String servidor, basededatos, usuario, clave, ejecutar;
    
    public Connection conectarse() throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            servidor = "localhost:3306/";
            basededatos = "proyecto cac 2022 java montiel";
            usuario = "root";
            clave = "";
            
            connect=DriverManager.getConnection("jdbc:mysql://" + servidor + basededatos + "?autoReconne=true&useSSL=false", usuario, clave);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connect;
    }
    
    public ResultSet consultaSQL(String busqueda){
        try {
            prepared = conectarse().prepareStatement(busqueda);
            result = prepared.executeQuery();
            //resultMeta = result.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }    
    return result;
    }
}
