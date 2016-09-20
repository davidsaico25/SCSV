/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.Perfil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOPerfil extends ADAO_crud<Perfil> implements Serializable {
    
    public List<Perfil> getListPerfil() {
        List<Perfil> listPerfil = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Perfil");
            listPerfil = (List<Perfil>) query.list();
        } catch (Exception e) {
        } finally {
            if(session != null) {
                session.close();
            }
        }
        
        return listPerfil;
    }
}