/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.Departamento;
import modelo.Distrito;
import modelo.Provincia;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOUbigeo implements Serializable {
    
    public List<Departamento> getListDepartamento() {
        List<Departamento> listDepartamento = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Departamento");
            listDepartamento = (List<Departamento>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listDepartamento;
    }
    
    public List<Provincia> getListProvinciaFromDepartamento(Departamento departamento) {
        List<Provincia> listProvincia = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Provincia p where p.departamento.codDepartamento=:codDepartamento");
            query.setParameter("codDepartamento", departamento.getCodDepartamento());
            listProvincia = (List<Provincia>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listProvincia;
    }
    
    public List<Distrito> getListDistritoFromProvincia(Provincia provincia) {
        List<Distrito> listDistrito = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Distrito d where d.provincia.codProvincia=:codProvincia");
            query.setParameter("codProvincia", provincia.getCodProvincia());
            listDistrito = (List<Distrito>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listDistrito;
    }
}
