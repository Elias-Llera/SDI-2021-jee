package com.uniovi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {

	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String dni;
	private String name;
	private String surname;
	private String category;

	public Professor() {
	}

	public Professor(String dni, String name, String surname, String category) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dNI) {
		dni = dNI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Professor [DNI=" + dni + ", name=" + name + ", surname=" + surname + ", category=" + category + "]";
	}

}
