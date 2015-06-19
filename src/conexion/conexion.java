/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.*;
    

/**
 *
 * @author enriqueramirezgonzalez
 */
public class conexion {
    private static Connection conexion;
    private static final String bd="db_gestionElectiva";
    private static final String user="saul";
    private static final String password="123456";
    private static final String host="localhost";
    private static final String server="jdbc:mysql://"+host+"/"+bd;
    
     public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(server,user,password);
            System.out.println("Conexión a base de datos " + server + " ... OK");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando el Driver MySQL JDBC ... FAIL");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Imposible realizar conexion con " + server + " ... FAIL");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //realizar consulta
        try {
            // Preparamos la consulta
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery ("select * from usuarios");
            // Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
            while (rs.next()){
                System.out.println(rs);
            }
        } catch (SQLException ex) {
            System.out.println("Imposible realizar consulta ... FAIL");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //desconectar
        try {
            conexion.close();
            System.out.println("Cerrar conexion con "+server+" ... OK");
        } catch (SQLException ex) {
            System.out.println("Imposible cerrar conexion ... FAIL");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
