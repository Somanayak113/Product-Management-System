package com.ProductManagementSystem.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "customers")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "address", nullable = false, length = 100)
    private String address;
	@Column(name = "email", nullable = false, length = 50)
    private String email;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name ="customer_id")
	private List<Order> orders=new ArrayList<Order>()  ;
	
	//Generate Constructors from Superclass
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Generate Constructors using Fields
	public Customer(long id, String name, String address, String email, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.orders = orders;
	}
	
	//Generate Constructors using Fields
	public Customer(String name, String address, String email, List<Order> orders) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.orders = orders;
	}

	//Generate Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	//Generate toString()
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", orders="
				+ orders + "]";
	}
}
