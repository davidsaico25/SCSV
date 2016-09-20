/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.ParteEnviada;
import modelo.Incidencia;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOParteEnviada extends ADAO_crud<Object> implements Serializable {
    
    public List<ParteEnviada> getListParteEnviada(Incidencia incidencia) {
        List<ParteEnviada> listParteEnviada = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from ParteEnviada pe inner join fetch pe.incidencia i inner join fetch pe.parte p inner join fetch p.componente c where i.srms=:srms or i.dps=:dps");
            query.setParameter("srms", incidencia.getSrms());
            query.setParameter("dps", incidencia.getDps());
            listParteEnviada = (List<ParteEnviada>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listParteEnviada;
    }
}