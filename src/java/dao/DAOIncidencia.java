/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.Incidencia;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOIncidencia extends ADAO_crud<Object> implements Serializable {
    
    public Incidencia getIncidencia(Incidencia facturaAux) {
        Incidencia incidencia = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Incidencia i inner join fetch i.equipo e inner join fetch i.tipoIncidencia ti inner join fetch i.slaIncidencia slai inner join fetch i.trabajador t inner join fetch i.direccion d  where i.srms=:srms or i.dps=:dps");
            query.setParameter("codIncidencia", facturaAux.getCodIncidencia());
            incidencia = (Incidencia) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return incidencia;
    }
    
    public List<Incidencia> getListIncidencia() {
        List<Incidencia> listIncidencia = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Incidencia i inner join fetch i.equipo e inner join fetch i.slaIncidencia si inner join fetch i.tipoIncidencia ti");
            listIncidencia = (List<Incidencia>) query.list();
        } catch (Exception e) {
        } finally {
            if(session != null) {
                session.close();
            }
        }
        
        return listIncidencia;
    }
    
    public List<Incidencia> getListIncidenciaPorAsignar() {
        List<Incidencia> listIncidencia = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Incidencia i inner join fetch i.equipo e inner join fetch e.modelo modelo inner join fetch i.slaIncidencia si inner join fetch i.tipoIncidencia ti inner join fetch i.direccion d inner join fetch d.distrito distrito inner join fetch distrito.provincia provincia inner join fetch provincia.departamento departamento where i.trabajador is null");
            listIncidencia = (List<Incidencia>) query.list();
        } catch (Exception e) {
        } finally {
            if(session != null) {
                session.close();
            }
        }
        
        return listIncidencia;
    }
}