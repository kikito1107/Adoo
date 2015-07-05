/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author enriqueramirezgonzalez
 */
public class ConexionBD {
    Connection Db = null;
    Statement DataRequest;
    ResultSet Resultado;
    
    String nombreBD="db_gestionElectiva";
    String contrasena="123456";
    String usuario1 ="saul";
    String ruta="localhost";
    String server = "jdbc:mysql://"+ ruta +"/"+ nombreBD;
    
    public Connection conexion(){
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
    
    public int obtenerRoll(String roll){
        int c = 0;
        if(roll.equalsIgnoreCase("admin")){
            c = 1;
        }if(roll.equals("maestro")){
            c = 2;
        }
        return c;
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
    
    public int obtenerIdTaller(String nombre, String lugar, String horario) {
        int id = 0;
        try{
            DataRequest = Db.createStatement();
            Resultado = DataRequest.executeQuery("Select id from talleres where nombre = '"+nombre+"' and lugar = '"+lugar+"' and horario = '"+horario+"';");
            while(Resultado.next()){
                id = Resultado.getInt(1);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return id;
    }
    
    public DefaultComboBoxModel listMaestros(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try{
            DataRequest = Db.createStatement();
            Resultado = DataRequest.executeQuery("Select nombre from usuario, maestro where maestro.usuario_id = usuario.id");
            while(Resultado.next()){
                model.addElement(Resultado.getString(1));
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return model;
    }

    public int obtenerIdMaestroLista(String nombre) {
        Statement DataRequest1;
        int id = 0;
        try{
            DataRequest = Db.createStatement();
            Resultado = DataRequest.executeQuery("Select id, nombre from usuario where nombre = '" + nombre + "';");
            while(Resultado.next()){
                DataRequest1 = Db.createStatement();
                ResultSet Resultado1;
                Resultado1 = DataRequest1.executeQuery("Select id from maestro where usuario_id = '" + Resultado.getInt(1) + "';");
                while(Resultado1.next()){
                    id = Resultado1.getInt(1);
                }
            }
        }catch(SQLException ex){
            System.out.println(ex + "buscaUsuarios");
        }
        return id; 
    }
}
