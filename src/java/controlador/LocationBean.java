/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOLocation;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Location;

/**
 *
 * @author David
 */
@ManagedBean
@ViewScoped
public class LocationBean implements Serializable {

    private Location location;
    
    private DAOLocation daoLocation;
    
    public LocationBean() {
        location = new Location();
        
        daoLocation = new DAOLocation();
    }
    
    public void crearLocation() {
        daoLocation.crear(location);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
