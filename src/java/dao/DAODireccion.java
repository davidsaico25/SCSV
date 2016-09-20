/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import modelo.ClienteNatural;
import modelo.Direccion;
import modelo.Empresa;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAODireccion extends ADAO_crud<Object> implements Serializable {
    
    public Direccion getDireccionFromClienteNatural (ClienteNatural clienteNatural) {
        Direccion direccion = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Direccion d inner join fetch d.distrito distrito inner join fetch distrito.provincia provincia inner join fetch provincia.departamento departamento where d.codDireccion=:codDireccion");
            query.setParameter("codDireccion", clienteNatural.getDireccion().getCodDireccion());
            direccion = (Direccion) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return direccion;
    }
    
    public Direccion getDireccionFromEmpresa (Empresa empresa) {
        Direccion direccion = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Direccion d inner join fetch d.distrito distrito inner join fetch distrito.provincia provincia inner join fetch provincia.departamento departamento where d.codDireccion=:codDireccion");
            query.setParameter("codDireccion", empresa.getDireccion().getCodDireccion());
            direccion = (Direccion) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return direccion;
    }
}