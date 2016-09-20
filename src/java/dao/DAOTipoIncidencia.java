/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.TipoIncidencia;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOTipoIncidencia extends ADAO_crud<Object> implements Serializable {
    
    public List<TipoIncidencia> getListTipoIncidencia() {
        List<TipoIncidencia> listTipoIncidencia = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from TipoIncidencia");
            listTipoIncidencia = (List<TipoIncidencia>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listTipoIncidencia;
    }
}
