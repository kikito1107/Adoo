/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saul
 */
public class DAOAlumno {
    ConexionBD obj = new ConexionBD();
    Connection cn = obj.conexion();
    PreparedStatement pstmt;
    ResultSet rs;
    
    public void altaAlumno(String nombre, String boleta, String escuela, int idTaller){
        try{
            pstmt = cn.prepareStatement("INSERT INTO alumno (nombre, boleta, escuela, horas, talleres_id) VALUES (?,?,?,?,?)");
            pstmt.setString(1, nombre);
            pstmt.setString(2, boleta);
            pstmt.setString(3, escuela);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, idTaller);
            pstmt.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    
    }
    
    public DefaultTableModel mostrarAlumnos(int id){
        // Inicializamos la tabla de Talleres
        DefaultTableModel modeloAlumnos = new DefaultTableModel();
        modeloAlumnos.addColumn("Nombre");
        modeloAlumnos.addColumn("Boleta");
        modeloAlumnos.addColumn("Escuela");
        modeloAlumnos.addColumn("Horas");
        
        String []datosAlumnos = new String [6];
        int num = 0;
        try{
            Statement st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM alumno where talleres_id = "+id);
            while(rs.next()){
                datosAlumnos[0] = rs.getString(2);
                datosAlumnos[1] = rs.getString(3);
                datosAlumnos[2] = rs.getString(4);
                datosAlumnos[3] = rs.getString(5);
                
                modeloAlumnos.addRow(datosAlumnos);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return modeloAlumnos;
    }
    
    
}
