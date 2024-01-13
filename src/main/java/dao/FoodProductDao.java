package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.FoodProduct;

public class FoodProductDao {
	public  EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	public EntityManager em = emf.createEntityManager();
	public EntityTransaction et = em.getTransaction();
	
	public void saveFoodProduct(FoodProduct food) {
		et.begin();
		em.persist(food);
		et.commit();
	}
	
	public FoodProduct findFoodProduct(int id) {
		return em.find(FoodProduct.class, id);
	}
	
	public void updateFoodProduct(FoodProduct food) {
		et.begin();
		em.merge(food);
		et.commit();
	}
	
	public void removeFoodProduct(FoodProduct food) {
		et.begin();
		em.remove(food);
		et.commit();
	}
}
