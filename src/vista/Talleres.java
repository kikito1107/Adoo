/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author enriqueramirez
 */
@Entity
@Table(name = "Talleres", catalog = "db_gestionElectiva", schema = "")
@NamedQueries({
    @NamedQuery(name = "Talleres.findAll", query = "SELECT t FROM Talleres t"),
    @NamedQuery(name = "Talleres.findById", query = "SELECT t FROM Talleres t WHERE t.id = :id"),
    @NamedQuery(name = "Talleres.findByNombre", query = "SELECT t FROM Talleres t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Talleres.findByLugar", query = "SELECT t FROM Talleres t WHERE t.lugar = :lugar"),
    @NamedQuery(name = "Talleres.findByHorario", query = "SELECT t FROM Talleres t WHERE t.horario = :horario")})
public class Talleres implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "horario")
    private String horario;

    public Talleres() {
    }

    public Talleres(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        String oldLugar = this.lugar;
        this.lugar = lugar;
        changeSupport.firePropertyChange("lugar", oldLugar, lugar);
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        String oldHorario = this.horario;
        this.horario = horario;
        changeSupport.firePropertyChange("horario", oldHorario, horario);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talleres)) {
            return false;
        }
        Talleres other = (Talleres) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "interfaces.Talleres[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
