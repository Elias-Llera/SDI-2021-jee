package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;
import com.uniovi.repositories.ProfessorRespository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRespository professorRepository;

	public List<Professor> getProfessors() {
		List<Professor> profesores = new ArrayList<Professor>();
		professorRepository.findAll().forEach(profesores::add);
		return profesores;
	}

	public Professor getProfessor(String dni) {
		return professorRepository.findById(dni).get();
	}

	public void addProfessor(Professor profesor) {
		professorRepository.save(profesor);
	}

	public void deleteProfessor(String dni) {
		professorRepository.deleteById(dni);
	}

	public void editProfessor(String oldDni, Professor newProfessorData) {
		Professor p = getProfessor(oldDni);
		deleteProfessor(oldDni);
		;
		if (!newProfessorData.getDNI().equals(null)) {
			p.setDNI(newProfessorData.getDNI());
		}
		if (!newProfessorData.getName().equals(null)) {
			p.setName(newProfessorData.getName());
		}
		if (!newProfessorData.getSurname().equals(null)) {
			p.setSurname(newProfessorData.getSurname());
		}
		if (!newProfessorData.getCategory().equals(null)) {
			p.setCategory(newProfessorData.getCategory());

		}
		addProfessor(p);
	}

}
