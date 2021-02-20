package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professor {

	@Id
	private String DNI;
	private String name;
	private String surname;
	private String category;

	public Professor() {
	}

	public Professor(String dni, String name, String surname, String category) {
		this.DNI = dni;
		this.name = name;
		this.surname = surname;
		this.category = category;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
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
		return "Professor [DNI=" + DNI + ", name=" + name + ", surname=" + surname + ", category=" + category + "]";
	}

}
