/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.ClienteNatural;
import modelo.DetalleFactura;
import modelo.Empresa;
import modelo.Factura;
import modelo.Location;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOFactura extends ADAO_crud<Object> implements Serializable {
    
    public Factura getFactura(Factura facturaAux) {
        Factura factura = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Factura f where f.codFactura=:codFactura");
            query.setParameter("codFactura", facturaAux.getCodFactura());
            factura = (Factura) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return factura;
    }
    
    public Location getLocationFromFactura(Factura factura) {
        Location location = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Location l where l.codLocation = (select f.location.codLocation from Factura f where f.codFactura=:codFactura)");
            query.setParameter("codFactura", factura.getCodFactura());
            location = (Location) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return location;
    }
    
    public ClienteNatural getClienteNaturalFromFactura(Location location) {
        ClienteNatural clienteNatural = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from ClienteNatural cn inner join fetch cn.direccion d where cn.location.codLocation=:codLocation");
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

    public Empresa getEmpresaFromFactura(Location location) {
        Empresa empresa = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Empresa e inner join fetch e.direccion d where e.location.codLocation=:codLocation");
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
    
    public List<DetalleFactura> getListDetalleFactura(Factura factura) {
        List<DetalleFactura> listDetalleFactura = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from DetalleFactura df inner join fetch df.equipo equipo inner join fetch equipo.modelo modelo inner join fetch modelo.marca marca inner join fetch df.factura factura inner join fetch df.garantia garantia where df.factura.codFactura=:codFactura");
            query.setParameter("codFactura", factura.getCodFactura());
            listDetalleFactura = (List<DetalleFactura>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listDetalleFactura;
    }
}
