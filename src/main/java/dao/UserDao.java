package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import entity_classes.User;

public class UserDao {
	 public EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	 public EntityManager em = emf.createEntityManager();
	 public EntityTransaction et = em.getTransaction();
	
	public void saveUser(User user) {
		et.begin();
		em.persist(user);
		et.commit();
	}
	
	public User findUser(int id) {
		return em.find(User.class, id);
	}
	
	public void updateUser(User user) {
		et.begin();
		em.merge(user);
		et.commit();
	}
	
	public void removeUser(User user) {
		et.begin();
		em.remove(user);
		et.commit();
	}
}
