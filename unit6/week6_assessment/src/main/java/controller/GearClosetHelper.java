/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.gearCloset;

public class GearClosetHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("week6_assessment");
	
	public void createCloset(gearCloset newCloset) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(newCloset);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteCloset(gearCloset closetToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<gearCloset> typedQuery = em.createQuery("SELECT toDel FROM gearCloset toDel where toDel.id = :toDeleteId", gearCloset.class);
		
		typedQuery.setParameter("toDeleteId", closetToDelete.getId());
		typedQuery.setMaxResults(1);
		
		gearCloset toDelete = typedQuery.getSingleResult();
		
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateCloset(gearCloset toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
	}
	
	public gearCloset searchClosetById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		gearCloset found = em.find(gearCloset.class, id);
		em.close();

		return found;
	}
	
	public List<gearCloset> viewAllClosets() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<gearCloset> allClosets = em.createQuery("SELECT allCLosets FROM gearCloset allClosets").getResultList();
		
		return allClosets;
	}
}	
