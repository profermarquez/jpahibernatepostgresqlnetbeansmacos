/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.List;
import javax.persistence.EntityManager;

import models.Usuario;

/**
 *
 * @author Sebastian
 */
public class UsuarioDao {
    
    EntityManager em= null;

    public String createUsuario(String text, String text0, String text1) {
        Usuario usuario =new Usuario(text,text0,text1);
        
		try {
			em =Conexion.createEntityManager();
			//if(em == null){System.out.println("Error..");return;}
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			System.out.println("Estudiante guardado");
		}
		catch(Exception e) {System.out.println(e);}
		finally {
			if(em!=null ) {
				
				em.close();
			}
		}
                return "Usuario creado!";
    }

    public String deleteUsuario(int id) {
        Usuario usuario =new Usuario();
        
		try {
			em =Conexion.createEntityManager();
			
			em.getTransaction().begin();
                        
                        usuario =em.find(Usuario.class, id);
                        if(usuario != null ){em.remove(usuario);}else{return "Usuario no encontrado";}
			em.getTransaction().commit();
			
		}
		catch(Exception e) {System.out.println(e);}
		finally {
			if(em!=null ) {
				
				em.close();
			}
		}
                return "Usuario eliminado!";
    }

    public String updateUsuario(int id, String text, String text0, String text1) {
        Usuario usuario =new Usuario(text,text0,text1);
        
		try {
			em =Conexion.createEntityManager();
			
			em.getTransaction().begin();
                        String sql= "UPDATE usuarios SET nombre = '"+text+"', apellido = '"+text0+"', direccion='"+text1+"' WHERE id = "+String.valueOf(id);
                        System.out.println(sql);
                        int countUpdated = em.createNativeQuery(sql).executeUpdate();
                        if(countUpdated!=1){return "Error";} /// si es correcto da uno
                        //System.out.println(countUpdated);
			em.getTransaction().commit();
		}
		catch(Exception e) {System.out.println(e);}
		finally {
			if(em!=null ) {
				
				em.close();
			}
		}
                return "Usuario modificado!";
    }

    public List<Usuario> getUsuarios() {
        List<Usuario> listEmployee=null;
        try {
			em =Conexion.createEntityManager();
			//if(em == null){System.out.println("Error..");return;}
			em.getTransaction().begin();
			listEmployee = em.createNativeQuery("SELECT id,nombre,direccion,apellido FROM usuarios", Usuario.class).getResultList();
			em.getTransaction().commit();
			//System.out.println("Listado de usuarios");
		}
		catch(Exception e) {System.out.println(e);}
		finally {
			if(em!=null ) {
				
				em.close();
			}
		}
                return listEmployee;
        
    }
    
}
