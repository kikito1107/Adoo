package modelo;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
public class Maestro extends Usuario{

    /**
     * Telefono de contacto al maestro
     */
    public String telefono;
    
    /**
     * Correo de contacto del maestro
     */
    public String correo;
    
    /**
     * Numero interno del IPN como boleta
     */
    public String clabe_interna;

    /**
     * 
     */
    public int usuario_id;

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    
    /**
     * 
     * @param telefono
     * @param correo
     * @param clabe_interna 
     */
    public Maestro(String telefono, String correo, String clabe_interna) {
        this.telefono = telefono;
        this.correo = correo;
        this.clabe_interna = clabe_interna;
    }
    
    /**
     * 
     * @return 
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * 
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
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
    
    /**
     * 
     * @return 
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * 
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public Maestro() {
    }
    
    /**
     * 
     * @param nombre
     * @param boleta
     * @param escuela
     * @param horas 
     */
    public void agregarAlumno(String nombre, int boleta, String escuela, int horas){
        //Alumno alumno = Alumno();
        //alumno.nombre = nombre;
        //alumno.boleta = boleta;
        //alumno.escuela = escuela;
        //alumno.horas = alumno.horas + horas;
    }
    
    //Método a contemplar
    public void eliminarAlumno(String nombre, int boleta){}
    
    /**
     * 
     * @param alumno
     * @param horas 
     */
    public void agregarHoras(String alumno, int horas){}
    
    /**
     * 
     * @param nombre
     * @param boleta 
     */
    public void liberarHorasAlumno(String nombre, int boleta){}

    private void conection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
