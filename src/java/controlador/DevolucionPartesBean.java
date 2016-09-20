/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOParteEnviada;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Incidencia;
import modelo.ParteEnviada;

/**
 *
 * @author David
 */
@ManagedBean
@ViewScoped
public class DevolucionPartesBean implements Serializable {

    private Incidencia incidencia;
    
    private ParteEnviada parteEnviada;
    
    private List<ParteEnviada> listParteEnviada;
    private List<ParteEnviada> listFilteredParteEnviada;
    
    private DAOParteEnviada daoParteEnviada;
    
    public DevolucionPartesBean() {
        daoParteEnviada = new DAOParteEnviada();
        
        incidencia = new Incidencia();
        
        parteEnviada = new ParteEnviada();
    }
    
    public void consultarParteEnviadaIncidencia() {
        listParteEnviada = daoParteEnviada.getListParteEnviada(incidencia);
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }

    public ParteEnviada getParteEnviada() {
        return parteEnviada;
    }

    public void setParteEnviada(ParteEnviada parteEnviada) {
        this.parteEnviada = parteEnviada;
    }

    public List<ParteEnviada> getListParteEnviada() {
        return listParteEnviada;
    }

    public void setListParteEnviada(List<ParteEnviada> listParteEnviada) {
        this.listParteEnviada = listParteEnviada;
    }

    public List<ParteEnviada> getListFilteredParteEnviada() {
        return listFilteredParteEnviada;
    }

    public void setListFilteredParteEnviada(List<ParteEnviada> listFilteredParteEnviada) {
        this.listFilteredParteEnviada = listFilteredParteEnviada;
    }
}
