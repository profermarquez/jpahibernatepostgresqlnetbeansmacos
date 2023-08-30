/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sebastian
 */
package controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {
	private static EntityManagerFactory emf =null;
	public static EntityManager createEntityManager() {
	
	
		try {if(emf ==null) {
			
			emf=Persistence.createEntityManagerFactory("estudiante");
			System.out.println("conectado!");
		}
			
		}
		catch(Exception e) {System.out.println("Error en la conexion.... "+ e);}
		
		
		return emf.createEntityManager();
	}
	
}
