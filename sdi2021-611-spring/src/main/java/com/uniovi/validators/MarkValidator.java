package com.uniovi.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import com.uniovi.entities.Mark;

@Component
public class MarkValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Mark.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Mark mark = (Mark) target;
		if(mark.getScore()>10 || mark.getScore()<0) {
			errors.rejectValue("score", "Error.mark.score.range");
		}
		if(mark.getDescription().length()<20) {
			errors.rejectValue("score", "Error.mark.description.length");
		}
		
	}

}
