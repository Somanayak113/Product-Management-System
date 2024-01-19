package com.ProductManagementSystem.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.ProductManagementSystem.entity.Product;
public class ProductRepository {
private final EntityManager em;
	public ProductRepository(final EntityManager em) {
		this.em=em;
	}
	public Product save(final Product product) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(product);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return product;
	}

	//Returning all Product records	
	public List<Product> findAll(){
				
		List<Product> products = em.createQuery("from Product ", Product.class).getResultList();
							
		return products;
	}	
}
