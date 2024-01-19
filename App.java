package com.example.ProductManagementSystem;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.HibernateException;
import com.ProductManagementSystem.entity.Customer;
import com.ProductManagementSystem.entity.Order;
import com.ProductManagementSystem.entity.Product;
import com.ProductManagementSystem.entity.Supplier;
import com.ProductManagementSystem.repository.CustomerRepository;
import com.ProductManagementSystem.repository.OrderRepository;
import com.ProductManagementSystem.repository.ProductRepository;
import com.ProductManagementSystem.repository.SupplierRepository;
public class App {
  public static void main(String[] args) {
	  System.out.println("_______________Product Management System_________________");
	  EntityManagerFactory factory = null;
		EntityManager em = null;
		
		try {
			factory = Persistence.createEntityManagerFactory("ProductManagementSystem");
			em = factory.createEntityManager();
			
			//Operations of Product class and ProductRepository class 
			ProductRepository prep = new ProductRepository(em);
			
			Product p1 = new Product("Bread",100,"2023-09-12","Britannia",null, null);
			Product p2 = new Product("Coffee",350,"2024-01-01","Nestle", null, null);
			Product p3 = new Product("Biscuit",100,"2023-12-12","Parle-G", null, null);
			Product p4 = new Product("Rice",900,"2023-09-15","Deradun", null, null);
			Product p5 = new Product("Butter",200,"2024-11-21","Amul", null, null);
			Product p6 = new Product("Cheese",750,"2023-02-02","Amul", null, null);
			
			List<Product> products = new ArrayList<Product> ();
			products.add(p1);
			products.add(p2);
			products.add(p3);
			products.add(p4);
			products.add(p5);
			products.add(p6);
			
			//Saving objects of type Product to the database
			for(Product p:products) {
				prep.save(p);
			}
			
			List<Product> products1 = new ArrayList<Product>();
			products1.add(p1);
			products1.add(p2);
			
			List<Product> products2 = new ArrayList<Product>();
			products2.add(p3);
			products2.add(p4);
			
			List<Product> products3 = new ArrayList<Product>();
			products3.add(p5);
			products3.add(p6);
			
			//Saving objects of type Customer to the database
			Customer c1 = new Customer("Soma Nayak","Bankura","somanayak@gmail.com",null);
			Customer c2 = new Customer("Diya Sen","Mumbai","diyasen@gmail.com",null);
			Customer c3 = new Customer("Sohini Mukherjee","Bengaluru","sohinimukherjee@gmail.com",null);
			
			CustomerRepository crep = new CustomerRepository(em);
			crep.save(c1);
			crep.save(c2);
			crep.save(c3);
			
			//Saving objects of type Order to the database
			Order o1 = new Order("Delivered","2023-02-12","2022-02-15", products1, c1);
			Order o2 = new Order("Shipped","2023-01-12","2022-01-25",  products2,c2);
			Order o3 = new Order("Not Shipped","2023-12-22","2023-12-25", products3,c3);
			
			OrderRepository orep = new OrderRepository(em);
			orep.save(o1);
			orep.save(o2);
			orep.save(o3);
	
			//Saving objects of type Order to the database
			Supplier s1 = new Supplier("Arun Dey","9876543210", products1);
			Supplier s2 = new Supplier("Barun Sen","9887766556",products2);
			Supplier s3 = new Supplier("Tarun Roy","9653785309",products3);
			
			SupplierRepository srep = new SupplierRepository(em);
			srep.save(s1);
			srep.save(s2);
			srep.save(s3);
			
			//Obtain all the products records
			List<Product> allProducts = prep.findAll();
			System.out.println("Product : " + allProducts);
			System.out.println("_________________________________________________________________________________");
			
			//Obtain all the Customer records
			List<Customer> allCustomers = crep.findAll();
			System.out.println("Customer : " + allCustomers);
			System.out.println("_________________________________________________________________________________");
		
			//Obtain all the Order records
			List<Order> allOrders = orep.findAll();
			System.out.println("Order : " + allOrders);
			System.out.println("_________________________________________________________________________________");
			
			//Obtain all the Supplier records
			List<Supplier> allSuppliers = srep.findAll();
			System.out.println("Supplier : " + allSuppliers);
			System.out.println("_________________________________________________________________________________");
		}	
		catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Exception Hibernate");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception");
		}
		finally {
			 if(factory!= null) {
			 factory.close();
			 }
	   }
  }
}