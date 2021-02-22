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

	public Professor getProfessor(Long id) {
		return professorRepository.findById(id).get();
	}

	public void addProfessor(Professor profesor) {
		professorRepository.save(profesor);
	}

	public void deleteProfessor(Long id) {
		professorRepository.deleteById(id);
	}

}
