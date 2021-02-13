package com.uniovi.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Mark;

@RestController
public class MarksControllers {

	@RequestMapping("/mark/list")
	public String getList() {
		return "Getting List";
	}

	@RequestMapping(value = "/mark/add", method = RequestMethod.POST)
	public String setMark(@ModelAttribute Mark mark) {
		return "Added: " + mark.getDescription() + " with score: " + mark.getScore() + " id: " + mark.getId();
	}

	@RequestMapping("/mark/details/{id}")
	public String getDetail(@PathVariable Long id) {
		return "Getting Detail: " + id;
	}

}
