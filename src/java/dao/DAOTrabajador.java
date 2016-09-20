/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.Departamento;
import modelo.Trabajador;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOTrabajador extends ADAO_crud<Object> implements Serializable {
    
    public List<Trabajador> getListTrabajador() {
        List<Trabajador> listTrabajador = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Trabajador t inner join fetch t.sucursal s inner join fetch t.location l inner join fetch t.perfil p");
            listTrabajador = (List<Trabajador>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listTrabajador;
    }
    
    public List<Trabajador> getListTrabajadorFromDepartamento(Departamento departamento) {
        List<Trabajador> listTrabajador = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("select t from Trabajador t inner join fetch t.location l inner join fetch t.sucursal s inner join fetch t.perfil p inner join fetch t.usuario u where t.estado='activo' and s.direccion.distrito.provincia.departamento.codDepartamento=:codDepartamento");
            query.setParameter("codDepartamento", departamento.getCodDepartamento());
            listTrabajador = (List<Trabajador>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listTrabajador;
    }
}
