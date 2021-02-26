package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PetsList;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Feb 10, 2021
 */
public class PetsListHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsolePetsList");
	
	public void insertPet(PetsList pl) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pl);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PetsList> showAllPets() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<PetsList> allPets = em.createQuery("SELECT i FROM PetsList i").getResultList();
		return allPets;
	}
	
	public void deletePet(PetsList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetsList> typedQuery = em.createQuery("SELECT pl FROM PetsList pl WHERE pl.owner = :selectedOwner AND pl.type = :selectedType"
				+ " AND pl.name = :selectedName", PetsList.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedOwner", toDelete.getOwner());
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedName", toDelete.getName());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		PetsList result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public PetsList searchForPetById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PetsList found = em.find(PetsList.class, idToEdit);
		em.close();
		return found;
	}

	public void updatePet(PetsList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	public List<PetsList> searchForPetByOwner(String ownerName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetsList> typedQuery = em.createQuery("SELECT pl FROM PetsList pl WHERE pl.owner = :selectedOwner", PetsList.class);
		typedQuery.setParameter("selectedOwner", ownerName);
		
		List<PetsList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<PetsList> searchForPetByType(String typeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetsList> typedQuery = em.createQuery("SELECT pl FROM PetsList pl WHERE pl.type = :selectedType", PetsList.class);
		typedQuery.setParameter("selectedType", typeName);
		
		List<PetsList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<PetsList> searchForPetByName(String petName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetsList> typedQuery = em.createQuery("SELECT pl FROM PetsList pl WHERE pl.name = :selectedName", PetsList.class);
		typedQuery.setParameter("selectedName", petName);
		
		List<PetsList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
