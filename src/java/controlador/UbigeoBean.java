/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOUbigeo;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Departamento;
import modelo.Distrito;
import modelo.Provincia;

/**
 *
 * @author David
 */
@ManagedBean
@ViewScoped
public class UbigeoBean implements Serializable {

    private Distrito distrito;
    private Provincia provincia;
    private Departamento departamento;
    
    private int departamentoID;
    private int provinciaID;
    
    private List<Departamento> listDepartamento;
    private List<Provincia> listProvincia;
    private List<Distrito> listDistrito;
    
    private DAOUbigeo daoUbigeo;
    
    public UbigeoBean() {
        departamento = new Departamento();
        provincia = new Provincia();
        distrito = new Distrito();
        
        daoUbigeo = new DAOUbigeo();
        
        listDepartamento = daoUbigeo.getListDepartamento();
    }

    public void onDepartamentoChange() {
        if(departamento.getCodDepartamento() != 0) {
            listProvincia = daoUbigeo.getListProvinciaFromDepartamento(departamento);
        } else {
            listProvincia = null;
            listDistrito = null;
        }
    }
    
    public void onProvinciaChange() {
        if(provincia.getCodProvincia() != 0) {
            listDistrito = daoUbigeo.getListDistritoFromProvincia(provincia);
        } else {
            listDistrito = null;
        }
    }
    
    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public int getDepartamentoID() {
        return departamentoID;
    }

    public void setDepartamentoID(int departamentoID) {
        this.departamentoID = departamentoID;
    }

    public int getProvinciaID() {
        return provinciaID;
    }

    public void setProvinciaID(int provinciaID) {
        this.provinciaID = provinciaID;
    }

    public List<Departamento> getListDepartamento() {
        return listDepartamento;
    }

    public void setListDepartamento(List<Departamento> listDepartamento) {
        this.listDepartamento = listDepartamento;
    }

    public List<Provincia> getListProvincia() {
        return listProvincia;
    }

    public void setListProvincia(List<Provincia> listProvincia) {
        this.listProvincia = listProvincia;
    }

    public List<Distrito> getListDistrito() {
        return listDistrito;
    }

    public void setListDistrito(List<Distrito> listDistrito) {
        this.listDistrito = listDistrito;
    }
}