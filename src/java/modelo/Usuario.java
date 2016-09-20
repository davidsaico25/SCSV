package modelo;
// Generated Nov 19, 2015 3:42:42 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer codUsuario;
     private String username;
     private String password;
     private Date ultimaConexion;
     private Set<Trabajador> trabajadors = new HashSet<Trabajador>(0);
     private Set<UsuarioHasModulo> usuarioHasModulos = new HashSet<UsuarioHasModulo>(0);

    public Usuario() {
    }

	
    public Usuario(String username, String password, Date ultimaConexion) {
        this.username = username;
        this.password = password;
        this.ultimaConexion = ultimaConexion;
    }
    public Usuario(String username, String password, Date ultimaConexion, Set<Trabajador> trabajadors, Set<UsuarioHasModulo> usuarioHasModulos) {
       this.username = username;
       this.password = password;
       this.ultimaConexion = ultimaConexion;
       this.trabajadors = trabajadors;
       this.usuarioHasModulos = usuarioHasModulos;
    }
   
    public Integer getCodUsuario() {
        return this.codUsuario;
    }
    
    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getUltimaConexion() {
        return this.ultimaConexion;
    }
    
    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }
    public Set<Trabajador> getTrabajadors() {
        return this.trabajadors;
    }
    
    public void setTrabajadors(Set<Trabajador> trabajadors) {
        this.trabajadors = trabajadors;
    }
    public Set<UsuarioHasModulo> getUsuarioHasModulos() {
        return this.usuarioHasModulos;
    }
    
    public void setUsuarioHasModulos(Set<UsuarioHasModulo> usuarioHasModulos) {
        this.usuarioHasModulos = usuarioHasModulos;
    }




}


