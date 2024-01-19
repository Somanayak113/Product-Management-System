package com.ProductManagementSystem.entity;
import java.util.ArrayList;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="products")
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="name",nullable=false,length=50)
	private String name;
	@Column(name="cost",nullable=false)
	private int cost;
	@Column(name="expirydate",nullable=false)
	private String expirydate;
	@Column(name="brandname",nullable=false,length=50)
	private String brandname;
	
	@ManyToMany(mappedBy = "products")
	 private List<Order> orders= new ArrayList<Order>();
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	
	//Generate Constructors from Superclass
	public Product() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	//Generate Constructors using Fields
	public Product(long id, String name, int cost, String expirydate, String brandname, List<Order> orders,
			Supplier supplier) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.expirydate = expirydate;
		this.brandname = brandname;
		this.orders = orders;
		this.supplier = supplier;
	}
	
	//Generate Constructors using Fields
	public Product(String name, int cost, String expirydate, String brandname, List<Order> orders, Supplier supplier) {
		super();
		this.name = name;
		this.cost = cost;
		this.expirydate = expirydate;
		this.brandname = brandname;
		this.orders = orders;
		this.supplier = supplier;
	}

	//Generate Getters and Setters
	public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public int getcost() {
		return cost;
	}
	public void setcost(int cost) {
		this.cost = cost;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	
	//Generate toString()
	@Override
	public String toString() 
	{
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", expirydate=" + expirydate
				+ ", brandname=" + brandname + "]";
	}
}
