package gestionelectiva;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
public class Actividad {
    
    public String nombre;
    
    public Maestro encargado;
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
