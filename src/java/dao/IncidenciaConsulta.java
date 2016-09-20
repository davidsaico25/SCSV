/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dao.HibernateUtil;
import java.util.List;
import modelo.Incidencia;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Joe
 */
public class IncidenciaConsulta {
    
   
       public Incidencia getIncidencia(Incidencia InceAux) {
        Incidencia inxc = null;
        Session session = null;
        try {
             session = HibernateUtil.getSessionFactory().openSession();
             Query query = session.createQuery("from Incidencia where srms=:srms or dps=:dps");
             query.setParameter("srms",InceAux.getSrms());
             query.setParameter("dps",InceAux.getDps());
             inxc = (Incidencia) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return inxc;
    }
   
    public List<Incidencia> getListIncidencia(Incidencia incd) {
        List<Incidencia> listIncidencia = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Incidencia where srms=:srms or dps=:dps");            
            query.setParameter("srms",incd.getSrms());
            query.setParameter("dps",incd.getDps());
            listIncidencia = (List<Incidencia>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listIncidencia;
    }
       
       
 
       
    } 
     
    
    

