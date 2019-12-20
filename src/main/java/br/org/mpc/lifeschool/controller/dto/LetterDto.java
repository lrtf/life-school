package br.org.mpc.lifeschool.controller.dto;

import org.springframework.data.domain.Page;

import br.org.mpc.lifeschool.modelo.Letter;
import br.org.mpc.lifeschool.modelo.StatusLetter;

public class LetterDto {
	
	private Long id;
	private String sender;
	private int age;
	private String schoolName;
	private int year;
	private StatusLetter statusLetter = StatusLetter.UPLOAD;
	private String voluntaryName;
	
	public LetterDto(Letter letter) {
		this.id = letter.getId();
		this.sender = letter.getSender();
		this.age = letter.getAge();
		this.schoolName = letter.getSchool().getName();
		this.year = letter.getYear();
		if(letter.getVoluntary() != null) {
			this.voluntaryName = letter.getVoluntary().getName();		
		}
		
		
	}

	
	
	
	public Long getId() {
		return id;
	}



	public String getSender() {
		return sender;
	}



	public String getSchoolName() {
		return schoolName;
	}



	public int getYear() {
		return year;
	}



	public int getAge() {
		return age;
	}



	public StatusLetter getStatusLetter() {
		return statusLetter;
	}



	public String getVoluntaryName() {
		return voluntaryName;
	}



	public static Page<LetterDto> converter(Page<Letter> letters){
		return letters.map(LetterDto::new);
	}
	
	

}
