/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.NotasImplement;
import DAO.certificacionDAO;
import modelo.Certificado;
import modelo.Location;
import modelo.Nota;
import modelo.Trabajador;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Joe
 */
@ManagedBean
@ViewScoped
public class NotasBean {

    private Nota nts;
    NotasImplement daoNotas;

    public NotasBean() {
        nts = new Nota();
        daoNotas = new NotasImplement();
    }

    public void insertarnotas() {
        certificacionDAO linkDao = new NotasImplement();
        nts.setFecha(new Date());
        nts.setIncidencia(daoNotas.getListIncidencias().get(0));
        linkDao.InsertarNotas(nts);
        nts = new Nota();
    }

    public Nota getNts() {
        return nts;
    }

    public void setNts(Nota nts) {
        this.nts = nts;
    }

}
