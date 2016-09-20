/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOIncidencia;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Incidencia;

/**
 *
 * @author David
 */
@ManagedBean
@ViewScoped
public class IncidenciaConsultarBean {

    private Incidencia incidencia;
    
    private DAOIncidencia daoIncidencia;
    
    public IncidenciaConsultarBean() {
        daoIncidencia = new DAOIncidencia();
        
        incidencia = new Incidencia();
    }
    
    public void consultarIncidencia() {
        return;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }
}