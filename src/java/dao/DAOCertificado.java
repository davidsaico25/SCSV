/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.Certificado;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOCertificado extends ADAO_crud<Object> implements Serializable {
    
    public List<Certificado> getListCertificado() {
        List<Certificado> listCertificado = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Certificado c");
            listCertificado = (List<Certificado>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listCertificado;
    }
    
    public Certificado getCertificado(Certificado certificadoAux) {
        Certificado certificado = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Certificado c where c.codCertificado=:codCertificado");
            query.setParameter("codCertificado", certificadoAux.getCodCertificado());
            certificado = (Certificado) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return certificado;
    }
}