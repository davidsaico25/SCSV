/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOUsuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import util.Util;

/**
 *
 * @author David
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    DAOUsuario daoUsuario;
    
    private Usuario usuario;
    
    HttpSession sesion;
    
    public LoginBean() {
        daoUsuario = new DAOUsuario();
        
        usuario = new Usuario();
        
        sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }
    
    public String login() {
        String mensaje = validarCamposLogin();
        if(mensaje != null) {
            Util.sendErroMessage(mensaje);
            return "";
        }
        usuario = daoUsuario.login(usuario);
        if(usuario != null) {
            sesion.setAttribute("usuario", this.usuario);
            return "vistaUsuario";
        } else {
            mensaje = "Usuario no existe";
            Util.sendErroMessage(mensaje);
            usuario = new Usuario();
        }
        return "";
    }
    
    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "index";
    }
    
    public String validarCamposLogin() {
        if(!Util.isWritten(usuario.getUsername())) {
            return "USERNAME: Ingrese username";
        }
        
        if(!Util.isWritten(usuario.getPassword())) {
            return "CONTRASENA: Ingrese contrasena";
        }
        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}