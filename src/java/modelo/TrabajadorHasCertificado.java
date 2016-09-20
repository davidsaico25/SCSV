package modelo;
// Generated Nov 19, 2015 3:42:42 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * TrabajadorHasCertificado generated by hbm2java
 */
public class TrabajadorHasCertificado  implements java.io.Serializable {


     private TrabajadorHasCertificadoId id;
     private Certificado certificado;
     private Trabajador trabajador;
     private Date fechaAsignacion;

    public TrabajadorHasCertificado() {
    }

    public TrabajadorHasCertificado(TrabajadorHasCertificadoId id, Certificado certificado, Trabajador trabajador, Date fechaAsignacion) {
       this.id = id;
       this.certificado = certificado;
       this.trabajador = trabajador;
       this.fechaAsignacion = fechaAsignacion;
    }
   
    public TrabajadorHasCertificadoId getId() {
        return this.id;
    }
    
    public void setId(TrabajadorHasCertificadoId id) {
        this.id = id;
    }
    public Certificado getCertificado() {
        return this.certificado;
    }
    
    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }
    public Trabajador getTrabajador() {
        return this.trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    public Date getFechaAsignacion() {
        return this.fechaAsignacion;
    }
    
    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }




}


