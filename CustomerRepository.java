package com.ProductManagementSystem.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.ProductManagementSystem.entity.Customer;
public class CustomerRepository {
private final EntityManager em;
	public CustomerRepository(final EntityManager em) {
		this.em=em;
	}
	public Customer save(final Customer customer) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(customer);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return customer;
	}

	//Returning all Customer records	
	public List<Customer> findAll(){
				
		List<Customer> customers = em.createQuery("from Customer ", Customer.class).getResultList();
							
		return customers;
	}
}