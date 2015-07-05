package modelo;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
public class DTOTaller {
    
    private String nombre;
    private String lugar;
    private String horario;
    private String dias;
    private int observacion;

    public DTOTaller(String nombre, String lugar, String horario, String dia, int observacion){
        this.nombre = nombre; 
        this.lugar = lugar;
        this.horario = horario;
        this.dias = dia;
        this.observacion = observacion;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public int getObservacion() {
        return observacion;
    }

    public void setObservacion(int observacion) {
        this.observacion = observacion;
    } 
}
