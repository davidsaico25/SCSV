/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.SlaIncidencia;
import modelo.SlaIncidencia;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOSlaIncidencia extends ADAO_crud<Object> implements Serializable {
    
    public List<SlaIncidencia> getListSlaIncidencia() {
        List<SlaIncidencia> listSlaIncidencia = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SlaIncidencia");
            listSlaIncidencia = (List<SlaIncidencia>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listSlaIncidencia;
    }
}