package com.ProductManagementSystem.repository;
import com.ProductManagementSystem.entity.Order;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
public class OrderRepository {	
private final EntityManager em;	
	public OrderRepository(final EntityManager em) {
		this.em=em;
	}
	public Order save(final Order order) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(order);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return order;
	}

	//Returning all Order records	
	public List<Order> findAll(){			
		List<Order> orders = em.createQuery("from Order ", Order.class).getResultList();
		return orders;
	}
}