package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@RestController
public class ProfessorController {

	@Autowired // Inyectar el servicio
	private ProfessorService professorService;
	
	@RequestMapping("/professor/add")
	public String getProfessor(@ModelAttribute Professor profesor) {
		professorService.addProfessor(profesor);
		return "Profesor añadido";
	}

	@RequestMapping("/professor/remove/{dni}")
	public String deleteProfessor(@PathVariable String dni) {
		professorService.deleteProfessor(dni);
		return "Profesor eliminado";
	}

	@RequestMapping("/professor/edit/{oldDni}")
	public String getEdit(@PathVariable String oldDni, @ModelAttribute Professor newProfessorData) {
		professorService.editProfessor(oldDni, newProfessorData.getDNI(), newProfessorData.getName(), newProfessorData.getSurname(), newProfessorData.getCategory());
		return "Profesor editado";
	}

	@RequestMapping("/professor/details/{dni}")
	public String getDetail(@PathVariable String dni) {
		Professor p = professorService.getProfessor(dni);
		return p.toString();
	}

}
