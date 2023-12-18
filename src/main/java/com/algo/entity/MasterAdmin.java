package com.algo.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "master_admin")
public class MasterAdmin {
	@Id
	@GeneratedValue(generator = "Distributer_gen", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "Distributer_gen", strategy = "com.algo.config.DistributerIdGenerator", parameters = @org.hibernate.annotations.Parameter(name = "type", value = "String"))
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PASSWORD")
	private String password;


	@Column(name="ROLE")	
	private String role;


	@Column(name = "ISACTIVE")
	private boolean isActive;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean getisActive() {
		return isActive;
	}


	public void setisActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
