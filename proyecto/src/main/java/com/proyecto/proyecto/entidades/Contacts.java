package com.proyecto.proyecto.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name= "contacts")
public class Contacts {

	@Id
	@Column(name= "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@Column(name = "name", nullable = false , length= 30)
	String name;
	
	@Column(name = "phone", nullable = false , length= 30)
	String phone;
	
	@Column(name = "address", nullable = false , length= 30)
	String adress;
	
	@Column(name = "email", nullable = false , length= 30)
	String email;
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
	
	
	
	
}
