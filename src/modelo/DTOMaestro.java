package modelo;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
public class DTOMaestro extends Usuario{

    private String telefono;
    private String correo;
    private String clave;
    
    public DTOMaestro(String nombre, String nickname, String password, String rol, String telefono, String correo, String clave) {
        super(nombre, nickname, password, rol);
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
