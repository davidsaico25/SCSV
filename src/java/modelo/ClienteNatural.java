package modelo;
// Generated Nov 19, 2015 3:42:42 PM by Hibernate Tools 4.3.1



/**
 * ClienteNatural generated by hbm2java
 */
public class ClienteNatural  implements java.io.Serializable {


     private Integer codClienteNatural;
     private Direccion direccion;
     private Location location;

    public ClienteNatural() {
    }

    public ClienteNatural(Direccion direccion, Location location) {
       this.direccion = direccion;
       this.location = location;
    }
   
    public Integer getCodClienteNatural() {
        return this.codClienteNatural;
    }
    
    public void setCodClienteNatural(Integer codClienteNatural) {
        this.codClienteNatural = codClienteNatural;
    }
    public Direccion getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public Location getLocation() {
        return this.location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }




}


