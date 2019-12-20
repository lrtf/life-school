package br.org.mpc.lifeschool.controller.form;

import br.org.mpc.lifeschool.modelo.Letter;
import br.org.mpc.lifeschool.modelo.School;
import br.org.mpc.lifeschool.modelo.User;
import br.org.mpc.lifeschool.repository.SchoolRepository;
import br.org.mpc.lifeschool.repository.UserRepository;

public class LetterForm {
	
	private String sender;
	private int age;
	private String nameSchool;
	private int year;
	
	public String getSender() {
		return sender;
	}
	public String getNameSchool() {
		return nameSchool;
	}
	public int getYear() {
		return year;
	}
	public int getAge() {
		return age;
	}

	public Letter converter(SchoolRepository schoolRepository) {
		School school = schoolRepository.findByName(nameSchool);
		return new Letter(sender, year, age, school);
	}

}
