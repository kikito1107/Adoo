package gestionelectiva;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
public class Alumno {

    public String nombre;
    
    public String boleta;
    
    public String fecha_inicio;
    
    public String fecha_fin;
    
    public double horas;
    
    public Actividad actividad;
    
    public Maestro encargado;
    //public int edad;
    public String escuela = "Escuela Superior de Turismo";
    
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

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Maestro getEncargado() {
        return encargado;
    }

    public void setEncargado(Maestro encargado) {
        this.encargado = encargado;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
}
