/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author enriqueramirezgonzalez
 */
public class conexion {
    /**
     * Creacion de la conección
     */
    Connection Db = null;
    
    /**
     * Estado de la respuesta
     */
    Statement DataRequest;
    
    /**
     * Lo que regresa las sentencias de mysql
     */
    ResultSet Resultado;
    /**
     * Ruta de conecicon a base de datos
     */
    String url = "jdbc:mysql://127.0.0.1:8888/db_gestionElectiva";
    
    /**
     * usuario de la base de datos
     */
    String usuario = "saul";
    
    /**
     * Contraseña del usuario de la base de datos
     */
    String password = "123456";
    
    /**
     * Método para crear la conección a base de datos
     * @return 
     */
    public boolean Conexion(){
        boolean a = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Db = (Connection) DriverManager.getConnection(url, usuario, password);
            a = true;
        }catch(ClassNotFoundException error){
            System.err.println("No se puede conectara a la base de datos" + error);
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, "Error en la contraseña");
        }
        return a;
    }
    
    public int buscarUsuario(String user, String pass){
        int b = 0;
        
        try{
            DataRequest = (Statement) Db.createStatement();
            Resultado = DataRequest.executeQuery("Select * from usuarios where nickname = '" + user + "' and password = md5('" + pass + "');");
            while(Resultado.next()){
                b++;
            }
        }catch(SQLException ex){
            System.out.println(ex + "buscaUsuarios");
        }
        
        return b;
    }
}
