/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOClienteNatural;
import dao.DAODireccion;
import dao.DAOEmpresa;
import dao.DAOFactura;
import dao.DAOIncidencia;
import dao.DAOLocation;
import dao.DAOParte;
import dao.DAOParteEnviada;
import dao.DAOSlaIncidencia;
import dao.DAOTipoIncidencia;
import dao.DAOTrabajador;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.ClienteNatural;
import modelo.DetalleFactura;
import modelo.Direccion;
import modelo.Distrito;
import modelo.Empresa;
import modelo.Equipo;
import modelo.Factura;
import modelo.Incidencia;
import modelo.Location;
import modelo.Parte;
import modelo.ParteEnviada;
import modelo.SlaIncidencia;
import modelo.TipoIncidencia;
import modelo.Trabajador;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author David
 */
@ManagedBean
@ViewScoped
public class IncidenciaRegistroBean implements Serializable {

    private Incidencia incidencia;
    
    private Factura factura;
    
    private Equipo equipo;
    
    private Location location;
    
    private Direccion direccion;
    private Direccion direccionAtencion;
    
    private Distrito distrito;
    private Distrito distritoAtencion;
    
    private ClienteNatural clienteNatural;
    private Empresa empresa;
    
    private Trabajador selectedTrabajador;
    
    private TipoIncidencia tipoIncidencia;
    private List<TipoIncidencia> listTipoIncidencia;
    
    private SlaIncidencia slaIncidencia;
    private List<SlaIncidencia> listSlaIncidencia;
    
    private List<DetalleFactura> listDetalleFactura;
    private List<DetalleFactura> listFiltradoDetalleFactura;
    
    private List<Parte> listParte;
    private List<Parte> listSelectedParte;

    private DetalleFactura detalleFactura;
    private DetalleFactura selectedDetalleFactura;
    
    private ParteEnviada parteEnviada;
    
    private DAOIncidencia daoIncidencia;
    private DAOLocation daoLocation;
    private DAODireccion daoDireccion;
    private DAOClienteNatural daoClienteNatural;
    private DAOEmpresa daoEmpresa;
    private DAOTrabajador daoTrabajador;
    private DAOTipoIncidencia daoTipoIncidencia;
    private DAOSlaIncidencia daoSlaIncidencia;
    private DAOParte daoParte;
    private DAOParteEnviada daoParteEnviada;
    private DAOFactura daoFactura;
    
    private Date date;

    private boolean skip;

    public IncidenciaRegistroBean() {
        incidencia = new Incidencia();
        tipoIncidencia = new TipoIncidencia();
        slaIncidencia = new SlaIncidencia();
        direccion = new Direccion();
        direccionAtencion = new Direccion();
        distrito = new Distrito();
        distritoAtencion = new Distrito();
        
        factura = new Factura();
        
        daoIncidencia = new DAOIncidencia();
    }

    public void crearIncidencia() {
        if(incidencia.getNombreContacto().isEmpty()) {
            incidencia.setNombreContacto(null);
        }
        if(direccionAtencion.getDetalleDireccion().isEmpty()) {
            incidencia.setDireccion(direccion);
        } else {
            daoDireccion = new DAODireccion();
            direccionAtencion.setDistrito(distritoAtencion);
            daoDireccion.crear(direccionAtencion);
            incidencia.setDireccion(direccionAtencion);
        }
        incidencia.setFechaRegistro(new Date());
        incidencia.setFechaAsignacion(null);
        incidencia.setFechaCierre(null);
        incidencia.setEstado("open");
        incidencia.setEquipo(equipo);
        incidencia.setTipoIncidencia(tipoIncidencia);
        incidencia.setSlaIncidencia(slaIncidencia);
        incidencia.setTrabajador(null);
        daoIncidencia.crear(incidencia);
        daoParteEnviada = new DAOParteEnviada();
        for (Parte listSelectedParteItem : listSelectedParte) {
            parteEnviada = new ParteEnviada();
            parteEnviada.setEstado("nuevo");
            parteEnviada.setDps(incidencia.getDps());
            parteEnviada.setFechaEnvio(null);
            parteEnviada.setIncidencia(incidencia);
            parteEnviada.setParte(listSelectedParteItem);
            daoParteEnviada.crear(parteEnviada);
        }
        listSelectedParte.clear();
    }
    
    public void consultarFactura() {
        daoFactura = new DAOFactura();
        daoDireccion = new DAODireccion();
        factura = daoFactura.getFactura(factura);
        if (factura == null) {
            factura = new Factura();
            location = null;
            listDetalleFactura = null;
            listFiltradoDetalleFactura = null;
            listParte = null;
            listSelectedParte = null;
            return;
        }
        location = daoFactura.getLocationFromFactura(factura);
        listDetalleFactura = daoFactura.getListDetalleFactura(factura);
        if (location.getCodLocation().length() == 8) {
            clienteNatural = daoFactura.getClienteNaturalFromFactura(location);
            direccion = daoDireccion.getDireccionFromClienteNatural(clienteNatural);
        } else if (location.getCodLocation().length() == 11) {
            empresa = daoFactura.getEmpresaFromFactura(location);
            direccion = daoDireccion.getDireccionFromEmpresa(empresa);
        }
    }
    
    public void onRowFromTableDetalleFacturaSelect(SelectEvent event) {
        daoParte = new DAOParte();
        selectedDetalleFactura = (DetalleFactura) event.getObject();
        equipo = selectedDetalleFactura.getEquipo();
        listParte = daoParte.getListParteForEquipo(equipo);
        FacesMessage msg = new FacesMessage("Equipo Selected", equipo.getNumeroSerie());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowFromTableDetalleFacturaUnselect(UnselectEvent event) {
        daoParte = null;
        selectedDetalleFactura = null;
        equipo = null;
        listParte = null;
        FacesMessage msg = new FacesMessage("Equipo Unselected", equipo.getNumeroSerie());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }

    public Trabajador getSelectedTrabajador() {
        return selectedTrabajador;
    }

    public void setSelectedTrabajador(Trabajador selectedTrabajador) {
        this.selectedTrabajador = selectedTrabajador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public TipoIncidencia getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(TipoIncidencia tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public SlaIncidencia getSlaIncidencia() {
        return slaIncidencia;
    }

    public void setSlaIncidencia(SlaIncidencia slaIncidencia) {
        this.slaIncidencia = slaIncidencia;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Direccion getDireccionAtencion() {
        return direccionAtencion;
    }

    public void setDireccionAtencion(Direccion direccionAtencion) {
        this.direccionAtencion = direccionAtencion;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Distrito getDistritoAtencion() {
        return distritoAtencion;
    }

    public void setDistritoAtencion(Distrito distritoAtencion) {
        this.distritoAtencion = distritoAtencion;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ClienteNatural getClienteNatural() {
        return clienteNatural;
    }

    public void setClienteNatural(ClienteNatural clienteNatural) {
        this.clienteNatural = clienteNatural;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<DetalleFactura> getListDetalleFactura() {
        return listDetalleFactura;
    }

    public void setListDetalleFactura(List<DetalleFactura> listDetalleFactura) {
        this.listDetalleFactura = listDetalleFactura;
    }

    public List<DetalleFactura> getListFiltradoDetalleFactura() {
        return listFiltradoDetalleFactura;
    }

    public void setListFiltradoDetalleFactura(List<DetalleFactura> listFiltradoDetalleFactura) {
        this.listFiltradoDetalleFactura = listFiltradoDetalleFactura;
    }

    public List<Parte> getListParte() {
        return listParte;
    }

    public void setListParte(List<Parte> listParte) {
        this.listParte = listParte;
    }

    public List<TipoIncidencia> getListTipoIncidencia() {
        daoTipoIncidencia = new DAOTipoIncidencia();
        listTipoIncidencia = daoTipoIncidencia.getListTipoIncidencia();
        return listTipoIncidencia;
    }

    public void setListTipoIncidencia(List<TipoIncidencia> listTipoIncidencia) {
        this.listTipoIncidencia = listTipoIncidencia;
    }

    public List<SlaIncidencia> getListSlaIncidencia() {
        daoSlaIncidencia = new DAOSlaIncidencia();
        listSlaIncidencia = daoSlaIncidencia.getListSlaIncidencia();
        return listSlaIncidencia;
    }

    public void setListSlaIncidencia(List<SlaIncidencia> listSlaIncidencia) {
        this.listSlaIncidencia = listSlaIncidencia;
    }

    public List<Parte> getListSelectedParte() {
        return listSelectedParte;
    }

    public void setListSelectedParte(List<Parte> listSelectedParte) {
        this.listSelectedParte = listSelectedParte;
    }

    public DetalleFactura getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }
    
    public DetalleFactura getSelectedDetalleFactura() {
        return selectedDetalleFactura;
    }

    public void setSelectedDetalleFactura(DetalleFactura selectedDetalleFactura) {
        this.selectedDetalleFactura = selectedDetalleFactura;
    }

    public ParteEnviada getParteEnviada() {
        return parteEnviada;
    }

    public void setParteEnviada(ParteEnviada parteEnviada) {
        this.parteEnviada = parteEnviada;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "incidencia";
        } else {
            return event.getNewStep();
        }
    }

    public Date getDate() {
        date = new Date();
        return date;
    }
}