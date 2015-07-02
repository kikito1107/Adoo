package clases;

import conectar.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
public class Coordinador extends Usuario{
    
    Conectar obj = new Conectar();
    Connection cn = obj.conexion();
    
    /**
     * Numero interno del IPN como boleta
     */
    public String clabe_interna;
    
    /**
     * 
     * @return 
     */
    public String getClabeInterna() {
        return clabe_interna;
    }

    /**
     * 
     * @param clabe_interna 
     */
    public void setClabeInterna(String clabe_interna) {
        this.clabe_interna = clabe_interna;
    }   
    
    
    public Coordinador(){
    }
    
    /**
     * 
     * @param nombre
     * @param nickname
     * @param password
     * @param roll
     * @param clabe 
     */
    public void agregarUsuario(String nombre, String nickname, String password, String roll, String clabe, String tel, String email ){
        this.nombre = nombre;
        this.nickname = nickname;
        this.password = password;
        this.roll = roll;
        this.clabe_interna = clabe;
        
        try{
            PreparedStatement pst = cn.prepareStatement("INSERT INTO usuario (nombre, nickname, password, roll, clabe_interna) VALUES (?,?,?,?,?)");
            pst.setString(1, this.nombre);
            pst.setString(2, this.nickname);
            pst.setString(3, this.password);
            pst.setString(4, this.roll);
            pst.setString(5, this.clabe_interna);
            pst.executeUpdate();
            agregarMaestro(tel, email, this.clabe_interna, obj.obtenerUserId(this.nombre, this.nickname));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * 
     * @param password 
     */
    public void agregarMaestro(String tel, String email, String clabe, int id){
        Maestro nuevoMaestro = new Maestro();
        nuevoMaestro.setTelefono(tel);
        nuevoMaestro.setCorreo(email);
        nuevoMaestro.setClabeInterna(clabe);
        nuevoMaestro.setUsuario_id(id);
        
        String s;
        s = String.valueOf(nuevoMaestro.getUsuario_id());
        try{
            PreparedStatement pst = cn.prepareStatement("INSERT INTO maestro (telefono, correo, clabe_interna, usuario_id) VALUES (?,?,?,?)");
            pst.setString(1, nuevoMaestro.getTelefono());
            pst.setString(2, nuevoMaestro.getCorreo());
            pst.setString(3, nuevoMaestro.getClabeInterna());
            pst.setString(4, s);
            pst.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * 
     * @param maestro
     * @param nuevoMaestro 
     */
    public void reasignarMaestro(String maestro, String nuevoMaestro){}
    
    /**
     * 
     * @param maestro
     * @param nombre
     * @param lugar
     * @param horario 
     */
    public void agregarActividad(String maestro, String nombre, String lugar, String horario){}
    
    /**
     * 
     * @param nombre 
     */
    public void suspenderActividad(String nombre){}
    
    /**
     * 
     * @param alumno 
     */
    public void generarComprobante(String alumno){}
    
}
