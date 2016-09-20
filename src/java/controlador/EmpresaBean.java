/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAODireccion;
import dao.DAOEmpresa;
import dao.DAOLocation;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Direccion;
import modelo.Distrito;
import modelo.Empresa;
import modelo.Location;

/**
 *
 * @author David
 */
@ManagedBean
@ViewScoped
public class EmpresaBean implements Serializable {

    private Empresa empresa;
    private List<Empresa> listEmpresa;
    private List<Empresa> listFiltradoEmpresa;
    
    private Location location;
    
    private Direccion direccion;
    
    private Distrito distrito;
    
    private DAOEmpresa daoEmpresa;
    private DAOLocation daoLocation;
    private DAODireccion daoDireccion;
    
    public EmpresaBean() {
        empresa = new Empresa();
        location = new Location();
        direccion = new Direccion();
        distrito = new Distrito();
        
        daoEmpresa = new DAOEmpresa();
    }

    public void crearEmpresa() {
        daoLocation = new DAOLocation();
        daoDireccion = new DAODireccion();
        location.setApellidoPaterno(null);
        location.setApellidoMaterno(null);
        location.setCelular(null);
        daoLocation.crear(location);
        direccion.setDistrito(distrito);
        daoDireccion.crear(direccion);
        empresa.setLocation(location);
        empresa.setDireccion(direccion);
        daoEmpresa.crear(empresa);
    }
    
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public List<Empresa> getListEmpresa() {
        listEmpresa = daoEmpresa.getListEmpresa();
        return listEmpresa;
    }

    public void setListEmpresa(List<Empresa> listEmpresa) {
        this.listEmpresa = listEmpresa;
    }

    public List<Empresa> getListFiltradoEmpresa() {
        return listFiltradoEmpresa;
    }

    public void setListFiltradoEmpresa(List<Empresa> listFiltradoEmpresa) {
        this.listFiltradoEmpresa = listFiltradoEmpresa;
    }
}
