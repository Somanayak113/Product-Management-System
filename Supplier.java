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
@Table(name = "suppliers")
public class Supplier 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "contactno", nullable = false, length = 20)
    private String contactno;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name ="supplier_id")
	 private List<Product> products= new ArrayList<Product>();
	
	//Generate Constructors from Superclass
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Generate Constructors using Fields
	public Supplier(long id, String name, String contactno, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.contactno = contactno;
		this.products = products;
	}
	
	//Generate Constructors using Fields
	public Supplier(String name, String contactno, List<Product> products) {
		super();
		this.name = name;
		this.contactno = contactno;
		this.products = products;
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
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	//Generate toString()
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", contactno=" + contactno + ", products=" + products
				+ "]";
	}
}
