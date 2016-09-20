/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

//import dao.DAOPerfil;
import dao.DAOLocation;
import dao.DAOPerfil;
import dao.DAOSucursal;
import dao.DAOTrabajador;
import dao.DAOUsuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Location;
import modelo.Perfil;
import modelo.Sucursal;
import modelo.Trabajador;
import modelo.Usuario;

/**
 *
 * @author David
 */
@ManagedBean
@ViewScoped
public class TrabajadorBean implements Serializable {

    private Trabajador trabajador;
    private List<Trabajador> listTrabajador;
    private List<Trabajador> listFiltradoTrabajador;
    
    private Location location;
    private Usuario usuario;
    
    private Perfil perfil;
    private List<Perfil> listPerfil;
    
    private Sucursal sucursal;
    private List<Sucursal> listSucursal;
    
    private DAOTrabajador daoTrabajador;
    private DAOLocation daoLocation;
    private DAOPerfil daoPerfil;
    private DAOSucursal daoSucursal;
    private DAOUsuario daoUsuario;
    
    public TrabajadorBean() {
        location = new Location();
        trabajador = new Trabajador();
        perfil = new Perfil();
        sucursal = new Sucursal();
        
        daoLocation = new DAOLocation();
        daoTrabajador = new DAOTrabajador();
        daoUsuario = new DAOUsuario();
        daoPerfil = new DAOPerfil();
        daoSucursal = new DAOSucursal();
        
        listTrabajador = daoTrabajador.getListTrabajador();
    }
    
    public void crearTrabajador() {
        daoLocation.crear(location);
        trabajador.setEstado("activo");
        trabajador.setSucursal(sucursal);
        trabajador.setLocation(location);
        trabajador.setPerfil(perfil);
        daoTrabajador.crear(trabajador);
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<Trabajador> getListTrabajador() {
        listTrabajador = daoTrabajador.getListTrabajador();
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

    public List<Perfil> getListPerfil() {
        listPerfil = daoPerfil.getListPerfil();
        return listPerfil;
    }

    public void setListPerfil(List<Perfil> listPerfil) {
        this.listPerfil = listPerfil;
    }
    
    public List<Sucursal> getListSucursal() {
        listSucursal = daoSucursal.getListSucursal();
        return listSucursal;
    }

    public void setListSucursal(List<Sucursal> listSucursal) {
        this.listSucursal = listSucursal;
    }
}