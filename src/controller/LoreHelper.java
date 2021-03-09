package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Lore;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Mar 4, 2021
 */
public class LoreHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("webpetslist");
	
	public void insertLore(Lore l) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Lore> showAllLore() {
		EntityManager em = emfactory.createEntityManager();
		List<Lore> allLore = em.createQuery("SELECT l FROM Lore l").getResultList();
		return allLore;
	}

	public Lore findLore(String nameToLookUp) {
		// TODO Auto-generated method stub

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Lore> typedQuery = em.createQuery("SELECT lo FROM Lore lo WHERE lo.loreName = :selectedName", Lore.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Lore foundLore;
		try {
			foundLore = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundLore = new Lore(nameToLookUp);
		}
		em.close();
		return foundLore;
		}
}