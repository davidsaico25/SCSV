/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOClienteNatural;
import dao.DAOEmpresa;
import dao.DAOIncidencia;
import dao.DAOLocation;
import dao.DAOTrabajador;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.ClienteNatural;
import modelo.Empresa;
import modelo.Equipo;
import modelo.Incidencia;
import modelo.Location;
import modelo.Trabajador;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author David
 */
@ManagedBean
@ViewScoped
public class IncidenciaAsignarBean implements Serializable {

    private Incidencia selectedIncidencia;
    private List<Incidencia> listIncidencia;
    private List<Incidencia> listFiltradoIncidencia;
    
    private Trabajador selectedTrabajador;
    private List<Trabajador> listTrabajador;
    private List<Trabajador> listFiltradoTrabajador;
    
    private Location locationCliente;
    private Location locationTrabajador;
    
    private ClienteNatural clienteNatural;
    
    private Equipo equipo;
    
    private Empresa empresa;
    
    private DAOIncidencia daoIncidencia;
    private DAOTrabajador daoTrabajador;
    private DAOLocation daoLocation;
    private DAOClienteNatural daoClienteNatural;
    private DAOEmpresa daoEmpresa;
    
    public IncidenciaAsignarBean() {
        daoIncidencia = new DAOIncidencia();
        daoTrabajador = new DAOTrabajador();
        daoLocation = new DAOLocation();
        daoClienteNatural = new DAOClienteNatural();
        daoEmpresa = new DAOEmpresa();
        
        clienteNatural = new ClienteNatural();
    }
    
    public void asignarTrabajador() {
        selectedIncidencia.setFechaAsignacion(new Date());
        selectedIncidencia.setTrabajador(selectedTrabajador);
        daoIncidencia.actualizar(selectedIncidencia);
        FacesMessage msg = new FacesMessage("Incidencia Actualizada", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowFromTableListIncidenciaSelect(SelectEvent event) {
        selectedIncidencia = (Incidencia) event.getObject();
        equipo = selectedIncidencia.getEquipo();
        locationCliente = daoLocation.getLocationFromEquipo(equipo);
        if(locationCliente.getCodLocation().length() == 8) {
            clienteNatural = daoClienteNatural.getClienteNaturalFromLocation(locationCliente);
        } else if(locationCliente.getCodLocation().length() == 11) {
            empresa = daoEmpresa.getEmpresaFromLocation(locationCliente);
        }
        selectedTrabajador = null;
        locationTrabajador = null;
        listTrabajador = daoTrabajador.getListTrabajadorFromDepartamento(selectedIncidencia.getDireccion().getDistrito().getProvincia().getDepartamento());
        FacesMessage msg = new FacesMessage("Incidencia Selected", locationCliente.getNombre()+" "+locationCliente.getApellidoPaterno()+" "+locationCliente.getApellidoMaterno());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowFromTableListIncidenciaUnselect(UnselectEvent event) {
        selectedIncidencia = (Incidencia) event.getObject();
        FacesMessage msg = new FacesMessage("Equipo Unselected", selectedIncidencia.getSrms());
        selectedIncidencia = null;
        selectedTrabajador = null;
        locationTrabajador = null;
        equipo = null;
        locationCliente = null;
        clienteNatural = null;
        empresa = null;
        listTrabajador = null;
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowFromTableListTrabajadorSelect(SelectEvent event) {
        selectedTrabajador = (Trabajador) event.getObject();
        locationTrabajador = selectedTrabajador.getLocation();
        FacesMessage msg = new FacesMessage("Incidencia Selected", locationTrabajador.getNombre()+" "+locationTrabajador.getApellidoPaterno()+" "+locationTrabajador.getApellidoMaterno());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowFromTableListTrabajadorUnselect(UnselectEvent event) {
        selectedTrabajador = (Trabajador) event.getObject();
        FacesMessage msg = new FacesMessage("Equipo Unselected", selectedTrabajador.getUsuario().getUsername());
        selectedTrabajador = null;
        locationTrabajador = null;
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Incidencia getSelectedIncidencia() {
        return selectedIncidencia;
    }

    public void setSelectedIncidencia(Incidencia selectedIncidencia) {
        this.selectedIncidencia = selectedIncidencia;
    }

    public Trabajador getSelectedTrabajador() {
        return selectedTrabajador;
    }

    public void setSelectedTrabajador(Trabajador selectedTrabajador) {
        this.selectedTrabajador = selectedTrabajador;
    }

    public List<Incidencia> getListIncidencia() {
        listIncidencia = daoIncidencia.getListIncidenciaPorAsignar();
        return listIncidencia;
    }

    public void setListIncidencia(List<Incidencia> listIncidencia) {
        this.listIncidencia = listIncidencia;
    }

    public List<Incidencia> getListFiltradoIncidencia() {
        return listFiltradoIncidencia;
    }

    public void setListFiltradoIncidencia(List<Incidencia> listFiltradoIncidencia) {
        this.listFiltradoIncidencia = listFiltradoIncidencia;
    }

    public List<Trabajador> getListTrabajador() {
        return listTrabajador;
    }

    public void setListTrabajador(List<Trabajador> listTrabajador) {
        this.listTrabajador = listTrabajador;
    }

    public List<Trabajador> getListFiltradoTrabajador() {
        return listFiltradoTrabajador;
    }

    public void setListFiltradoTrabajador(List<Trabajador> listFiltradoTrabajador) {
        this.listFiltradoTrabajador = listFiltradoTrabajador;
    }

    public Location getLocationCliente() {
        return locationCliente;
    }

    public void setLocationCliente(Location locationCliente) {
        this.locationCliente = locationCliente;
    }

    public Location getLocationTrabajador() {
        return locationTrabajador;
    }

    public void setLocationTrabajador(Location locationTrabajador) {
        this.locationTrabajador = locationTrabajador;
    }

    public ClienteNatural getClienteNatural() {
        return clienteNatural;
    }

    public void setClienteNatural(ClienteNatural clienteNatural) {
        this.clienteNatural = clienteNatural;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
