package com.uniovi.services;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Mark;

@Service
public class MarksService {
	private List<Mark> marksList = new LinkedList<Mark>();

	@PostConstruct
	public void init() {
		marksList.add(new Mark(1L, "Ejercicio 1", 10.0));
		marksList.add(new Mark(2L, "Ejercicio 2", 9.0));
	}

	public List<Mark> getMarks() {
		return marksList;
	}

	public Mark getMark(Long id) {
		return marksList.stream().filter(mark -> mark.getId().equals(id)).findFirst().get();
	}

	public void addMark(Mark mark) {
// Si en Id es null le asignamos el ultimo + 1 de la lista
		if (mark.getId() == null) {
			mark.setId(marksList.get(marksList.size() - 1).getId() + 1);
		}
		marksList.add(mark);
	}

	public void deleteMark(Long id) {
		marksList.removeIf(mark -> mark.getId().equals(id));
	}
}