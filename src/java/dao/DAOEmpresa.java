/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.Empresa;
import modelo.Empresa;
import modelo.Location;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOEmpresa extends ADAO_crud<Object> implements Serializable {
    
    public List<Empresa> getListEmpresa() {
        List<Empresa> listEmpresa = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Empresa e inner join fetch e.location l where l.codLocation != '10232343451'");
            listEmpresa = (List<Empresa>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listEmpresa;
    }
    
    public Empresa getEmpresaFromLocation(Location location) {
        Empresa empresa = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Empresa e inner join fetch e.direccion d inner join fetch d.distrito distrito inner join fetch distrito.provincia provincia inner join fetch provincia.departamento departamento where e.location.codLocation=codLocation");
            query.setParameter("codLocation", location.getCodLocation());
            empresa = (Empresa) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return empresa;
    }
}
