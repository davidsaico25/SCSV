/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.Equipo;
import modelo.Parte;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOParte extends ADAO_crud<Object> implements Serializable {
    
    public List<Parte> getListParteForEquipo(Equipo equipo) {
        List<Parte> listParte = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("select p from Parte p inner join fetch p.componente componente, Componente c, EquipoHasComponente ehc inner join fetch p.componente componente where c.codComponente=p.componente.codComponente and ehc.componente.codComponente=c.codComponente and ehc.equipo.numeroSerie=:numeroSerie");
            query.setParameter("numeroSerie", equipo.getNumeroSerie());
            listParte = (List<Parte>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listParte;
    }
}
