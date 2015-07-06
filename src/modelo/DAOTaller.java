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

/**
 *
 * @author saul
 */
public class DAOTaller {
    ConexionBD obj = new ConexionBD();
    Connection cn = obj.conexion();
    PreparedStatement pstmt;
    ResultSet rs;
   
    public void agregarTaller(DTOTaller dtoTaller, String maestro){
        int idTaller;
        int idMaestro;
        int idPeriodo = 1;
        DAOTaller daoTaller = new DAOTaller();
        try{
            pstmt = cn.prepareStatement("INSERT INTO talleres (nombre, lugar, horario, dias, observacion) VALUES (?,?,?,?,?)");
            pstmt.setString(1, dtoTaller.getNombre());
            pstmt.setString(2, dtoTaller.getLugar());
            pstmt.setString(3, dtoTaller.getHorario());
            pstmt.setString(4, dtoTaller.getDias());
            pstmt.setInt(5, dtoTaller.getObservacion());
            pstmt.executeUpdate();
            idTaller = obj.obtenerIdTaller(dtoTaller.getNombre(), dtoTaller.getLugar(), dtoTaller.getHorario());
            idMaestro = obj.obtenerIdMaestroLista(maestro);
            asignarMaestro(idTaller,idMaestro,idPeriodo);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }     
    }
    
    public void asignarMaestro(int idTaller, int idMaestro, int idPeriodo){
        try{
            JOptionPane.showMessageDialog(null, idTaller +" "+ idPeriodo +" "+ idMaestro);
            pstmt = cn.prepareStatement("INSERT INTO talleres_has_periodo (talleres_id, periodo_id, maestro_id) VALUES ("+idTaller+","+idPeriodo+","+idMaestro+")");
            //pstmt.setInt(1, idTaller);
            //pstmt.setInt(2, idMaestro);
            //pstmt.setInt(3, idPeriodo);
            pstmt.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void editarTaller(int id, String taller, String horario, String dias, String lugar, int obs){
        try {
            PreparedStatement pst = cn.prepareStatement("Update talleres SET nombre='"
                    + taller +
                    "', horario='" + horario +
                    "', dias='" + dias +
                    "', lugar='" + lugar +
                    "', observacion='" + obs + "' WHERE id = " + id
            );
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
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
            rs = st.executeQuery("SELECT talleres.nombre, talleres.horario, talleres.dias, usuario.nombre, talleres.lugar ,talleres.observacion "
                    + "           FROM talleres_has_periodo, talleres, maestro ,usuario "
                    + "           WHERE talleres_has_periodo.talleres_id = talleres.id and talleres_has_periodo.maestro_id = maestro.id and maestro.usuario_id = usuario.id");
            while(rs.next()){
                num++;
                String numero = String.valueOf(num);
                int tipo = Integer.valueOf(rs.getString(6));
                datosTalleres[0] = numero ;
                datosTalleres[1] = rs.getString(1);
                datosTalleres[2] = rs.getString(2);
                datosTalleres[3] = rs.getString(3);
                datosTalleres[4] = rs.getString(4);
                datosTalleres[5] = rs.getString(5);
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
}
