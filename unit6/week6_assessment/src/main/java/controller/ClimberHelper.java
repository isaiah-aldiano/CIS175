/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.climber;

public class ClimberHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("week6_assessment");
	
	public void insertClimber(climber newClimber) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(newClimber);
		em.getTransaction().commit();
		em.close();
	}
	
	public climber searchClimbersByName(String climberName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<climber> typedQuery = em.createQuery("SELECT c FROM climber c where c.name = :nameToFind", climber.class);
		
		typedQuery.setParameter("nameToFind", climberName);
		typedQuery.setMaxResults(1);
		
		climber found;
		
		try {
			found = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			found = new climber(climberName);
			this.insertClimber(found);
		}
		
		em.close();
		return found;
	}
}
