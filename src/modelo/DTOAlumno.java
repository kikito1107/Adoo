package modelo;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
public class DTOAlumno {

    private String nombre;
    
    private String boleta;
    
    private int horas;
    
    private String escuela;
    
    public DTOAlumno(String nombre, String boleta, String escuela){
        this.nombre = nombre;
        this.boleta = boleta;
        this.escuela = escuela;
        this.horas = 0;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }
    
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
}
