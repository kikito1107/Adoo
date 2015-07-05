package modelo;

import controlador.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
public class Coordinador extends Usuario{
    ConexionBD obj = new ConexionBD();
    Connection cn = obj.conexion();
    
    private String clave;
    
    public Coordinador(String nombre, String nickname, String password, String rol, String clave) {
        super(nombre, nickname, password, rol);
        this.clave = clave;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
