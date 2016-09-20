/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Certificado;
import modelo.Location;
import modelo.Nota;
import modelo.Perfil;
import modelo.Trabajador;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface certificacionDAO {
    public List<Certificado> mostrarCertificado();
    public List<Perfil> listaPerfil();
    
    
    public void insertarCertificado(Certificado cert);
    public void modificarCertificado(Certificado cert);
    public void eliminarCertificado(Certificado cert);
    public void InsertarLocation(Location locat);
    public void InsertarTablaTrabajador(Trabajador Mtrabajador);
    public void InsertarNotas (Nota nt);
  
    
}
