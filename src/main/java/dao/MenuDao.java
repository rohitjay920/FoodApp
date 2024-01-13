package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Menu;

public class MenuDao {
	public EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	public EntityManager em = emf.createEntityManager();
	public EntityTransaction et = em.getTransaction();
	
	public void saveMenu(Menu menu) {
		et.begin();
		em.persist(menu);
		et.commit();
	}
	
	public Menu findMenu(int id) {
		return em.find(Menu.class, id);
	}
	
	public void updateMenu(Menu menu) {
		et.begin();
		em.merge(menu);
		et.commit();
	}
	
	public void removeMenu(Menu menu) {
		et.begin();
		em.remove(menu);
		et.commit();
	}
}
