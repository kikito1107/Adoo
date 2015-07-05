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
public class DAOTaller {
    ConexionBD obj = new ConexionBD();
    Connection cn = obj.conexion();
    
    
    public DefaultTableModel mostrarTalleres(){
        // Inicializamos la tabla de Talleres
        DefaultTableModel modeloTalleres = new DefaultTableModel();
        modeloTalleres.addColumn("#");
        modeloTalleres.addColumn("Taller");
        modeloTalleres.addColumn("Horario");
        modeloTalleres.addColumn("Dias");
        modeloTalleres.addColumn("Profesor");
        modeloTalleres.addColumn("Lugar");
        modeloTalleres.addColumn("Observación");
        
        String []datosTalleres = new String [8];
        int num = 0;
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM talleres");
            while(rs.next()){
                num++;
                String numero = String.valueOf(num);
                int tipo = Integer.valueOf(rs.getString(6));
                datosTalleres[0] = numero ;
                datosTalleres[1] = rs.getString(2);
                datosTalleres[2] = rs.getString(4);
                datosTalleres[3] = rs.getString(5);
                datosTalleres[4] = "aun no";//rs.getString(3);
                datosTalleres[5] = rs.getString(3);
                if(tipo == 1){
                    datosTalleres[6] = "Electiva";
                }else{
                    datosTalleres[6] = " ";
                }
                modeloTalleres.addRow(datosTalleres);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return modeloTalleres;
    }
    
    /*public void editarTaller(String numero, String taller, String horario, String dias, String profesor, String lugar, String observacion){
    try {
        PreparedStatement pst = cn.prepareStatement("Update talleres SET nombre='"
                + taller +
                "', horario='" + horario +
                "', dias='" + dias +
                "', lugar='" + lugar +
                "', observacion='" + obs + "' WHERE id = " + tablaTalleresEditable.getValueAt(0,0)
        );
        pst.executeUpdate();

    } catch (SQLException ex) {
        Logger.getLogger(IGCoordinador.class.getName()).log(Level.SEVERE, null, ex);
    }*/
}
