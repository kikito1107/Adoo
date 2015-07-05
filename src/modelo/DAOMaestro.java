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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DTOMaestro;
/**
 *
 * @author saul
 */
public class DAOMaestro {
    ConexionBD obj = new ConexionBD();
    Connection cn = obj.conexion();
    PreparedStatement pstmt;
    ResultSet rs;
    DTOMaestro maestro;
    
    public void agregarUsuario(DTOMaestro maestro) {
        try{
            pstmt = cn.prepareStatement("INSERT INTO usuario (nombre, nickname, password, roll, clabe_interna) VALUES (?,?,?,?,?)");
            pstmt.setString(1, maestro.getNombre());
            pstmt.setString(2, maestro.getNickname());
            pstmt.setString(3, maestro.getPassword());
            pstmt.setString(4, maestro.getRol());
            pstmt.setString(5, maestro.getClave());
            pstmt.executeUpdate();
            agregarMaestro(maestro.getTelefono(), maestro.getCorreo(), maestro.getClave(), obj.obtenerUserId(maestro.getNombre(), maestro.getNickname()));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getCause());
        }
    }
    
    public void agregarMaestro(String tel, String email, String clave, int id){
        try{
            pstmt = cn.prepareStatement("INSERT INTO maestro (telefono, correo, clabe_interna ,usuario_id) VALUES (?,?,?,?)");
            pstmt.setString(1, tel);
            pstmt.setString(2, email);
            pstmt.setString(3, clave);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public DefaultTableModel mostrarMaestros(){
        // Inicializamos la tabla de maestros
        DefaultTableModel modeloMaestros = new DefaultTableModel();
        modeloMaestros.addColumn("#");
        modeloMaestros.addColumn("Nombre");
        modeloMaestros.addColumn("Télefono");
        modeloMaestros.addColumn("Correo");
        
        String []datosMaestros = new String [5];
        int num = 0;
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre, telefono, correo FROM maestro, usuario where usuario.id = maestro.usuario_id");
            while(rs.next()){
                num++;
                String numero = String.valueOf(num);
                datosMaestros[0] = numero;
                datosMaestros[1] = rs.getString(1);
                datosMaestros[2] = rs.getString(2);
                datosMaestros[3] = rs.getString(3);
                modeloMaestros.addRow(datosMaestros);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return modeloMaestros;
    }

    public void showM() {
        JOptionPane.showMessageDialog(null, "hola"); //To change body of generated methods, choose Tools | Templates.
    }
}
