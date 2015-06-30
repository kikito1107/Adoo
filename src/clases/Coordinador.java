package clases;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
public class Coordinador extends Usuario{
     
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
     * @param usuario
     * @param password 
     */
    public void agregarMaestro(String nombre, String usuario, String password){}
    
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
