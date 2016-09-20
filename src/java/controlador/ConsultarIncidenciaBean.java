/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.IncidenciaConsulta;
import modelo.Incidencia;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Joe
 */
@ManagedBean
@ViewScoped
public class ConsultarIncidenciaBean {

      IncidenciaConsulta consulta;
       private Incidencia inc;
    public ConsultarIncidenciaBean() {
        
        inc=new Incidencia();
        consulta=new IncidenciaConsulta();
    }
    
      public void ConsultarIncidenciaS(){
        inc = consulta.getIncidencia(inc);     
              //listIncidencia=consulta.getListIncidencia(inc);
    }

    public Incidencia getInc() {
        return inc;
    }

    public void setInc(Incidencia inc) {
        this.inc = inc;
    }
}
