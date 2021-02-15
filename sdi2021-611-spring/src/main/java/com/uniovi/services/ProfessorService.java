package com.uniovi.services;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import com.uniovi.entities.Professor;

public class ProfessorService {

	private HashMap<String, Professor> profesores = new HashMap<String, Professor>();

	@PostConstruct
	public void init() {
		profesores.put("1", new Professor("1", "Paco", "García", "Categoria1"));
		profesores.put("2", new Professor("2", "Pepe", "Lopez", "Categoria2"));
	}

	public Professor getProfessor(String dni) {
		return profesores.get(dni);
	}

	public void addProfessor(Professor profesor) {
		profesores.put(profesor.getDNI(), profesor);
	}

	public void deleteProfessor(String dni) {
		profesores.remove(dni);
	}

	public void editProfessor(String oldDni, String newDni, String name, String surname, String category) {
		Professor p = getProfessor(oldDni);
		profesores.remove(oldDni);
		if (!newDni.equals(null)) {
			p.setDNI(newDni);
		}
		if (!name.equals(null)) {
			p.setName(name);
		}
		if (!surname.equals(null)) {
			p.setSurname(surname);
		}
		if (!category.equals(null)) {
			p.setCategory(category);

		}
		addProfessor(p);
	}

}
