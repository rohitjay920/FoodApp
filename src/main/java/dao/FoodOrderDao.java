package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.FoodOrder;

public class FoodOrderDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et = em.getTransaction();
	
	public void saveFoodOrder(FoodOrder food) {
		et.begin();
		em.persist(food);
		et.commit();
	}
	
	public FoodOrder findFoodOrder(int id) {
		return em.find(FoodOrder.class, id);
	}
	
	public void updateFoodOrder(FoodOrder food) {
		et.begin();
		em.merge(food);
		et.commit();
	}
	
	public void removeFoodOrder(FoodOrder food) {
		et.begin();
		em.remove(food);
		et.commit();
	}
			
}
