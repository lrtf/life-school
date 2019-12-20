package br.org.mpc.lifeschool.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Letter {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sender;
	private int age;
	@ManyToOne
	private School school;
	private int year;
	@Enumerated(EnumType.STRING)
	private StatusLetter status = StatusLetter.UPLOAD;
	@ManyToOne
	private User voluntary;
	
	public Letter() {
		
	}
	
	public Letter(String sender, int year, int age, School school) {
		this.sender = sender;
		this.year = year;
		this.age = age;
		this.school = school;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public StatusLetter getStatusLetter() {
		return status;
	}
	public void setStatus(StatusLetter status) {
		this.status = status;
	}
	public User getVoluntary() {
		return voluntary;
	}
	public void setVoluntary(User voluntary) {
		this.voluntary = voluntary;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
