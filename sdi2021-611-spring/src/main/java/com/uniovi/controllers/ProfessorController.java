package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

//------------------------------List------------------------------
	@RequestMapping("/professor/list")
	public String getListado(Model model) {
		model.addAttribute("professorsList", professorService.getProfessors());
		return "professor/list";
	}

//------------------------------Add-------------------------------
	@RequestMapping("/professor/add")
	public String getProfessor(Model model) {
		model.addAttribute("professorsList", professorService.getProfessors());
		return "professor/add";
	}

	@RequestMapping(value = "/professor/add", method = RequestMethod.POST)
	public String setProfessor(@ModelAttribute Professor profesor) {
		professorService.addProfessor(profesor);
		return "redirect:/professor/list";
	}

//------------------------------Edit------------------------------
	@RequestMapping("/professor/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id) {
		Professor professor = professorService.getProfessor(id);
		model.addAttribute("professor", professor);
		return "professor/edit";
	}

	@RequestMapping(value = "/professor/edit/{id}", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Professor professor) {
		Professor original = professorService.getProfessor(id);

		original.setName(professor.getName());
		original.setSurname(professor.getSurname());
		original.setCategory(professor.getCategory());
		
		professorService.addProfessor(original);
		
		return "redirect:/professor/details/" + id;
	}

//---------------------Remove------------------------------------
	@RequestMapping("/professor/delete/{id}")
	public String delete(@PathVariable Long id) {
		professorService.deleteProfessor(id);
		return "redirect:/professor/list";
	}

//---------------------Details-----------------------------------
	@RequestMapping("/professor/details/{id}")
	public String getDetail(Model model, @PathVariable Long id) {
		model.addAttribute("professor", professorService.getProfessor(id));
		return "professor/details";
	}

}
