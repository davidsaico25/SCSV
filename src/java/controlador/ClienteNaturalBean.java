/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOClienteNatural;
import dao.DAODireccion;
import dao.DAOLocation;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ClienteNatural;
import modelo.Direccion;
import modelo.Distrito;
import modelo.Location;

/**
 *
 * @author David
 */
@ManagedBean
@ViewScoped
public class ClienteNaturalBean implements Serializable {

    private ClienteNatural clienteNatural;
    private List<ClienteNatural> listClienteNatural;
    private List<ClienteNatural> listFiltradoClienteNatural;

    private Location location;

    private Direccion direccion;

    private Distrito distrito;

    private DAOClienteNatural daoClienteNatural;
    private DAOLocation daoLocation;
    private DAODireccion daoDireccion;

    public ClienteNaturalBean() {
        clienteNatural = new ClienteNatural();
        location = new Location();
        direccion = new Direccion();
        distrito = new Distrito();
        
        daoClienteNatural = new DAOClienteNatural();
    }

    public void crearClienteNatural() {
        daoLocation = new DAOLocation();
        daoDireccion = new DAODireccion();
        if(location.getTelefono().isEmpty()) {
            location.setTelefono(null);
        }
        if(location.getCelular().isEmpty()) {
            location.setCelular(null);
        }
        daoLocation.crear(location);
        direccion.setDistrito(distrito);
        daoDireccion.crear(direccion);
        clienteNatural.setLocation(location);
        clienteNatural.setDireccion(direccion);
        daoClienteNatural.crear(clienteNatural);
    }
    
    public ClienteNatural getClienteNatural() {
        return clienteNatural;
    }

    public void setClienteNatural(ClienteNatural clienteNatural) {
        this.clienteNatural = clienteNatural;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public List<ClienteNatural> getListClienteNatural() {
        listClienteNatural = daoClienteNatural.getListClienteNatural();
        return listClienteNatural;
    }

    public void setListClienteNatural(List<ClienteNatural> listClienteNatural) {
        this.listClienteNatural = listClienteNatural;
    }

    public List<ClienteNatural> getListFiltradoClienteNatural() {
        return listFiltradoClienteNatural;
    }

    public void setListFiltradoClienteNatural(List<ClienteNatural> listFiltradoClienteNatural) {
        this.listFiltradoClienteNatural = listFiltradoClienteNatural;
    }
}
