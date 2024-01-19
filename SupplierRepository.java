package com.ProductManagementSystem.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.ProductManagementSystem.entity.Supplier;
public class SupplierRepository {
private final EntityManager em;
	public SupplierRepository(final EntityManager em) {
		this.em=em;
	}
	public Supplier save(final Supplier supplier) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(supplier);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return supplier;
	}

	//Returning all Supplier records	
	public List<Supplier> findAll(){
				
		List<Supplier> suppliers = em.createQuery("from Supplier ", Supplier.class).getResultList();
							
		return suppliers;
	}
}