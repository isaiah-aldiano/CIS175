/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 1, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.climbingGear;

	/*
	 * Simple CRUD helpers and search methods for items in the database by item name, manufacturer, and ID
	 */
public class ClimbingGearHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("databaseProject");
	
	public void insertItem(climbingGear cg) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cg);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<climbingGear> showAll() {
		EntityManager em = emfactory.createEntityManager();
		
		List<climbingGear> allGear = em.createQuery("select allGear from climbingGear allGear").getResultList();
		
		return allGear;
	}
	
	public void deleteItem(climbingGear deleteItem) {
		EntityManager em = emfactory.createEntityManager();
		climbingGear result = new climbingGear();

		em.getTransaction().begin();
		
		TypedQuery<climbingGear> typedQuery = em.createQuery("select cg from climbingGear cg where cg.item = :selectedItem and cg.manufacturer = :selectedManufacturer", climbingGear.class);
		
		typedQuery.setParameter("selectedItem", deleteItem.getItem());
		typedQuery.setParameter("selectedManufacturer", deleteItem.getManufacturer());
		
		typedQuery.setMaxResults(1);
		
		try {
			result = typedQuery.getSingleResult();
		} catch(Exception e) {
			System.out.println("* No results found! * ");
			em.close();
			return;
		}
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateItem(climbingGear editItem) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(editItem);
		em.getTransaction().commit();
		em.clear();
	}
	
	/*
	 * Search by methods
	 */
	
	public climbingGear searchById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		climbingGear found = em.find(climbingGear.class, idToEdit);
		
		em.close();
		return found;
		
	}
	
	public List<climbingGear> searchByItem(String itemName) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<climbingGear> typedQuery = em.createQuery("SELECT itemName FROM climbingGear itemName WHERE itemName.item = :selectedItemName", climbingGear.class);
		
		typedQuery.setParameter("selectedItemName", itemName);
		
		List<climbingGear> foundItems = typedQuery.getResultList();
		
		em.close();
		return foundItems;
		
	}

	public List<climbingGear> searchByManufacturer(String manufacturer) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<climbingGear> typedQuery = em.createQuery("SELECT man FROM climbingGear man WHERE man.manufacturer = :selectedManufacturer", climbingGear.class);
		
		typedQuery.setParameter("selectedManufacturer", manufacturer);
		
		List<climbingGear> foundItems = typedQuery.getResultList();
		
		em.close();
		return foundItems;
	}
	
	/*
	 * End search by methods
	 */
	
	public void cleanUp() {
		emfactory.close();
	}
}
