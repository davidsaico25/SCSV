/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOCertificado;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Certificado;

/**
 *
 * @author David
 */
@ManagedBean
@ViewScoped
public class CertificadoBean implements Serializable {

    private Certificado certificado;
    private Certificado certificadoSelected;
    private Certificado certificadoCreate;
    private Certificado certificadoEdit;
    private Certificado certificadoDelete;
    
    private List<Certificado> listCertificado;
    private List<Certificado> listFilteredCertificado;
    
    private DAOCertificado daoCertificado;
    
    public CertificadoBean() {
        daoCertificado = new DAOCertificado();
        
        certificado = new Certificado();
        certificadoCreate = new Certificado();
        certificadoEdit = new Certificado();
        certificadoDelete = new Certificado();
    }
    
    public void createCertificado() {
        certificadoCreate.setFechaEmision(new Date());
        daoCertificado.crear(certificadoCreate);
        certificadoCreate = new Certificado();
    }
    
    public void editCertificado() {
        daoCertificado.actualizar(certificadoSelected);
        certificadoSelected = new Certificado();
    }
    
    public void deleteCertificado() {
        daoCertificado.eliminar(certificadoSelected);
        certificadoSelected = new Certificado();
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public Certificado getCertificadoSelected() {
        return certificadoSelected;
    }

    public void setCertificadoSelected(Certificado certificadoSelected) {
        this.certificadoSelected = certificadoSelected;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public List<Certificado> getListCertificado() {
        listCertificado = daoCertificado.getListCertificado();
        return listCertificado;
    }

    public void setListCertificado(List<Certificado> listCertificado) {
        this.listCertificado = listCertificado;
    }

    public List<Certificado> getListFilteredCertificado() {
        return listFilteredCertificado;
    }

    public void setListFilteredCertificado(List<Certificado> listFilteredCertificado) {
        this.listFilteredCertificado = listFilteredCertificado;
    }

    public Certificado getCertificadoCreate() {
        return certificadoCreate;
    }

    public void setCertificadoCreate(Certificado certificadoCreate) {
        this.certificadoCreate = certificadoCreate;
    }

    public Certificado getCertificadoEdit() {
        return certificadoEdit;
    }

    public void setCertificadoEdit(Certificado certificadoEdit) {
        this.certificadoEdit = certificadoEdit;
    }

    public Certificado getCertificadoDelete() {
        return certificadoDelete;
    }

    public void setCertificadoDelete(Certificado certificadoDelete) {
        this.certificadoDelete = certificadoDelete;
    }
}
