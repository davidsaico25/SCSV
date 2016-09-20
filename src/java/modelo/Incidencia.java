package modelo;
// Generated Nov 19, 2015 3:42:42 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Incidencia generated by hbm2java
 */
public class Incidencia  implements java.io.Serializable {


     private Integer codIncidencia;
     private Direccion direccion;
     private Equipo equipo;
     private SlaIncidencia slaIncidencia;
     private TipoIncidencia tipoIncidencia;
     private Trabajador trabajador;
     private String srms;
     private String dps;
     private String nombreIncidencia;
     private Date fechaRegistro;
     private Date fechaAsignacion;
     private Date fechaCierre;
     private String descripcion;
     private String nombreContacto;
     private String estado;
     private String prioridad;
     private Set<ParteEnviada> parteEnviadas = new HashSet<ParteEnviada>(0);
     private Set<ParteDevuelta> parteDevueltas = new HashSet<ParteDevuelta>(0);
     private Set<Nota> notas = new HashSet<Nota>(0);
     private Set<IncidenciaHasEstado> incidenciaHasEstados = new HashSet<IncidenciaHasEstado>(0);

    public Incidencia() {
    }

	
    public Incidencia(Equipo equipo, SlaIncidencia slaIncidencia, TipoIncidencia tipoIncidencia, String srms, String dps, String nombreIncidencia, Date fechaRegistro, String descripcion, String estado, String prioridad) {
        this.equipo = equipo;
        this.slaIncidencia = slaIncidencia;
        this.tipoIncidencia = tipoIncidencia;
        this.srms = srms;
        this.dps = dps;
        this.nombreIncidencia = nombreIncidencia;
        this.fechaRegistro = fechaRegistro;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
    }
    public Incidencia(Direccion direccion, Equipo equipo, SlaIncidencia slaIncidencia, TipoIncidencia tipoIncidencia, Trabajador trabajador, String srms, String dps, String nombreIncidencia, Date fechaRegistro, Date fechaAsignacion, Date fechaCierre, String descripcion, String nombreContacto, String estado, String prioridad, Set<ParteEnviada> parteEnviadas, Set<ParteDevuelta> parteDevueltas, Set<Nota> notas, Set<IncidenciaHasEstado> incidenciaHasEstados) {
       this.direccion = direccion;
       this.equipo = equipo;
       this.slaIncidencia = slaIncidencia;
       this.tipoIncidencia = tipoIncidencia;
       this.trabajador = trabajador;
       this.srms = srms;
       this.dps = dps;
       this.nombreIncidencia = nombreIncidencia;
       this.fechaRegistro = fechaRegistro;
       this.fechaAsignacion = fechaAsignacion;
       this.fechaCierre = fechaCierre;
       this.descripcion = descripcion;
       this.nombreContacto = nombreContacto;
       this.estado = estado;
       this.prioridad = prioridad;
       this.parteEnviadas = parteEnviadas;
       this.parteDevueltas = parteDevueltas;
       this.notas = notas;
       this.incidenciaHasEstados = incidenciaHasEstados;
    }
   
    public Integer getCodIncidencia() {
        return this.codIncidencia;
    }
    
    public void setCodIncidencia(Integer codIncidencia) {
        this.codIncidencia = codIncidencia;
    }
    public Direccion getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public Equipo getEquipo() {
        return this.equipo;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public SlaIncidencia getSlaIncidencia() {
        return this.slaIncidencia;
    }
    
    public void setSlaIncidencia(SlaIncidencia slaIncidencia) {
        this.slaIncidencia = slaIncidencia;
    }
    public TipoIncidencia getTipoIncidencia() {
        return this.tipoIncidencia;
    }
    
    public void setTipoIncidencia(TipoIncidencia tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }
    public Trabajador getTrabajador() {
        return this.trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    public String getSrms() {
        return this.srms;
    }
    
    public void setSrms(String srms) {
        this.srms = srms;
    }
    public String getDps() {
        return this.dps;
    }
    
    public void setDps(String dps) {
        this.dps = dps;
    }
    public String getNombreIncidencia() {
        return this.nombreIncidencia;
    }
    
    public void setNombreIncidencia(String nombreIncidencia) {
        this.nombreIncidencia = nombreIncidencia;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Date getFechaAsignacion() {
        return this.fechaAsignacion;
    }
    
    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
    public Date getFechaCierre() {
        return this.fechaCierre;
    }
    
    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNombreContacto() {
        return this.nombreContacto;
    }
    
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getPrioridad() {
        return this.prioridad;
    }
    
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    public Set<ParteEnviada> getParteEnviadas() {
        return this.parteEnviadas;
    }
    
    public void setParteEnviadas(Set<ParteEnviada> parteEnviadas) {
        this.parteEnviadas = parteEnviadas;
    }
    public Set<ParteDevuelta> getParteDevueltas() {
        return this.parteDevueltas;
    }
    
    public void setParteDevueltas(Set<ParteDevuelta> parteDevueltas) {
        this.parteDevueltas = parteDevueltas;
    }
    public Set<Nota> getNotas() {
        return this.notas;
    }
    
    public void setNotas(Set<Nota> notas) {
        this.notas = notas;
    }
    public Set<IncidenciaHasEstado> getIncidenciaHasEstados() {
        return this.incidenciaHasEstados;
    }
    
    public void setIncidenciaHasEstados(Set<IncidenciaHasEstado> incidenciaHasEstados) {
        this.incidenciaHasEstados = incidenciaHasEstados;
    }




}


