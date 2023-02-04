/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Jan 29, 2023
 */
package controller;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ShoppingList");
	
	public void insertItem(ListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListItem> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		
		List<ListItem> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		
		return allItems;
	}
	
	public void deleteItem(ListItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		ListItem result = new ListItem("", "");

		em.getTransaction().begin();
		
		TypedQuery<ListItem> typedQuery = em.createQuery("SELECT li FROM ListItem li WHERE li.store = :selectedStore and li.item = :selectedItem", ListItem.class);
		
		typedQuery.setParameter("selectedStore", toDelete.getStore());
		typedQuery.setParameter("selectedItem", toDelete.getItem());
		
		typedQuery.setMaxResults(1);
		
		try {
			result = typedQuery.getSingleResult();
		} catch (Exception e) {
			System.out.println("*  No results found!!");
			em.close();
			return;
		}
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListItem> searchForItemByStore(String storeName) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<ListItem> typedQuery = em.createQuery("Select li from ListItem li where li.store = :selectedStore", ListItem.class);
		
		typedQuery.setParameter("selectedStore", storeName);		
				
		List<ListItem> foundItems = typedQuery.getResultList();
		
		em.close();
		return foundItems;
	}
	
	public List<ListItem> searchForItemByitem(String itemName) {
		EntityManager em = emfactory.createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<ListItem> typedQuery = em.createQuery("SELECT i FROM ListItem i WHERE i.item = :selectedItem", ListItem.class);
		
		typedQuery.setParameter("selectedItem", itemName);
		
		List<ListItem> foundItems = typedQuery.getResultList();
		
		em.close();
		return foundItems;
		
	}
	
	public ListItem searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, idToEdit);
		
		em.close();
		return found;
	}
	
	public void updateItem(ListItem toEdit) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}