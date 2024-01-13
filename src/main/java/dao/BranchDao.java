package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Branch;

public class BranchDao {
	public EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	public EntityManager em = emf.createEntityManager();
	public EntityTransaction et = em.getTransaction();
	
	public void saveBranch(Branch branch) {
		et.begin();
		em.persist(branch);
		et.commit();
	}
	
	public Branch findBranch(int id) {
		return em.find(Branch.class, id);
	}
	
	public void removeBranch(Branch branch) {
			et.begin();
			em.remove(branch);
			et.commit();
	}
	
	public void updateBranch(Branch branch) {
		et.begin();
		em.merge(branch);
		et.commit();
	}
}
