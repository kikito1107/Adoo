/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author enriqueramirezgonzalez
 */
public class Conectar {
    Connection Db = null;
    Statement DataRequest;
    ResultSet Resultado;
    
    String nombreBD="db_gestionElectiva";
    String contrasena="123456";
    String usuario1 ="saul";
    String ruta="localhost";
    String server = "jdbc:mysql://"+ ruta +"/"+ nombreBD;
    
    /**
     * Método para crear la conección a base de datos
     * @return 
     */
    /*public boolean Conexion(){
        boolean a = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Db = (Connection) DriverManager.getConnection(server , usuario1, contrasena);
            a = true;
        }catch(ClassNotFoundException error){
            JOptionPane.showMessageDialog(null, "Error en la conexion" + error);
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, "Error en el acceso a la base\n" +"\n"+ error.getCause() +"\n"+ error.getMessage() +"\n" + error.getSuppressed());
        }
        return a;
    }*/
    
    public Connection conexion(){
        //Connection Db = null;
        boolean a = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Db = (Connection) DriverManager.getConnection(server , usuario1, contrasena);
            a = true;
        }catch(ClassNotFoundException error){
            JOptionPane.showMessageDialog(null, "Error en la conexion" + error);
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, "Error en el acceso a la base\n" +"\n"+ error.getCause() +"\n"+ error.getMessage() +"\n" + error.getSuppressed());
        }
        return Db;
    }
    
    public int buscarUsuario(String user, String pass){
        int b = 0;
        int roll = 0;
        
        try{
            DataRequest = Db.createStatement();
            Resultado = DataRequest.executeQuery("Select * from usuario where nickname = '" + user + "' and password = '" + pass + "';");
            while(Resultado.next()){
                b++;
                roll = obtenerRoll( Resultado.getString("roll"));
            }
        }catch(SQLException ex){
            System.out.println(ex + "buscaUsuarios");
        }
        
        return b + roll; 
        //return c;
    }
     
    public int obtenerUserId(String nombre, String nickname){
        int id = 0;
        try{
            DataRequest = Db.createStatement();
            Resultado = DataRequest.executeQuery("Select id from usuario where nickname = '" + nickname + "' and nombre = '" + nombre + "';");
            while(Resultado.next()){
                String id_user = Resultado.getString(1);
                id = Integer.valueOf(id_user);
            }
        }catch(SQLException ex){
            System.out.println(ex + "buscaUsuarios");
        }
        
        return id; 
    }
    
    public Object mostrarTalleres(){
        try{
            DataRequest = (Statement) Db.createStatement();
            Resultado = DataRequest.executeQuery("Select * from talleres");
            ResultSetMetaData Result = Resultado.getMetaData();
            int col = Result.getColumnCount();
            DefaultTableModel modeloTalleres = new DefaultTableModel();
            while(Resultado.next()){
                String fila[] = new String[col];
                for(int i = 0; i<col; i++){
                    fila[i] = Resultado.getString(i+1);
                    modeloTalleres.addRow(fila);
                }
            }
        }catch(SQLException ex){
            System.out.println(ex + "mostrarTalleres");
        }
        return null;
    }
    
    /**
     * Asignar un valor int a val
     * @param roll
     * @return 
     */
    public int obtenerRoll(String roll){
        int c = 0;
        if(roll.equalsIgnoreCase("admin")){
            c = 1;
        }if(roll.equals("maestro")){
            c = 2;
        }
        return c;
    }
}
