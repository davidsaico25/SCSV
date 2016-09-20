/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import modelo.Equipo;
import modelo.Location;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOLocation extends ADAO_crud<Object> implements Serializable {
    
    public Location getLocationFromEquipo(Equipo equipo) {
        Location location = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("select l from Location l, Equipo e, DetalleFactura df, Factura f where e.numeroSerie=df.equipo.numeroSerie and df.factura.codFactura=f.codFactura and f.location.codLocation=l.codLocation and e.numeroSerie=:numeroSerie");
            query.setParameter("numeroSerie", equipo.getNumeroSerie());
            location = (Location) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return location;
    }
}
