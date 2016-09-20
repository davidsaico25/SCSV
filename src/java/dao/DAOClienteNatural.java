/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.ClienteNatural;
import modelo.Location;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOClienteNatural extends ADAO_crud<Object> implements Serializable {
    
    public List<ClienteNatural> getListClienteNatural() {
        List<ClienteNatural> listClienteNatural = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from ClienteNatural cn inner join fetch cn.location l inner join fetch cn.direccion d inner join fetch d.distrito distrito inner join fetch distrito.provincia provincia inner join fetch provincia.departamento departamento");
            listClienteNatural = (List<ClienteNatural>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listClienteNatural;
    }
    
    public ClienteNatural getClienteNaturalFromLocation(Location location) {
        ClienteNatural clienteNatural = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from ClienteNatural cn inner join fetch cn.direccion d inner join fetch d.distrito distrito inner join fetch distrito.provincia provincia inner join fetch provincia.departamento departamento where cn.location.codLocation=:codLocation");
            query.setParameter("codLocation", location.getCodLocation());
            clienteNatural = (ClienteNatural) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return clienteNatural;
    }
}
