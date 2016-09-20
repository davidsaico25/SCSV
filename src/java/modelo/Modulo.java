package modelo;
// Generated Nov 19, 2015 3:42:42 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Modulo generated by hbm2java
 */
public class Modulo  implements java.io.Serializable {


     private int codModulo;
     private String nombreModulo;
     private Set<UsuarioHasModulo> usuarioHasModulos = new HashSet<UsuarioHasModulo>(0);

    public Modulo() {
    }

	
    public Modulo(int codModulo, String nombreModulo) {
        this.codModulo = codModulo;
        this.nombreModulo = nombreModulo;
    }
    public Modulo(int codModulo, String nombreModulo, Set<UsuarioHasModulo> usuarioHasModulos) {
       this.codModulo = codModulo;
       this.nombreModulo = nombreModulo;
       this.usuarioHasModulos = usuarioHasModulos;
    }
   
    public int getCodModulo() {
        return this.codModulo;
    }
    
    public void setCodModulo(int codModulo) {
        this.codModulo = codModulo;
    }
    public String getNombreModulo() {
        return this.nombreModulo;
    }
    
    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }
    public Set<UsuarioHasModulo> getUsuarioHasModulos() {
        return this.usuarioHasModulos;
    }
    
    public void setUsuarioHasModulos(Set<UsuarioHasModulo> usuarioHasModulos) {
        this.usuarioHasModulos = usuarioHasModulos;
    }




}

