/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Certificado;
import modelo.Incidencia;
import modelo.Location;
import modelo.Nota;
import modelo.Perfil;
import modelo.Trabajador;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Joe
 */
public class NotasImplement implements certificacionDAO {

    
    
     public List<Incidencia> getListIncidencias() {
        List<Incidencia> listEquipo = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Incidencia");
            listEquipo = (List<Incidencia>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listEquipo;
    }
    
    
     
     
     
    public List<Certificado> mostrarCertificado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Perfil> listaPerfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertarCertificado(Certificado cert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void modificarCertificado(Certificado cert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminarCertificado(Certificado cert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void InsertarLocation(Location locat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void InsertarTablaTrabajador(Trabajador Mtrabajador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void InsertarNotas(Nota nt) {
      Session session=null;
      
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(nt);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
        
        if(session!=null){
            session.close();
        }
        }
    
    
    
    }
 
    
   
    
    
    
    
}
