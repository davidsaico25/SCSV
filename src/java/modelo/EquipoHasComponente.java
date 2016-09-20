package modelo;
// Generated Nov 19, 2015 3:42:42 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * EquipoHasComponente generated by hbm2java
 */
public class EquipoHasComponente  implements java.io.Serializable {


     private EquipoHasComponenteId id;
     private Componente componente;
     private Equipo equipo;
     private Date fechaAsignacion;

    public EquipoHasComponente() {
    }

    public EquipoHasComponente(EquipoHasComponenteId id, Componente componente, Equipo equipo, Date fechaAsignacion) {
       this.id = id;
       this.componente = componente;
       this.equipo = equipo;
       this.fechaAsignacion = fechaAsignacion;
    }
   
    public EquipoHasComponenteId getId() {
        return this.id;
    }
    
    public void setId(EquipoHasComponenteId id) {
        this.id = id;
    }
    public Componente getComponente() {
        return this.componente;
    }
    
    public void setComponente(Componente componente) {
        this.componente = componente;
    }
    public Equipo getEquipo() {
        return this.equipo;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public Date getFechaAsignacion() {
        return this.fechaAsignacion;
    }
    
    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }




}

