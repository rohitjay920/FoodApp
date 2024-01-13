package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Item;

public class ItemDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et = em.getTransaction();
	
	public void saveItem(Item item) {
		et.begin();
		em.persist(item);
		et.commit();
	}
	
	public Item findItem(int id) {
		return em.find(Item.class, id);
	}
	
	public void updateItem(Item item) {
		et.begin();
		em.merge(item);
		et.commit();
	}
	
	public void removeItem(Item item) {
		et.begin();
		em.remove(item);
		et.commit();
	}
}
