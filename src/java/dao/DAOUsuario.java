/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public class DAOUsuario extends ADAO_crud<Object> implements Serializable {
    
    public List<Usuario> getListUsuario() {
        List<Usuario> listUsuario = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Usuario");
            listUsuario = (List<Usuario>) query.list();
        } catch (Exception e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listUsuario;
    }
    
    public Usuario login(Usuario usuarioAux) {
        Usuario usuario = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Usuario u where u.username=:username");
            query.setParameter("username", usuarioAux.getUsername());
            usuario = (Usuario) query.uniqueResult();
            if(usuario.getPassword().equals(usuarioAux.getPassword())) {
                return usuario;
            }
        } catch(Exception e) {
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
