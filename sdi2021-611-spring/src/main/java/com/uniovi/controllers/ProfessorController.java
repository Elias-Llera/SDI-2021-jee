package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/professor/add", method = RequestMethod.POST)
	public String setProfessor(@ModelAttribute Professor profesor) {
		professorService.addProfessor(profesor);
		return "Profesor añadido";
	}

	@RequestMapping("/professor/remove/{dni}")
	public String deleteProfessor(@PathVariable String dni) {
		professorService.deleteProfessor(dni);
		return "Profesor eliminado";
	}

	
	//------------De momento ambos realizan la misma funcion------------
	@RequestMapping("/professor/edit/{oldDni}") //respuesta a get, saca los datos a modificar
	public String getEdit(@PathVariable String oldDni, @ModelAttribute Professor newProfessorData) {
		professorService.editProfessor(oldDni, newProfessorData);
		return "Profesor editado";
	}
	
	@RequestMapping(value = "/professor/edit/{oldDni}", method = RequestMethod.POST) //respuesta a pot, introduce nuevos datos
	public String setEdit(@PathVariable String oldDni, @ModelAttribute Professor newProfessorData) {
		professorService.editProfessor(oldDni, newProfessorData);
		return "Profesor editado";
	}
	//--------------------------------------------------------

	@RequestMapping("/professor/details/{dni}")
	public String getDetail(@PathVariable String dni) {
		Professor p = professorService.getProfessor(dni);
		return p.toString();
	}

}
